/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package winnowing;

import java.util.*;

/**
 * ESTA CLASE REPRESENTA UN FINGERPRINT DE UN DOCUMENTO
 * @author PEPE
 */
public class Fingerprint {
    
    /**
     * EL FINGERPRINT
     */
    private List<Hash> fingerPrint;
    private int pos;

    public Fingerprint() {
        fingerPrint = new ArrayList<Hash>();
        pos = 0;
    }

    public void agregar(int hash) {
        fingerPrint.add(new Hash(hash));
    }

    public int getNextHash(){
        if (hasMoreHash()) {
            pos++;
            return fingerPrint.get(pos-1).getHash();
        }
        else
            return 0;
    }

    public boolean hasMoreHash(){
        return pos != fingerPrint.size();
    }

    public void reset() {
        pos = 0;
    }

    public int size() {
        return fingerPrint.size();
    }

}
