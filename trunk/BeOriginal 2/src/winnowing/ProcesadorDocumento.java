/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package winnowing;

import java.io.*;
import java.util.*;

/**
 * ESTA CLASE SE ENCARGA DE PROCESAR UN DOCUMENTO
 * @author PEPE
 */
public class ProcesadorDocumento {

    private String ruta;
    private List<String> documento;

    /**
     * CONSTRUCTOR POR DEFECTO
     */
    public ProcesadorDocumento(){
        ruta = "C:\\archivo.txt";
    }

    public ProcesadorDocumento(String ruta){
        this.ruta = ruta;
    }

    /**
     *
     * @param espacios VALOR CERO ELIMINA ESPACIOS EN BLANCO
     * @return
     */
    public List<String> procesarDocumento(int espacios) {
        List<String> output = new ArrayList<String>();
        try {
            BufferedReader input =  new BufferedReader(new FileReader(new File(ruta)));
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
