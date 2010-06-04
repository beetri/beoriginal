/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessLogic;

import BusinessEntity.TransaccionBE;
import DataAccess.TransaccionDA;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class TransaccionBL {
    private TransaccionDA objTransaccionDA;

    public boolean registrarTransaccion(TransaccionBE objTransaccionAuxBE){
        objTransaccionDA = new TransaccionDA();
        try {
            return objTransaccionDA.registrarTransaccion(objTransaccionAuxBE);
        }
        catch(Exception exc) {
            return false;
        }
    }
    public List<TransaccionBE> buscarTransaccion(TransaccionBE objTransaccionAuxBE){
        objTransaccionDA = new TransaccionDA();
        try {
              return objTransaccionDA.buscarTransaccion(objTransaccionAuxBE);
        }
        catch(Exception exc) {
            return null;
        }
    }

}
