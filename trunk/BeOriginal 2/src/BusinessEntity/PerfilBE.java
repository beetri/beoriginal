/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessEntity;

/**
 *
 * @author Administador
 */
public class PerfilBE {
    private Integer iCodPerfil;
    private String sPerfil;
    private String sEstado;

    /**
     * @return the iCodPerfil
     */
    public Integer getiCodPerfil() {
        return iCodPerfil;
    }

    /**
     * @param iCodPerfil the iCodPerfil to set
     */
    public void setiCodPerfil(Integer iCodPerfil) {
        this.iCodPerfil = iCodPerfil;
    }

    /**
     * @return the sPerfil
     */
    public String getsPerfil() {
        return sPerfil;
    }

    /**
     * @param sPerfil the sPerfil to set
     */
    public void setsPerfil(String sPerfil) {
        this.sPerfil = sPerfil;
    }

    /**
     * @return the sEstado
     */
    public String getsEstado() {
        return sEstado;
    }

    /**
     * @param sEstado the sEstado to set
     */
    public void setsEstado(String sEstado) {
        this.sEstado = sEstado;
    }
}
