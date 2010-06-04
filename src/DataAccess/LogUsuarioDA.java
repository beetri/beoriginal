/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;

import BusinessEntity.*;
import BusinessLogic.TransaccionBL;
import Conexion.Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * @author Bernabe
 */
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
                query = "insert into "+Conexion.getStrEsquema()+".t_logusuario(intcodusuario,vchip,vchmac,dtefechainicio,dtefechafin) " +
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
public List<LogUsuarioBE> buscarLogs(LogUsuarioBE objLogUsuarioAuxBE){

        List<LogUsuarioBE> lstLogUsuarioBE = new ArrayList<LogUsuarioBE>();
        String where="";


        try{
            Conexion = new Conexion();
            try{
                 comando=Conexion.getConexion().createStatement();
//                String query = "select * from " +Conexion.getSchema()+".logusuario order by CodLog;";
                //String query= " select * from t_logusuario A, t_usuario B where A.intcodusuario=B.intcodusuario ";
                //String query = "select * from "+cnxConexion.getStrEsquema()+".t_usuario where intcodusuario="+variableEntera+";";
                String query="select * from "+Conexion.getStrEsquema()+".t_logusuario A,"+Conexion.getStrEsquema()+".t_usuario B ";
                String query1="where A.intcodusuario=B.intcodusuario ";
                if (!objLogUsuarioAuxBE.getObjUsuarioBE().getNombre().equals("")){
                    where = where + " and upper(vchnombre) like upper('%"+objLogUsuarioAuxBE.getObjUsuarioBE().getNombre()+"%')";
                }
                if (!objLogUsuarioAuxBE.getObjUsuarioBE().getUsuario().equals("")){
                    where = where + " and upper(vchusuario) like upper('%"+objLogUsuarioAuxBE.getObjUsuarioBE().getUsuario()+"%')";

                }
                query = query +query1+ where + "order by intcodlog";
                ResultSet rsl = comando.executeQuery(query);

                while (rsl.next()) {
                    objLogUsuarioBE = new LogUsuarioBE();
                    objLogUsuarioBE.setCodLog(rsl.getInt("intcodlog"));
                    UsuarioBE objUsuarioBE = new UsuarioBE();
                    objUsuarioBE.setCodUsuario(rsl.getInt("intcodusuario"));
                    objUsuarioBE.setNombre(rsl.getString("vchnombre"));
                    objUsuarioBE.setApellidoPaterno(rsl.getString("vchapepaterno"));
                    objUsuarioBE.setApellidoMaterno(rsl.getString("vchapematerno"));
                    objUsuarioBE.setUsuario(rsl.getString("vchusuario"));
                    objUsuarioBE.setEstado(rsl.getString("vchestado"));
                    objLogUsuarioBE.setObjUsuarioBE(objUsuarioBE);
                    objLogUsuarioBE.setIP(rsl.getString("vchip"));
                    objLogUsuarioBE.setMAC(rsl.getString("vchmac"));
                    objLogUsuarioBE.setFechaIngreso(rsl.getTimestamp("dtefechainicio"));
                    objLogUsuarioBE.setFechaSalida(rsl.getTimestamp("dtefechafin"));

                    lstLogUsuarioBE.add(objLogUsuarioBE);
                }
                rsl.close();
                Conexion.getConexion().close();
                return lstLogUsuarioBE;
            }
            catch (Exception exc){
                Conexion.getConexion().close();
            }
        }
        catch (Exception exc){
                return null;
        }

        return null;
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
               //query="select last_value from "+Conexion.getStrEsquema()+".t_logusuario_intcodlog_seq;";
                query="select max(intcodlog)from "+Conexion.getStrEsquema()+".t_logusuario order by 1 desc;";
                ResultSet rsl = comando.executeQuery(query);

               if (rsl.next()) {
                    idMax = rsl.getInt("intcodlog");
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
