<%-- 
    Document   : CuadrosVentas
    Created on : 1/05/2021, 10:38:07 PM
    Author     : JESÚS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelo.Usuarios"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Pageasd</title>
    </head>
    <body>
        
         <c:forEach var = "usuarios" items ="${usuarios}"  varStatus="status">


        
        <div class="row row-cols-1 row-cols-md-3 g-4  m-4 pb-3 " style="border:1px solid red;">
            <div class="col">
                <div class="card">
                    <img src="Imagenes/Sincelejo.png" class="card-img-top" alt="Sincelejo">
                    <div class="card-body">
                        <h5 class="card-title">${usuarios.usuario} asd</h5>
                        <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>

                    </div>
                    <div class="card-footer d-flex justify-content-between"   >
                        <!-- class="btn btn-primary me-5" data-bs-toggle="modal" data-bs-target="#exampleModal"-->
                        <button class="btn btn-danger"  data-bs-toggle="modal" data-bs-target="#exampleModal">Comprar</button>
                        <strong calss="pl-2">50.000 COP</strong>

                        <button class="btn btn-warning align-items-start " data-bs-toggle="modal" data-bs-target="#exampleModal">Reservar</button>
                    </div>
                </div>
            </div>
        </div>
            
            
  </c:forEach>
    
    
    <jsp:include page="../Paginas/listado.jsp"></jsp:include>
    </body>
</html>
