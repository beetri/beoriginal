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
import java.sql.ResultSet;
import java.util.ArrayList;


public class SubcategoriaDA {
    private Conexion cnxConexion;
    java.sql.Statement comando;


public boolean registrarSubcategoria(SubcategoriaBE objSubcategoriaBE) throws Exception{
   try {
         cnxConexion = new Conexion();
         try {
         comando =  cnxConexion.getConexion().createStatement();

         String query = " insert into "+cnxConexion.getStrEsquema()+".t_subcategoria (vchDescripcion,vchEstado,intCodCategoria) " +
                        "values ('"+
                        objSubcategoriaBE.getDescripcion() +"','"+
                        objSubcategoriaBE.getEstado() +"','"+
                        objSubcategoriaBE.getCodCategoria() +"');";

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

public ArrayList<SubcategoriaBE> buscarSubcategoria(SubcategoriaBE objSubcategoriaAuxBE){

        ArrayList<SubcategoriaBE> lstSubcategoriaBE = new ArrayList<SubcategoriaBE>();
        SubcategoriaBE objSubcategoriaBE;
        String where= "";
        String estado = "Activo";
        try{
            cnxConexion = new Conexion();
            try{
                comando =  cnxConexion.getConexion().createStatement();
                String query =" select * from "+cnxConexion.getStrEsquema()+".t_subcategoria ";
                query = query + where +"order by intcodsubcategoria";
                ResultSet rsl = comando.executeQuery(query);
                while ( rsl.next()){
                    objSubcategoriaBE = new SubcategoriaBE();
                    objSubcategoriaBE.setCodSubcategoria(rsl.getInt("intcodsubcategoria"));
                    objSubcategoriaBE.setDescripcion(rsl.getString("vchdescripcion"));
                    objSubcategoriaBE.setEstado(rsl.getString("vchestado"));
                    objSubcategoriaBE.setCodCategoria(rsl.getInt("intcodcategoria"));
                    lstSubcategoriaBE.add(objSubcategoriaBE);
                }
                rsl.close();
                cnxConexion.getConexion().close();
                return lstSubcategoriaBE;
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
