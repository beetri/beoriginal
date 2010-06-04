/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Winnowing;

import java.util.*;
import java.io.*;
/**
 *
 * @author joseluis
 */
public class Parametros {

    private int k_grama;
    private int window_size;
    int porcentajePlagio;
    private List<File> documentosComparar;
    private List<Integer> documentosBD;

    public Parametros(){
        k_grama = 9;
        window_size = 5;
        porcentajePlagio = 20;
        documentosComparar = new ArrayList<File>();
        documentosBD = new ArrayList<Integer>();
    }
    
    public Parametros(int k_grama, int window_size) {
        this.k_grama = k_grama;
        this.window_size = window_size;
        documentosComparar = new ArrayList<File>();
        documentosBD = new ArrayList<Integer>();
    }

    public int getMaxPorcentaje(){
        return porcentajePlagio;
    }

    public int get_k (){
        return k_grama;
    }
    public void set_k (int k_grama) {
        this.k_grama = k_grama;
    }


    public int get_w() {
        return window_size;
    }
    public void set_w(int window_size) {
        this.window_size = window_size;
    }


    public File get_docDisco(int indice) {
        return documentosComparar.get(indice);
    }
    public void add_documento(File documento) {
        documentosComparar.add(documento);
    }
    public void set_docList(List<File> documentos) {
        this.documentosComparar = documentos;
    }
    public int get_numDocsDisco(){
        return documentosComparar.size();
    }


    public int get_idDocBD(int indice) {
        return documentosBD.get(indice);
    }
    public void add_idBD(int id){
        documentosBD.add(id);
    }
    public void set_idListBD(List<Integer> lista_ids) {
        this.documentosBD = lista_ids;
    }
    public int get_numDocsBD() {
        return documentosBD.size();
    }

}
