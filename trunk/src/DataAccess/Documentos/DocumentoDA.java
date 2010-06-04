/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess.Documentos;

import BusinessEntity.Documentos.DocumentoBE;
import Conexion.Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Harvey Rivadeneyra
 */
public class DocumentoDA {
    private Conexion Conexion;
    private Statement comando;
    private String query = "";
    DateFormat formato= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    ResultSet rsl;
//    DocumentoBE objDocumentoBE;
    public boolean insertarDocumento(DocumentoBE objDocumentoBE){
       try{
            Conexion = new Conexion();
            try{
                comando = Conexion.getConexion().createStatement();
//                query = "select * from  "+Conexion.getStrEsquema()+".t_documento order by 1 desc";
//                ResultSet rs = comando.executeQuery(query);
//                if (rs.next()) {
//                    objDocumentoBE.setintCodDocumento(rs.getInt("intCodDocumento") + 1);
//                }
//                rs.close();


                query = "insert into "+Conexion.getStrEsquema()+".t_documento(vchTitulo,dteFechaGuardado,intCodSubcategoria,intCodUsuario) " +
                          "values ('"+objDocumentoBE.getvchTitulo() +"',"+
                                    "'"+fechaACadena(objDocumentoBE.getdteFechaGuardado()) + "'," +
                                    objDocumentoBE.getintCodSubcategoria()+","+
                                    objDocumentoBE.getintCodUsuario() +");";

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
//        SimpleDateFormat strFecha=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formato.format(objDate);

    }

}
