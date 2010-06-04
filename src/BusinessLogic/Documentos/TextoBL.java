/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessLogic.Documentos;

import BusinessEntity.Documentos.TextoBE;
import DataAccess.Documentos.TextoDA;

/**
 *
 * @author Harvey Rivadeneyra
 */
public class TextoBL {
    private TextoDA objTextoDA;

    public boolean insertarTexto(TextoBE objTextoBE){
        objTextoDA = new TextoDA();
        try{
//            int intCodDocumento = 1;
//            String vchTexto = "insertar.txt";
//            objTextoBE.setintCodDocumento(intCodDocumento);
//            objTextoBE.setvchTexto(vchTexto);
            return objTextoDA.insertarTexto(objTextoBE);
        }
        catch (Exception ex){
            return false;
        }

    }

}
