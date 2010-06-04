/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessLogic;

/**
 *
 * @author Bernabe Yanac
 */
import BusinessEntity.AccesoSistemaBE;
import BusinessEntity.UsuarioBE;
import DataAccess.AccesoSistemaDA;

public class AccesoSistemaBL {
     private AccesoSistemaDA objAccesoDA;

     public UsuarioBE validarCuenta(AccesoSistemaBE objAcceso){
        objAccesoDA = new AccesoSistemaDA();
        try{
           return objAccesoDA.validarCuenta(objAcceso);
        }catch(Exception e){
            System.out.println("Error AccesoDA y metodo ValidarCuenta "+e.getMessage());
            return null;
        }
    }
}
