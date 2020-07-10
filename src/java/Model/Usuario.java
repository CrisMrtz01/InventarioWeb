
package Model;

import java.sql.Date;

/**
 *
 * @author Cristian
 */
public class Usuario {
    private int id;
    private String nombre;
    private String apellido;
    private String correo;
    private String usuario;
    private String clave;
    private int tipo;
    private int estado;
    private String pregunta;
    private String repuesta;
    //fecha registro null por que se llena automatico primera prueba
    private Date fecha_registro;  

    public Usuario() {
        this.id = 0;
        this.nombre = "";
        this.apellido = "";
        this.correo = "";
        this.usuario = "";
        this.clave = "";
        this.tipo = 1;
        this.estado = 1;
        this.pregunta = "";
        this.repuesta = "";
        //this.fecha_registro = null;
    }

    public Usuario(int id, String nombre, String apellido, String correo, String usuario, String clave, int tipo, int estado, String pregunta, String repuesta, Date fecha_registro) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.usuario = usuario;
        this.clave = clave;
        this.tipo = tipo;
        this.estado = estado;
        this.pregunta = pregunta;
        this.repuesta = repuesta;
        this.fecha_registro = fecha_registro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRepuesta() {
        return repuesta;
    }

    public void setRepuesta(String repuesta) {
        this.repuesta = repuesta;
    }  
    
    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
    
}
