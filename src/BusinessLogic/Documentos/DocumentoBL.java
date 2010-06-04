/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessLogic.Documentos;

import BusinessEntity.Documentos.DocumentoBE;
import DataAccess.Documentos.DocumentoDA;
import java.util.Date;

/**
 *
 * @author Harvey Rivadeneyra
 */
public class DocumentoBL {
    private DocumentoDA objDocumentoDA;

    public boolean insertarDocumento(DocumentoBE objDocumentoBE){
        objDocumentoDA = new DocumentoDA();
        try{
//            int intCodDocumento = 1;
//            String vchTitulo = "insertar.txt";
            int intCodSubcategoria = 1;
            int intCodUsuario = 1;
//            objDocumentoBE.setintCodDocumento(intCodDocumento);
//            objDocumentoBE.setvchTitulo(vchTitulo);
            Date fechaActual= new Date();
            objDocumentoBE.setdteFechaGuardado(fechaActual);
            objDocumentoBE.setintCodSubcategoria(intCodSubcategoria);
            objDocumentoBE.setintCodUsuario(intCodUsuario);
            return objDocumentoDA.insertarDocumento(objDocumentoBE);
        }
        catch (Exception ex){
            return false;
        }

    }

}
