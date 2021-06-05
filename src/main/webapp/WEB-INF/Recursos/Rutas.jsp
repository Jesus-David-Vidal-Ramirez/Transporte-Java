<%-- 
    Document   : Rutas
    Created on : 5/05/2021, 09:33:20 PM
    Author     : JESÚS
--%>

<%@page import="java.util.List"%>
<%@page import="Modelo.RutasJDBC"%>
<%@page import="Modelo.Rutas"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <div class="p-3 d-flex justify-content-center mt-4">
            <h1>
                Destinos mas buscados
            </h1>
        </div>
        
        
            
        <% HttpSession sesion = request.getSession(); %>
            <% if(sesion.getAttribute("usuario")!=null ){ 
            
            %>
            
            
            <div class="row row-cols-1 row-cols-md-3 g-4  m-4 pb-3  " id="Rutas">
            <%
                List<Rutas> listas = RutasJDBC.obtenerRutas();

                for (Rutas ruta : listas) {
            %>
            <div class="col" >
                <div class="card" >
                    <img src="Imagenes/<%=ruta.getImagen()%>" class="card-img-top" alt="<%=ruta.getImagen()%>" width="1200px" height="330px">
                    <div class="card-body" height="330px" style="max-height: 100%">
                        <h5 class="card-title"><%=ruta.getNombre()%></h5>
                        <p class="card-text"  >
                            <%=ruta.getInfo()%>
                        </p>
                    </div>
                    <div class="card-footer d-flex justify-content-between"   >
                        <!-- class="btn btn-primary me-5" data-bs-toggle="modal" data-bs-target="#exampleModal"-->
                        <form method="post" action="${pageContext.request.contextPath}/RutasControl?accion=Compras&ruta=<%= ruta.getCodigoRuta()%>">
                        <button name="Compra" class="btn btn-danger" >Comprar</button>
                        </form>

                        <strong class="pl-3">$ <%=ruta.getPrecio()%> COP</strong>
                        <form method="post" action="${pageContext.request.contextPath}/RutasControl?accion=Reservar&ruta=<%= ruta.getCodigoRuta()%>">
                            <button   name="Reservar" class="btn btn-warning" >Reservas</button>
                        </form>
                    </div>
                </div>
            </div>
            <% }%> 
        </div> 
            <% 
            }else{
            %>
            
            <div class="row row-cols-1 row-cols-md-3 g-4  m-4 pb-3  " id="Rutas">
            <%
                List<Rutas> listas = RutasJDBC.obtenerRutas();

                for (Rutas ruta : listas) {
            %>
            <div class="col" >
                <div class="card" >
                    <img src="Imagenes/<%=ruta.getImagen()%>" class="card-img-top" alt="<%=ruta.getImagen()%>" width="1200px" height="330px">
                    <div class="card-body" height="330px" style="max-height: 100%">
                        <h5 class="card-title"><%=ruta.getNombre()%></h5>
                        <p class="card-text"  >
                            <%=ruta.getInfo()%>
                        </p>
                    </div>
                    <div class="card-footer d-flex justify-content-between"   >
                        <!-- class="btn btn-primary me-5" data-bs-toggle="modal" data-bs-target="#exampleModal"-->

                        <button name="Compra" class="btn btn-danger"  data-bs-toggle="modal" data-bs-target="#exampleModal">Comprar</button>
                        <strong class="pl-3">$ <%=ruta.getPrecio()%> COP</strong>
                        <button   name="Reservar" class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#exampleModal1">Reservas</button>
                        

                    </div>
                </div>

            </div>

            <% }%> 

        </div> 
            <% }
                %>  
           

            

        <!-- Modal -->
        <div class="modal fade " id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Iniciar session</h5>
                        <!-- <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button> -->
                        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Cerrar</button>
                    </div>
                    <div class="modal-body">
                        <!-- FORMULARIO LOGIN -->
                        <form method="POST" action="${pageContext.request.contextPath}/Login" >
                            <div class="mb-3">
                                <label for="exampleInputEmail1" class="form-label">Email address</label>
                                <input type="text" name="user" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required="" placeholder="Usuario">

                            </div>
                            <div class="mb-3">
                                <label for="exampleInputPassword1" class="form-label">Password</label>
                                <input type="text" name="pass" class="form-control" id="exampleInputPassword1" required="" placeholder="Contraseña">
                            </div>
                            <!-- <div class="mb-3 form-check">
                              <input type="checkbox" class="form-check-input" id="exampleCheck1">
                              <label class="form-check-label" for="exampleCheck1">Check me out</label>
                            </div> -->
                            <!-- <button type="submit" class="btn btn-primary">Submit</button> -->
                            <div d-flex justify-content-center>
                                <button type="submit" class="btn btn-primary justify-content-end">Iniciar session </button><br>
                            </div>
                        </form>

                    </div>

                    <form action="${pageContext.request.contextPath}/Registro.jsp" method="POST">
                        <div class="modal-footer">
                            <p>Algunas funcionalidades de esta pagina web estan solo disponibles para usuarios registrados. Crea una cuenta ahora y obten acceso a las paginas protegidas de esta web</p>
                            <button type="submit" class="btn btn-success">Registrarse</button>
                    </form>

                </div> 
            </div>
        </div>
    </div>


        <!-- Modal Reservas -->
        <div class="modal fade " id="exampleModal1" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Iniciar session</h5>
                        <!-- <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button> -->
                        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Cerrar</button>
                    </div>
                    <div class="modal-body">
                        <!-- FORMULARIO LOGIN -->
                        <form method="POST" action="${pageContext.request.contextPath}/Login" >
                            <div class="mb-3">
                                <label for="exampleInputEmail1" class="form-label">Email address</label>
                                <input type="text" name="user" class="form-control"  id="exampleInputEmail1" aria-describedby="emailHelp" required="" placeholder="Usuario">

                            </div>
                            <div class="mb-3">
                                <label for="exampleInputPassword1" class="form-label">Password</label>
                                <input type="text" name="pass" class="form-control" id="exampleInputPassword1" required="" placeholder="Contraseña">
                            </div>
                            <!-- <div class="mb-3 form-check">
                              <input type="checkbox" class="form-check-input" id="exampleCheck1">
                              <label class="form-check-label" for="exampleCheck1">Check me out</label>
                            </div> -->
                            <!-- <button type="submit" class="btn btn-primary">Submit</button> -->
                            <div d-flex justify-content-center>
                                <button type="submit" class="btn btn-primary justify-content-end">Iniciar session </button><br>
                            </div>
                        </form>

                    </div>

                    <form action="${pageContext.request.contextPath}/Registro.jsp" method="POST">
                        <div class="modal-footer">
                            <p>Algunas funcionalidades de esta pagina web estan solo disponibles para usuarios registrados. Crea una cuenta ahora y obten acceso a las paginas protegidas de esta web</p>
                            <button type="submit" class="btn btn-success">Registrarse</button>
                    </form>

                </div> 
            </div>
        </div>
    </div>





</body>
</html>
