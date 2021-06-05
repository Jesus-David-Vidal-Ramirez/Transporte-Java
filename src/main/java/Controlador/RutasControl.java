/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Rutas;
import Modelo.RutasJDBC;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.commons.fileupload.UploadContext;
//import org.glassfish.jersey.media.multipart.MultiPart;

/**
 *
 * @author JESÚS
 */
@WebServlet(name = "RutasControl", urlPatterns = {"/RutasControl"})
@MultipartConfig()


public class RutasControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Rutas ruta = new Rutas();
    RutasJDBC rutaJDBC = new RutasJDBC();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        String url = null;
        switch (accion) {
            case "Agregar":
                System.out.println("--" + request.getContextPath());
                System.out.println("ENTRO a AGREGAR");
                System.out.println(request.getParameter("file"));
                this.rutaAgregar(request, response);

                break;
            case "Eliminar":   
                    this.EliminarRuta(request, response);
                break;
                
            case "Edicion":   
                url = "/WEB-INF/Recursos/EdicionEmpleados.jsp";
                request.getRequestDispatcher(url).forward(request, response);
                break;
            case "Reservar":
                url = "/WEB-INF/Recursos/Ventas.jsp";
                request.getRequestDispatcher(url).forward(request, response);
                break;
//            case "Reservo":
//                String idRuta = request.getParameter("");
//                String idUsuario = request.getParameter("");
//                String idCantidad = request.getParameter("");
//                String idPrecio = request.getParameter("");
//                
//                    
//                break;
//                
            case "Compras":
                    url = "/WEB-INF/Recursos/Ventas.jsp";
                    request.getRequestDispatcher(url).forward(request, response);
                    break;
            default:
                request.getRequestDispatcher("Login.jsp").forward(request, response);
                break;
        }
    }
    
    private void EliminarRuta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int eliminado = 0;
        String key = request.getParameter("ruta");
        System.out.println("ruta key ter " + key);
        System.out.println("ruta parameter " + ruta);
        ruta = new Rutas(key);
        System.out.println("ruta parameter " + ruta);
        eliminado = new RutasJDBC().eliminarRuta(ruta);
        System.out.println("Ruta Eliminado = " + eliminado);
        String url = "/WEB-INF/Paginas/EliminadoAlerta.jsp";
        request.getRequestDispatcher(url).forward(request, response);
    }
    
    
    
    private void rutaAgregar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        String nombre = request.getParameter("Nombre");
        String precio = request.getParameter("Precio");
        String info = request.getParameter("Info");
        String opcion = request.getParameter("Opcion");
        Part archivo = request.getPart("file"); //Obtener el archivo, viene tipo object parecido
        String foto = Paths.get(archivo.getSubmittedFileName()).getFileName().toString(); //Sacando del object el nombre del archivo
        
        ruta.setCodigoRuta(opcion);
        ruta.setNombre(nombre);
        ruta.setPrecio(precio);
        ruta.setImagen(foto);
        ruta.setInfo(info);
        System.out.println(ruta.getCodigoRuta());
        System.out.println(ruta.getNombre());
        System.out.println(ruta.getPrecio());
        System.out.println(ruta.getImagen());
        System.out.println(ruta.getInfo());
        rutaJDBC.AgregarRuta(ruta);
        String url = "/WEB-INF/Paginas/Agregado.jsp";
        request.getRequestDispatcher(url).forward(request, response);
       
        //<meta http-equiv="refresh" content="0; ${pageContext.request.contextPath}/Login" > 
    }
    
    //MultiPart multiPart = new MultiPart();
    
    private int ruta(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Part archivo = request.getPart("file"); //llamada al parámetro foto de mi formulario.
        System.out.println("archivo" + archivo);
        String context = request.getServletContext().getRealPath("/Imagenes"); //img es la carpeta que he creado en mi proyecto, dentro de la carpeta Web Content.
        System.out.println("context"+ context);
        String foto = Paths.get(archivo.getSubmittedFileName()).getFileName().toString();
        System.out.println("foto"+foto);
        
        archivo.write( "/" + foto); // Escribimos el archivo al disco duro del servidor.

        String fotoName =  File.separator + foto;
        System.out.println("FOTONAME="+ fotoName);
        return 0;
    }

    private int AgregarRuta(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String nombre = request.getParameter("Nombre");
        String precio = request.getParameter("Precio");
        String info = request.getParameter("Info");
        String opcion = request.getParameter("Opcion");
        String ruta = request.getParameter("file");
        System.out.println("opcion" + opcion);
        System.out.println("nombre" + nombre);
        System.out.println("file" + ruta);
        System.out.println("precio" + precio);

        String direccion = request.getSession().getServletContext().getRealPath("/") + "Imagenes/";
        System.out.println("La direcion: " + direccion);

        //String nameImage = multiPart.getOriginalFilename();
        Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
        System.out.println("filePart" + filePart);
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.

        InputStream fileContent = filePart.getInputStream();
        String path = request.getServletContext().getRealPath("/Imagenes");
        //System.out.println("el path " + path);
        //File file = new File(path + nameImage);
        File img = new File(direccion, fileName);
        //multiPart.transferTo(img);
        String context = request.getServletContext().getRealPath("/Imagenes");
        System.out.println("context" + context);
        filePart.write(context + File.separator);

        System.out.println("mm" + filePart);
        try (InputStream input = fileContent) {
            Files.copy(input, img.toPath());

            System.out.println("LA IMG " + img.toPath());
            //System.out.println("files" + Files.copy(input, img.toPath()));
            // String nameImage = multiPart.getOriginalFilename();
            //File file = new File(path + nameImage);
            //multiPart.transferTo(img);
            //multiPart.setEntity(img);

        }

        System.out.println("fileName" + fileName);

        //String fotoName = UPLOAD_DIR + File.separator + foto;
        //String nomb = UploadContext + File.separator +foto;
        //Rutas rutaar = new Rutas();
        //rutaar.setImagen(fotoName);
        return 0;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
