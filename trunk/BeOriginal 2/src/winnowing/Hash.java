/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package winnowing;

/**
 * ESTA CLASE REPRESENTA UN HASH
 * @author PEPE
 */
public class Hash {

    private int hash;

    /**
     * CONSTRUCTOR POR DEFECTO
     */
    public Hash(){

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

}
