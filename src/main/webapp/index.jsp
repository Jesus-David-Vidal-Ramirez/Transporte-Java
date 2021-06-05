<%-- 
    Document   : index
    Created on : 1/04/2021, 12:14:36 AM
    Author     : JESÚS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Transporte</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.3/css/all.css" integrity="sha384-SZXxX4whJ79/gErwcOYf+zWLeJdY/qpuqC4cAa9rOGUstPomtqpuNWT9wdPEn2fk" crossorigin="anonymous">
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script src = "https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.all.min.js"></script>  
 
 
 


 <!--AOS <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">-->
</head>
<body>
    
<!--    
    <form action="index.jsp" name="formulario_registro" method="post" onsubmit="return validar()">
        <div>
            <input type="submit" id="btn-submit" value="Enviar">  
        </div>
</form>
    
    <form action="index.jsp" name="formulario_registro" method="post" onsubmit="return enviar()">
        <div>
            <input type="submit" id="btn-submit" value="CLICK">  
        </div>
    </form>-->
   
    <!-- Nav con SVG ola -->
    <jsp:include page="WEB-INF/Recursos/Nav.jsp"></jsp:include>

    

    
    
    <!-- Rutas-->
    <jsp:include page="WEB-INF/Recursos/Rutas.jsp"></jsp:include>


<!-- Footer-->
<hr>
<jsp:include page="WEB-INF/Recursos/Footer.jsp"></jsp:include>




<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>

<script src="JS/SweetAlert.js" ></script>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<!-- <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js" integrity="sha384-SR1sx49pcuLnqZUnnPwx6FCym0wLsk5JZuNx2bPPENzswTNFaQU1RDvt3wT4gWFG" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js" integrity="sha384-j0CNLUeiqtyaRmlzUHCPZ+Gy5fQu0dQ6eZ/xAww941Ai1SxSY+0EQqNXNE6DZiVc" crossorigin="anonymous"></script> -->
<!--AOS 
<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
<script>
  AOS.init();
</script>-->
</body>
</html>
