
package Factory;

/**
 *
 * @author Cristian
 */
public class FactoryConexionDB {
    //Podemos definir la configuracion para diferentes BD
    public static final int MySQL = 1; //Para conectar a mysql
    public static String[] configMySQL = {"bd_inventario", "root", ""};
    
    public static ConexionDB open (int tipoBD){
        switch(tipoBD){
            case FactoryConexionDB.MySQL:
            return new MySQLConexionFactory(configMySQL);
            default:
            return null;
        }
    }
}
