/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package winnowing;

import java.util.*;

/**
 * ESTA CLASE RERESENTA EL CODIGO HASH DE UN DOCUMENTO
 * @author PEPE
 */
public class HashedDoc {

    private List<Hash> codigoHash;
    private int pos;
    private List<String> documento;


    /**
     * CONSTRUCTOR POR DEFECTO
     */
    public HashedDoc(){

    }
    public HashedDoc(List<String> documento){
        this.documento = documento;
    }

    public boolean enProceso(){
        return pos < codigoHash.size();
    }

    public Hash siguienteHash(){
        ++pos;
        return codigoHash.get(pos-1);
    }

    public void hashearDocumento(int k){
        codigoHash = new ArrayList<Hash>();
        StringBuffer documento = new StringBuffer();
        for (int i = 0; i < this.documento.size(); i++)
            documento.append(this.documento.get(i));
        String docJuntado = documento.toString();
        for (int i = 0; i <= docJuntado.length()-k; i++) {
            String palabra = docJuntado.substring(i,i+k);
            codigoHash.add(new Hash(palabra.hashCode()));
        }
    }

}
