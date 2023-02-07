
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.ext.DatabaseClosedException;
import com.db4o.ext.DatabaseReadOnlyException;


/**
 *
 * @author lenovo2022
 */
public class Conexion1 {
    
    private ObjectContainer oc;
    
    private void open(){
        
        this.oc=Db4o.openFile("Clientes.yap");
                        
    }
    
    public boolean Insertar1(Cliente objeto){
        try{
            this.open();
            oc.set(objeto);
            this.oc.close();
            return true;
        }catch (DatabaseClosedException | DatabaseReadOnlyException e){
            System.out.println("bdoo.Controlador.Insertar() : " +e);
            return false;
        }
    }
    public boolean Eliminar(Cliente objeto) {
       try{
           //Busca coincidencia en la base y la elimina
           this.open();
           ObjectSet resultados = this.oc.get(objeto);
           if(resultados.size()>0){
               Cliente persona = (Cliente) resultados.next();
               this.oc.delete(persona);
               this.oc.close();
               return true;
           }else{
               this.oc.close();
               return false;
           }
       }catch (DatabaseClosedException | DatabaseReadOnlyException e){
           System.out.println("bdoo.controlador.InserarPersona() : " +e);
           return false;
       }
   }
     
    public Cliente [] ConsultarCliente(Cliente objeto){
        try{
            Cliente[] clientes = null;
            this.open();
            ObjectSet resultado =this.oc.get(objeto);
            int i =0;
            if (resultado.hasNext()){
                clientes = new Cliente[resultado.size()];
                while(resultado.hasNext()){
                    clientes [i] = (Cliente) resultado.next();
                i++;
                }
            }
            this.oc.close();
            return clientes;
        }catch(DatabaseClosedException | DatabaseReadOnlyException e){
            System.out.println("bdoo.Controlador1.Inserat()" +e);
            return null;
            
        }
    }
}