<%-- 
    Document   : Registro
    Created on : 23/04/2021, 04:11:03 PM
    Author     : JESÚS
--%>

<jsp:include page="WEB-INF/Recursos/Nav.jsp"></jsp:include>


<div class="d-flex justify-content-center col-19 " >
                         
    <form class="p-5 m-3 w-50" action="${pageContext.request.contextPath}/LoginControl?accion=Insertar" method="POST">

        <h1 class="m-4">REGISTRO</h1>
        <div >
            <label for="Usuario" class="form-label">Usuario</label>
            <input type="text" name="IUsuario" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required="true">
        </div>
        <div>
            <label for="password" class="form-label">Password</label>
            <input type="password" name="IPassword" class="form-control " id="password" required="true">
        </div>
        <div class="mb-3">
            <label for="Cedula" class="form-label">Cedula Ciudadana</label>
            <input type="number"  name="IIdentificacion" class="form-control" id="cedula" required="true">
        </div>
        <div class="mb-3">
            <label for="Email" class="form-label">Email</label>
            <input type="email" name="ICorreo" class="form-control" id="email" required="true">
        </div>
        <div class="mb-3">
            <label for="Telefono" class="form-label">Telefono</label>
            <input type="tel" name="ITelefono" class="form-control" id="telefono" required="true">
        </div>

        <div class="mb-3">
            <label for="Direccion" class="form-label">Direccion</label>
            <input type="text" name="" class="form-control" id="direccion" required="true">
        </div>
        <!--Validar que solo acepte imagenes -->
        <div class="mb-3">
            <label for="formFile" class="form-label">Ingresar Imagen</label>
            <input class="form-control" type="file" id="formFile">
        </div>
        <div class="mb-3">
            
            <input class="form-control" type="hidden" value="2" name="IRol" id="formFile">
        </div>
        <button type="submit" class="btn btn-primary">Registrar</button>

    </form>
</div>

    <hr>
<jsp:include page="WEB-INF/Recursos/Footer.jsp"></jsp:include>