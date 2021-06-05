	

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Registro</title>
       <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
         <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.3/css/all.css" integrity="sha384-SZXxX4whJ79/gErwcOYf+zWLeJdY/qpuqC4cAa9rOGUstPomtqpuNWT9wdPEn2fk" crossorigin="anonymous">
 
</head>
<body>
	
<nav class="navbar navbar-expand-lg navbar-light bg-light mt-4 py-3">


  <div class="container-fluid ">
  			<!-- Button trigger modal -->
<button type="button" class="btn btn-primary me-5 mx-4 " data-bs-toggle="modal" data-bs-target="#exampleModal">
  LogIn
</button>

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




  <i class="fas fa-bus"></i>
    <!--<a class="navbar-brand" href="#">Icono</a> -->
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item ">
          <a class="nav-link " aria-current="page" href="">Inicio</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#Rutas">Nuestras Rutas</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#contacto">Contactos</a>
        </li>
       
      </ul>
      <form class="d-flex">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>

<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1440 320">
   <text x="600" y="100" font-size="4em" font-weight="2em" letter-spacing="1em">RIKLINSUS</text>
  <path fill="#0099ff" fill-opacity="1" d="M0,32L30,48C60,64,120,96,180,96C240,96,300,64,360,58.7C420,53,480,75,540,122.7C600,171,660,245,720,245.3C780,245,840,171,900,165.3C960,160,1020,224,1080,250.7C1140,277,1200,267,1260,250.7C1320,235,1380,213,1410,202.7L1440,192L1440,320L1410,320C1380,320,1320,320,1260,320C1200,320,1140,320,1080,320C1020,320,960,320,900,320C840,320,780,320,720,320C660,320,600,320,540,320C480,320,420,320,360,320C300,320,240,320,180,320C120,320,60,320,30,320L0,320Z"></path>
</svg>
     

                
                
            
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
</body>
</html>
