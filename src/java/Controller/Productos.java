
package Controller;

import DAO.ProductoDAO;
import DAO.ProductoDAOImplementar;
import Model.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Productos extends HttpServlet {

    protected void listarProductos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        ProductoDAO producto = new ProductoDAOImplementar();
        HttpSession session = request.getSession(true);
        session.setAttribute("lista", producto.Listar());
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Vistas-Productos/listarProductos.jsp");
        dispatcher.forward(request, response);
    }
    
    protected void borrarProducto(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Vistas-Productos/listarProductos.jsp");
        dispatcher.forward(request, response);
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String parametro = request.getParameter("opcion");
        if (parametro.equals("crear")) {
            //action
            String pagina = "/Vistas-Productos/crearProducto.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
            dispatcher.forward(request, response);
            
        } else if(parametro.equals("listar")){
            this.listarProductos(request, response);
            
        } else if(parametro.equals("modificar")){
            //action
            int id = Integer.parseInt(request.getParameter("id_prod"));
            String nombre = request.getParameter("nombre_prod");
            Double stock = Double.parseDouble(request.getParameter("stock_prod"));
            Double precio = Double.parseDouble(request.getParameter("precio_prod"));
            String unidad = request.getParameter("unidad_med");
            int estado = Integer.parseInt(request.getParameter("estado_prod"));
            String categoria = request.getParameter("categoria_prod");
            String descripcion = request.getParameter("desc_prod");
            
            String pagina = "/Vistas-Productos/crearProducto.jsp?id_prod="+id+"&&nombre_prod="+nombre+"&&stock_prod="+stock+"&&precio_prod="+precio+"&&unidad_med="+unidad+"&&estado_prod="+estado+"&&categoria_prod="+categoria+"&&desc_prod="+descripcion+"&&colmena=1";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
            dispatcher.forward(request, response);
            
            
        } else if(parametro.equals("eliminar")){
            int delete_id = Integer.parseInt(request.getParameter("id"));
            ProductoDAO producto = new ProductoDAOImplementar();
            producto.borrarProd(delete_id);
            this.listarProductos(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Producto producto = new Producto();
        int id_product = Integer.parseInt(request.getParameter("id_producto"));
        String nombre = request.getParameter("txtNombre");
        double stock = Double.parseDouble(request.getParameter("txtStock"));
        double precio = Double.parseDouble(request.getParameter("txtPrecio"));
        String unidadMedida = request.getParameter("txtUnidaMedida");
        int estado = Integer.parseInt(request.getParameter("txtEstado"));
        String categoria = request.getParameter("txtCategoria");
        String desProducto = request.getParameter("txtDescripcion");
        
        producto.setId_producto(id_product);
        producto.setNom_producto(nombre);
        producto.setStock(stock);
        producto.setPrecio(precio);
        producto.setUnidadMedida(unidadMedida);
        producto.setEstado(estado);
        producto.setCategoria_id(categoria);
        producto.setDes_producto(desProducto);
        
        ProductoDAO productoG = new ProductoDAOImplementar();
        productoG.guardarProd(producto);
        this.listarProductos(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
