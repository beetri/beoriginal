/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessLogic;

/**
 *
 * @author Bernabe
 */
import BusinessEntity.DepartamentoBE;
import BusinessEntity.ProvinciaBE;
import DataAccess.ProvinciaDA;
import java.util.ArrayList;

/**
 *
 * @author Bernabe
 */
public class ProvinciaBL {

    private ProvinciaDA objProvinciaDA;
    
     public ArrayList<ProvinciaBE> CargarProvincia(DepartamentoBE depa){
        objProvinciaDA = new ProvinciaDA();
        try{
           return objProvinciaDA.CargarProvincia(depa);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
//agregado por jacky
    public ArrayList<ProvinciaBE> CargarProvincia() {
        objProvinciaDA = new ProvinciaDA();
        try{
           return objProvinciaDA.CargarProvincia();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    
}

