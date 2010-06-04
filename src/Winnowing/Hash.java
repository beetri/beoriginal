/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Winnowing;

/**
 * ESTA CLASE REPRESENTA UN HASH
 * @author PEPE
 */
public class Hash {

    private int hash;
    private int marcado;

    /**
     * CONSTRUCTOR POR DEFECTO
     */
    public Hash(){
        marcado = 0;
    }

    public Hash(int hash){
        this.hash = hash;
    }

    public int getHash(){
        return this.hash;
    }

    public void setHash(int hash){
        this.hash = hash;
    }

    public void marcar() {
        marcado = 1;
    }

    public int marca() {
        return marcado;
    }

}
