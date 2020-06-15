
package Factory;

/**
 * @author Cristian
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class ConexionDB {
    protected String[] parametros; //Array que recibe los parametros de la conexion
    protected Connection conexion;
    //El siguiente metodo abstracto no se implementa solamente se declara
    //Se implementara en la subclase
    abstract Connection open();//Metodo abstracto que devuelve el objeto connection
    
    //Metodo para las consultas
    public ResultSet consultaSQL(String consulta){
        Statement st; //Objeto Statement en el encargado de ejecutar las consultas
        ResultSet rs = null; //Tabla temporal donde se almacenan los datos
        try{
            st = conexion.createStatement();
            rs = st.executeQuery(consulta); //Se ejecuta la consulta
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return rs;
    }
    
    //Metodo para ejecutar
    public boolean ejercutarSQL(String consulta){
        Statement st; //Objeto statement encargado de ejecutar las consultas
        boolean guardar = true;
        try{
            st = conexion.createStatement();
            st.executeQuery(consulta); //La consulta se ejecuta
        }catch(SQLException ex){
            guardar = false;
            ex.printStackTrace();
        }
        return guardar;
    }
    
    //Metodo para cerrar la conexion
    public boolean cerrarConexion(){
        boolean ok = true;
        try{
            conexion.close();
        }catch(Exception ex){
            ok = false;
            ex.printStackTrace();
        }
        return ok;
    }


}

