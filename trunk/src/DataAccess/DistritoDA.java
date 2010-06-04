/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;

/**
 *
 * @author Bernabe
 */

import BusinessEntity.DepartamentoBE;
import BusinessEntity.DistritoBE;
import BusinessEntity.ProvinciaBE;
import Conexion.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Mnu
 */
public class DistritoDA {

    private Conexion conexion;
    ResultSet rs;
    char chr = 34;
    java.sql.Statement comando;

    public String BuscarDistrito(int codDistrito) {
        String nombre="";
        conexion = new Conexion();
         try {
            comando =  conexion.getConexion().createStatement();
            String query = " select " +
                 "vchdistrito " +
                 " from "+conexion.getStrEsquema()+".t_distrito "+
                 " where intcoddistrito ="+codDistrito+";";
                 rs = comando.executeQuery(query);
                while ( rs.next()){
                    nombre=rs.getString("vchdistrito");
                }
                rs.close();
         }
         catch (SQLException ex) {
            System.out.println("error "+ex.getMessage());
        }
        return nombre;
    }
    
    
    public ArrayList<DistritoBE> CargarDistrito(ProvinciaBE provi){
        ArrayList<DistritoBE> ListaDistritos = new ArrayList<DistritoBE>();
        conexion = new Conexion();
         try {
            comando =  conexion.getConexion().createStatement();
            String query = " select " +
                 "intcoddistrito, " +
                 "vchdistrito, " +
                 "intcodprovincia " +
                 " from "+conexion.getStrEsquema()+".t_distrito "+
                 " where intcodprovincia ="+provi.getCodProvincia()+";";
                 rs = comando.executeQuery(query);
                       
                while ( rs.next()){
                    
                  ListaDistritos.add(setearDistrito(rs));
                }
                rs.close();
         
         }
         catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }        
        return ListaDistritos;
    }
    
    
    public DistritoBE setearDistrito(ResultSet rs)
    {   DistritoBE DistritoTemporal=new DistritoBE();
        try {
            
            DistritoTemporal.setCodDistrito(rs.getInt("intcoddistrito"));
            DistritoTemporal.setDistrito(rs.getString("vchdistrito"));
            DistritoTemporal.setCodProvincia(rs.getInt("intcodprovincia"));
            } catch (SQLException ex) {
            //Logger.getLogger(AccesoDA.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error Seteo");
        }
        return DistritoTemporal;
    }
//implementado por jacky
    public ArrayList<DistritoBE> CargarDistrito() {
        ArrayList<DistritoBE> ListaDistritos = new ArrayList<DistritoBE>();
        conexion = new Conexion();
         try {
            comando =  conexion.getConexion().createStatement();
            String query = " select " +
                 "intcoddistrito, " +
                 "vchdistrito, " +
                 "intcodprovincia " +
                 " from "+conexion.getStrEsquema()+".t_distrito "+
                 " where 1=1";
                 rs = comando.executeQuery(query);
            while ( rs.next()){
                  ListaDistritos.add(setearDistrito(rs));
            }
            rs.close();
         }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ListaDistritos;
    }
}
