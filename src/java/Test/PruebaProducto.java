
package Test;

import DAO.CategoriaDAO;
import DAO.CategoriaDAOImplementar;
import DAO.ProductoDAO;
import DAO.ProductoDAOImplementar;
import Model.Categoria;
import Model.Producto;
import java.util.List;
/**
 *
 * @author Cristian
 */
public class PruebaProducto {
    public static void main(String[] args) {
        PruebaProducto test = new PruebaProducto();
        //test.guardarProducto();
        test.listarProducto();
        System.out.println("============================");
        test.borrarProducto();
        test.listarProducto();
        //test.editarProducto();
        
    }
    
    public void listarProducto(){
        ProductoDAO producto = new ProductoDAOImplementar();
        CategoriaDAO categoria = new CategoriaDAOImplementar();
        Categoria ct = new Categoria();
        List<Producto> listar = producto.Listar();
        //List<Categoria> lst =  categoria.Listar();
        System.out.println("LISTA DE PRODUCTOS");
        /*
        String l = "";
        for(Categoria s : lst){
            l = s.getNom_categoria();
        }
        */
        for(Producto producto1 : listar){
            System.out.println("ID: " + producto1.getId_producto() + 
                    " \nNombre: " + producto1.getNom_producto() + 
                    " \nStock: " + producto1.getStock() + 
                    " \nPrecio: " + producto1.getPrecio() + 
                    " \nUM: " + producto1.getUnidadMedida() +
                    " \nEstado: " + producto1.getEstado() +
                    //" \nCategoria: " +l+ 
                    " \nCategoria: " + producto1.getCategoria_id()+
                    " \nDescripcion: " + producto1.getDes_producto() + 
                    " \nFecha: " + producto1.getFecha_entrada()+ "\n_________________");
        }
    }
    
    public void editarProducto(){
        ProductoDAO producto = new ProductoDAOImplementar();
        Producto prod_edit = producto.editaProd(2);
        System.out.println("<<<<Producto a Editar>>>>>");
        System.out.println("ID: " + prod_edit.getId_producto() + 
                    " \nNombre: " + prod_edit.getNom_producto() + 
                    " \nStock: " + prod_edit.getStock() + 
                    " \nPrecio: " + prod_edit.getPrecio() + 
                    " \nUM: " + prod_edit.getUnidadMedida() +
                    " \nEstado: " + prod_edit.getEstado() +
                    //" \nCategoria: " +l+ 
                    " \nCategoria: " + prod_edit.getCategoria_id()+
                    " \nDescripcion: " + prod_edit.getDes_producto() + 
                    " \nFecha: " + prod_edit.getFecha_entrada());
    }
    
    public void guardarProducto(){
        ProductoDAO producto = new ProductoDAOImplementar();
        Producto guardar_Prod = new Producto();
        //guardar_Prod.setId_producto(4);
        guardar_Prod.setNom_producto("leche");
        guardar_Prod.setPrecio(3.4);
        guardar_Prod.setPrecio(5.50);
        guardar_Prod.setUnidadMedida("lt");
        guardar_Prod.setEstado(1);
        guardar_Prod.setCategoria_id(Integer.toString(10));
        guardar_Prod.setDes_producto("leche fff");
        
        producto.guardarProd(guardar_Prod);
    }
    
    public void borrarProducto(){
        ProductoDAO producto = new ProductoDAOImplementar();
        producto.borrarProd(4);
    }
}
