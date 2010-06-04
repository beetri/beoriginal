/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Winnowing;

import java.util.*;
import BusinessEntity.Evaluacion.*;
import javax.swing.JOptionPane;
/**
 *
 * @author joseluis
 */
public class Reporte {

    private List<String> documentosProcesados;
    private List<String> documentosBD;
    private List<Integer> porcentajeTotal;
    private List<String> resultado;
    private List<Integer> porcentajeDetalle;
    private int numProcesados;
    private int numBD;

    public Reporte(){
        documentosProcesados = new ArrayList<String>();
        documentosBD = new ArrayList<String>();
        porcentajeTotal = new ArrayList<Integer>();
        porcentajeDetalle = new ArrayList<Integer>();
        resultado = new ArrayList<String>();
        numProcesados = 0;
        numBD = 0;
    }


    public String get_docProcesado(int indice) {
        return documentosProcesados.get(indice);
    }
    public void add_docProcesado(String documento) {
        documentosProcesados.add(documento);
        numProcesados++;
    }
    public void set_docProcesados(List<String> documentos) {
        this.documentosProcesados = documentos;
        numProcesados = documentos.size();
    }


    public String get_docBD(int indice) {
        return documentosBD.get(indice);
    }
    public void add_docBD(String documento){
        documentosBD.add(documento);
        numBD++;
    }
    public void set_docBD(List<String> documentos) {
        this.documentosBD = documentos;
        numBD = documentos.size();
    }


    public int get_porcentajeTotal(int indice) {
        return porcentajeTotal.get(indice);
    }
    public void add_porcentajeTotal(int porcentaje) {
        porcentajeTotal.add(porcentaje);
    }
    public void set_porcentajesTotales(List<Integer> porcentajesTotales) {
        this.porcentajeTotal = porcentajesTotales;
    }


    public String get_resultado(int indice) {
        return resultado.get(indice);
    }
    public void add_resultado(String r) {
        resultado.add(r);
    }
    public void set_resultados(List<String> resultados) {
        this.resultado = resultados;
    }


    public int get_porcentajeDetalle(int indiceDocProcesado, int indiceDocBD) {
        return porcentajeDetalle.get(indiceDocProcesado*numProcesados+indiceDocBD);
    }
    public void add_porcentajeDetalle(int porcentaje){
        porcentajeDetalle.add(porcentaje);
    }


    public ArrayList<ResultadoAnalisisBE> obtenerReporte(){
        ArrayList<ResultadoAnalisisBE> reporte = new ArrayList<ResultadoAnalisisBE>();
        for (int i = 0; i < documentosProcesados.size(); i++) {
            ResultadoAnalisisBE reporteDetalle = new ResultadoAnalisisBE();
            reporteDetalle.setNombreDocumentoSospechoso(documentosProcesados.get(i));
            reporteDetalle.setPorcentajeTotal(porcentajeTotal.get(i));
            reporteDetalle.setResultadoPlagio(get_resultado(i));
            for (int j = 0; j < documentosBD.size(); j++) {
                ArchFuenteBE reporteDetalleFuente = new ArchFuenteBE();
                reporteDetalleFuente.setNombreDocumentoFuente(documentosBD.get(j));
                reporteDetalleFuente.setPorcentajePlagio(get_porcentajeDetalle(i,j));
                reporteDetalleFuente.setTipoPlagio("COPIA");
                reporteDetalle.getListaDetArchivos().add(reporteDetalleFuente);
            }
            reporte.add(reporteDetalle);
        }
        return reporte;
    }

}
