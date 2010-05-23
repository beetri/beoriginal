/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;

/**
 *
 * @author Administador
 */
import java.util.ArrayList;
import Conexion.Conexion;
import BusinessEntity.*;
import java.sql.ResultSet;
import java.sql.Statement;

public class ModuloDA {
private Conexion cnxConexion;
    private char chr = 34;
    private String strConsulta = "";
    java.sql.Statement comando;



       public ArrayList<ModuloBE> getModulo(int idPerfil){
        ArrayList<ModuloBE> lstModuloBE = new ArrayList<ModuloBE>();
        ModuloBE objModuloBE;
        try {
            cnxConexion = new Conexion();
            try {
                comando =  cnxConexion.getConexion().createStatement();
                String query = "select B.CodModulo,B.Modulo  from "+cnxConexion.getStrEsquema()+".AccesosModulosXPerfil A, "+
                        cnxConexion.getStrEsquema()+".Modulo B where A.CodPerfil="+idPerfil+
                        " and A.CodModulo = B.CodModulo;";
//                String query = "select *  from "+cnxConexion.getSchema()+".Modulo where CodModulo = " +
//                        "(Select CodModulo from AccesosModulosXPerfil where CodPerfil="+idPerfil+");";
                ResultSet rsl = comando.executeQuery(query);
                while (rsl.next()) {
                    objModuloBE = new ModuloBE();
                    objModuloBE.setCodModulo(rsl.getInt("CodModulo"));
                    objModuloBE.setModulo(rsl.getString("Modulo"));
                    lstModuloBE.add(objModuloBE);
                }

                rsl.close();
                cnxConexion.getConexion().close();
                return lstModuloBE;
            }
            catch(Exception exc) {
               System.out.printf("Error1 = %s",exc.getMessage() );
                cnxConexion.getConexion().close();

                return null;
                //ex.getMessage();
            }
        }
        catch(Exception exc) {
            System.out.printf("Error2 = %s",exc.getMessage() );
            return null;
            //ex.getMessage();
        }

    }
        public ModuloBE getModulo(String nombre){

        ArrayList<ModuloBE> lstModuloBE = new ArrayList<ModuloBE>();
        ModuloBE objModuloBE = new ModuloBE();

        try {
            cnxConexion = new Conexion();
            try {
                comando =  cnxConexion.getConexion().createStatement();
                String query = "select * from "+cnxConexion.getStrEsquema()+".Modulo where Modulo='"+nombre+"';";
                ResultSet rsl = comando.executeQuery(query);
                if (rsl.next()) {
                    objModuloBE = new ModuloBE();
                    objModuloBE.setCodModulo(rsl.getInt("CodModulo"));
                    objModuloBE.setModulo(rsl.getString("Modulo"));
                    //lstModuloBE.add(objModuloBE);
                }

                rsl.close();
                cnxConexion.getConexion().close();
                return objModuloBE;
            }
            catch(Exception exc) {
               System.out.printf("Error1 = %s",exc.getMessage() );
                cnxConexion.getConexion().close();

                return null;
                //ex.getMessage();
            }
        }
        catch(Exception exc) {
            System.out.printf("Error2 = %s",exc.getMessage() );
            return null;
            //ex.getMessage();
        }

    }
        public ArrayList<ModuloBE> getModuloTotal(){

        ArrayList<ModuloBE> lstModuloTotalBE = new ArrayList<ModuloBE>();
        ModuloBE objModuloBE;

        try {
            cnxConexion = new Conexion();
            try {
                comando =  cnxConexion.getConexion().createStatement();
                String query = "select * from "+cnxConexion.getStrEsquema()+".Modulo;";
                ResultSet rsl = comando.executeQuery(query);
                while (rsl.next()) {
                    objModuloBE = new ModuloBE();
                    objModuloBE.setCodModulo(rsl.getInt("CodModulo"));
                    objModuloBE.setModulo(rsl.getString("Modulo"));
                    lstModuloTotalBE.add(objModuloBE);
                }

                rsl.close();
                cnxConexion.getConexion().close();
                return lstModuloTotalBE;
            }
            catch(Exception exc) {
               System.out.printf("Error1 = %s",exc.getMessage() );
                cnxConexion.getConexion().close();

                return null;
                //ex.getMessage();
            }
        }
        catch(Exception exc) {
            return null;
            //ex.getMessage();
        }

    }

}
