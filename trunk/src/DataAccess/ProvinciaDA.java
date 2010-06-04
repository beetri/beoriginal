/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;

/**
 *
 * @author Mnu
 */
import BusinessEntity.DepartamentoBE;
import BusinessEntity.ProvinciaBE;
import Conexion.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Bernabe
 */
public class ProvinciaDA {

    private Conexion conexion;
    ResultSet rs;
    char chr = 34;
    java.sql.Statement comando;
    
    
    public ArrayList<ProvinciaBE> CargarProvincia(DepartamentoBE depa){
        ArrayList<ProvinciaBE> ListaProvincias = new ArrayList<ProvinciaBE>();
        conexion = new Conexion();
        try {
            comando =  conexion.getConexion().createStatement();
            String query = " select " +
                 "intcodProvincia, " +
                 "vchprovincia, " +
                 "intcodDepartamento " +
                 " from "+conexion.getStrEsquema()+".t_provincia "+
                 " where intcodDepartamento ="+depa.getCodDepartamento()+";";
                 rs = comando.executeQuery(query);
                       
                while ( rs.next()){                    
                  ListaProvincias.add(setearProvincia(rs));
                }
                rs.close();         
         }
         catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }        
        return ListaProvincias;
    }
    
    
    public ProvinciaBE setearProvincia(ResultSet rs)
    {   ProvinciaBE ProvinciaTemporal=new ProvinciaBE();
        try {
            
            ProvinciaTemporal.setCodProvincia(rs.getInt("intcodprovincia"));
            ProvinciaTemporal.setProvincia(rs.getString("vchprovincia"));
            ProvinciaTemporal.setCodDepartamento(rs.getInt("intcoddepartamento"));
            } catch (SQLException ex) {
            //Logger.getLogger(AccesoDA.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error Seteo");
        }
        return ProvinciaTemporal;
    }
//agregado por jacky
    public ArrayList<ProvinciaBE> CargarProvincia() {
        ArrayList<ProvinciaBE> ListaProvincias = new ArrayList<ProvinciaBE>();
        conexion = new Conexion();
        try {
            comando =  conexion.getConexion().createStatement();
            String query = " select " +
                 "intcodprovincia, " +
                 "vchprovincia, " +
                 "intcoddepartamento " +
                 " from "+conexion.getStrEsquema()+".t_provincia "+
                 " where 1=1;";
                 rs = comando.executeQuery(query);

                while ( rs.next()){
                  ListaProvincias.add(setearProvincia(rs));
                }
                rs.close();
         }
         catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ListaProvincias;
    }
}