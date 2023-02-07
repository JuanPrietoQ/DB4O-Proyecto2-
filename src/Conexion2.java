
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.ext.DatabaseClosedException;
import com.db4o.ext.DatabaseReadOnlyException;


/**
 *
 * @author lenovo2022
 */
public class Conexion2 {
    
    private ObjectContainer db;
    
    private void open(){
        
        this.db=Db4o.openFile("productos.yap");
                        
    }
    
   //Metodo Insertar
    public boolean Insertar2 (Producto objeto){
        
        try{
            this.open();
            db.set(objeto);
            this.db.close();
            return true;
        }catch (DatabaseClosedException | DatabaseReadOnlyException e){
            System.out.println("bdooo.Controlador.InsertarProducto() : "+e);
            return false;
        }
    }
    
    //Metodo Eliminar
     public boolean Eliminar2(Producto objeto) {
       try{
           //Busca coincidencia en la base y la elimina
           this.open();
           ObjectSet resultados = this.db.get(objeto);
           
           if(resultados.size()>0){
               Producto adquirido = (Producto) resultados.next();
               this.db.delete(adquirido);
               this.db.close();
               return true;
           }else{
               this.db.close();
               return false;
           }
       }catch (DatabaseClosedException | DatabaseReadOnlyException e){
           System.out.println("bdoo.controlador.InserarPersona() : " +e);
           return false;
       }
   }
     
     public Producto [] ConsultarProducto(Producto objeto){
         try{
             Producto [] productos = null;
             this.open();
             ObjectSet resultados = this.db.get(objeto);
             int j = 0;
             if(resultados.hasNext()){
                 productos = new Producto [resultados.size()];
                 while(resultados.hasNext()){
                     productos[j] = (Producto) resultados.next();
                     j++;
                 }
             }
             this.db.close();
             return productos;
         }catch(DatabaseClosedException | DatabaseReadOnlyException e){
             System.out.println("dboo.Controlador2.InsertarProducto() : " +e);
             return null;
         }
     }
}
