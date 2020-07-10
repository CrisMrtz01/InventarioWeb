<%-- 
    Document   : crearCategoria
    Created on : 07-09-2020, 06:45:13 PM
    Author     : Cristian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--Importar los datos de la clase categoria-->
<!DOCTYPE html>
<jsp:useBean id="categoria" scope="session"  class="Model.Categoria" />
<%
    String id = "";
    String nombre_cat = "";
    String estado_cat = "";
    if(request.getParameter("senal") != null){
        id = request.getParameter("id_cat");
        nombre_cat = request.getParameter("nombre_cat");
        estado_cat = request.getParameter("estado_cat");
    } else {
        id = String.valueOf(categoria.getId_categoria());
        nombre_cat = categoria.getNom_categoria();
        estado_cat = String.valueOf(categoria.getEstado_categoria());
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Control de Inventario</title>
        <%@include file="../WEB-INF/Vistas-Parciales/css-js.jspf" %>
        <script type="text/javascript">
            function regresar(url){ 
                location.href = url;
            }
        </script>
    </head>
    <body>
        
            
        <%@include file="../WEB-INF/Vistas-Parciales/encabezado.jspf" %>
        <div class="container">
        <h3>Mantenimiento categorias</h3>
        <form class="form-horizontal" id="frmCategoria" name="frmCategoria" action="<%= request.getContextPath() %>/categorias" method="post">
            <input type="hidden" name="id_categoria" value="<%= id %>" >
            
            <div class="form-group">
                <label for="txtNomCategoria" class="col-sm-2 control-label">Nombre:</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" name="txtNomCategoria" value="<%= nombre_cat %>">
                </div>
            </div>
            
            <div class="form-group">
                <label for="txtEstadoCategoria" class="col-sm-2 control-label">Estado:</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" name="txtEstadoCategoria" value="<%= estado_cat %>">
                </div>
            </div>
            
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <%
                        if(request.getParameter("senal") != null){
                    %>
                    <input type="submit" class="btn btn-default btn-sm" name="btnModificar" value="Actualizar" />
                    <%
                        } else{ 
                    %>
                    <input type="submit" class="btn btn-success btn-sm" name="btnGuardar" value="Guardar" >
                    <%
                        }
                    %>
                    <input type="button" class="btn btn-danger btn-sm" onclick="regresar('<%= request.getContextPath() %>/categorias?opcion=listar')" name="btnRegresar" value="Regresar">
               
                
                </div>
            </div>
            
        </form>
        </div>
        <%@include file="../WEB-INF/Vistas-Parciales/pie.jspf" %>
        
    </body>
</html>
