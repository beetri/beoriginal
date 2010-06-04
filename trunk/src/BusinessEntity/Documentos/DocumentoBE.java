/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessEntity.Documentos;

import java.util.Date;

/**
 *
 * @author Harvey Rivadeneyra
 */
public class DocumentoBE {
    private int intCodDocumento;
    private String vchTitulo;
    private Date dteFechaGuardado;
    private int intCodSubcategoria;
    private int intCodUsuario;

    public Integer getintCodDocumento() {
        return intCodDocumento;
    }

    public void setintCodDocumento(Integer intCodDocumento) {
        this.intCodDocumento = intCodDocumento;
    }

     public String getvchTitulo() {
        return vchTitulo;
    }

    public void setvchTitulo(String vchTitulo) {
        this.vchTitulo = vchTitulo;
    }

    public Date getdteFechaGuardado() {
        return dteFechaGuardado;
    }

    public void setdteFechaGuardado(Date dteFechaGuardado) {
        this.dteFechaGuardado = dteFechaGuardado;
    }

    public Integer getintCodSubcategoria() {
        return intCodSubcategoria;
    }

    public void setintCodSubcategoria(Integer intCodSubcategoria) {
        this.intCodSubcategoria = intCodSubcategoria;
    }

    public Integer getintCodUsuario() {
        return intCodUsuario;
    }

    public void setintCodUsuario(Integer intCodUsuario) {
        this.intCodUsuario = intCodUsuario;
    }
}
