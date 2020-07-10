<%-- 
    Document   : crearProducto
    Created on : 07-09-2020, 06:53:45 PM
    Author     : Cristian
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="Factory.ConexionBD"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="producto" scope="session" class="Model.Producto" />
<jsp:useBean id="catego" scope="session" class="Model.Categoria" />
<%
    String id = "";
    String nombre = "";
    String stock = "";
    String precio = "";
    String unidadMedia = "";
    String estado = "";
    String categoria = "";
    String descripcion = "";
    
    if(request.getParameter("colmena") != null){
        id = request.getParameter("id_prod");
        nombre = request.getParameter("nombre_prod");
        stock = request.getParameter("stock_prod");
        precio = request.getParameter("precio_prod");
        unidadMedia = request.getParameter("unidad_med");
        estado = request.getParameter("estado_prod");
        categoria = request.getParameter("categoria_prod");
        descripcion = request.getParameter("desc_prod");
    } else {
        id = String.valueOf(producto.getId_producto());
        nombre = producto.getNom_producto();
        stock = String.valueOf(producto.getStock());
        precio = String.valueOf(producto.getPrecio());
        unidadMedia = producto.getUnidadMedida();
        estado = String.valueOf(producto.getEstado());
        categoria = producto.getCategoria_id();
        descripcion = producto.getDes_producto();
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        
        <% //cuerpo  %>
        
        <div class="container">
        <h3>Registros de Productos</h3>
        <form class="form-horizontal" id="frmProducto" name="frmProducto" action="<%= request.getContextPath() %>/productos" method="post">
            <input type="hidden" name="id_producto" value="<%= id %>" >
            
            <div class="form-group">
                <label for="txtNombre" class="col-sm-2 control-label">Nombre:</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" name="txtNombre" value="<%= nombre %>">
                </div>
            </div>
            
            <div class="form-group">
                <label for="txtStock" class="col-sm-2 control-label">Stock:</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" name="txtStock" value="<%= stock %>">
                </div>
            </div>
                
            <div class="form-group">
                <label for="txtPrecio" class="col-sm-2 control-label">Precio:</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" name="txtPrecio" value="<%= precio %>">
                </div>
            </div>
                
            <div class="form-group">
                <label for="txtUnidaMedida" class="col-sm-2 control-label">Unidad de Medida:</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" name="txtUnidaMedida" value="<%= unidadMedia %>">
                </div>
            </div>
                
            <div class="form-group">
                <label for="txtEstado" class="col-sm-2 control-label">Estado:</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" name="txtEstado" value="<%= estado %>">
                </div>
            </div>
                
            <div class="form-group">
                <label for="txtCategoria" class="col-sm-2 control-label">Categoria</label>
                <div class="col-sm-6">
                    <!--input type="text" class="form-control" name="txtCategoria" value="<%= categoria %>"-->
                    <!--intento de select-->
                    <select class="form-control" name="txtCategoria" >
                        <%
                            try{
                                String miQuery = "select * from tb_categoria";
                                Class.forName("com.mysql.jdbc.Driver").newInstance();
                                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_inventario","root", "");
                                Statement stm = conn.createStatement();
                                ResultSet rs = stm.executeQuery(miQuery);
                                while(rs.next())
                                {  
                                    %>
                                       <option value="<%=rs.getString("id_categoria")%>"><%=rs.getString("nom_categoria")%></option>
                                    <%
                                }
                                conn.close();
                            } catch(Exception ex){
                                ex.printStackTrace();
                            }
                        %>
                    </select>
                </div>
            </div>
                        
                
            <div class="form-group">
                <label for="txtDescripcion" class="col-sm-2 control-label">Descripcion</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" name="txtDescripcion" value="<%= descripcion %>">
                </div>
            </div>
            
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <%
                        if(request.getParameter("colmena") != null){
                    %>
                    <input type="submit" class="btn btn-default btn-sm" name="btnModificar" value="Actualizar" />
                    <%
                        } else{ 
                    %>
                    <input type="submit" class="btn btn-success btn-sm" name="btnGuardar" value="Guardar" >
                    <%
                        }
                    %>
                    <input type="button" class="btn btn-danger btn-sm" onclick="regresar('<%= request.getContextPath() %>/productos?opcion=listar')" name="btnRegresar" value="Regresar">
               
                
                </div>
            </div>
            
        </form>
        </div>
        
        
        <% //fin cuerpo  %>
        
        <%@include file="../WEB-INF/Vistas-Parciales/pie.jspf" %>
    </body>
</html>

