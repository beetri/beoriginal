/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess.Documentos;

/**
 *
 * @author pedro
 */
import BusinessEntity.Documentos.*;
import Conexion.*;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoriaDA {
    private Conexion cnxConexion;
    java.sql.Statement comando;

    public boolean registrarCategoria(CategoriaBE objCategoriaBE) throws Exception{
   try {
         cnxConexion = new Conexion();
         try {
         comando =  cnxConexion.getConexion().createStatement();

         String query = " insert into "+cnxConexion.getStrEsquema()+".t_categoria (vchDescripcion,vchEstado) " +
                        "values ('"+
                        objCategoriaBE.getDescripcion() +"','"+
                        objCategoriaBE.getEstado() +"');";

                        int r = comando.executeUpdate(query);
//                        return true;
         }
         catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        cnxConexion.getConexion().close();
        return true;
        }
        catch(Exception exc) {
            return false;
            //ex.getMessage();
        }
   }

    public ArrayList<CategoriaBE> buscarCategoria(CategoriaBE objCategoriaAuxBE){

        ArrayList<CategoriaBE> lstCategoriaBE = new ArrayList<CategoriaBE>();
        CategoriaBE objCategoriaBE;
        String where= "";
        String estado = "Activo";
        try{
            cnxConexion = new Conexion();
            try{
                comando =  cnxConexion.getConexion().createStatement();
                String query =" select * from "+cnxConexion.getStrEsquema()+".t_categoria ";
                query = query + where +"order by intcodcategoria";
                ResultSet rsl = comando.executeQuery(query);
                while ( rsl.next()){
                    objCategoriaBE = new CategoriaBE();
                    objCategoriaBE.setCodCategoria(rsl.getInt("intcodcategoria"));
                    objCategoriaBE.setDescripcion(rsl.getString("vchdescripcion"));
                    objCategoriaBE.setEstado(rsl.getString("vchestado"));
                    lstCategoriaBE.add(objCategoriaBE);
                }
                rsl.close();
                cnxConexion.getConexion().close();
                return lstCategoriaBE;
         }
         catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }catch (Exception ex) {
                return null;
            }
     }


}
