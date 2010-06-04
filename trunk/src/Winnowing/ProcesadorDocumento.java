/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Winnowing;

import java.io.*;
import java.util.*;
import DataAccess.Evaluacion.*;
import javax.swing.JOptionPane;

/**
 * ESTA CLASE SE ENCARGA DE PROCESAR UN DOCUMENTO
 * @author PEPE
 */
public class ProcesadorDocumento {

    private File docSinProcesar;
    private List<String> documento;
    private String nombre;

    public String get_Nombre(){
        return nombre;
    }
    /**
     * CONSTRUCTOR POR DEFECTO
     */
    public ProcesadorDocumento(int id){
        // obtener el archivo de la base de datos
        String documentoPlano = new WinnowingDA().obtenerDocumento(id);
        documento = procesarDocumentoPlano(0,documentoPlano);
        nombre = new WinnowingDA().obtenerNombre(id);
    }

    public ProcesadorDocumento(File documento){
        this.docSinProcesar = documento;
        procesarDocumento(0);
    }

    public List<String> get_documento(){
        return documento;
    }
    /**
     *
     * @param espacios VALOR CERO ELIMINA ESPACIOS EN BLANCO
     * @return
     */
    public List<String> procesarDocumento(int espacios) {
        List<String> output = new ArrayList<String>();
        try {
            BufferedReader input =  new BufferedReader(new FileReader(docSinProcesar));
            try {
                String linea;
                String temp = new String();
                while (( linea = input.readLine()) != null){
                    linea = temp + linea;
                    temp = "";
                    StringTokenizer st = new StringTokenizer(linea,".");
                    while (st.hasMoreTokens()) {
                        if (st.countTokens() == 1) {
                            temp = st.nextToken();
                            if (linea.charAt(linea.length()-1) == '.'){
                                output.add(procesarLinea(temp,espacios));
                                temp = "";
                            }
                        }
                        else
                            output.add(procesarLinea(st.nextToken(),espacios));
                    }
                }
                output.add(procesarLinea(temp,espacios));
            }
            finally {
                input.close();
            }
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        documento = output;
        return output;
    }

    public List<String> procesarDocumentoPlano(int espacios,String documentoPlano) {
        List<String> output = new ArrayList<String>();
        List<String> temp = new ArrayList<String>();
        StringTokenizer st = new StringTokenizer(documentoPlano,".");
        while (st.hasMoreTokens()) {
            temp.add(st.nextToken());
        }
        for (int i = 0; i < temp.size(); i++) {
            output.add(procesarLinea(temp.get(i),espacios));
        }
        documento = output;
        return output;
    }


    private String procesarLinea(String linea, int espacios) {
        linea = linea.toLowerCase();
        linea = linea.replaceAll("[á]", "a");
        linea = linea.replace("\u00e9", "e");
        linea = linea.replace('í', 'i');
        linea = linea.replace('ó', 'o');
        linea = linea.replace('ú', 'u');
        linea = linea.replace('ñ', 'n');
        linea = linea.replaceAll("[^ a-z0-9]", "");
        String lineaProcesada = new String();
        if (espacios == 0)
            linea = linea.replaceAll("[^a-z0-9]", "");
        else
            linea = linea.replaceAll("[^ a-z0-9]", "");
        lineaProcesada = linea;
        return lineaProcesada;
    }

    public int size(){
        int size = 0;
        for(int i=0; i < documento.size(); ++i)
            size += documento.get(i).length();
        return size;
    }
}
