/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessLogic;

import BusinessEntity.DepartamentoBE;
import DataAccess.DepartamentoDA;
import java.util.ArrayList;

/**
 *
 * @author Bernabe Yanac
 */
public class DepartamentoBL {

    private DepartamentoDA objDepartamentoDA;
    
     public ArrayList<DepartamentoBE> CargarDepartamento(){
        objDepartamentoDA = new DepartamentoDA();
        try{
           return objDepartamentoDA.CargarDepartamento();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    
}
