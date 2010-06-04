/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessEntity.Evaluacion;

/**
 *
 * @author Jose Miguel
 */
public class ArchFuenteBE {
    private String nombreDocumentoFuente; //Nombre del documento fuente
    private float porcentajePlagio; //Porcentaje de plagio del documento sospechoso / documento fuente
    private String tipoPlagio; // por copia o por parafraseo.

    /**
     * @return the nombreDocumentoFuente
     */
    public String getNombreDocumentoFuente() {
        return nombreDocumentoFuente;
    }

    /**
     * @param nombreDocumentoFuente the nombreDocumentoFuente to set
     */
    public void setNombreDocumentoFuente(String nombreDocumentoFuente) {
        this.nombreDocumentoFuente = nombreDocumentoFuente;
    }

    /**
     * @return the porcentajePlagio
     */
    public float getPorcentajePlagio() {
        return porcentajePlagio;
    }

    /**
     * @param porcentajePlagio the porcentajePlagio to set
     */
    public void setPorcentajePlagio(float porcentajePlagio) {
        this.porcentajePlagio = porcentajePlagio;
    }

    /**
     * @return the tipoPlagio
     */
    public String getTipoPlagio() {
        return tipoPlagio;
    }

    /**
     * @param tipoPlagio the tipoPlagio to set
     */
    public void setTipoPlagio(String tipoPlagio) {
        this.tipoPlagio = tipoPlagio;
    }

    public void llenarClaseParaPrueba(){
        this.nombreDocumentoFuente = "Las mil y una noches";
        this.porcentajePlagio = (float)75;
        this.tipoPlagio = "copia literal";
    }

}
