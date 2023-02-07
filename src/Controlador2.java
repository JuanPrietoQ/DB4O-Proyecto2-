
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author Juan Dario
 */
public class Controlador2 extends Conexion2{
    
    public boolean InsertarProductos(int id_pro, int precio, String nombre_pro){
        Producto producto = new Producto(id_pro,precio,nombre_pro);
        return this.Insertar2(producto);
    }
    
    public DefaultTableModel productos(){
        String titulos[] = {"CODIGO", "PRECIO", "NOMBRE"};
        DefaultTableModel dtm = new DefaultTableModel(null, titulos);
        Producto producto = null;
        Producto [] p = this.ConsultarProducto(producto);
        if (p!=null){
            for(Producto pro : p){
                Object[] prod = new Object[3];
                prod [0] = pro.getId_pro();
                prod [1] = pro.getPrecio();
                prod [2] = pro.getNombre_pro();
                dtm.addRow(prod);
            }
        }
        return dtm;
    }
    
    public boolean EliminarProducto (int id_prod){
        if (id_prod>0){
            Producto producto = new Producto(id_prod, 0, null);
            return this.Eliminar2(producto);
        }else{
            return false;
        }
    }
}
