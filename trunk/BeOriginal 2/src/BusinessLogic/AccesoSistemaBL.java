/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessLogic;

/**
 *
 * @author Administador
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
            System.out.println("error AccesoDA y metodo ValidarCuenta "+e.getMessage());
            return null;
        }
    }
}
