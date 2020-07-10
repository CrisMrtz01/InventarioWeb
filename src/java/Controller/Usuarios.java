

package Controller;

import DAO.UsuarioDAO;
import DAO.UsuarioDAOImplementar;
import java.io.IOException;
import Model.Usuario;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Usuarios extends HttpServlet {

    protected void listarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        //objeto usuario
        UsuarioDAO usuarios = new UsuarioDAOImplementar();
        HttpSession session = request.getSession(true);
        session.setAttribute("lista", usuarios.Listar());
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Vistas-Usuarios/listarUsuario.jsp");
        dispatcher.forward(request, response);
    }
    
    protected void borrarUsuario(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Vistas-Usuarios/listarUsuario.jsp");
        dispatcher.forward(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String parametro = request.getParameter("opcion");//caturando la opcion elejida por el user
        
        if (parametro.equals("crear")) {
            String pagina = "/Vistas-Usuarios/crearUsuario.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
            dispatcher.forward(request, response);
            
        } else if(parametro.equals("listar")){
            this.listarUsuario(request, response);
            
        } else if(parametro.equals("modificar")){
            int id = Integer.parseInt(request.getParameter("id_usu"));
            String nombre = request.getParameter("nombre_usu");
            String apellido = request.getParameter("apellido_usu");
            String correo = request.getParameter("correo_usu");
            String usuario = request.getParameter("usuario_usu");
            String clave = request.getParameter("clave_usu");
            int tipo = Integer.parseInt(request.getParameter("tipo_usu"));
            int estado = Integer.parseInt(request.getParameter("estado_usu"));
            String pregunta = request.getParameter("pregunta_usu");
            String respuesta = request.getParameter("respuesta_usu");
            //Date fecha_registro = Date.valueOf(request.getParameter("fecha_reg"));
            
            String pagina = "/Vistas-Usuarios/crearUsuario.jsp?id_usu="+id+"&&nombre_usu="+nombre+"&&apellido_usu="+apellido+"&&correo_usu="+correo+"&&usuario_usu="+usuario+"&&clave_usu="+clave+"&&tipo_usu="+tipo+"&&estado_usu="+estado+"&&pregunta_usu="+pregunta+"&&respuesta_usu="+respuesta+"&&jabaly=1";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
            dispatcher.forward(request, response);
        } else if(parametro.equals("eliminar")){
            int delete_id = Integer.parseInt(request.getParameter("id"));
            UsuarioDAO usuario = new UsuarioDAOImplementar();
            usuario.borrarUsu(delete_id);
            this.listarUsuario(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario usuario = new Usuario();
        int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
        String nombre_usuario = request.getParameter("txtNombre");
        String apellido = request.getParameter("txtApellido");
        String correo = request.getParameter("txtCorreo");
        String usuar = request.getParameter("txtUsuario");
        String clave = request.getParameter("txtClave");
        int tipo = Integer.parseInt(request.getParameter("txtTipo"));
        int estado = Integer.parseInt(request.getParameter("txtEstado"));
        String pregunta = request.getParameter("txtPregunta");
        String respuesta = request.getParameter("txtRespuesta");
        
        usuario.setId(id_usuario);
        usuario.setNombre(nombre_usuario);
        usuario.setApellido(apellido);
        usuario.setCorreo(correo);
        usuario.setUsuario(usuar);
        usuario.setClave(clave);
        usuario.setTipo(tipo);
        usuario.setEstado(estado);
        usuario.setPregunta(pregunta);
        usuario.setRepuesta(respuesta);
        
        UsuarioDAO guardarUsuario = new UsuarioDAOImplementar();
        guardarUsuario.guardarUsu(usuario);
        this.listarUsuario(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
