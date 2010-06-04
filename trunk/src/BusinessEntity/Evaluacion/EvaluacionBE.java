/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessEntity.Evaluacion;

import java.io.File;
import java.util.ArrayList;
/**
 *
 * @author Jose Miguel
 */
public class EvaluacionBE {
    private ArrayList<File> listaArchivosEvaluacion;
    private ArrayList<File> listaArchivosFuentesOriginales;
    private int tipoEvaluacion;

    //Tipo de Evaluacion permitira identificar si la evaluacion es contra TODA LA BASE DE DATOS (1)  o
    //contra una FUENTE SELECCIONADA (0).
    public EvaluacionBE(int tipoEvaluacion, ArrayList<File> listaArchivosEva, ArrayList<File> listaArchivosFuentes){
        this.tipoEvaluacion = tipoEvaluacion;
        listaArchivosEvaluacion = listaArchivosEva;

        if (this.tipoEvaluacion == 0){ //SE HA SELECCIONADO FUENTE
            this.listaArchivosFuentesOriginales = listaArchivosFuentes;
        }
    }

    /**
     * @return the listaArchivosEvaluacion
     */
    public ArrayList<File> getListaArchivosEvaluacion() {
        return listaArchivosEvaluacion;
    }

    /**
     * @param listaArchivosEvaluacion the listaArchivosEvaluacion to set
     */
    public void setListaArchivosEvaluacion(ArrayList<File> listaArchivosEvaluacion) {
        this.listaArchivosEvaluacion = listaArchivosEvaluacion;
    }
}
