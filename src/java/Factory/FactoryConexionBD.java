
package Factory;
import Factory.MySQLConexionFactory;

/**
 *
 * @author Cristian 
 */
public class FactoryConexionBD {
    //podemos definir la conexion para diferentes BD
    public static final int MySql = 1;
    public static String[] configMySql = {"bd_inventario", "root", ""};
    
    public static ConexionBD open(int tipoBD){
        switch(tipoBD){
            case FactoryConexionBD.MySql:
                return new MySQLConexionFactory(configMySql);
               
            default:
                return null;
        }
    }
}
