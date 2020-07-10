<%-- 
    Document   : listarProductos
    Created on : 07-09-2020, 06:54:03 PM
    Author     : Cristian
--%>

<%@page import="Model.Producto"  %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="lista" scope="session" class="java.util.List"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Productos</title>
        <%@include file="../WEB-INF/Vistas-Parciales/css-js.jspf" %>
    </head>
    <body>
        <%@include file="../WEB-INF/Vistas-Parciales/encabezado.jspf"%>
        
        <div class="container">
            <a href="<%= request.getContextPath() %>/productos?opcion=crear" class="btn btn-success btn-sm glyphicon glyphicon-pencil" role="button"> Nueva Producto</a>
            <span><a href="#" class="btn btn-success glyphicon glyphicon-print"> Reporte PDF</a></span>
            <h3>Registro de Prodcutos</h3>
            <table class="table table-striped">
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Stock</th>
                    <th>Precio</th>
                    <th>Unidad de M.</th>
                    <th>Estado</th>
                    <th>Categoria</th>
                    <th>Descripcion</th>
                    <th>Fecha registro</th>
                </tr> 
                <%
                    for(int i = 0; i < lista.size(); i++){
                        Producto producto = new Producto();
                        producto = (Producto)lista.get(i);
                    
                %>
                <tr>
                    <td><%= producto.getId_producto() %></td>
                    <td><%= producto.getNom_producto() %></td>
                    <td><%= producto.getStock() %></td>
                    <td><%= producto.getPrecio() %></td>
                    <td><%= producto.getUnidadMedida() %></td>
                    <td><%= producto.getEstado() %></td>
                    <td><%= producto.getCategoria_id() %></td>
                    <td><%= producto.getDes_producto() %></td>
                    <td><%= producto.getFecha_entrada() %></td>
                    <td>  
                        <a href="<%= request.getContextPath() %>/productos?opcion=modificar&&id_prod=<%= producto.getId_producto() %>&&nombre_prod=<%= producto.getNom_producto() %>&&stock_prod=<%= producto.getStock() %>&&precio_prod=<%= producto.getPrecio() %>&&unidad_med=<%= producto.getUnidadMedida() %>&&estado_prod=<%= producto.getEstado() %>&&categoria_prod=<%= producto.getCategoria_id() %>&&desc_prod=<%= producto.getDes_producto() %>" class="btn btn-info btn-sm glyphicon glyphicon-edit">Editar</a>
                        <a href="<%= request.getContextPath() %>/productos?opcion=eliminar&&id=<%= producto.getId_producto() %>" class="btn btn-danger btn-sm glyphicon glyphicon-remove" >Borrar</a>
                        
                    </td>
                </tr>
                <%
                    }
                %>
            </table>
        </div>     
        <%@include file="../WEB-INF/Vistas-Parciales/pie.jspf"%>
    </body>
</html>
