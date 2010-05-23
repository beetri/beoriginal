/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package winnowing;

import java.util.*;
import javax.swing.*;

/**
 *
 * @author PEPE
 */
public class Winnowing {

    /**
     * @param args the command line arguments
     */
    public Winnowing(String ruta) {
        int k = 9;
        int w = 5;
        String rutaOrigen = ruta;
        String rutaVs = "/usr/home/a20030466/Escritorio/comparame.txt";
        ProcesadorDocumento docOrigen = new ProcesadorDocumento(rutaOrigen);
        ProcesadorDocumento docVs = new ProcesadorDocumento(rutaVs);
        HashedDoc docHOrigen = new HashedDoc(docOrigen.procesarDocumento(0));
        HashedDoc docHVs = new HashedDoc(docVs.procesarDocumento(0));
        docHOrigen.hashearDocumento(k);
        docHVs.hashearDocumento(k);
        Winnow winOrigen = new Winnow(w,docHOrigen);
        Winnow winVs = new Winnow(w,docHVs);
        winOrigen.createFingerprint();
        winVs.createFingerprint();
        Comparador comparador = new Comparador(winOrigen.getFP(),winVs.getFP());
        JOptionPane.showMessageDialog(null, comparador.porcentajeCopiado());
    }

}
