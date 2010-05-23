/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessEntity;

/**
 *
 * @author Administador
 */
import java.util.Date;
public class LogUsuarioBE {
       private Integer codLog;
       private UsuarioBE objUsuarioBE;
       private String codigoLog;
       private Date FechaIngreso;
       private Date FechaSalida;
       private String IP;
       private String MAC;
       private String fechaMia;

    /**
     * @return the codLog
     */
    public Integer getCodLog() {
        return codLog;
    }

    /**
     * @param codLog the codLog to set
     */
    public void setCodLog(Integer codLog) {
        this.codLog = codLog;
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
     * @return the codigoLog
     */
    public String getCodigoLog() {
        return codigoLog;
    }

    /**
     * @param codigoLog the codigoLog to set
     */
    public void setCodigoLog(String codigoLog) {
        this.codigoLog = codigoLog;
    }

    /**
     * @return the FechaIngreso
     */
    public Date getFechaIngreso() {
        return FechaIngreso;
    }

    /**
     * @param FechaIngreso the FechaIngreso to set
     */
    public void setFechaIngreso(Date FechaIngreso) {
        this.FechaIngreso = FechaIngreso;
    }

    /**
     * @return the FechaSalida
     */
    public Date getFechaSalida() {
        return FechaSalida;
    }

    /**
     * @param FechaSalida the FechaSalida to set
     */
    public void setFechaSalida(Date FechaSalida) {
        this.FechaSalida = FechaSalida;
    }

    /**
     * @return the IP
     */
    public String getIP() {
        return IP;
    }

    /**
     * @param IP the IP to set
     */
    public void setIP(String IP) {
        this.IP = IP;
    }

    /**
     * @return the MAC
     */
    public String getMAC() {
        return MAC;
    }

    /**
     * @param MAC the MAC to set
     */
    public void setMAC(String MAC) {
        this.MAC = MAC;
    }

    /**
     * @return the fechaMia
     */
    public String getFechaMia() {
        return fechaMia;
    }

    /**
     * @param fechaMia the fechaMia to set
     */
    public void setFechaMia(String fechaMia) {
        this.fechaMia = fechaMia;
    }
}
