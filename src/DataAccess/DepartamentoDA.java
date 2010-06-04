/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;

import BusinessEntity.DepartamentoBE;
import Conexion.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Bernabe
 */
public class DepartamentoDA {

    private Conexion conexion;
    ResultSet rs;
    char chr = 34;
    java.sql.Statement comando;
    
    
    public ArrayList<DepartamentoBE> CargarDepartamento()
    {   ArrayList<DepartamentoBE> ListaDepartamentos = new ArrayList<DepartamentoBE>();
        
        
        conexion = new Conexion();
         try {
         comando =  conexion.getConexion().createStatement();
        
         String query = " select " +
                 "intcoddepartamento, " +
                 "vchdepartamento " +
                 " from "+conexion.getStrEsquema()+".t_departamento ";
                    rs = comando.executeQuery(query);
                       
                while ( rs.next()){
                    
                  ListaDepartamentos.add(setearDepartamento(rs));
                }
                rs.close();
         
         }
         catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return ListaDepartamentos;
    }
    
    
    public DepartamentoBE setearDepartamento(ResultSet rs)
    {   DepartamentoBE DepartamentoTemporal=new DepartamentoBE();
        try {
            
            DepartamentoTemporal.setCodDepartamento(rs.getInt("intcoddepartamento"));
            DepartamentoTemporal.setDepartamento(rs.getString("vchdepartamento"));
            
            } catch (SQLException ex) {
            //Logger.getLogger(AccesoDA.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error Seteo");
        }
        return DepartamentoTemporal;
    }
    
     
     
     
    
}
