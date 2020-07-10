
package Factory;

/**
 *
 * @author Cristian
 */
public class FactoryConexionBD {
//Definir la conexion para diferentes BD
    public static final int MySql = 1;
    public static String[] configMySql = {"bd_inventario", "root", ""};
    
    public static ConexionBD open(int tipoBD){
        switch(tipoBD){
            case FactoryConexionBD.MySql:
                return new MySqlConexionFactory(configMySql);
               
            default:
                return null;
        }
    }
}