
package DAO;

import Model.Producto;
import java.util.List;

// @author Cristian
 
public interface ProductoDAO {
    public List<Producto> Listar();
    public  Producto editaProd(int id_prod_edit);
    public boolean guardarProd(Producto producto);
    public boolean borrarProd(int id_prod_borrar);
}
