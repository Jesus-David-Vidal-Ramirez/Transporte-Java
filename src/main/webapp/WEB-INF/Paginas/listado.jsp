<%-- 
    Document   : listado
    Created on : 6/04/2021, 10:44:38 PM
    Author     : JESÚS
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<!-- <link rel="stylesheet" href="CSS/nuevo.css"> -->

<div>

    <table border="1" class="table"> 
        <caption>TITULO DE TABLAa</caption>
        <th>Usuario</th>
        <th>Password</th>
        <th>Identificacion</th>
        <th>telefono</th>
        
        <th>Correo</th>
        <th>Rol</th>
        <th>Eliminacion</th>
        <th>Editar</th>


        <c:forEach var = "usuario" items ="${usuario}" >

            <tr>
                <td>${usuarios.usuario}</td>
                <td>${usuarios.password}</td>
                <td>${usuarios.telefono}</td>
                <td>${usuarios.correo}</td>
                <td>${usuarios.identificacion}</td>
                <td>${usuarios.identificacion}</td>
                

                <td >
                    <a href="${pageContext.request.contextPath}/LoginControl?accion=Eliminar&usuario=${usuarios.usuario}"
                       Style="Color:red; text-decoration: none"    >        
                        <i class="fas fa-angle-double-right"></i>Delete
                </td>
                 
                <td>
                    <a href="${pageContext.request.contextPath}/LoginControl?accion=Editar&usuario=${usuarios.usuario}">
                        <i class="fas fa-angle-double-right"></i>
                        Editacion
                    </a>
                </td>
            </tr>
        </c:forEach>

    </table>
   

</form>
</div>