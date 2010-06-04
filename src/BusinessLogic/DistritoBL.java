/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessLogic;

/**
 *
 * @author Bernabe Yanac
 */

import BusinessEntity.DepartamentoBE;
import BusinessEntity.DistritoBE;
import BusinessEntity.ProvinciaBE;
import DataAccess.DistritoDA;
import java.util.ArrayList;

/**
 *
 * @author Mnu
 */
public class DistritoBL {

    private DistritoDA objDistritoDA;
    
     public ArrayList<DistritoBE> CargarDistrito(ProvinciaBE provi){
        objDistritoDA = new DistritoDA();
        try{
           return objDistritoDA.CargarDistrito(provi);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public ArrayList<DistritoBE> CargarDistrito() {
        objDistritoDA = new DistritoDA();
        try{
           return objDistritoDA.CargarDistrito();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    
}