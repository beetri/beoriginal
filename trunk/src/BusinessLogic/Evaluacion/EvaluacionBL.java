/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessLogic.Evaluacion;
import BusinessEntity.Evaluacion.*;
import DataAccess.Evaluacion.*;
import Winnowing.*;
import java.util.ArrayList;
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperExportManager;

/**
 *
 * @author Jose Miguel
 */
public class EvaluacionBL {
    EvaluacionBE evaluacionBE;
    ArrayList<Integer> listaIds;
    private ArrayList<ResultadoAnalisisBE> listaResultado;

    public EvaluacionBL(EvaluacionBE evaluacionBE){
        this.evaluacionBE = evaluacionBE;
    }

    public void ejecutarWinnowing(){
        
        EvaluacionDA evaluacionDA = new EvaluacionDA();        
        this.listaIds = evaluacionDA.obtenerIdDocumentos();

        Parametros parametros = new Parametros();
        parametros.set_docList(evaluacionBE.getListaArchivosEvaluacion());
        parametros.set_idListBD(listaIds);

        Winnowing winnowing = new Winnowing(parametros);
        Reporte reporte = winnowing.getReporte();
        this.listaResultado = reporte.obtenerReporte();

        
    }


    public static JasperPrint generaReporte(String nombreReporte, HashMap param, ArrayList<Object> lista){

        JRBeanCollectionDataSource dataSource;
        JasperReport jR;
        JasperPrint jPrint;

        try{
            dataSource = new JRBeanCollectionDataSource(lista);
            jR = JasperCompileManager.compileReport(nombreReporte+".jrxml");
            jPrint = JasperFillManager.fillReport(jR, param, dataSource);
            JasperExportManager.exportReportToPdfFile(jPrint, nombreReporte+".pdf");
             return jPrint;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * @return the listaResultado
     */
    public ArrayList<ResultadoAnalisisBE> getListaResultado() {
        return listaResultado;
    }

    public void probarReporte(){
        this.listaResultado = new ArrayList<ResultadoAnalisisBE>();
        ResultadoAnalisisBE a = new ResultadoAnalisisBE();
        a.llenarClaseParaPrueba();
        listaResultado.add(a);
    }

}
