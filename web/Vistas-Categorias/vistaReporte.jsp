<%-- 
    Document   : vistaReporte
    Created on : 07-09-2020, 06:49:34 PM
    Author     : Cristian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<%@page import="java.io.*" %>
<%@page import="net.sf.jasperreports.engine.*" %>
<%@page import="net.sf.jasperreports.view.JasperViewer.*" %>
<%@page import="javax.servlet.ServletResponse" %>
<%@include file="../Vistas-Categorias/conexion.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reporte Categorias</title>
    </head>
    <body>
        <%                                                   // Mal redireccionada estaba la ruta
            File reportfile = new File(application.getRealPath("./Reportes/CategoryReport.jasper"));
            Map<String, Object> parametros = new HashMap<String, Object>();
            byte[] bytes = JasperRunManager.runReportToPdf(reportfile.getPath(), parametros, con);
            response.setContentType("application/pdf");
            response.setContentLength(bytes.length);
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(bytes, 0, bytes.length);

            outputStream.flush();
            outputStream.close();                    
        %>
        <h1>Hola mundo</h1>
    </body>
</html>

