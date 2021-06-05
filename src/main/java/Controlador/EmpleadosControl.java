/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DATOS.UsuarioJDBC;
import Modelo.Empleados;
import Modelo.EmpleadosJDBC;
import Modelo.Usuarios;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author JESÚS
 */
@WebServlet(name = "EmpleadosControl", urlPatterns = {"/EmpleadosControl"})
@MultipartConfig
public class EmpleadosControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    EmpleadosJDBC empleadosJDBC = new EmpleadosJDBC();
    Empleados empleados = new Empleados();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
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
         
       String accion = request.getParameter("accion");
       
       switch(accion){
             case "Listar":
                List<Empleados> lista = empleadosJDBC.listarEmpleados();
                System.out.println("listaaa " + lista);
                request.setAttribute("lista",lista);
                request.getRequestDispatcher("welcome.jsp").forward(request, response);
            break; 
            
           case "Agregar":
               System.out.println("Entraron agregar");
               this.AgregarEmpleado(request, response);
               break;
               
           case "Modificar":
               String cedula = request.getParameter("Identificacion");
               String nombre = request.getParameter("Nombre");
               String apellido = request.getParameter("Apellido");
               String telefono = request.getParameter("Telefono");
               String direccion = request.getParameter("Direccion");
               String correo = request.getParameter("Correo");
               String FOTO ;
               empleados = new Empleados(nombre, apellido,cedula , telefono, direccion,correo  );
               int rows =0 ;
               rows = new EmpleadosJDBC().ModificarEmpleado(empleados);
               System.out.println("las afectadas " + rows);
               String urll = "/WEB-INF/Paginas/prueba.jsp";
               request.getRequestDispatcher(urll).forward(request, response);
               break;
               
           case "Edicion":
               String url = "/WEB-INF/Recursos/EdicionEmpleados.jsp";
               String editar = request.getParameter("usuario");
               System.out.println("LA llave del eliminar " + editar);
               Empleados emp = new Empleados();
               emp.setCedulaCiudadania(editar);
               List<Empleados> listaEmpleado = empleadosJDBC.ListarEmpleado(emp);
               System.out.println("Empleado " + listaEmpleado);
               request.setAttribute("Empleado",listaEmpleado);
               request.getRequestDispatcher(url).forward(request, response);
               break;
               
           case "Eliminar":
               
               String key = request.getParameter("usuario");
               System.out.println("LA llave del eliminar " );
               this.EliminarEmpleado(request, response);
               
               break;  
               
            case "Nuevo":
               request.getRequestDispatcher("AgregarImg.jsp").forward(request, response);
               break;  
            case "guardar":
//                String nombre = request.getParameter("Nombre");
//                String cedula = request.getParameter("Identificacion");
//                Part part = request.getPart("foto");
//                InputStream inputStrem = part.getInputStream();
//                empleados.setNombre(nombre);
//                empleados.setCedulaCiudadania(cedula);
//                empleados.setImagen(inputStrem);
//                empleadosJDBC.AgregarEmpleado(empleados);
//                request.getRequestDispatcher("Resultado.jsp").forward(request, response);
               break;  
           default:
               
               request.getRequestDispatcher("Salida.jsp").forward(request, response);
               break;
                   
       }
    }
    
    private void AgregarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                String nombre = request.getParameter("Nombre");
                String apellido = request.getParameter("Apellido");
                String cedula = request.getParameter("Identificacion");
                String telefono = request.getParameter("Telefono");
                String direccion = request.getParameter("Direccion");
                String correo = request.getParameter("Correo");
                Part part = request.getPart("foto");
                
                InputStream inputStrem = part.getInputStream();
                empleados.setNombre(nombre);
                empleados.setApellido(apellido);
                empleados.setCedulaCiudadania(cedula);
                empleados.setTelefono(telefono);
                empleados.setDireccion(direccion);
                empleados.setCorreo(correo);
                empleados.setImagen(inputStrem);
                
                empleadosJDBC.AgregarEmpleado(empleados);
                String url = "/WEB-INF/Paginas/Agregado.jsp";
                request.getRequestDispatcher(url).forward(request, response);
        
        
    }
    
    
    
    private void listarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Empleados> empleados = new EmpleadosJDBC().listarE();

        request.setAttribute("empleados", empleados);
        request.getRequestDispatcher("Salida.jsp");

    }
    
    private void EliminarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int eliminado = 0;
        String key = request.getParameter("usuario");

        Empleados empleado = new Empleados(key);

        eliminado = new EmpleadosJDBC().eliminarEmpleado(empleado);
        System.out.println("Empleado Eliminado = " + eliminado);
       // this.listarEmpleado(request, response);
        //String url = "/WEB-INF/Paginas/EliminadoAlerta.jsp";
        
        String url = "/WEB-INF/Paginas/EliminadoAlerta.jsp";
                      //${pageContext.request.contextPath}/Salida.jsp"
        request.getRequestDispatcher(url).forward(request, response);

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
