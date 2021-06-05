<%-- 
    Document   : Salido
    Created on : 4/04/2021, 11:24:03 PM
    Author     : JESÚS
--%>

<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.commons.fileupload.FileUploadException"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.FileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Usuarios"%>
<%@page import="Modelo.EmpleadosJDBC"%>
<%@page import="Modelo.Empleados"%>
<%@page import="Modelo.BusetasJDBC"%>
<%@page import="Modelo.Busetas"%>
<%@page import="Modelo.RutasJDBC"%>
<%@page import="Modelo.Rutas"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://kit.fontawesome.com/247d2323bf.js" crossorigin="anonymous"></script>


        <link rel="stylesheet" href="CSS/style.css">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous"> 
        <title>Administrador</title>
    </head>
    <body>

        <div class="container-fluid">


            <form method="POST" action="${pageContext.request.contextPath}/Logout" class="d-flex justify-content-end" >
                <input type="submit" name="" value="Cerrar session" class="btn btn-outline-danger border-2 mt-5 me-5">
            </form>


            <h1 style="margin-top: -50px;" class="text-primary mx-5">
                <i>
                    Usuario: ${usuario.getUsuario()} </i>
            </h1>


            <hr>

            <div class="row row-cols-1 row-cols-md-2 g-4">

                <!--EMPLEADOS -->
                <div class="col ">
                    <div class="card m-5 ">
                        <h5 class="card-title text-center p-3 ">Empleados</h5>
                        <div class="divider"></div>
                        <img src="./Imagenes/Empleado.png" class="img-fluid rounded-circle " title='Empleados'style="width: 100% ; height:400px; ">
                        <div class="card-body text-center">
                            <p class="card-text"> <strong> Aqui puedes agregar y modificar empleados </strong></p>
                            <button type="button" class="btn btn-primary m-3" data-bs-toggle="modal" data-bs-target="#modalAgregar">Agregar</button>
                            <!-- Modal Agregar-->
                            <div class="modal fade" id="modalAgregar" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title col-11 text-center" id="exampleModalLabel">Agregar Empleado</h5>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">

                                            <form class="form" action="${pageContext.request.contextPath}/EmpleadosControl?accion=Agregar" method="POST" enctype="multipart/form-data">

                                                <div class="p-2 m-2" >
                                                    <label for="password" class="">Nombre</label>
                                                    <input type="text" name="Nombre" class="input form-control " id="password" >
                                                </div> 

                                                <div class="p-2 m-2" >
                                                    <label for="password" class="form-label">Apellido</label>
                                                    <input type="text" name="Apellido" class="form-control " id="password"  >
                                                </div>

                                                <div class="p-2 m-2" >
                                                    <label for="Cedula" class="form-label">Cedula de Ciudadania</label>
                                                    <input type="number"  name="Identificacion" class="form-control" id="cedula"  >
                                                </div>

                                                <div class="p-2 m-2" >
                                                    <label for="Telefono" class="form-label">Telefono</label>
                                                    <input type="tel" name="Telefono" class="form-control" id="telefono"  >
                                                </div>

                                                <div class="p-2 m-2" >
                                                    <label for="Direccion" class="form-label">Direccion</label>
                                                    <input type="text" class="form-control" id="direccion" name="Direccion"  >
                                                </div>

                                                <div class="p-2 m-2" >
                                                    <label for="Correo" class="form-label">Correo</label>
                                                    <input type="text" class="form-control" id="Correo" name="Correo" >
                                                </div>
                                                <!--Validar que solo acepte imagenes -->
                                                <div class="p-2 m-2" >
                                                    <label for="formFile" class="form-label">Ingresar Imagen</label>
                                                    <input class="form-control" type="file" id="formFile" name="foto">
                                                </div> 

                                                <button type="submit" class="btn btn-primary m-4 w-50">Enviar</button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <button type="button" class="btn btn-success m-3" data-bs-toggle="modal" data-bs-target="#modalModificar">Modificar</button>
                            <!-- Modal modificar-->
                            <div class="modal fade " id="modalModificar" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog modal-xl">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title col-11 text-center" id="exampleModalLabel">MODIFICAR EMPLEADO</h5>
                                            <button type="button" name="accion" value="Listar" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            <table border="1" class="table"> 
                                                <caption>Empleados</caption>
                                                <th>Empleado</th>
                                                <th>Apellido</th>
                                                <th>Identificacion</th>
                                                <th>telefono</th>
                                                <th>Direccion</th>
                                                <th>Correo</th>
                                                <th>Eliminacion</th>
                                                <th>Editar</th>


                                                <% List<Empleados> emp = new EmpleadosJDBC().listarEmpleados(); %>


                                                <%

                                                    for (Empleados empleado : emp) {


                                                %>





                                                <tr>

                                                    <td><%= empleado.getNombre()%></td>
                                                    <td><%= empleado.getApellido()%></td>
                                                    <td><%= empleado.getCedulaCiudadania()%></td>
                                                    <td><%= empleado.getTelefono()%></td>
                                                    <td><%= empleado.getDireccion()%></td>
                                                    <td><%= empleado.getCorreo()%></td>
                                                    <td>

                                                        <i class="fas fa-trash-alt text-danger"> </i>
                                                        <form class="form" action="${pageContext.request.contextPath}/EmpleadosControl?accion=Eliminar&usuario=<%= empleado.getCedulaCiudadania()%>" method="POST" enctype="multipart/form-data"> 
                                                            <input type="submit" value="Eliminar    " class="btn btn-danger m-4 w-50" /> 
                                                        </form>
                                                    </td>
                                                    <td>
                                                        <i class="fas fa-sync text-success"> </i>    
                                                        <form class="form" action="${pageContext.request.contextPath}/EmpleadosControl?accion=Edicion&usuario=<%= empleado.getCedulaCiudadania()%>" method="POST" enctype="multipart/form-data"> 
                                                            <input type="submit" value="Editar" class="btn btn-success m-4 w-50" /> 
                                                        </form>
                                                    </td>
                                                </tr>

                                                <%
                                                    }

                                                %>

                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!--BUSETAS -->
                <div class="col ">
                    <div class="card m-5 text-center ">
                        <h5 class="card-title text-center p-3">BUSETAS</h5>
                        <div class="divider"></div>

                        <img src="./Imagenes/buses.png" class="img-fluid rounded-circle m-4 px-4 text-center" title='Busetas' style="width: 90% ; height: 350px; ">
                        <div class="card-body text-center">

                            <p class="card-text "><strong> AQUI PUEDES AGREGAR Y MODIFICAR BUSETAS </strong></p>
                            <button type="button" class="btn btn-primary m-3" data-bs-toggle="modal" data-bs-target="#modalAgregarBusetas">Agregar</button>

                            <!-- Modal Agregar Busetas-->
                            <div class="modal fade" id="modalAgregarBusetas" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title col-11 text-center" id="exampleModalLabel">AGREGAR BUSETAS</h5>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <div class= "modal-body">
                                            <form class="" action="${pageContext.request.contextPath}/BusetasControl?accion=Agregar" method="POST" >
                                                <div class="p-2 m-2">
                                                    <label for="Modelo" class="form-label">Modelo</label>
                                                    <input type="text" name="Modelo" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required="true">
                                                </div>
                                                <div class="p-2 m-2">
                                                    <label for="Marca" class="form-label">Marca</label>
                                                    <input type="text" name="Marca" class="form-control " id="Marca" required="true">
                                                </div>

                                                <div class="p-2 m-2">
                                                    <label for="Placa" class="form-label">Placa</label>
                                                    <input type="text"  name="Placa" class="form-control" id="Placa" required="true">
                                                </div>

                                                <div class="p-2 m-2">
                                                    <label for="Color" class="form-label">Color</label>
                                                    <input type="text" name="Color" class="form-control" id="telefono" required="true">
                                                </div>


                                                <button type="submit" name="Enviar" value="Enviar" class="btn btn-primary m-4 w-50">Enviar</button>

                                            </form>

                                        </div>

                                    </div>
                                </div>
                            </div>

                            <button type="button" class="btn btn-success m-3" data-bs-toggle="modal" data-bs-target="#modalModificarBusetas">Modificar</button>

                            <!-- Modal modificar Busetas-->
                            <div class="modal fade" id="modalModificarBusetas" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog modal-lg">
                                    <div class="modal-content">
                                        <div class="modal-header ">
                                            <h5 class="modal-title col-11 text-center" id="exampleModalLabel">MODIFICAR BUSETAS</h5>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            <table border="1" class="table"> 
                                                <caption>Busetas</caption>
                                                <th>Marca</th>
                                                <th>Modelo</th>
                                                <th>Placa</th>
                                                <th>Color</th>
                                                <th>Eliminacion</th>
                                                <th>Editar</th>

                                                <% List<Busetas> buseta = new BusetasJDBC().ListarBusetas(); %>
                                                <%

                                                    for (Busetas busetas : buseta) {


                                                %>
                                                <tr>
                                                    <td><%= busetas.getMarca()%></td>
                                                    <td><%= busetas.getModelo()%></td>
                                                    <td><%= busetas.getPlaca()%></td>
                                                    <td><%= busetas.getColor()%></td>
                                                    <td>
                                                        <i class="fas fa-trash-alt text-danger"> </i>
                                                        <form class="form" action="${pageContext.request.contextPath}/BusetasControl?accion=Eliminar&buseta=<%= busetas.getPlaca()%>" method="POST" enctype="multipart/form-data"> 
                                                            <input type="submit" value="Eliminar    " class="btn btn-danger m-4 w-50" /> 
                                                        </form>
                                                    </td>
                                                    <td>
                                                        <i class="fas fa-sync text-success"> </i>    
                                                        <form class="form" action="${pageContext.request.contextPath}/BusetasControl?accion=Edicion&buseta=<%= busetas.getPlaca()%>" method="POST" enctype="multipart/form-data"> 
                                                            <input type="submit" value="Editar" class="btn btn-success m-4 w-50" /> 
                                                        </form>
                                                    </td>
                                                </tr>
                                                <%
                                                    }

                                                %>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- RUTAS -->

                <div class="col ">
                    <div class="card m-5 text-center ">
                        <h5 class="card-title text-center p-3">RUTAS</h5>
                        <div class="divider"></div>

                        <img src="./Imagenes/Ruta.png" class="img-fluid rounded-circle m-4" title='RUtas'style="width: 90% ; height: 350px; ">
                        <div class="card-body text-center">
                            <p class="card-text "><strong> AQUI PUEDES AGREGAR Y MODIFICAR RUTAS </strong></p>

                            <button type="button" class="btn btn-primary m-3" data-bs-toggle="modal" data-bs-target="#modalAgregarRutas">Agregar</button>

                            <!-- Modal Agregar Rutas-->
                            <div class="modal fade" id="modalAgregarRutas" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title col-11 text-center" id="exampleModalLabel"> AGREGAR RUTAS</h5>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            <form class="" action="${pageContext.request.contextPath}/RutasControl?accion=Agregar" method="POST" enctype="multipart/form-data">


                                                <div class="p-2 m-2">
                                                    <label for="Usuario" class="form-label">Nombre</label>
                                                    <input type="text" vale="/Imagenes" name="Nombre" class="form-control  text-center" id="exampleInputEmail1" aria-describedby="emailHelp" required="true" placeholder="Sicnelejo - Sucre">
                                                </div>

                                                <div class="p-2 m-2">
                                                    <label for="Precio" class="form-label">Precio</label>
                                                    <input type="text" name="Precio" class="form-control text-center" id="Precio" required="true" placeholder="50.000">
                                                </div>
                                                <div class="p-2 m-2">
                                                    <label for="Precio" class="form-label">Seleccionar vehiculo</label>
                                                    <select class="form-select" aria-label="Default select example" name="Opcion">
                                                        <option value="">Vehiculos</option>
                                                        <% List<Rutas> ruta = new RutasJDBC().DisponibilidadRutas(); %>
                                                        <%
                                                            for (Rutas rutas : ruta) {


                                                        %>
                                                        <% if (rutas.getInfo() == null) {


                                                        %>
                                                        <option value="<%= rutas.getCodigoRuta()%>" name="Opcion"><%= rutas.getCodigoRuta()%></option>
                                                        <% }

                                                        %>
                                                        <%                                                            }
                                                        %>
                                                    </select>
                                                </div>

                                                <!--Validar que solo acepte imagenes -->
                                                <div class="p-2 m-2">
                                                    <label for="formFile" class="form-label">Ingresar Imagen</label>
                                                    <input class="form-control" type="file" id="formFile" name="file" required="true">
                                                </div>

                                                <div class="p-2 m-2">
                                                    <label for="Info" class="form-label">Informacion</label>
                                                    <textarea required="true" name="Info" rows="10" cols="52" placeholder="Informacion refrente" class="text-center" > </textarea>
                                                </div>

                                                
                                                <button type="submit" class="btn btn-primary m-4 w-50">Enviar</button>

                                            </form>
                                        </div>

                                    </div>
                                </div>
                            </div>

                            <button type="button" class="btn btn-success m-3" data-bs-toggle="modal" data-bs-target="#modalModificarRutas">Modificar</button>

                            <!-- Modal modificar Rutas-->
                            <div class="modal fade" id="modalModificarRutas" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog modal-xl">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title col-11 text-center" id="exampleModalLabel">MODIFICAR RUTAS</h5>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            <table class="table table-bordered" >
                                                <caption>Rutas</caption>
                                                <thead>
                                                    <tr>
                                                        <th scope="col">Placa</th>
                                                        <th scope="col">Nombre</th>
                                                        <th scope="col">Precio</th>
                                                        <th scope="col">Info</th>
                                                        <th scope="col">Imagen</th>

                                                        <th colspan="2">Acciones</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <!-- HAY QUE VALIDAR QUE LA BUSETA TENGA PLACA UNICA -->
                                                   
                                                <% List<Rutas> rutas = new RutasJDBC().obtenerRutas(); %>

                                                <%

                                                    for(Rutas Lisruta : rutas) {


                                                %>
                                                <tr>
                                                    <td><%= Lisruta.getCodigoRuta()%></td>
                                                    <td><%= Lisruta.getNombre()%></td>
                                                    <td><%= Lisruta.getPrecio()%></td>
                                                    <td><%= Lisruta.getInfo()%></td>
                                                    <td><%= Lisruta.getImagen()%></td>
                                                    <td>

                                                        <i class="fas fa-trash-alt text-danger"> </i>
                                                        <form class="form" action="${pageContext.request.contextPath}/RutasControl?accion=Eliminar&ruta=<%= Lisruta.getCodigoRuta()%>" method="POST" enctype="multipart/form-data"> 
                                                            <input type="submit" value="Eliminar      " class="btn btn-danger m-4 w-50" /> 
                                                        </form>
                                                    </td>
                                                    <td>
                                                        <i class="fas fa-sync text-success"> </i>    
                                                        <form class="form" action="${pageContext.request.contextPath}/RutasControl?accion=Edicion&ruta=<%= Lisruta.getCodigoRuta()%>" method="POST" enctype="multipart/form-data"> 
                                                            <input type="submit" value="Editar" class="btn btn-success m-4 w-50" /> 
                                                        </form>
                                                    </td>
                                                </tr>

                                                <%
                                                    }

                                                %>


                                                </tbody>
                                            </table>


                                        </div>

                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>





                <!-- ESTADISTICAS -->
                <div class="col ">
                    <div class="card m-5 text-center ">
                        <h5 class="card-title text-center p-3">ESTADISTICA</h5>
                        <div class="divider"></div>
                        <a href="RecursosAdmin/Estadisticas.php">

                            <img src="./Imagenes/estadistica.png" class="img-fluid rounded-circle m-4 px-4 text-center" title='Estadisticas'style="width: 90% ; height: 350px; "></a>
                        <div class="card-body text-center">
                            <p class="card-text "><strong> AQUI PUEDES AGREGAR Y MODIFICAR RUTAS </strong></p>

                            <button type="button" class="btn btn-primary m-3 w-50"  data-bs-toggle="modal" data-bs-target="#modalMostrarEstadisticas">Modificar</button>

                            <!-- Modal Mostrar Rutas-->
                            <div class="modal fade" id="modalMostrarEstadisticas" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog modal-lg">
                                    <div class="modal-content ">
                                        <div class="modal-header">
                                            <h5 class="modal-title col-11 text-center" id="exampleModalLabel"> ESTADISTICAS</h5>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">

                                            <?php

                                            require_once('./consultas/SelectBusetas.php');

                                            ?>

                                            <table class="table table-bordered" >
                                                <thead>
                                                    <tr>
                                                        <th scope="col">Rutas</th>
                                                        <th scope="col">Pasajeros</th>
                                                        <th scope="col">Precio</th>
                                                        <th scope="col">Mes</th>
                                                        <th scope="col">Total</th>


                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <!-- HAY QUE VALIDAR QUE LA BUSETA TENGA PLACA UNICA -->
                                                <tbody>
                                                    <!-- <?php foreach ($Busetas as  $buseta): ?> -->
                                                    <tr>

                                                        <td> <!-- <?php echo $buseta[ 'Marca']  ?> --> Sincelejo - Sucre</td> 
                                                        <td> 15<!-- <?php echo $buseta[ 'Modelo']  ?> --></td> 	
                                                        <td> 50.000<!-- <?php echo $buseta[ 'Placa']  ?> --></td> 	
                                                        <td> Enero<!-- <?php echo $buseta[ 'Color']  ?> --></td> 	
                                                        <td> 750.000<!-- <?php echo $buseta[ 'Color']  ?> --></td> 	


                                                        <!-- <td>
                                                                     <a href="./Consultas/Eliminarbuseta.php?accion=<?php echo $buseta['Placa']; ?>"
                                                                        >        
                                                                        <i class="fas fa-trash-alt text-danger"> Eliminar</i>
                                                                    </a>
                                                    </td>
                                                                 
                                                                <td>
                                                                    <a href="./Consultas/EditarBusetas.php?accion=<?php echo $buseta['Placa']; ?>">
                                                                    
                                                                       <i class="fas fa-sync text-success"> Editar </i>
                                                                        
                                                                    </a>
                                                                </td> -->
                                                    </tr>
                                                    <!-- <?php endforeach; ?>  -->

                                                </tbody>
                                                </tbody>
                                            </table>


                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>



            <%                if (session.getAttribute("usuario") == null) {
                    response.sendRedirect("index.jsp");
                }
            %>

            <h1 class="mx-5 my-5 text-primary text-center">
                Bienvenido
            </h1>


            <div class="m-5" >

                <table border="1" class="table "> 
                    <caption>Usuarios</caption>
                    <th>Usuario</th>
                    <th>Password</th>
                    <th>Identificacion</th>
                    <th>telefono</th>
                    <th>Correo</th>
                    <th>Rol</th>
                    <th>Eliminacion</th>
                    <th>Editar</th>



                    <c:forEach var = "usuarios" items ="${usuarios}" >

                        <tr>
                            
                            <td>${usuarios.usuario}</td>
                            <td>${usuarios.password}</td>
                            <td>${usuarios.telefono}</td>
                            <td>${usuarios.correo}</td>
                            <td>${usuarios.identificacion}</td>
                            <td>${usuarios.rol}</td>

                            <td >
                                <a href="${pageContext.request.contextPath}/LoginControl?accion=Eliminar&usuario=${usuarios.usuario}"
                                   Style="text-decoration: none" class="text-danger"    >        
                                    <i class="fas fa-trash-alt text-danger"> </i>Delete
                            </td>

                            <td>
                                <a href="${pageContext.request.contextPath}/LoginControl?accion=Editar&usuario=${usuarios.usuario}"
                                   Style=" text-decoration: none"  class="text-success" >
                                    <i class="fas fa-sync text-success"> </i>    
                                    Editar
                                </a>
                            </td>
                        </tr>
                    </c:forEach>

                </table>



                <script src="https://kit.fontawesome.com/247d2323bf.js" crossorigin="anonymous"></script>	

                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>      
                <hr>

                </body>
                </html>
