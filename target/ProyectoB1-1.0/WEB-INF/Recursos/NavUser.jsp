	

<%@page import="Modelo.VentasJDBC"%>
<%@page import="Modelo.Ventas"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Usuarios"%>
<%@page import="Modelo.RutasJDBC"%>
<%@page import="Modelo.Rutas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%

    // Rutas producto = RutasJDBC.obtenerRuta(Integer.parseInt(request.getParameter("id")));
    Usuarios usuario = new Usuarios();
    Object datos = null;
%>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>acceso</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.3/css/all.css" integrity="sha384-SZXxX4whJ79/gErwcOYf+zWLeJdY/qpuqC4cAa9rOGUstPomtqpuNWT9wdPEn2fk" crossorigin="anonymous">

    </head>
    <body>

        <% usuario = (Usuarios) session.getAttribute("usuario"); %>
        <% if (usuario == null) {

        %>

        <p>Se puso nula</p>
        <%            }
        %>

        <nav class="navbar navbar-expand-lg navbar-light bg-light mt-4 " id="Inicio">

            <div class="container-fluid ">
                <!-- Button trigger modal -->

                <!-- -->

                <div class="dropdown m-3">
                    <button class="btn btn-success dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                        Usuario <%= usuario.getUsuario()%> 
                    </button>

                    <ul class="dropdown-menu" >
                        <li class="Reservas" data-bs-toggle="modal" data-bs-target="#Reservas"><a class="dropdown-item" href="#" >Reservas</a></li>
                        <li class="Compras" data-bs-toggle="modal" data-bs-target="#Compras" ><a class="dropdown-item" href="#">Compras</a></li>
                        <li class="Cerrar"  ><a class="dropdown-item" href="${pageContext.request.contextPath}/Logout"  >Cerrar Session</a></li>

                    </ul>
                </div>




                <!-- Modal Reservas -->
                <div class="modal fade " id="Reservas" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered modal-lg">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title col-12 text-center" id="exampleModalLabel">Reservas</h5>
                            </div>
                            <div class="modal-body">     

                                <table border="1" class="table"> 
                                    <caption>Reservas</caption>
                                    <th>idRuta</th>
                                    <th>Usuario</th>
                                    <th>Cantidad</th>
                                    <th>Precio</th>
                                    <th>Nombre Ruta</th>
                                    <th>Tipo</th>
                                    <th>Total</th>
                                        <% String idreserva = usuario.getUsuario(); %> 

                                    <% List<Ventas> reserva = new VentasJDBC().listarReservas(idreserva);
                                        for (Ventas Reservas : reserva) {
                                        int total = 0 ;
                                        int cantidad = 0 ;
                                        int precio = 0 ;
                                    %>
                                    <tr>
                                        <td><%= Reservas.getIdRuta()%></td>
                                        <td><%= Reservas.getIdUsuario()%></td>
                                        <td><%= Reservas.getCantidad()%></td>
                                        <td><%= Reservas.getPrecio()%></td>
                                        <td><%= Reservas.getNombreRuta()%></td>
                                        <td><%= Reservas.getTipo()%></td>
                                         <% cantidad = Integer.parseInt(Reservas.getCantidad()); %>
                                         <% precio = Integer.parseInt(Reservas.getPrecio()); %>
                                         <% total = precio * cantidad; %>
                                        <td><%= total %></td>
                                    </tr>
                                    <%
                                        }

                                    %>
                                </table>
                            </div>
                        </div> 
                    </div>
                </div>

                <!-- Modal Compras-->
                <div class="modal fade " id="Compras" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered modal-lg">
                        <div class="modal-content">
                            <div class="modal-header ">
                                <h5 class="modal-title col-12 text-center" id="exampleModalLabel">Compras</h5>
                                
                            </div>
                            <div class="modal-body">     
                                
                                <table border="1" class="table"> 
                                    <caption>Compras</caption>
                                    <th>idRuta</th>
                                    <th>Usuario</th>
                                    <th>Cantidad</th>
                                    <th>Precio</th>
                                    <th>Nombre Ruta</th>
                                    <th>Tipo</th>
                                    <th>Total</th>
                                        <% String idCompras = usuario.getUsuario(); %> 

                                    <% List<Ventas> compra = new VentasJDBC().listarCompras(idCompras);
                                        for (Ventas Compras : compra) {
                                        int total = 0 ;
                                        int cantidad = 0 ;
                                        int precio = 0 ;
                                    %>
                                    <tr>
                                        <td><%= Compras.getIdRuta()%></td>
                                        <td><%= Compras.getIdUsuario()%></td>
                                        <td><%= Compras.getCantidad()%></td>
                                        <td><%= Compras.getPrecio()%></td>
                                        <td><%= Compras.getNombreRuta()%></td>
                                        <td><%= Compras.getTipo()%></td>
                                         <% cantidad = Integer.parseInt(Compras.getCantidad()); %>
                                         <% precio = Integer.parseInt(Compras.getPrecio()); %>
                                         <% total = precio * cantidad; %>
                                        <td><%= total %></td>
                                    </tr>
                                    <%
                                        }

                                    %>
                                </table>
                            </div>
                        </div> 
                    </div>
                </div>


                <i class="fas fa-bus"></i>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item ">
                            <a class="nav-link " aria-current="page" href="#Inicio">Inicio</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#Rutas">Nuestras Rutas</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#contacto">Contactos</a>
                        </li>

                    </ul>
                    <form class="d-flex">
                        <input class="form-control me-2" type="search" placeholder="Destino" aria-label="Search">
                        <button class="btn btn-outline-success" type="submit">Buscar</button>
                    </form>
                </div>
            </div>
        </nav>

        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1440 320">
        <text x="600" y="100" font-size="4em" font-weight="2em" letter-spacing="1em">RIKLINSUS</text>
        <path fill="#0099ff" fill-opacity="1" d="M0,32L30,48C60,64,120,96,180,96C240,96,300,64,360,58.7C420,53,480,75,540,122.7C600,171,660,245,720,245.3C780,245,840,171,900,165.3C960,160,1020,224,1080,250.7C1140,277,1200,267,1260,250.7C1320,235,1380,213,1410,202.7L1440,192L1440,320L1410,320C1380,320,1320,320,1260,320C1200,320,1140,320,1080,320C1020,320,960,320,900,320C840,320,780,320,720,320C660,320,600,320,540,320C480,320,420,320,360,320C300,320,240,320,180,320C120,320,60,320,30,320L0,320Z"></path>
        </svg>



        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>

        <script src="https://kit.fontawesome.com/247d2323bf.js" crossorigin="anonymous"></script>
    </body>
</html>
