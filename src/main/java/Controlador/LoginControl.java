/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DATOS.Conexion;
import DATOS.UsuarioJDBC;
import Modelo.Empleados;
import Modelo.EmpleadosJDBC;
import Modelo.Usuarios;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author JESÚS
 */
@WebServlet(name = "LoginControl", urlPatterns = {"/LoginControl"})
public class LoginControl extends HttpServlet {

    

    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    UsuarioJDBC consulta = new UsuarioJDBC();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");

        switch (accion) {
//            case "Login":
//                //this.Loguear(request, response);
//                break;

            case "Insertar":
                this.Insertar(request, response);
                break;

            case "Editado":

                this.Editado(request, response);
                break;

            default:
                break;
        }
    }

//    private void Loguear(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        String user = request.getParameter("email");
//        String pass = request.getParameter("pass");
//
//        Usuarios usuario = consulta.Acceso(new Usuarios(user, pass));
//        HttpSession sesion = request.getSession();
//
//        sesion.setAttribute("usuario", usuario);
//        System.out.println(usuario);
//        if (usuario.getMensaje().equals("Se encontro un dato")) {
//            System.out.println("los datos aca son " + usuario);
//            this.listar(request, response);
//            request.getRequestDispatcher("Salida.jsp").forward(request, response);
//
//        } else {
//            String url = "/WEB-INF/Paginas/Alerta.jsp";
//            request.getRequestDispatcher(url).forward(request, response);
//        }
//
//    }

    private void Insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usuario = request.getParameter("IUsuario");
        String Password = request.getParameter("IPassword");
        String Telefono = request.getParameter("ITelefono");
        String Identificacion = request.getParameter("IIdentificacion");
        String Correo = request.getParameter("ICorreo");
        String Rol = request.getParameter("IRol");

        int insertar = 0;
        Usuarios usu = new Usuarios(usuario, Password, Telefono, Identificacion, Correo,Rol);
        if (!consulta.VerificarId(usu)) {
            insertar = new UsuarioJDBC().Insertar(usu);
            System.out.println("Numero de inseccion" + insertar);
            String url = "/WEB-INF/Paginas/RegistroAlertaExitosa.jsp";
            request.getRequestDispatcher(url).forward(request, response);

        } else {
            String Alerta = "/WEB-INF/Paginas/RegistroAlerta.jsp";
            request.getRequestDispatcher(Alerta).forward(request, response);

        }
    }

    private void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Usuarios> usuarios = new UsuarioJDBC().listar();

        request.setAttribute("usuarios", usuarios);
        request.getRequestDispatcher("Salida.jsp");

    }
    
    private void listarEmp(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Empleados> empleados = new EmpleadosJDBC().listarE();
        System.out.println("listarEMp " + empleados);
        request.setAttribute("empleados", empleados);
        //request.getRequestDispatcher("Salida.jsp");

    }
    
    private void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int eliminado = 0;
        String key = request.getParameter("accion");

        Usuarios usuario = new Usuarios(key);

        eliminado = new UsuarioJDBC().Eliminar(usuario);
        System.out.println("Eliminados = " + eliminado);
        this.listar(request, response);
        //String url = "/WEB-INF/Paginas/EliminadoAlerta.jsp";
        
        String url = "/WEB-INF/Paginas/EliminadoAlerta.jsp";
                      //${pageContext.request.contextPath}/Salida.jsp"
        request.getRequestDispatcher(url).forward(request, response);

    }

    private void Editado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String user = request.getParameter("Usuario");
        String Password = request.getParameter("Password");
        String Telefono = request.getParameter("Telefono");
        String Identificacion = request.getParameter("Identificacion");
        String Correo = request.getParameter("Correo");
        String Rol = request.getParameter("Rol");
        Usuarios usuario = new Usuarios(user, Password, Telefono, Identificacion, Correo, Rol);
        System.out.println("EL usuario del parametro es " + usuario);
        int rows = new UsuarioJDBC().Modificar(usuario);
        System.out.println("rows " + rows);
        ///
//      
//        if (Password.equals("") && Telefono.equals("") && Correo.equals("") && Identificacion.equals("") && Rol.equals("")) {
//            System.out.println("Todos vacios");
//            user = new Usuarios(oculto, pass, tel, iden, cor);
//            rows = new UsuarioJDBC().Modificar(user);
//        } else if (Password.equals("") && Telefono.equals("") && Correo.equals("") && Rol.equals("")) {
//            System.out.println("Menos Identificacion");
//            user = new Usuarios(oculto, pass, tel, Identificacion, cor);
//            rows = new UsuarioJDBC().Modificar(user);
//        } else if (Correo.equals("") && Identificacion.equals("") && Password.equals("") && Rol.equals("")) {
//            System.out.println("Menos Telefono");
//            user = new Usuarios(oculto, pass, Telefono, iden, cor);
//            rows = new UsuarioJDBC().Modificar(user);
//        } else if (Telefono.equals("") && Password.equals("") && Identificacion.equals("") && Rol.equals("")) {
//            System.out.println("Menos Correo");
//            user = new Usuarios(oculto, pass, tel, iden, Correo);
//            rows = new UsuarioJDBC().Modificar(user);
//        } else if (Telefono.equals("") && Correo.equals("") && Identificacion.equals("") && Rol.equals("")) {
//            System.out.println("Menos pass");
//            user = new Usuarios(oculto, Password, tel, iden, cor);
//            rows = new UsuarioJDBC().Modificar(user);
//        } else if (Password.equals("") && Telefono.equals("") && Rol.equals("")) {
//            System.out.println("tel y pass");
//            user = new Usuarios(oculto, pass, tel, Identificacion, Correo);
//            rows = new UsuarioJDBC().Modificar(user);
//        } else if (Password.equals("") && Correo.equals("")) {
//            System.out.println("Correo y pass");
//            user = new Usuarios(oculto, pass, Telefono, Identificacion, cor);
//            rows = new UsuarioJDBC().Modificar(user);
//        } else if (Password.equals("") && Identificacion.equals("")) {
//            System.out.println("Identificacion y pass");
//            user = new Usuarios(oculto, pass, Telefono, iden, Correo);
//            rows = new UsuarioJDBC().Modificar(user);
//        } else if (Telefono.equals("") && Correo.equals("")) {
//            System.out.println("Correo y tel");
//            user = new Usuarios(oculto, Password, tel, Identificacion, cor);
//            rows = new UsuarioJDBC().Modificar(user);
//        } else if (Telefono.equals("") && Identificacion.equals("")) {
//            System.out.println("Identificacion y tell");
//            user = new Usuarios(oculto, Password, tel, iden, Correo);
//            rows = new UsuarioJDBC().Modificar(user);
//        } else if (Password.equals("")) {
//            System.out.println("solo pass");
//            user = new Usuarios(oculto, pass, Telefono, Identificacion, Correo);
//            rows = new UsuarioJDBC().Modificar(user);
//
//        } else if (Telefono.equals("")) {
//            System.out.println("solo tel");
//            user = new Usuarios(oculto, Password, tel, Identificacion, Correo);
//            rows = new UsuarioJDBC().Modificar(user);
//
//        } else if (Correo.equals("")) {
//            System.out.println("solo corre");
//            user = new Usuarios(oculto, Password, Telefono, Identificacion, cor);
//            rows = new UsuarioJDBC().Modificar(user);
//
//        } else if (Identificacion.equals("")) {
//            System.out.println("solo identifiaccion");
//            user = new Usuarios(oculto, Password, Telefono, iden, Correo);
//            rows = new UsuarioJDBC().Modificar(user);
//        } else {
//            System.out.println("todos llenos");
//            user = new Usuarios(oculto, Password, Telefono, Identificacion, Correo);
//            rows = new UsuarioJDBC().Modificar(user);
//        }

     
        request.setAttribute("editado", user);

        String url = "/WEB-INF/Paginas/prueba.jsp";
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
        String accion = request.getParameter("accion");
        switch (accion) {
            case "Eliminar":
                this.eliminar(request, response);
                break;
            case "Editar":
                String url = "/WEB-INF/Paginas/Editar.jsp";
                request.getRequestDispatcher(url).forward(request, response);
                break;
            case "Editado":
                this.Editado(request, response);
                break;

        }

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
