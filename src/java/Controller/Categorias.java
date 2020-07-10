
package Controller;

import DAO.CategoriaDAO;
import DAO.CategoriaDAOImplementar;
import Model.Categoria;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Cristian
 */
public class Categorias extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }
    
    //redirecciona al metodo para lsitar categorias
    protected void listarCategorias(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        //crear instancia a categoriaDAO
        CategoriaDAO categoria = new CategoriaDAOImplementar();
        //crea instancia de session; se coloca true para crear la sesion
        HttpSession session = request.getSession(true);
        session.setAttribute("lista", categoria.Listar());//lista es el nombre de la session
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Vistas-Categorias/listarCategorias.jsp");
        dispatcher.forward(request, response);
        
    }
    
    //redireciona al metodo borrar categorias
    protected void borrarCategoria(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Vistas-Categorias/listarCategorias.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String parametro = request.getParameter("opcion");
        //si el parametro enviado desde el formulario es crear redirecciona a la vista crearCategoria.jsp
        if (parametro.equals("crear")) {
            String pagina = "/Vistas-Categorias/crearCategoria.jsp";//vista p formulario para registrar nueva categoria
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
            dispatcher.forward(request, response);
            
        } else if(parametro.equals("listar")) {//si el parametro es listar pues ya saben que se hace
            this.listarCategorias(request, response);
            
        } else if(parametro.equals("modificar")){//si el paramtro es modifcar se ejecuta la siguiente sentencia
            int id_categoria = Integer.parseInt(request.getParameter("id_cat"));
            String nom_categoria = request.getParameter("nombre_cat");
            int estado = Integer.parseInt(request.getParameter("estado_cat"));
            
            //redirecciona a la pagina crearCategoria
            String pagina = "/Vistas-Categorias/crearCategoria.jsp?id_cat="+ id_categoria+"&&nombre_cat="+nom_categoria+"&&estado_cat="+estado+"&&senal=1";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
            dispatcher.forward(request, response);
            
        } else if(parametro.equals("eliminar")){//si el parametro es eliminar se ejecutara esta accion
            int delete_id = Integer.parseInt(request.getParameter("id"));
            CategoriaDAO categoria = new CategoriaDAOImplementar();
            categoria.borrarCat(delete_id);
            this.listarCategorias(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //instancia la modelo Categoria
        Categoria categoria = new Categoria();
        int id_cat = Integer.parseInt(request.getParameter("id_categoria"));
        String nom_categoria = request.getParameter("txtNomCategoria");
        int estado_categoria = Integer.parseInt(request.getParameter("txtEstadoCategoria"));
        
        categoria.setId_categoria(id_cat);
        categoria.setNom_categoria(nom_categoria);
        categoria.setEstado_categoria(estado_categoria);
        
        CategoriaDAO guardarCategoria = new CategoriaDAOImplementar();
        guardarCategoria.guardarCat(categoria);
        this.listarCategorias(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
