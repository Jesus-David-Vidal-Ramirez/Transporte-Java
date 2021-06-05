/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DATOS.UsuarioJDBC;
import Modelo.Usuarios;
import java.io.IOException;

import java.util.List;
import java.util.Objects;
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
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    UsuarioJDBC consulta = new UsuarioJDBC();
    Usuarios usuario = null;
    HttpSession sesion;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         
        
            this.Loguear(request, response);
        
        
//        if(sesion.getAttribute("usuario") == null){
//            System.out.println("NO HAY SESSION");
//            response.sendRedirect("inicio.jsp");
//            request.getRequestDispatcher("/WEB-INF/Paginas/Alerta.jsp").forward(request, response);
//        }else{
//            System.out.println("SI HAY SESSION");
//        }

    }
    Object dato = null;

    private void Loguear(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "";

        String user = request.getParameter("user");
        String pass = request.getParameter("pass");

        if (user == null && usuario == null) {
            System.out.println("User" + user);
            System.out.println("USuario.get" + usuario);
            url = "/WEB-INF/Paginas/Alerta.jsp";
            System.out.println("LA URL " + url);
            // request.getRequestDispatcher("/WEB-INF/Paginas/Alerta.jsp").forward(request, response);

        } else if (user != null) {
            System.out.println("User" + user);
            System.out.println("USUARIo" + usuario);
            usuario = consulta.Acceso(new Usuarios(user, pass));
            if (usuario.getMensaje().equals("Se encontro un dato")) {
                System.out.println("Usuario mensaje " + usuario.getMensaje());
                System.out.println("USUARIO con ROL " + usuario.getRol());
                sesion = request.getSession();
                sesion.setAttribute("usuario", usuario);
                
                if (usuario.getRol().equals("1")) {
                    this.listar(request, response);
                    url = "Salida.jsp";
                    System.out.println("LA URL " + url);
                }else{
                    url = "acceso.jsp";
                }
                dato = sesion.getAttribute("usuario");

            } else {
                url = "/WEB-INF/Paginas/Alerta.jsp";
                System.out.println("LA URL " + url);
            }
            System.out.println("Usuario mensajess2 " + usuario.getMensaje());
            System.out.println("usuario es: " + usuario.getUsuario());
            System.out.println("los datos " + dato);
            System.out.println("El usuario, " + usuario);

            //sesion.setAttribute("inicio", name);
            //response.sendRedirect("welcome.jsp");
            System.out.println("EL OBJECT DATO" + dato);
            //this.listar(request, response);
            //url = "Salida.jsp";
            //request.getRequestDispatcher("Salida.jsp").forward(request, response);
        }
        else if(dato != null){
            
                if (usuario.getRol().equals("1")) {
                    System.out.println("ahora si perro pasa");
              System.out.println("Los datos" + dato);
              this.listar(request, response);
               url =  "Salida.jsp";
                    System.out.println("la URL" + url);
                    
                }else{
                    url = "acceso.jsp";
                     System.out.println("la URL" + url);
                }
              
             
        }
        else {

            System.out.println("QUe pasa");
            url = "/WEB-INF/Paginas/Alerta.jsp";
        }

//            System.out.println("El ID" + sesion.getId());
        request.getRequestDispatcher(url).forward(request, response);

    }

    private void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Usuarios> usuarios = new UsuarioJDBC().listar();

        request.setAttribute("usuarios", usuarios);
        request.getRequestDispatcher("Salida.jsp");

    }
    
    
    private void logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

          System.out.println("El ID" + sesion.getId());
//        Object dato = sesion.getAttribute("usuario");
//        System.out.println("NO NULL los object " + dato);
        
        sesion.getAttribute("usuario");
//        dato = sesion.getAttribute("usuario");
         dato = sesion.getAttribute("usuario");
          System.out.println("Datps desde el logout " + dato);
          //Y si en ves de eso mando el usuario null 
        sesion.removeAttribute("usuario");
        sesion.invalidate(); 
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
        //doGet(request, response);
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
