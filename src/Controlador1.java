
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author lenovo2022
 */
public class Controlador1 extends Conexion1 {
    
    public boolean InsertarClientes(int id, String nombre, String apellido){
        Cliente cliente = new Cliente(id, nombre, apellido);
        return this.Insertar1(cliente);
    }
    
    
    public DefaultTableModel clientes(){
        String titulos[] = {"CEDULA","NOMBRE", "APELLIDO"};
        DefaultTableModel dtm = new DefaultTableModel(null, titulos);
        Cliente persona = null;
        Cliente [] c = this.ConsultarCliente(persona);
        if(c!=null){
            for (Cliente client : c){
                Object[] cli = new Object [3];
                cli[0] = client.getId();
                cli[1] = client.getNombre();
                cli[2] = client.getApellido();
                
            }
        }
        return dtm;
    }
    
    public boolean EliminarCliente(int id){
        if(id>0){
            Cliente cliente = new Cliente(id, null,null);
            return this.Eliminar(cliente);
        }else{
            return false;
        }
    }
}
