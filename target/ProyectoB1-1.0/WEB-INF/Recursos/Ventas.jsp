<%-- 
    Document   : DetallesVentas
    Created on : 2/06/2021, 07:08:51 PM
    Author     : JESÚS
--%>

<%@page import="Modelo.Usuarios"%>
<%@page import="Modelo.RutasJDBC"%>
<%@page import="Modelo.Rutas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>


    <jsp:include page="NavUser.jsp"></jsp:include>
    <% Usuarios usuario = new Usuarios();
            usuario = (Usuarios) session.getAttribute("usuario"); %>

    <% int nombre = Integer.parseInt(request.getParameter("ruta")); %>
    <p>--</p>

    <% Rutas ruta = new Rutas();%>

    <%  ruta = new RutasJDBC().obtenerRuta(nombre);%>

    <div class="justify-content-center d-flex" >
        <div class="card mb-3 " style="max-width: 640px;">
            <div class="row g-0">
                <div class="col-md-8">
                    <img src="Imagenes/<%= ruta.getImagen()%>" alt="<%= ruta.getImagen()%>" width="410" height="360">
                </div>

                <div class="col-md-4">
                    <div class="card-body mx-2">
                        <% String boton = request.getParameter("accion"); %>
                        <% if (boton.equals("Reservar")) {%>
                        
                        <form action="${pageContext.request.contextPath}/VentasControl?accion=Reservo&usuario=<%= usuario.getUsuario()%>&ruta=<%= ruta.getCodigoRuta()%>&Precio=<%=ruta.getPrecio()%>&Nombre=<%=ruta.getNombre()%>" method="Post"> 
                            <h5 class="card-title text-center py-2"> <strong class="text-uppercase" > <%= ruta.getNombre()%> </strong></h5>
                            <label class="py-2">Cantidad</label> <input type="number" value="1" min="1" max="10" name="Cantidad">
                            <br>
                            <strong name="Precio" >$ <%= ruta.getPrecio() %> COP</strong>
                            <p class="py-3" name="CodigoRuta">Vehiculo disponible <%= ruta.getCodigoRuta()%> </p>
                            <button type="submit" class="btn btn-outline-primary mb-3 w-100 text-uppercase" name="Reservas"> Reservar</button>
                        </form>
                        <% 
                            }
                        %>
                        <% if(boton.equals("Compras")){ %>
                        
                        <form action="${pageContext.request.contextPath}/VentasControl?accion=Compro&usuario=<%= usuario.getUsuario()%>&ruta=<%= ruta.getCodigoRuta()%>&Precio=<%=ruta.getPrecio()%>&Nombre=<%=ruta.getNombre()%>" method="Post"> 
                        <h5 class="card-title text-center py-2"> <strong class="text-uppercase" > <%= ruta.getNombre() %> </strong></h5>

                        <label class="py-2">Cantidad</label> <input type="number" value="1" min="1" max="10" name="Cantidad">
                        <br>
                        <strong name="Precio" >$ <%= ruta.getPrecio() %> COP</strong>
                        <p class="py-3" name="CodigoRuta">Vehiculo disponible <%= ruta.getCodigoRuta()%> </p>

                        <button type="submit" class="btn btn-outline-primary w-100 my-4 text-uppercase">Comprar</button>
                        </form>
                        <% 
                            }
                        %>

                        <a href="${pageContext.request.contextPath}/Login" class="btn btn-outline-danger border-3  w-100 text-uppercase"> cancelar</a>
                        <p class="card-text pt-4"><small class="text-muted">Desde Sincelejo</small></p>

                    </div>
                </div>
            </div>
        </div>
    </div>

    <jsp:include page="Footer.jsp"></jsp:include>



</html>
