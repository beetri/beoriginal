/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessLogic;
import java.util.ArrayList;
import BusinessEntity.ModuloBE;
import DataAccess.ModuloDA;
/**
 *
 * @author Administador
 */
public class ModuloBL {
private ModuloDA objModuloDA;
    private ArrayList<ModuloBE> lModulo = new ArrayList<ModuloBE>();
    private ArrayList<ModuloBE> lModuloTotal = new ArrayList<ModuloBE>();
    public ArrayList<ModuloBE> getModulo(int idPerfil){
        objModuloDA = new ModuloDA();
        try{

           lModulo = objModuloDA.getModulo(idPerfil);
        //   System.out.printf("numero de Moduloes = %d\n",lModulo.size() );
       //    System.out.printf("vcMenuItem = %s\n",lModulo.get(0).getStrMenuItem() );
            return lModulo;
        }
        catch(Exception ex){
            return null;
        }
    };
     public ModuloBE getModulo(String nombre){
        objModuloDA = new ModuloDA();
        ModuloBE objModulo = new ModuloBE();
        try{

           objModulo = objModuloDA.getModulo(nombre);
        //   System.out.printf("numero de Moduloes = %d\n",lModulo.size() );
       //    System.out.printf("vcMenuItem = %s\n",lModulo.get(0).getStrMenuItem() );
            return objModulo;
        }
        catch(Exception ex){
            return null;
        }
    };
    public ArrayList<ModuloBE> getModuloTotal(){
        objModuloDA = new ModuloDA();
        try{
            lModuloTotal = objModuloDA.getModuloTotal();
            return lModuloTotal;
        }
        catch(Exception ex){
            return null;
        }
    };
}
