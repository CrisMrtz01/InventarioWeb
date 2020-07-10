
package DAO;

import Factory.ConexionBD;
import Factory.FactoryConexionBD;
import Model.Categoria;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cristian
 */
public class CategoriaDAOImplementar implements CategoriaDAO{
    
    //metodo constructor para la conexion
    ConexionBD conn;//cre el objeto de tipo conexion
    public CategoriaDAOImplementar(){
        //definimos la base de datos a conectar por defecto
        // se va de aqui this.conn = FactoryConexionBD.open(FactoryConexionBD.MySql);
    }

    @Override
    public List<Categoria> Listar() {
        this.conn = FactoryConexionBD.open(FactoryConexionBD.MySql);
        StringBuilder miSql = new StringBuilder();//construir la consulta
        miSql.append("Select * from tb_categoria;");//agrega la consulta
        List<Categoria> lista = new ArrayList<Categoria>();
        try {
            //se crea el objeto ResultSet implementando el metodo(consultaSql) creado para la consulta
            ResultSet resultadoSql = this.conn.consultaSql(miSql.toString());
            while (resultadoSql.next()) {                
                Categoria categoria = new Categoria();//declara el objeto categoria
                //asigna cada campo consultado al atributo de la clase
                categoria.setId_categoria(resultadoSql.getInt("id_categoria"));
                categoria.setNom_categoria(resultadoSql.getString("nom_categoria"));
                categoria.setEstado_categoria(resultadoSql.getInt("estado_categoria"));
                lista.add(categoria);//agrega al array cada registro encontrado
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            this.conn.cerrarConexion();//cierra la conexion
        }
        return lista;
    }

    @Override
    public List<Categoria> Listar2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Categoria editarCat(int id_cat_edit) {
        this.conn = FactoryConexionBD.open(FactoryConexionBD.MySql);
        Categoria categoria = new Categoria();//objeto para devolver los datos
        StringBuilder miSql = new StringBuilder();//construye la consulta
        //agrega la consulta
        miSql.append("select * from tb_categoria where id_categoria = ").append(id_cat_edit);
        //realiza la consulta
        try {
            ResultSet resultadosSql = this.conn.consultaSql(miSql.toString());
            while (resultadosSql.next()) {                
                categoria.setId_categoria(resultadosSql.getInt("id_categoria"));
                categoria.setNom_categoria(resultadosSql.getString("nom_categoria"));
                categoria.setEstado_categoria(resultadosSql.getInt("estado_categoria"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.conn.cerrarConexion();
        }
        return categoria;
    }

    @Override
    public boolean guardarCat(Categoria categoria) {
        this.conn = FactoryConexionBD.open(FactoryConexionBD.MySql);
        boolean guardar = false;//bandera de resultado
        try {
            if (categoria.getId_categoria() == 0) {//valida para una nueva categoria
                StringBuilder miSql = new StringBuilder();
                miSql.append("insert into tb_categoria(nom_categoria, estado_categoria) Values ('");
                miSql.append(categoria.getNom_categoria() + "', ").append(categoria.getEstado_categoria());
                miSql.append(");");
                //invoca al metodo para ejecutar la consulta
                this.conn.ejecutarSql(miSql.toString());
            } else if(categoria.getId_categoria() > 0){//actualizar, id_categoria mayores a 0
                StringBuilder miSql = new StringBuilder();
                miSql.append("update tb_categoria set id_categoria = ").append(categoria.getId_categoria());
                miSql.append(", nom_categoria ='").append(categoria.getNom_categoria());
                miSql.append("', estado_categoria =").append(categoria.getEstado_categoria());
                miSql.append(" where id_categoria =").append(categoria.getId_categoria()).append(";");
                //invoca metodo para ejecutar la consulta
                this.conn.ejecutarSql(miSql.toString());
            }
            guardar = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.conn.cerrarConexion();
        }
        return guardar;
    }

    @Override
    public boolean borrarCat(int id_cat_borrar) {
        this.conn = FactoryConexionBD.open(FactoryConexionBD.MySql);
        boolean borrar = false;
        try {
            StringBuilder miSql = new StringBuilder();
            miSql.append("delete from tb_categoria where id_categoria =").append(id_cat_borrar);
            this.conn.ejecutarSql(miSql.toString());
            borrar = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.conn.cerrarConexion();
        }
        return borrar;
    }
    
}