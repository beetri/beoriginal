/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess.Documentos;

import BusinessEntity.Documentos.TextoBE;
import Conexion.Conexion;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Harvey Rivadeneyra
 */
public class TextoDA {
    private Conexion Conexion;
    private Statement comando;
    private String query = "";
    ResultSet rsl;
 public boolean insertarTexto(TextoBE objTextoBE){
       try{
            Conexion = new Conexion();
            try{
                comando = Conexion.getConexion().createStatement();
//                query = "select max(intCodDocumento) from  "+Conexion.getStrEsquema()+".t_texto";
//                ResultSet rs = comando.executeQuery(query);
//                if (rs.absolute(1)){
////                if (rs.next()) {
//                    objTextoBE.setintCodDocumento(rs.getInt(1) + 1);
////                    objTextoBE.setintCodDocumento(rs.getInt("intCodDocumento") + 1);
//                }
//                rs.close();
//

                query = "insert into "+Conexion.getStrEsquema()+".t_texto " +
                        "values ((select max(intCodDocumento) from "+
                        Conexion.getStrEsquema()+".t_documento),'"+objTextoBE.getvchTexto() +"');";

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



}
