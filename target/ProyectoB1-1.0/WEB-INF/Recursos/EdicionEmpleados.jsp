<%-- 
    Document   : EdicionEmpleados
    Created on : 18/05/2021, 02:46:59 PM
    Author     : JESÚS
--%>

<%@page import="Modelo.RutasJDBC"%>
<%@page import="Modelo.Rutas"%>
<%@page import="Modelo.BusetasJDBC"%>
<%@page import="Modelo.Busetas"%>
<%@page import="Modelo.Empleados"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.EmpleadosJDBC"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.3/css/all.css" integrity="sha384-SZXxX4whJ79/gErwcOYf+zWLeJdY/qpuqC4cAa9rOGUstPomtqpuNWT9wdPEn2fk" crossorigin="anonymous">
        <title>EditandoEMPLEADOS</title>
    </head>
    <body>

        <% String usuario = request.getParameter("usuario");%>
        <% String buseta = request.getParameter("buseta");%>
        <% String ruta = request.getParameter("ruta");%>
        
        
        
        
       <a href="${pageContext.request.contextPath}/Login" class="btn btn-outline-secondary border-3 mt-5 mx-5 "> Regresar</a>
            <% 
                if(usuario != null){
                    
                %>

        <%
            Empleados empl = new Empleados(request.getParameter("usuario"));

            List<Empleados> emp = new EmpleadosJDBC().ListarEmpleado(empl); %>

        <%

            for (Empleados empleado : emp) {


        %>

        <hr>

        <div class="d-flex justify-content-center col-19 " >

            <form class="p-2 m-1 w-50 " action="${pageContext.request.contextPath}/EmpleadosControl?accion=Modificar" method="POST">

                <h1 class="m-3 text-center" >EDITAR USUARIO</h1>
                <h1 class="title">Editar Usuario <%=  request.getParameter("usuario")%></h1>

                <div class="mb-3">
                    <label for="Cedula" class="form-label">Cedula Ciudadana</label>
                    <input type="number"  name="Identificacion" class="form-control" id="cedula" required="true" value="<%=  request.getParameter("usuario")%>"readonly>
                </div>
                <div class="mb-3" >
                    <label for="Nombre" class="form-label">Nombre</label>
                    <input type="text" name="Nombre" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required="true" value="<%= empleado.getNombre()%>" > 
                </div>
                <div class="mb-3">
                    <label for="Apellido" class="form-label">Apellido</label>
                    <input type="text" name="Apellido" class="form-control " id="Apellido" required="true" value="<%= empleado.getApellido()%>">
                </div>
                <div class="mb-3">
                    <label for="Correo" class="form-label">Correo</label>
                    <input type="text" name="Correo" class="form-control " id="Correo" required="true" value="<%= empleado.getCorreo()%>">
                </div>

                <div class="mb-3">
                    <label for="Telefono" class="form-label">Telefono</label>
                    <input type="tel" name="Telefono" class="form-control" id="telefono" required="true" value="<%= empleado.getTelefono()%>">
                </div>

                <div class="mb-3">
                    <label for="Direccion" class="form-label">Direccion</label>
                    <input type="text" class="form-control" id="direccion" name="Direccion" required="true" value="<%= empleado.getDireccion()%>">
                </div>
                <div class="p-2 m-3" >
                    <label for="formFile" class="form-label">Ingresar Imagen</label>
                    <input class="form-control" type="file" id="formFile" name="foto">
                </div> 
                <div class="mb-4 text-center">
                    <img src="Img?id=<%=  request.getParameter("usuario")%>" width="250" height="230">
                </div>
                <button type="submit" class="btn btn-primary w-100 py-3 my-4 rounded-pill  text-uppercase">Modificar</button>
                
                
                
                <%
                    }

                %>
            </form>
            <% 
            }
            %>
           
<!--BUSETa-->

         
           
            <% 
                if(buseta != null){
                    
                %>

        <%
            
            Busetas busetas = new Busetas(request.getParameter("buseta"));

            List<Busetas> busetasJDBC = new BusetasJDBC().ListaBuseta(busetas); %>

        <%

            for (Busetas bus : busetasJDBC) {


        %>

        <hr>

        <div class="d-flex justify-content-center col-19 " >

            <form class="p-2 m-1 w-50 " action="${pageContext.request.contextPath}/BusetasControl?accion=Modificar" method="POST">

                <h1 class="m-3 text-center" >EDITAR BUSETA</h1>
                <h1 class="title">Editar busetas <%=  request.getParameter("buseta")%></h1>

                <div class="mb-3" >
                    <label for="Modelo" class="form-label">Modelo</label>
                    <input type="text" name="Modelo" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required="true" value="<%= bus.getModelo()%>" > 
                </div>
                <div class="mb-3">
                    <label for="Marca" class="form-label">Marca</label>
                    <input type="text" name="Marca" class="form-control " id="Marca" required="true" value="<%= bus.getMarca()%>">
                </div>
                <div class="mb-3">
                    <label for="Color" class="form-label">Color</label>
                    <input type="text" name="Color" class="form-control " id="Color" required="true" value="<%= bus.getColor() %>">
                </div>

                <div class="mb-3">
                    <label for="Placa" class="form-label">Placa</label>
                    <input type="text" name="Placa" class="form-control" id="Placa" required="true" value="<%= bus.getPlaca()%>" readonly="">
                </div>
                
                <button type="submit" class="btn btn-primary w-100 py-3 my-4 rounded-pill  text-uppercase">Modificar</button>
                
                
                
                <%
                    }

                %>
            </form>
    <% 
            }
        
            %>

            
            
            <!-- RUTA -->
            <% 
                if(ruta != null){
                    
                %>
                

        <%
            Rutas rutas = new Rutas(request.getParameter("ruta"));
            
            List<Rutas> lisruta = new RutasJDBC().ListaRuta(rutas); %>

        <%

            for (Rutas laRuta : lisruta) {


        %>

        <hr>

        <div class="d-flex justify-content-center col-19 " >

            <form class="p-2 m-1 w-50 " action="${pageContext.request.contextPath}/EmpleadosControl?accion=Modificar" method="POST">

                <h1 class="m-3 text-center" >EDITAR RUTAS</h1>
                <h1 class="title">Editar Ruta <%=  request.getParameter("ruta")%></h1>

                <div class="mb-3">
                    <label for="Cedula" class="form-label">Codigo Ruta</label>
                    <input type="text"  name="Identificacion" class="form-control" id="cedula" required="true" value="<%= laRuta.getCodigoRuta()%>"readonly>
                </div>
                <div class="mb-3" >
                    <label for="Nombre" class="form-label">Nombre</label>
                    <input type="text" name="Nombre" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required="true" value="<%= laRuta.getNombre()%>" > 
                </div>
                <div class="mb-3">
                    <label for="Apellido" class="form-label">Precio</label>
                    <input type="text" name="Apellido" class="form-control " id="Apellido" required="true" value="<%= laRuta.getPrecio()%>">
                </div>
                <div class="mb-3">
                    <label for="Correo" class="form-label">Correo</label>
                    <input type="text" name="Correo" class="form-control " id="Correo" required="true" value="<%= laRuta.getImagen()%>">
                </div>

                <div class="mb-3">
                    <label for="Telefono" class="form-label">Telefono</label>
                    <input type="text" name="Telefono" class="form-control" id="telefono" required="true" value="<%= laRuta.getInfo()%>">
                </div>
 
                <div class="mb-4 text-center">
                   <!--<img src="Img?id/<%=  request.getParameter("ruta")%>" width="250" height="230"> -->
                   <img src="Imagenes/<%= laRuta.getImagen()%>" width="250" height="230">
                </div> 
                
                <button type="submit" class="btn btn-primary w-100 py-3 my-4 rounded-pill  text-uppercase">Modificar</button>
                
                
                
                <%
                    }

                %>
            </form>
            
            <% 
            }
            %>
            
        </div>
            <hr>
    </body>
</html>
