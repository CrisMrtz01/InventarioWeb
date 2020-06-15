
package Model;

/**
 *
 * @author Cristian
 */
public class Producto {
    private int id_producto;
    private String nom_producto;
    private float stock;
    private float precio;
    private String unidad_de_medida;
    private int estado_producto;
    private int id_categoria;
    private Categoria categoria; //Objeto categoria
    
    public Producto(){
        this.id_producto = 0;
        this.categoria = new Categoria(); //Inicializar el metodo categoria
    }
    
    public Producto(int id_producto, String nom_producto, float stock, float precio, String unidad_de_medida, int estado_producto, int id_categoria, Categoria categoria) {
        this.id_producto = id_producto;
        this.nom_producto = nom_producto;
        this.stock = stock;
        this.precio = precio;
        this.unidad_de_medida = unidad_de_medida;
        this.estado_producto = estado_producto;
        this.id_categoria = id_categoria;
        this.categoria = categoria;
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

    public float getStock() {
        return stock;
    }

    public void setStock(float stock) {
        this.stock = stock;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getUnidad_de_medida() {
        return unidad_de_medida;
    }

    public void setUnidad_de_medida(String unidad_de_medida) {
        this.unidad_de_medida = unidad_de_medida;
    }

    public int getEstado_producto() {
        return estado_producto;
    }

    public void setEstado_producto(int estado_producto) {
        this.estado_producto = estado_producto;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    
}
