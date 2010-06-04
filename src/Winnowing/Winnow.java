/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Winnowing;

import java.util.*;

/**
 * ESTA CLASE REPRESENTA AL ALGORITMO WINNOWING
 * @author PEPE
 */
public class Winnow {
    // PARAMETROS
    private Fingerprint huella;
    private Window ventana;
    private HashedDoc documento;
    private int windowSize;

    public Fingerprint getFP(){
        return huella;
    }

    /**
     * CONSTRUCTOR QUE CARGA PARAMETROS POR DEFECTO
     */
    public Winnow() {
    }

    /**
     * CONSTRUCTOR
     */
    public Winnow(int windowSize, HashedDoc documento){
        this.huella = new Fingerprint();
        this.ventana = new Window(windowSize);
        this.documento = documento;
        this.windowSize= windowSize;
        createFingerprint();
    }

    /**
     * METODO QUE EJECUTA EL ALGORITMO Y OBTIENE UN FINGERPRINT
     */
    private void createFingerprint(){
        for (int i = 0; i < windowSize-1; i++)
            ventana.agregarHash(documento.siguienteHash());
        while (documento.enProceso()) {
            ventana.agregarHash(documento.siguienteHash());
            if (ventana.tieneNuevoMin())
                huella.agregar(ventana.getMinimo());
        }
    }

}
