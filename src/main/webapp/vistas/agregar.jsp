<%-- 
    Document   : agregar
    Created on : 26/05/2024, 8:17:59 p. m.
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Parqueadero CRUD</title>
       <link href="./bootstrap/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h1 class="text text-center">Bien Cuidado Patrón</h1>
            <h2 class="text text-center">Agregar Vehículo </h2>
            <div class="row">
                <div class="col-2">

                </div>
                <div class="col-8">
                    <form action="ServletControlador">
                        <div class="mb-3">
                            <label for="placa" class="form-label">Placa:</label>
                            <input type="text" class="form-control" name="txtPlaca">
                        </div>
                        <div class="mb-3">
                            <label for="tipo" class="form-label">Tipo:</label>
                            <input type="text" class="form-control" name="txtTipo">
                        </div>
                        <div class="mb-3">
                            <label for="color" class="form-label">Color:</label>
                            <input type="text" class="form-control" name="txtColor">
                        </div>
                        <div class="mb-3">
                            <label for="modelo" class="form-label">Modelo:</label>
                            <input type="text" class="form-control" name="txtModelo">
                        </div>
                        <input type="submit" class="btn btn-primary" name="accion" value="Agregar">
                        <a href="ServletControlador?accion=listar" class="btn btn-primary">Regresar</a>
                    </form>
                </div>    
                <div class="col-2">

                </div>
            </div>

        </div>
        <script src="./bootstrap/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
