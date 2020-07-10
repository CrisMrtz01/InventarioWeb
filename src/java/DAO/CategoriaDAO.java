
package DAO;

import Model.Categoria;
import java.util.List;

/**
 *
 * @author Cristian 
 */
public interface CategoriaDAO {
    //aqui definimos los metodos abstractos
    public List<Categoria> Listar();
    public List<Categoria> Listar2();
    public Categoria editarCat(int id_cat_edit);
    public boolean guardarCat(Categoria categoria);
    public boolean borrarCat(int id_cat_borrar);
}
