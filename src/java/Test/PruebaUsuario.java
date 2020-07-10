
package Test;

import DAO.UsuarioDAO;
import DAO.UsuarioDAOImplementar;
import Model.Usuario;
import java.util.List;

/**
 *
 * @author Cristian
 */
public class PruebaUsuario {
    
    public static void main(String[] args) {
        PruebaUsuario test =new PruebaUsuario();
        
        //test.editarUsuario();
        //test.guardarUsusario();
        test.listarUsuario();
        //test.borrarUsuario();
        //test.listarUsuario();
    }
    
    public void listarUsuario(){
        UsuarioDAO usuario = new UsuarioDAOImplementar();
        List<Usuario> listar = usuario.Listar();
        System.out.println("LISTADO DE USUARIOS");
        for(Usuario usuarioListar : listar){
            System.out.println("ID: " + usuarioListar.getId() + 
                    " \nNombre: " + usuarioListar.getNombre() + 
                    " \nApellido: " + usuarioListar.getApellido() + 
                    " \nCorreo: " + usuarioListar.getCorreo() + 
                    " \nUsuario: " + usuarioListar.getUsuario() +
                    " \nClave: " + usuarioListar.getClave() +
                    " \nTipo: " + usuarioListar.getTipo() + 
                    " \nEstado: " + usuarioListar.getEstado() + 
                    " \nPregunta: " + usuarioListar.getPregunta() +
                    " \nRespuesta: " + usuarioListar.getRepuesta() +
                    " \nFecha: " + usuarioListar.getFecha_registro());
        }
    }
    
    public void editarUsuario(){
        UsuarioDAO usuario = new UsuarioDAOImplementar();
        Usuario user_edit = usuario.editarUsu(1);
        System.out.println("Usuario a Editar");
        System.out.println("ID: " + user_edit.getId() + 
                    " \nNombre: " + user_edit.getNombre() + 
                    " \nApellido: " + user_edit.getApellido() + 
                    " \nCorreo: " + user_edit.getCorreo() + 
                    " \nUsuario: " + user_edit.getUsuario() +
                    " \nClave: " + user_edit.getClave() +
                    " \nTipo: " + user_edit.getTipo() + 
                    " \nEstado: " + user_edit.getEstado() + 
                    " \nPregunta: " + user_edit.getPregunta() +
                    " \nRespuesta: " + user_edit.getRepuesta() +
                    " \nFecha: " + user_edit.getFecha_registro());
    }
    
    public void guardarUsusario(){
        UsuarioDAO usuario = new UsuarioDAOImplementar();
        Usuario guarda_user = new Usuario();
        guarda_user.setId(2);
        guarda_user.setNombre("Raul Auron");
        guarda_user.setApellido("Manzano Play");
        guarda_user.setCorreo("auron@gmail.com");
        guarda_user.setUsuario("Usuario");
        guarda_user.setClave("9876");
        guarda_user.setTipo(1);
        guarda_user.setEstado(1);
        guarda_user.setPregunta("Cual es el color que no gusta");
        guarda_user.setRepuesta("El amarillo");
        
        usuario.guardarUsu(guarda_user);
    }
    
    public void borrarUsuario(){
        UsuarioDAO usuario = new UsuarioDAOImplementar();
        usuario.borrarUsu(2);
    }
}
