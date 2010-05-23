/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessEntity;

/**
 *
 * @author Administador
 */
public class AccesoSistemaBE {
    private String Usuario;
    private String Password;
    private String Id;

    public AccesoSistemaBE(String Usuario, String Clave) {
        this.Usuario = Usuario;
        this.Password = Clave;

    }


    public String getStrClave() {return Password;}
    public String getStrUsuario() {return Usuario;}
    public String getId() {return Id;}


    public void setStrClave(String strClave) {this.Password = strClave;}
    public void setStrUsuario(String strUsuario) {this.Usuario = strUsuario;}
    public void setId(String Id) {this.Id = Id;}
}
