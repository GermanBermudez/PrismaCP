<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html lang="es">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Colombia print</title>

    <!-- AQUI VAN LOS LINKS DE LOS SCRIPTS DE LIBRERIAS -->
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
      crossorigin="anonymous">
  </script>
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script src="iniciodesesion.js"></script>

    <!-- AQUI VAN TODOS LOS LINKS DE ESTILOS -->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
      crossorigin="anonymous">
    <link rel="stylesheet" href="iniciosesion.css">
    <link rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">

  </head>

  <body>
    <header> <!-- AQUI VA LA PARTE SUPERIOR DE LA PAGINA  -->
      <nav class="navbar bg-light navbar-expand-lg">
        <div class="container-fluid ">
          <img id="logo" src="Imagenes/COLOMBIAPRINT.png" alt="LOGO">
          <div class="row">
            <div class="col-1">
              <!-- logo -->
            </div>
            <div class="col justify-content-end">
                
              <button class="btn btn-outline-primary" id="btninicio" type="submit">Inicio</button>
              <button class="btn btn-outline-primary" type="submit">Iniciar
                sesion</button>
              <img id="perfil" src="../assets/imagenes/perfil.png" alt>
            </div>
          </div>
        </div>
      </nav>
    </header>

    <main>
      <br>
      <br>
      <br>

      <div class="row mt-10 justify-content-center">
        <div class="col-5">
          <div class="card">
            <div class="card-body mb-10">
              <h1 class="card-title text-center">Ingreso</h1>
              <form name="Ingreso" action="Login" method="post">                
                <label for= "Usuario"><%= new String("Usuario")%></label>         
                <input type="text" placeholder="Digite su Usuario" name="Usuario" value="">
                <label for= "Contrasena"><%= new String("Contraseña")%></label>
                <input type="password" placeholder="Digite su Contraseña" name="Contrasena" value="">
                <div class="col-12 text-center">
                  <button id="btnlogin">login</button>
                  <button id="cancelar">cancelar</button>
                </div>
              </form>
              <br>
            </div>
          </div>
        </div>
      </div>

    </main>
    <br>
    <br>
    <br>
    <footer><!-- AQUI VA LA PARTE INFERIOR DE LA PAGINA -->
      <nav class="navbar bg-light navbar-expand-sm">
        <div class="container-fluid justify-content-center ">
          <p class=" card-title text-bg-light text-center ">Colombiaprint@gmail.com
            | ©2023 por Colombia Print.</p>
          <br>
        </nav>
      </footer>
    </body>
  </html>