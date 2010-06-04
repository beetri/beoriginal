/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Winnowing;

/**
 * CLASE QUE COMPARA DOS FINGERPRINTS
 * @author PEPE
 */
public class Comparador {

    Fingerprint huellaOrigen;
    Fingerprint huellaVs;
    int porcentaje;

    /**
     * CONSTRUCTOR
     * @param doc1
     * @param doc2
     */
    public Comparador(Fingerprint doc1, Fingerprint doc2) {
        huellaOrigen = doc1;
        huellaVs = doc2;
    }

    public int porcentajeCopiado(){
        int copiado = 0;
        int hashOrigen = 0;
        boolean notFound = true;
        while (huellaOrigen.hasMoreHash()) {
            hashOrigen = huellaOrigen.getNextHash();
            while (huellaVs.hasMoreHash() && notFound) {
                if (hashOrigen == huellaVs.getNextHash()) {
                    huellaOrigen.marcar();
                    ++copiado;
                    notFound = false;
                }
            }
            huellaVs.reset();
            notFound = true;
        }
        porcentaje = 100 * copiado / huellaOrigen.size();
        return porcentaje;
    }

}
