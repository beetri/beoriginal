/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Seguridad;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Bernabe & tRufA
 */
public class Encriptador {
    private MessageDigest md;

    public Encriptador(){
       try {
           md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
    }

    public byte[] getHash(String password){
        return md.digest(password.getBytes());
    }

    public String encriptar(String password){
        byte[] byteContrasenhaEncriptada= this.getHash(password);
        String strContrasena ="";
        for (int i=0;i<byteContrasenhaEncriptada.length;i++){
            strContrasena +=byteContrasenhaEncriptada[i];
        }
        return strContrasena;
    }
}
