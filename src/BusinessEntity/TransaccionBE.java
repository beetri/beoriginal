/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessEntity;

import java.util.Date;

/**
 *
 * @author Bernabe Yanac
 */
public class TransaccionBE {
    private int codlog;
    private LogUsuarioBE objLogUsuarioBE;
    private UsuarioBE objUsuarioBE;
    //private ModuloBE objModuloBE;
    private int codModulo;
    private int codFormulario;
    private Date fecha;
    private String accion;

    /**
     * @return the codlog
     */
    public int getCodlog() {
        return codlog;
    }

    /**
     * @param codlog the codlog to set
     */
    public void setCodlog(int codlog) {
        this.codlog = codlog;
    }

    /**
     * @return the objLogUsuarioBE
     */
    public LogUsuarioBE getObjLogUsuarioBE() {
        return objLogUsuarioBE;
    }

    /**
     * @param objLogUsuarioBE the objLogUsuarioBE to set
     */
    public void setObjLogUsuarioBE(LogUsuarioBE objLogUsuarioBE) {
        this.objLogUsuarioBE = objLogUsuarioBE;
    }

    /**
     * @return the objUsuarioBE
     */
    public UsuarioBE getObjUsuarioBE() {
        return objUsuarioBE;
    }

    /**
     * @param objUsuarioBE the objUsuarioBE to set
     */
    public void setObjUsuarioBE(UsuarioBE objUsuarioBE) {
        this.objUsuarioBE = objUsuarioBE;
    }

    /**
     * @return the codModulo
     */
    public int getCodModulo() {
        return codModulo;
    }

    /**
     * @param codModulo the codModulo to set
     */
    public void setCodModulo(int codModulo) {
        this.codModulo = codModulo;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the accion
     */
    public String getAccion() {
        return accion;
    }

    /**
     * @param accion the accion to set
     */
    public void setAccion(String accion) {
        this.accion = accion;
    }

    /**
     * @return the codFormulario
     */
    public int getCodFormulario() {
        return codFormulario;
    }

    /**
     * @param codFormulario the codFormulario to set
     */
    public void setCodFormulario(int codFormulario) {
        this.codFormulario = codFormulario;
    }

   
   
}