/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Busetas;
import Modelo.BusetasJDBC;
import Modelo.Empleados;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JESÚS
 */
@WebServlet(name = "BusetasControl", urlPatterns = {"/BusetasControl"})
public class BusetasControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Busetas busetas = new Busetas();
    BusetasJDBC busetasJDBC = new BusetasJDBC();
    String url = null;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        
        switch(accion){
            
            case "Agregar":
                 this.AgregarBuseta(request, response);
                break;
                
            case "Eliminar" :
                 this.EliminarEmpleado(request, response);
                break;
            
            case "Edicion":
               url = "/WEB-INF/Recursos/EdicionEmpleados.jsp";
               String editar = request.getParameter("usuario");
               Empleados emp = new Empleados();
               emp.setCedulaCiudadania(editar);
               request.getRequestDispatcher(url).forward(request, response);
                break;
                
            case "Modificar":
                String modelo = request.getParameter("Modelo");
                String marca = request.getParameter("Marca");
                String placa = request.getParameter("Placa");
                String color = request.getParameter("Color");
                busetas = new Busetas(modelo, marca, color, placa );
               int rows = new BusetasJDBC().ModificarBusetas(busetas);
               // System.out.println("Las filas afectadas " + rows);
               url = "/WEB-INF/Paginas/prueba.jsp";
               request.getRequestDispatcher(url).forward(request, response);
                break;
                
        }
    }
    
    
    
    private void AgregarBuseta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                String modelo = request.getParameter("Modelo");
                String marca = request.getParameter("Marca");
                String placa = request.getParameter("Placa");
                String color = request.getParameter("Color");

                busetas.setModelo(modelo);
                busetas.setMarca(marca);
                busetas.setPlaca(placa);
                busetas.setColor(color);
                if(busetasJDBC.VerificarId(busetas)){
                    url = "/WEB-INF/Paginas/AgregarAlerta.jsp";
                }else{
                    busetasJDBC.InsertarBusetas(busetas);  
                    url = "/WEB-INF/Paginas/Agregado.jsp";
                }
                request.getRequestDispatcher(url).forward(request, response);
        
        
    }
    
    
    private void EliminarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int eliminado = 0;
        String key = request.getParameter("buseta");

        busetas.setPlaca(key);

        eliminado = busetasJDBC.EliminarBuseta(busetas);
        System.out.println("BUSETA Eliminado = " + eliminado);
       // this.listarEmpleado(request, response);
        //String url = "/WEB-INF/Paginas/EliminadoAlerta.jsp";
        
        url = "/WEB-INF/Paginas/EliminadoAlerta.jsp";
                      //${pageContext.request.contextPath}/Salida.jsp"
        request.getRequestDispatcher(url).forward(request, response);

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
