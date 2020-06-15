
package Factory;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Cristian
 */
public final class MySQLConexionFactory extends ConexionDB {

    
    //@Override
    //Connection open() {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}
    
    public MySQLConexionFactory(String[] criterios) {
        this.parametros = criterios; //Pasar los criterios al array de la clase padre
        this.open(); //Llamar al metodo open
    }
    
    @Override
    public Connection open(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            //en this.parametros van los respectivos datos de la bd, usuario, clave
            this.conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + this.parametros[0], this.parametros[1], this.parametros[2]);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return this.conexion;
    }
}
