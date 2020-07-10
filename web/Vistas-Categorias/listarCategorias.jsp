<%-- 
    Document   : listarCategorias
    Created on : 07-09-2020, 06:46:26 PM
    Author     : Cristian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="Model.Categoria" %>

<!--el id debe ser el mismo que se le coloco al nombre de la session-->
<jsp:useBean id="lista" scope="session" class="java.util.List"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Control de inventario</title>
        <!--incluimos las vistas parciales de las url de librerias-->
        <%@include file="../WEB-INF/Vistas-Parciales/css-js.jspf" %>
    </head>
    <body>
        
        <!--vista parcial del encabezado-->
        <%@include file="../WEB-INF/Vistas-Parciales/encabezado.jspf"%>
        
        <div class="container">
            <a href="<%= request.getContextPath() %>/categorias?opcion=crear" class="btn btn-success btn-sm glyphicon glyphicon-pencil" role="button"> Nueva Categoria</a>
            <span><a href="Vistas-Categorias/vistaReporte.jsp" target="_blank" class="btn btn-success glyphicon glyphicon-print"> Reporte PDF</a></span>
            <h3>Listado de Categorias Registradas</h3>
            <table class="table table-striped">
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Estado</th>
                    <th>Accion</th>
                </tr> 
                <%
                    for(int i = 0; i < lista.size(); i++){
                        Categoria categoria = new Categoria();
                        categoria = (Categoria)lista.get(i);//se realiza el castong (Categoria)
                    
                %>
                <tr>
                    <td><%= categoria.getId_categoria() %></td>
                    <td><%= categoria.getNom_categoria() %></td>
                    <td><%= categoria.getEstado_categoria() %></td>
                    <td>                        
                        <a href="<%= request.getContextPath() %>/categorias?opcion=modificar&&id_cat=<%= categoria.getId_categoria() %>&&nombre_cat=<%= categoria.getNom_categoria() %>&&estado_cat=<%= categoria.getEstado_categoria() %>" class="btn btn-info btn-sm glyphicon glyphicon-edit" role="button" name="btnModificar">Editar</a>
                        
                        <a href="<%= request.getContextPath() %>/categorias?opcion=eliminar&&id=<%= categoria.getId_categoria() %>" class="btn btn-danger btn-sm glyphicon glyphicon-remove" role="button">Eliminar</a>
                    </td>
                </tr>
                <%
                    }
                %>
            </table>
        </div>
        
        <!--vista parcial del pie de pagina-->
        <%@include file="../WEB-INF/Vistas-Parciales/pie.jspf"%>
    </body>
</html>
