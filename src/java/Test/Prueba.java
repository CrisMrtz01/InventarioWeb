
package Test;

import DAO.CategoriaDAO;
import DAO.CategoriaDAOImplementar;
import Model.Categoria;
import java.util.List;

public class Prueba {
    public static void main(String[] args) {
        Prueba evaluar = new Prueba();
        //evaluar.listarCategorias();
        evaluar.editarCategoria();
    }
    
    public void listarCategorias(){
        CategoriaDAO categoria = new  CategoriaDAOImplementar();
        List<Categoria> listar = categoria.Listar();
        System.out.println("LISTADO DE CATEGORIAS");
        for (Categoria categoriaListar: listar) {
            System.out.println("ID: " + categoriaListar.getId_categoria() +
                               " NOMBRE: " + categoriaListar.getNom_categoria() +
                               " ESTADO: " + categoriaListar.getEstado_categoria()
            );
        }
    }
    
    public void editarCategoria(){
    CategoriaDAO categoria = new CategoriaDAOImplementar();
    Categoria cat_edit = categoria.editarCat(1); //se pasa el valor id_categoria = 1
        System.out.println("CATEGORIA A MODIFICAR");
        System.out.println("ID: " + cat_edit.getId_categoria() +
                               " NOMBRE: " + cat_edit.getNom_categoria() +
                               " ESTADO: " + cat_edit.getEstado_categoria()
            );
    }
}
