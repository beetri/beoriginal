/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess.Evaluacion;

import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import Conexion.Conexion;

/**
 *
 * @author joseluis
 */
public class WinnowingDA {
    private Statement comandoSql;
    private Conexion conexion;

    public String obtenerDocumento(int id){
        //ArrayList <String> documento = new ArrayList<String>();
        String documento = new String();
        try{
            conexion = new Conexion();
            try{
                comandoSql = conexion.getConexion().createStatement();
                String query = "select vchTexto from "+ conexion.getStrEsquema()+".t_texto where intCodDocumento = "+ String.valueOf(id) + ";";
                ResultSet rs = comandoSql.executeQuery(query);

                while (rs.next()){
                    documento = rs.getString("vchTexto");
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
        return documento;
    }

    public String obtenerNombre(int id){
        String nombre = new String();
        try{
            conexion = new Conexion();
            try{
                comandoSql = conexion.getConexion().createStatement();
                String query = "select vchTitulo from "+ conexion.getStrEsquema()+".t_documento where intCodDocumento = "+ String.valueOf(id) + ";";
                ResultSet rs = comandoSql.executeQuery(query);

                while (rs.next()){
                    nombre  = rs.getString("vchTitulo");
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
        return nombre;
    }
}