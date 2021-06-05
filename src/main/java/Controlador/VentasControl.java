/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Ventas;
import Modelo.VentasJDBC;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JESÚS
 */
public class VentasControl extends HttpServlet {

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
        String accion = request.getParameter("accion");
        String url = null;
        Ventas venta = null;
        VentasJDBC ventasJDBC = new VentasJDBC();
        String tipo = null;
        String Nombre = null;
        String Precio = null;
        String Cantidad = null;
        String idUsuario = null;
        String idRuta = null;

        int rows = 0;
        switch (accion) {
            case "Reservo":
                System.out.println("Entre");
                idRuta = request.getParameter("ruta");
                idUsuario = request.getParameter("usuario");
                Cantidad = request.getParameter("Cantidad");
                Precio = request.getParameter("Precio");
                Nombre = request.getParameter("Nombre");
                tipo = "Reservas";

                venta = new Ventas(idRuta, idUsuario, Cantidad, Precio, Nombre, tipo);
                System.out.println("Ventacotnro" + venta);
                rows = new VentasJDBC().Reservas(venta);

                if (rows >= 1) {
                    System.out.println("inserto rows " + rows);
                    url = "/WEB-INF/Paginas/Agregado.jsp";
                } else {
                    System.out.println("NO inserto rows " + rows);
                    url = "/WEB-INF/Paginas/AgregadoAlerta.jsp";
                }
                request.getRequestDispatcher(url).forward(request, response);
                break;
            case "Compro":
                System.out.println("Compro");
                idRuta = request.getParameter("ruta");
                idUsuario = request.getParameter("usuario");
                Cantidad = request.getParameter("Cantidad");
                Precio = request.getParameter("Precio");
                Nombre = request.getParameter("Nombre");
                tipo = "Compras";

                venta = new Ventas(idRuta, idUsuario, Cantidad, Precio, Nombre, tipo);
                System.out.println("Ventacotnro" + venta);
                rows = new VentasJDBC().Compras(venta);

                if (rows >= 1) {
                    System.out.println("inserto rows " + rows);
                    url = "/WEB-INF/Paginas/Agregado.jsp";
                } else {
                    System.out.println("NO inserto rows " + rows);
                    url = "/WEB-INF/Paginas/AgregadoAlerta.jsp";
                }
                request.getRequestDispatcher(url).forward(request, response);
                break;
            default:
                request.getRequestDispatcher("Login.jsp").forward(request, response);
                break;
        }
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
