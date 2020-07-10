
package DAO;

import Factory.ConexionBD;
import Factory.FactoryConexionBD;
import Model.Categoria;
import Model.Producto;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAOImplementar implements ProductoDAO{

    ConexionBD conn;
    public ProductoDAOImplementar(){
        
        
    }
    
    @Override
    public List<Producto> Listar() {
        this.conn = FactoryConexionBD.open(FactoryConexionBD.MySQL);
        
        StringBuilder miSql = new StringBuilder();
        miSql.append("SELECT\n" +
            " p.categoria, p.id_producto, p.nom_producto, p.stock, p.precio, p.unidad_de_medida, p.estado_producto,\n" +
            " c.nom_categoria, p.des_producto, p.fecha_entrada\n" +
            "FROM tb_producto p INNER JOIN tb_categoria c\n" +
            "on p.categoria = c.id_categoria;");
        List<Producto> lista = new ArrayList<Producto>();
        //List<Categoria> lista2 = new ArrayList<Categoria>();
        try {
            ResultSet resultadoSql = this.conn.consultaSql(miSql.toString());
            while (resultadoSql.next()) {                
                Producto producto = new Producto();
                //Categoria cate = new Categoria();
                producto.setId_producto(resultadoSql.getInt("id_producto"));
                producto.setNom_producto(resultadoSql.getString("nom_producto"));
                producto.setStock(resultadoSql.getFloat("stock"));
                producto.setPrecio(resultadoSql.getFloat("precio"));
                producto.setUnidadMedida(resultadoSql.getString("unidad_de_medida"));
                producto.setEstado(resultadoSql.getInt("estado_producto"));
                //producto.setCategoria(resultadoSql.getObject(Categoria, "nom_cat");
                producto.setCategoria_id(resultadoSql.getString("c.nom_categoria"));
                //cate.setNom_categoria(resultadoSql.getString("nom_categoria"));
                producto.setDes_producto(resultadoSql.getString("des_producto"));
                producto.setFecha_entrada(resultadoSql.getDate("fecha_entrada"));
                lista.add(producto);
                //lista2.add(cate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.conn.cerrarConexion();
        }
        return lista;
    }

    @Override
    public Producto editaProd(int id_prod_edit) {
        this.conn = FactoryConexionBD.open(FactoryConexionBD.MySQL);
        Producto producto = new Producto();
        StringBuilder miSql = new StringBuilder();
        miSql.append("SELECT\n" +
            " p.categoria, p.id_producto, p.nom_producto, p.stock, p.precio, p.unidad_de_medida, p.estado_producto,\n" +
            " c.nom_categoria, p.des_producto, p.fecha_entrada\n" +
            "FROM tb_producto p INNER JOIN tb_categoria c\n" +
            "on p.categoria = c.id_categoria where id_producto = ").append(id_prod_edit);
        
        try {
            ResultSet resultadosSql = this.conn.consultaSql(miSql.toString());
            while (resultadosSql.next()) {                
                producto.setId_producto(resultadosSql.getInt("id_producto"));
                producto.setNom_producto(resultadosSql.getString("nom_producto"));
                producto.setStock(resultadosSql.getFloat("stock"));
                producto.setPrecio(resultadosSql.getFloat("precio"));
                producto.setUnidadMedida(resultadosSql.getString("unidad_de_medida"));
                producto.setEstado(resultadosSql.getInt("estado_producto"));
                //producto.setCategoria(resultadoSql.getObject(Categoria, "nom_cat");
                producto.setCategoria_id(resultadosSql.getString("c.nom_categoria"));
                //cate.setNom_categoria(resultadoSql.getString("nom_categoria"));
                producto.setDes_producto(resultadosSql.getString("des_producto"));
                producto.setFecha_entrada(resultadosSql.getDate("fecha_entrada"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.conn.cerrarConexion();
        }
        
        return producto;
    }

    @Override
    public boolean guardarProd(Producto producto) {
        this.conn = FactoryConexionBD.open(FactoryConexionBD.MySQL);
        boolean guardar = false;
        try {
            if (producto.getId_producto() == 0) {
                StringBuilder miSql = new StringBuilder();
                miSql.append("INSERT INTO tb_producto (nom_producto, stock, precio, unidad_de_medida, estado_producto, categoria, des_producto) values('");
                miSql.append(producto.getNom_producto() +
                        "', '").append(producto.getStock() +
                        "', '").append(producto.getPrecio()+
                        "', '").append(producto.getUnidadMedida()+
                        "', '").append(producto.getEstado()+
                        "', '").append(producto.getCategoria_id()+
                        "', '").append(producto.getDes_producto());
                miSql.append("');");
                this.conn.ejecutarSql(miSql.toString());
                
            } else if(producto.getId_producto() > 0){
                StringBuilder miSql = new StringBuilder();
                miSql.append("update tb_producto set id_producto ='").append(producto.getId_producto());
                miSql.append("', nom_producto = '").append(producto.getNom_producto());
                miSql.append("', stock = '").append(producto.getStock());
                miSql.append("', precio = '").append(producto.getPrecio());
                miSql.append("', unidad_de_medida = '").append(producto.getUnidadMedida());
                miSql.append("', estado_producto = '").append(producto.getEstado());
                miSql.append("', categoria = '").append(producto.getCategoria_id());
                miSql.append("', des_producto = '").append(producto.getDes_producto());
                miSql.append("' where id_producto = ").append(producto.getId_producto()).append(";");
                this.conn.ejecutarSql(miSql.toString());
            }
            guardar = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            this.conn.cerrarConexion();
        }
        return guardar;
    }

    @Override
    public boolean borrarProd(int id_prod_borrar) {
        this.conn = FactoryConexionBD.open(FactoryConexionBD.MySQL);
        boolean borrar = false;
        try {
            StringBuilder miSql = new StringBuilder();
            miSql.append("delete from tb_producto where id_producto =").append(id_prod_borrar);
            this.conn.ejecutarSql(miSql.toString());
            borrar = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.conn.cerrarConexion();
        }
        return borrar;
    }
    
}
