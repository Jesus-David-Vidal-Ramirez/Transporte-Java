<%-- 
    Document   : Editar
    Created on : 7/04/2021, 05:26:10 PM
    Author     : JESÚS
--%>



<%@page import="DATOS.UsuarioJDBC"%>
<%@page import="Modelo.EmpleadosJDBC"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Empleados"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Modelo.Usuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
       <!-- <link rel="stylesheet" href="../../CSS/nuevoo.css">
        <link rel="stylesheet" type="text/css"  href="/ProyectoB1/CSS/Edicion.css" /> -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.3/css/all.css" integrity="sha384-SZXxX4whJ79/gErwcOYf+zWLeJdY/qpuqC4cAa9rOGUstPomtqpuNWT9wdPEn2fk" crossorigin="anonymous">
  
    </head>
    <body>
            
               
<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1440 320">
   <text x="680" y="100" font-size="4em" font-weight="2em" letter-spacing="1em">RIKLINSUS</text>
  <path fill="#0099ff" fill-opacity="1" d="M0,32L30,48C60,64,120,96,180,96C240,96,300,64,360,58.7C420,53,480,75,540,122.7C600,171,660,245,720,245.3C780,245,840,171,900,165.3C960,160,1020,224,1080,250.7C1140,277,1200,267,1260,250.7C1320,235,1380,213,1410,202.7L1440,192L1440,320L1410,320C1380,320,1320,320,1260,320C1200,320,1140,320,1080,320C1020,320,960,320,900,320C840,320,780,320,720,320C660,320,600,320,540,320C480,320,420,320,360,320C300,320,240,320,180,320C120,320,60,320,30,320L0,320Z"></path>
</svg>

<a href="${pageContext.request.contextPath}/Login" class="btn btn-outline-secondary border-3 mt-5 mx-5 "> Regresar </a>
<div class="d-flex justify-content-center col-19 " >
       
             <%
            Usuarios usu = new Usuarios(request.getParameter("usuario"));

            List<Usuarios> usua = new UsuarioJDBC().ListarUsuario(usu); %>

        <%

            for (Usuarios usuario : usua) {


        %>            
    <form class="p-5 m-3 w-50" action="${pageContext.request.contextPath}/LoginControl?accion=Editado" method="POST">

        <h1 class="m-4 text-center">REGISTRO</h1>
        <div >
            <label for="Usuario" class="form-label">Usuario</label>
            <input type="text" value="<%=usuario.getUsuario()%>" name="Usuario" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required="true">
        </div>
        <div>
            <label for="password" class="form-label">Password</label>
            <input type="text" value="<%= usuario.getPassword()%>" name="Password" class="form-control " id="password" required="true">
        </div>
        <div class="mb-3">
            <label for="Cedula" class="form-label">Identificador</label>
            <input type="text" value="<%= usuario.getTelefono()%>" name="Identificacion" class="form-control" id="cedula" required="true">
        </div>
        <div class="mb-3">
            <label for="Email" class="form-label">Correo</label>
            <input type="email"value="<%= usuario.getCorreo()%>" name="Correo" class="form-control" id="email" required="true">
        </div>
        <div class="mb-3">
            <label for="Telefono" class="form-label">Telefono</label>
            <input type="tel" value="<%= usuario.getIdentificacion()%>" name="Telefono" class="form-control" id="telefono" required="true">
        </div>

        <div class="mb-3">
            <label for="Rol" class="form-label">Rol</label>
            <input type="text" value="<%= usuario.getRol()%>" name="Rol" class="form-control" id="direccion" required="true">
        </div>
        <button type="submit" class="btn btn-primary w-100 p-2 rounded-pill">Modificar</button>
<%
                    }

                %>
    </form>
</div>

    <hr>
<jsp:include page="../Recursos/Footer.jsp"></jsp:include>     
    </body>
</html>
