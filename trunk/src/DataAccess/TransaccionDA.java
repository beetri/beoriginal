/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;

import BusinessEntity.LogUsuarioBE;
import BusinessEntity.TransaccionBE;
import BusinessEntity.UsuarioBE;
import Conexion.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class TransaccionDA {
    private Conexion Conexion;
    private char chr = 34;
    private String query = "";
    java.sql.Statement comando;
    DateFormat df= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    ResultSet rsl;

    public boolean registrarTransaccion(TransaccionBE objTransaccionBE){
try{
            Conexion = new Conexion();
            try {
                comando = Conexion.getConexion().createStatement();
                query = "insert into "+Conexion.getStrEsquema()+".t_formularioxlog(intcodformulario,intcodlog,dtehora,vchaccion) " +
                          "values "+" ("+objTransaccionBE.getCodFormulario() +","+
                                    ""+objTransaccionBE.getObjLogUsuarioBE().getCodigoLog() +","+
                                    ""+fechaACadena(objTransaccionBE.getFecha()) + "," +
                                    "'"+objTransaccionBE.getAccion() +"');";
               int rsl = comando.executeUpdate(query);
            }
            catch(Exception exc) {
                //System.out.println(exc.getMessage());
                return true;
            }
            Conexion.getConexion().close();
            return true;
       }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public List<TransaccionBE> buscarTransaccion(TransaccionBE objTransaccionAuxBE){

        List<TransaccionBE> lstTransaccionBE = new ArrayList<TransaccionBE>();
        TransaccionBE objTransaccionBE =  new TransaccionBE();
        String where="";

        try{
            Conexion = new Conexion();
            try{
                 comando=Conexion.getConexion().createStatement();
                String query1= " select * from t_formularioxlog A, t_logusuario B, t_usuario C ";
                String query2=" where A.intcodlog=B.intcodlog and B.intcodusuario=C.intcodusuario ";
//                if (objTransaccionAuxBE.getCodlog()!=0){
//                    where = where + " and A.intcodlog = "+objTransaccionAuxBE.getCodlog();
//                }
//                if (!objTransaccionAuxBE.getObjUsuarioBE().getUsuario().equals("")){
//                    where = where + " and upper(C.vchusuario) like upper('%"+objTransaccionAuxBE.getObjUsuarioBE().getUsuario()+"%')";
//                }
                if (!objTransaccionAuxBE.getAccion().equals("<Seleccione>")){
                   where = where + " and upper(A.vchaccion) like upper('%"+objTransaccionAuxBE.getAccion()+"%')";
                }
                query = query1+query2+where+" order by A.intcodlog";
                ResultSet rsl = comando.executeQuery(query);

                while (rsl.next()) {
                    objTransaccionBE = new TransaccionBE();
//                    objTransaccionBE.setCodlog(rsl.getInt("intcodlog"));
//                    LogUsuarioBE objLogUsuarioBE = new LogUsuarioBE();
//                    objLogUsuarioBE.setIP(rsl.getString("vchip"));
//                    UsuarioBE objUsuarioBE = new UsuarioBE();
//                    objUsuarioBE.setUsuario(rsl.getString("vchusuario"));
//                    objTransaccionBE.setObjUsuarioBE(objUsuarioBE);
//                    objTransaccionBE.setObjLogUsuarioBE(objLogUsuarioBE);
                    objTransaccionBE.setFecha(rsl.getTimestamp("dtefecha"));
                    objTransaccionBE.setAccion(rsl.getString("vchaccion"));
                    lstTransaccionBE.add(objTransaccionBE);
                }
                rsl.close();
                Conexion.getConexion().close();
                return lstTransaccionBE;
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

    public String fechaACadena(Date objDate) {
        String strFecha="";
        if (objDate != null)
            strFecha="'"+df.format(objDate)+"'";
        else
            strFecha="null";
        return strFecha;
    }


    // Cambiar luego de iteracion a clase para todo el proyecto
    public Integer ObtenerCodFormulario(String NombreFormulario) {
      Integer codFormulario=null;
      try{
         Conexion = new Conexion();
         try {
             comando = Conexion.getConexion().createStatement();
             String query ="select intcodformulario from "+Conexion.getStrEsquema()+".t_formulario";
             query = query + " where vchformulario='"+NombreFormulario+"';";

             ResultSet rs = comando.executeQuery(query);
             while(rs.next()){
                 codFormulario = rs.getInt(1);
                 return codFormulario;
             }
             rs.close();
        }
        catch (SQLException ex) {
        }
     }
     catch (Exception ex){
     }
     return codFormulario;
    }

}
