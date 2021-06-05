/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuarios;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author JESÚS
 */
@WebServlet(name = "Logout", urlPatterns = {"/Logout"})
public class Logout extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        this.Logout(request, response);
       
    }
    
    Usuarios usuario;
      private void Logout( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
       
        HttpSession sesion = request.getSession();
        
          System.out.println("El ID" + sesion.getId());
//        Object dato = sesion.getAttribute("usuario");
//        System.out.println("NO NULL los object " + dato);
        
        sesion.getAttribute("usuario");
//        dato = sesion.getAttribute("usuario");
        Object dato = sesion.getAttribute("usuario");
          System.out.println("Datps desde el logout " + dato);
          //Y si en ves de eso mando el usuario null 
        sesion.removeAttribute("usuario");
        sesion.invalidate(); 
        usuario = null;
          System.out.println("USUARIOS LOGOUT " + usuario);
        System.out.println("Datps desde el logout invalidate " + dato);
        System.out.println("El ID invalidado" + sesion.getId());
//          System.out.println("Esta session se perdio ");
//             System.out.println("No es vacia");
//             System.out.println("DEBE SER NULL los object " + dato);
//             System.out.println("Los usuarios del logout " + usuario);
//             usuario = null;
//             dato = null;
//             System.out.println("Los usuarios del logout " + usuario);
//             System.out.println("DEBE SER NULL los object " + dato);
        String url = "/WEB-INF/Paginas/CerrarSession.jsp";
                                       
        //response.sendRedirect("CerrarSession.jsp");
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
