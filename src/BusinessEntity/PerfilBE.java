/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessEntity;

/**
 *
 * @author Bernabe Yanac
 */
public class PerfilBE {

   private Integer CodPerfil;
   private String Perfil;
   private String Estado;


    public Integer getCodPerfil() {
        return CodPerfil;
    }

    public String getEstado() {
        return Estado;
    }

    public String getPerfil() {
        return Perfil;
    }

    public void setCodPerfil(Integer CodPerfil) {
        this.CodPerfil = CodPerfil;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public void setPerfil(String Perfil) {
        this.Perfil = Perfil;
    }
}
