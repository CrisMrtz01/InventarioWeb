<%-- 
    Document   : listarUsuario
    Created on : 07-09-2020, 06:59:55 PM
    Author     : Cristian
--%>

<%@page import="Model.Usuario" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="lista" scope="session" class="java.util.List"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuarios Registrados</title>
        <%@include file="../WEB-INF/Vistas-Parciales/css-js.jspf" %>
    </head>
    <body>
        <%@include file="../WEB-INF/Vistas-Parciales/encabezado.jspf"%>
        
        <div class="container">
            <a href="<%= request.getContextPath() %>/usuarios?opcion=crear" class="btn btn-success btn-sm glyphicon glyphicon-pencil" role="button"> Nueva Usuario</a>
            <span><a href="#" class="btn btn-success glyphicon glyphicon-print"> Reporte PDF</a></span>
            <h3>Listado de Usuarios Registrados</h3>
            <table class="table table-striped">
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Correo</th>
                    <th>Usuario</th>
                    <th>Clave</th>
                    <th>Tipo</th>
                    <th>Estado</th>
                    <th>Pregunta</th>
                    <th>Respuesta</th>
                    <th>Fecha</th>
                </tr> 
                <%
                    for(int i = 0; i < lista.size(); i++){
                        Usuario usuario = new Usuario();
                        usuario = (Usuario)lista.get(i);//se realiza el castong (Categoria)
                    
                %>
                <tr>
                    <td><%= usuario.getId() %></td>
                    <td><%= usuario.getNombre() %></td>
                    <td><%= usuario.getApellido() %></td>
                    <td><%= usuario.getCorreo() %></td>
                    <td><%= usuario.getUsuario() %></td>
                    <td><%= usuario.getClave() %></td>
                    <td><%= usuario.getTipo() %></td>
                    <td><%= usuario.getEstado() %></td>
                    <td><%= usuario.getPregunta() %></td>
                    <td><%= usuario.getRepuesta() %></td>
                    <td><%= usuario.getFecha_registro() %></td>
                    <td>                        
                        <a href="<%= request.getContextPath() %>/usuarios?opcion=modificar&&id_usu=<%= usuario.getId() %>&&nombre_usu=<%= usuario.getNombre() %>&&apellido_usu=<%= usuario.getApellido() %>&&correo_usu=<%= usuario.getCorreo() %>&&usuario_usu=<%= usuario.getUsuario() %>&&clave_usu=<%= usuario.getClave() %>&&tipo_usu=<%= usuario.getTipo() %>&&estado_usu=<%= usuario.getEstado() %>&&pregunta_usu=<%= usuario.getPregunta() %>&&respuesta_usu=<%= usuario.getRepuesta() %>" class="btn btn-info btn-sm glyphicon glyphicon-edit" role="button" name="btnModificar">Editar</a>
                        
                        <a href="<%= request.getContextPath() %>/usuarios?opcion=eliminar&&id=<%= usuario.getId() %>" class="btn btn-danger btn-sm glyphicon glyphicon-remove" role="button">Eliminar</a>
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

