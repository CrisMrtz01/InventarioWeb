
package Model;

import java.sql.Date;

/**
 *
 * @author Cristian
 */
public class Producto {
    private int id_producto;
    private String nom_producto;
    private String categoria_id;
    private double stock;
    private double precio;
    private String unidadMedida;
    private int estado;
    private String des_producto;
    private Date fecha_entrada;

    private Categoria categoria;//objeto categoria para la llave foranea

    public Producto() {
        this.id_producto = 0;
        this.nom_producto = "";
        this.categoria_id = "";
        this.stock = 0;
        this.precio =0;
        this.unidadMedida="";
        this.estado = 1;
        this.des_producto = "";
        
        //this.categoria = new Categoria();
    }

    public Producto(int id_producto, String nom_producto, String categoria_id, double stock, double precio, String unidadMedida, int estado, String des_producto, Date fecha_entrada, Categoria categoria) {
        this.id_producto = id_producto;
        this.nom_producto = nom_producto;
        this.categoria_id = categoria_id;
        this.stock = stock;
        this.precio = precio;
        this.unidadMedida = unidadMedida;
        this.estado = estado;
        this.des_producto = des_producto;
        this.fecha_entrada = fecha_entrada;
        //this.categoria = categoria;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNom_producto() {
        return nom_producto;
    }

    public void setNom_producto(String nom_producto) {
        this.nom_producto = nom_producto;
    }

    public String getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(String categoria_id) {
        this.categoria_id = categoria_id;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
    public String getDes_producto() {
        return des_producto;
    }

    public void setDes_producto(String des_producto) {
        this.des_producto = des_producto;
    }

    public Date getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(Date fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }
    
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    
}
