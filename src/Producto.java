
/**
 *
 * @author lenovo2022
 */
public class Producto {
    int id_pro, precio;
    String nombre_pro;

    public Producto(int id_pro, int precio, String nombre_pro) {
        this.id_pro = id_pro;
        this.precio = precio;
        this.nombre_pro = nombre_pro;
    }

    public void setId_pro(int id_pro) {
        this.id_pro = id_pro;
    }

    public int getId_pro() {
        return id_pro;
    }
    

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setNombre_pro(String nombre_pro) {
        this.nombre_pro = nombre_pro;
    }

    
    public int getPrecio() {
        return precio;
    }

    public String getNombre_pro() {
        return nombre_pro;
    }

    
    
    
}
