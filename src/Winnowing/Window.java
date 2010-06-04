/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Winnowing;

import java.util.*;
/**
 * ESTA CLASE REPRESENTA UNA VENTANA
 * @author PEPE
 */
public class Window {

    /**
     * TAMAÑO DE LA VENTANA
     */
    private int windowSize;

    /**
     * LA VENTANA NO NECESARIAMENTE INICIA CON EL INDICE CERO, ES CIRCULAR.
     * POR LO TANTO ESTA VARIABLE REPRESENTA SU LIMITE DERECHO.
     */
    private int limiteDerecho;

    /**
     * ESTA VARIABLE RERESENTA EL VALOR DEL HASH MINIMO
     */
    private int minimoHash;

    /**
     * LA VENTANA
     */
    private List<Hash> ventana;

    /**
     * VARIABLE QUE DICE SI CAMBIO EL MINIMO DESDE LA ULTIMA INSERCION
     */
    private boolean nuevoMin;

    /**
     * CONSTRUCTOR POR DEFECTO
     */
    public Window() {
        this.windowSize = 5;
        this.ventana = new ArrayList<Hash>(windowSize);
    }

    /**
     * CONSTRUCTOR
     */
    public Window(int windowSize){
        this.windowSize = windowSize;
        this.ventana = new ArrayList<Hash>();
        for (int i = 0; i < windowSize; i++)
            ventana.add(new Hash());
    }

    public void agregarHash(Hash hash){
        ++limiteDerecho;
        limiteDerecho %= windowSize;
        ventana.set(limiteDerecho, new Hash(hash.getHash()));
        calcularNuevoMinimo();
    }

    private void calcularNuevoMinimo() {
        if (limiteDerecho == minimoHash) {
            nuevoMin = true;
            minimoHash = 0;
            for (int i = 1; i<windowSize; ++i) {
                if (ventana.get(i).getHash() < ventana.get(minimoHash).getHash()) {
                    minimoHash = i;
                }
            }
        }
        else {
            if (ventana.get(limiteDerecho).getHash() <= ventana.get(minimoHash).getHash()) {
                nuevoMin = true;
                minimoHash = limiteDerecho;
            }
            else {
                nuevoMin = false;
            }
        }
    }

    public boolean tieneNuevoMin(){
        return this.nuevoMin;
    }

    public int getMinimo() {
        return ventana.get(minimoHash).getHash();
    }

}
