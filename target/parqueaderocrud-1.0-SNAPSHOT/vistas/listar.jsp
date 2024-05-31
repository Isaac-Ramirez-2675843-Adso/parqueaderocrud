<%-- 
    Document   : listar
    Created on : 26/05/2024, 8:17:05 p. m.
    Author     : User
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.VehiculoDAO"%>
<%@page import="Modelo.Vehiculo"%>
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
            <h2 class="text text-center">Listado de Vehículos</h2>
            <a href="ServletControlador?accion=agregar" class="btn btn-primary mt-4">Agregar Vehículo</a>
            <div class="row mt-4">


                <div class="col-2">

                </div>
                <div class="col-8">
                    <table class="table table-striped mt-4">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Placa</th>
                                <th>Tipo</th>
                                <th>Color</th>
                                <th>Modelo</th>
                                <th>Opciones</th>
                            </tr>
                        </thead>
                        <%
                            VehiculoDAO dao=new VehiculoDAO();
                            List<Vehiculo>list=dao.listar();
                            Iterator<Vehiculo>iter=list.iterator();
                            Vehiculo veh=null;
                            while(iter.hasNext()){
                                veh=iter.next();
                            
                        %>
                        <tbody>
                            <tr>
                                <td><%= veh.getId() %></td>
                                <td><%= veh.getPlaca() %></td>
                                <td><%= veh.getTipo() %></td>
                                <td><%= veh.getColor() %></td>
                                <td><%= veh.getModelo() %></td>
                                <td>
                                    <a href="ServletControlador?accion=editar&id=<%= veh.getId() %>" class="btn btn-primary">Editar</a>
                                    <a href="ServletControlador?accion=eliminar&id=<%= veh.getId() %>" class="btn btn-danger">Eliminar</a>
                                </td>
                            </tr>
                            <% } %>
                        </tbody>
                    </table>

                </div>
                <div class="col-2">

                </div>
            </div>
        </div>
        <script src="./bootstrap/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
