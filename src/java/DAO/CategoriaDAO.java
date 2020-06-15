
package DAO;

/**
 *
 * @author Cristian
 */
import Model.Categoria;
import java.util.List;

public interface CategoriaDAO {
    //Definir los metodos como la clase interface los metodos no se implementaran aqui
    //Los metodos son de tipo abstracto
    public List<Categoria> Listar();
    public List<Categoria> Listar2();
    public Categoria editarCat(int id_cat_edit);
    public boolean guardarCat(Categoria categoria);
    public boolean borrarCat(int id_cat_borrar);
}
