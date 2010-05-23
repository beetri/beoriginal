/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;

/**
 *
 * @author Administador
 */
import BusinessEntity.*;
//import BusinessLogic.TransaccionBL;
import Conexion.Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogUsuarioDA {
    private Conexion Conexion;
    private char chr = 34;
    private String query = "";  // query = Consulta
    private String ConsultaRealizada = "";
    private String Accion = "";
    private int codUsuario = 0;
    java.sql.Statement comando;
    DateFormat formato= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    ResultSet rsl;
    LogUsuarioBE objLogUsuarioBE;
    public boolean registrarLog(LogUsuarioBE objLogUsuarioBE){
       try{
            Conexion = new Conexion();
            try{
                comando = Conexion.getConexion().createStatement();
                //Accion = "Login";
                codUsuario=objLogUsuarioBE.getObjUsuarioBE().getCodUsuario();
                query = "insert into "+Conexion.getStrEsquema()+".logusuario(codusuario,ip,mac,inicio,fin) " +
                          "values "+" ("+objLogUsuarioBE.getObjUsuarioBE().getCodUsuario() +","+
                                    "'"+objLogUsuarioBE.getIP() +"',"+
                                    "'"+objLogUsuarioBE.getMAC() + "'," +
                                    "'"+fechaACadena(objLogUsuarioBE.getFechaIngreso()) + "'," +
                                    "'"+fechaACadena(objLogUsuarioBE.getFechaSalida()) +"');";

                int rsl = comando.executeUpdate(query);

            }
            catch (Exception ex){
                return false;
            }
           Conexion.getConexion().close();
           return true;
        }
        catch (Exception ex){
            return false;
        }
    }
    private String fechaACadena(Date objDate){
        SimpleDateFormat strFecha=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formato.format(objDate);

    }
    public int retornarID() {

        int idMax = 0;

        try {
            Conexion = new Conexion();
            try {
                comando = Conexion.getConexion().createStatement();
               // query = "select codLog from "+Conexion.getSchema()+".logusuario;";
                query="select last_value from logusuario_codlog_seq;";
                ResultSet rsl = comando.executeQuery(query);

               if (rsl.next()) {
                    idMax = rsl.getInt("last_value");
                }
                rsl.close();
                Conexion.getConexion().close();
                return idMax;
                // En este chrCso lo que se devuelve es una lista.
            }
            catch(Exception exc) {
                Conexion.getConexion().close();
                return 0;
                //ex.getMessage();
            }
        }
        catch(Exception exc) {
            return 0;
            //ex.getMessage();
        }

    }
}
