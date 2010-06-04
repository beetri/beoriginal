/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess.Evaluacion;

/**
 *
 * @author Jose Miguel
 */

import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import Conexion.Conexion;

public class EvaluacionDA {
    private Statement comandoSql;
    private Conexion conexion;

    public ArrayList<Integer> obtenerIdDocumentos(){
        ArrayList <Integer> idsDocumentos = new ArrayList<Integer>();

        try{
            conexion = new Conexion();
            try{
                comandoSql = conexion.getConexion().createStatement();
                String query = "select intCodDocumento from "+conexion.getStrEsquema()+".t_documento;";
                ResultSet rs = comandoSql.executeQuery(query);

                while (rs.next()){
                    idsDocumentos.add(rs.getInt("intCodDocumento"));
                }
                rs.close();
            }catch(Exception e){
                System.out.println(e.getMessage());
                return null;
            }

            conexion.getConexion().close();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        return idsDocumentos;
    }
}
