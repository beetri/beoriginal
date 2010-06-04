/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Winnowing;

import java.util.*;
import javax.swing.*;

/**
 *
 * @author PEPE
 **/

public class Winnowing {

    private Reporte reporte;

    /**
     * @param args the command line arguments
     */
    public Winnowing(Parametros parametros) {
        reporte = new Reporte();
        // se ejecuta el algoritmo para cada pareja de documentos
        for (int i = 0; i < parametros.get_numDocsDisco(); ++i) {
            ProcesadorDocumento docOrigen = new ProcesadorDocumento(parametros.get_docDisco(i));
            reporte.add_docProcesado(parametros.get_docDisco(i).getName());
            HashedDoc hashDoc = new HashedDoc(docOrigen.get_documento(),parametros);
            Winnow winDoc = new Winnow(parametros.get_w(),hashDoc);
            for (int j = 0; j < parametros.get_numDocsBD(); ++j) {
                ProcesadorDocumento docBD = new ProcesadorDocumento(parametros.get_idDocBD(j));
                reporte.add_docBD(docBD.get_Nombre());
                HashedDoc hashBD = new HashedDoc(docBD.get_documento(),parametros);
                Winnow winBD = new Winnow(parametros.get_w(),hashBD);
                Comparador comparador = new Comparador(winDoc.getFP(),winBD.getFP());
                reporte.add_porcentajeDetalle(comparador.porcentajeCopiado());
            }
            int p = 100*winDoc.getFP().marcados()/winDoc.getFP().size();
            reporte.add_porcentajeTotal(p);
            if ( p >= parametros.getMaxPorcentaje()) {
                reporte.add_resultado("PLAGIO");
            }
            else {
                reporte.add_resultado("NO ES PLAGIO");
            }
        }
    }

    /**
     * @return the reporte
     */
    public Reporte getReporte() {
        return reporte;
    }

}
