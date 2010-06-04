/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessEntity.Evaluacion;

import java.util.ArrayList;
/**
 *
 * @author Jose Miguel
 */
public class ResultadoAnalisisBE {
    private String nombreDocumentoSospechoso;
    private ArrayList<ArchFuenteBE> listaDetArchivos;
    private float porcentajeTotal;
    private String resultadoPlagio;

    public ResultadoAnalisisBE(){
        listaDetArchivos = new ArrayList<ArchFuenteBE>();
    }

    /**
     * @return the nombreDocumentoSospechoso
     */
    public String getNombreDocumentoSospechoso() {
        return nombreDocumentoSospechoso;
    }

    /**
     * @param nombreDocumentoSospechoso the nombreDocumentoSospechoso to set
     */
    public void setNombreDocumentoSospechoso(String nombreDocumentoSospechoso) {
        this.nombreDocumentoSospechoso = nombreDocumentoSospechoso;
    }

    /**
     * @return the listaDetArchivos
     */
    public ArrayList<ArchFuenteBE> getListaDetArchivos() {
        return listaDetArchivos;
    }

    /**
     * @return the porcentajeTotal
     */
    public float getPorcentajeTotal() {
        return porcentajeTotal;
    }

    /**
     * @param porcentajeTotal the porcentajeTotal to set
     */
    public void setPorcentajeTotal(float porcentajeTotal) {
        this.porcentajeTotal = porcentajeTotal;
    }

    public void llenarClaseParaPrueba(){
        this.nombreDocumentoSospechoso = "Las diez y dos noches";
        this.porcentajeTotal = (float)100;
        this.resultadoPlagio = "PLAGIO";

        this.listaDetArchivos = new ArrayList<ArchFuenteBE>();
        
        ArchFuenteBE aFuente = new ArchFuenteBE();
        aFuente.llenarClaseParaPrueba();
        
        ArchFuenteBE aFuente2 = new ArchFuenteBE();
        aFuente2.llenarClaseParaPrueba();
        
        this.listaDetArchivos.add(aFuente);
        this.listaDetArchivos.add(aFuente2);
    }

    /**
     * @return the resultadoPlagio
     */
    public String getResultadoPlagio() {
        return resultadoPlagio;
    }

    /**
     * @param resultadoPlagio the resultadoPlagio to set
     */
    public void setResultadoPlagio(String resultadoPlagio) {
        this.resultadoPlagio = resultadoPlagio;
    }
}
