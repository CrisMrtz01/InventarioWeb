<%-- 
    Document   : crearUsuario
    Created on : 07-09-2020, 06:57:54 PM
    Author     : Cristian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="usuario" scope="session" class="Model.Usuario" />
<%
    String id = "";
    String nombre = "";
    String apellido = "";
    String correo = "";
    String usua = "";
    String clave = "";
    String tipo = "";
    String estado = "";
    String pregunta = "";
    String respuesta = "";
    
    if(request.getParameter("jabaly")!=null){
        id = request.getParameter("id_usu");
        nombre = request.getParameter("nombre_usu");
        apellido = request.getParameter("apellido_usu");
        correo = request.getParameter("correo_usu");
        usua = request.getParameter("usuario_usu");
        clave = request.getParameter("clave_usu");
        tipo = request.getParameter("tipo_usu");
        estado = request.getParameter("estado_usu");
        pregunta = request.getParameter("pregunta_usu");
        respuesta = request.getParameter("respuesta_usu");
    } else {
        id = String.valueOf(usuario.getId());
        nombre = usuario.getNombre();
        apellido = usuario.getApellido();
        correo = usuario.getCorreo();
        usua = usuario.getUsuario();
        clave = usuario.getClave();
        tipo = String.valueOf(usuario.getTipo());
        estado = String.valueOf(usuario.getEstado());
        pregunta = usuario.getPregunta();
        respuesta = usuario.getRepuesta();
    }
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registra Usuario</title>
        <%@include file="../WEB-INF/Vistas-Parciales/css-js.jspf" %>
        <script type="text/javascript">
            //Función para el botón regresar.
            function regresar(url){
                location.href = url;
            }
        </script>
    </head>
    <body>
        <%@include file="../WEB-INF/Vistas-Parciales/encabezado.jspf" %>
        
        <div class="container">
        <h3>Registros de Usuarios</h3>
        <form class="form-horizontal" id="frmUsuario" name="frmUsuario" action="<%= request.getContextPath() %>/usuarios" method="post">
            <input type="hidden" name="id_usuario" value="<%= id %>" >
            
            <div class="form-group">
                <label for="txtNombre" class="col-sm-2 control-label">Nombre:</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" name="txtNombre" value="<%= nombre %>">
                </div>
            </div>
            
            <div class="form-group">
                <label for="txtApellido" class="col-sm-2 control-label">Apellido:</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" name="txtApellido" value="<%= apellido %>">
                </div>
            </div>
                
            <div class="form-group">
                <label for="txtCorreo" class="col-sm-2 control-label">Correo:</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" name="txtCorreo" value="<%= correo %>">
                </div>
            </div>
                
            <div class="form-group">
                <label for="txtUsuario" class="col-sm-2 control-label">Usuario:</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" name="txtUsuario" value="<%= usua %>">
                </div>
            </div>
                
            <div class="form-group">
                <label for="txtClave" class="col-sm-2 control-label">Clave:</label>
                <div class="col-sm-6">
                    <input type="password" class="form-control" name="txtClave" value="<%= clave %>">
                </div>
            </div>
                
            <div class="form-group">
                <label for="txtTipo" class="col-sm-2 control-label">Tipo:</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" name="txtTipo" value="<%= tipo %>">
                </div>
            </div>
                
            <div class="form-group">
                <label for="txtEstado" class="col-sm-2 control-label">Estado:</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" name="txtEstado" value="<%= estado %>">
                </div>
            </div>
                
            <div class="form-group">
                <label for="txtPregunta" class="col-sm-2 control-label">Pregunta:</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" name="txtPregunta" value="<%= pregunta %>">
                </div>
            </div>
                
            <div class="form-group">
                <label for="txtRespuesta" class="col-sm-2 control-label">Respuesta:</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" name="txtRespuesta" value="<%= respuesta %>">
                </div>
            </div>
            
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <%
                        if(request.getParameter("jabaly") != null){
                    %>
                    <input type="submit" class="btn btn-default btn-sm" name="btnModificar" value="Actualizar" />
                    <%
                        } else{ 
                    %>
                    <input type="submit" class="btn btn-success btn-sm" name="btnGuardar" value="Guardar" >
                    <%
                        }
                    %>
                    <input type="button" class="btn btn-danger btn-sm" onclick="regresar('<%= request.getContextPath() %>/usuarios?opcion=listar')" name="btnRegresar" value="Regresar">
               
                
                </div>
            </div>
            
        </form>
        </div>
        
        <%@include file="../WEB-INF/Vistas-Parciales/pie.jspf" %>
    </body>
</html>

