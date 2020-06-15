
package DAO;

import Model.Categoria;
import java.util.List;
import Factory.ConexionDB;
import Factory.FactoryConexionDB;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAOImplementar implements CategoriaDAO{
    
    ConexionDB conn;//Crear el objeto tipo conexion
    
    public  CategoriaDAOImplementar(){
        //Definir a la base de datos que se conectara por defecto
    }
    
    @Override
    public List<Categoria> Listar() {
        this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
        StringBuilder mySQL = new StringBuilder();//Construir la consulta
        mySQL.append("SELECT * FROM tb_categoria;"); //Agregar a la consulta
        List<Categoria> lista = new ArrayList<Categoria>();
        try{
            //Se crea el objeto ResultSet implementando el metodo consulta SQL creado para la consulta
            ResultSet resultadoSQL = this.conn.consultaSQL(mySQL.toString());
            while(resultadoSQL.next()){
                Categoria categoria = new Categoria();//Declarar el objeto categoria
                //Asignar a cada campo resultado al atributo de la clase
                categoria.setId_categoria(resultadoSQL.getInt("id_categoria"));
                categoria.setNom_categoria(resultadoSQL.getString("nom_categoria"));
                categoria.setEstado_categoria(resultadoSQL.getInt("estado_categoria"));
                lista.add(categoria);//Agregar al array cada registro encontrado    
            }
        }catch(Exception ex){
            
        }finally{
            this.conn.cerrarConexion(); //para cerrar la conexion
        }
        return lista;
    }

    @Override
    public List<Categoria> Listar2() {
        this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Categoria editarCat(int id_cat_edit) {
        this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
        Categoria categoria = new Categoria();//Objeto para devolver datos
        StringBuilder mySQL = new StringBuilder();//Construir la consulta
        //Agregar la consulta SQL
        mySQL.append("SELECT * FROM tb_categoria WHERE id_categoria = ").append(id_cat_edit);
        try{//Realizar la consulta
            ResultSet resultadoSQL = this.conn.consultaSQL(mySQL.toString());
            while(resultadoSQL.next()){
                categoria.setId_categoria(resultadoSQL.getInt("id_categoria"));
                categoria.setNom_categoria(resultadoSQL.getString("nom_categoria"));
                categoria.setEstado_categoria(resultadoSQL.getInt("estado_categoria"));
            }
        }catch(Exception e ){
        
        }finally{
            this.conn.cerrarConexion();//Cerrar Conexion
        }
        return categoria;
    }

    @Override
    public boolean guardarCat(Categoria categoria) {
        this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean borrarCat(int id_cat_borrar) {
        this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
