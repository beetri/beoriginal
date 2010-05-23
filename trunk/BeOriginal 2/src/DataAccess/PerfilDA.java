/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;

/**
 *
 * @author Administador
 */
import BusinessEntity.*;
import Conexion.Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class PerfilDA {
private Conexion cnxConexion;
    private char chr = 34;
    private String strConsulta = "";
    DateFormat df= new SimpleDateFormat("yyyy-MM-dd");
    private int idUsuario = 0;
    private int idUsuarioLogueado;
    private String strConsultaRealizada = "";
    private String strAccion="";
     java.sql.Statement comando;

//    public boolean registrarPerfil(PerfilBE objPerfilBE,int [] arre,int idUsuarioAux){
    public boolean registrarPerfil(PerfilBE objPerfilBE,int [] arre){
        Integer idper=buscarPerfilIDMax() + 1;
        try {
            cnxConexion = new Conexion();
            try {
                 comando=cnxConexion.getConexion().createStatement();
                String query =  " insert into "+cnxConexion.getStrEsquema()+".Perfil (Perfil,Estado) " +
                        "values ('"+
                        objPerfilBE.getsPerfil() +"','"+
                        objPerfilBE.getsEstado() +"');";
                int r = comando.executeUpdate(query);
                 for(int i=0 ;i< arre.length;i++){
                     if(arre[i]!=0)
                     registrarFuncionalidadXPerfil(idper,arre[i]);
                }
            }
            catch(Exception ex) {
                System.out.println(ex.toString());
                return false;
            }
            return true;
        }
        catch(Exception ex) {
            System.out.println(ex.toString());
            return false;
            //ex.getMessage();
        }

    }

 public boolean registrarFuncionalidadXPerfil(int idper, int idfun){
 Date dt;
     try {
            cnxConexion = new Conexion();
             try {
                comando =  cnxConexion.getConexion().createStatement();
                String query = " insert into "+cnxConexion.getStrEsquema()+".AccesosModulosxPerfil (CodPerfil,CodModulo,HoraCreacion) " +
                        "values ('"+
                        idper +"','"+
                        idfun +"','"+
                        new Date()+"');";
                 int r = comando.executeUpdate(query);
            }
            catch(Exception ex) {
                return false;
            }
               cnxConexion.getConexion().close();
             return true;
        }
        catch(Exception ex) {
            return false;
            //ex.getMessage();
        }
    }
 public PerfilBE buscarPerfil(int idPerfil){

       PerfilBE objPerfilBE = new PerfilBE();
        try {
            cnxConexion = new Conexion();
            try {
                comando =  cnxConexion.getConexion().createStatement();
                String query = "select * from "+cnxConexion.getStrEsquema()+".Perfil"+
                " where CodPerfil = "+idPerfil+";";
                ResultSet rs = comando.executeQuery(query);
                if (rs.next()) {
                    objPerfilBE.setiCodPerfil(rs.getInt("CodPerfil"));
                    objPerfilBE.setsPerfil(rs.getString("Perfil"));
                    objPerfilBE.setsEstado(rs.getString("Estado"));
                }
                rs.close();
            }
            catch(Exception ex) {
                return null;
                //ex.getMessage();
            }
            cnxConexion.getConexion().close();
            return objPerfilBE;
        }
        catch(Exception ex) {
            return null;
            //ex.getMessage();
        }

    }
 public ArrayList<PerfilBE> buscarperfiles(PerfilBE objPerfilAuxBE){
        ArrayList<PerfilBE> lstPerfilBE = new ArrayList<PerfilBE>();
        PerfilBE objPerfilBE;
        String where= "";
        String estado = "Activo";
        cnxConexion = new Conexion();
         String query =" select * from "+cnxConexion.getStrEsquema()+".Perfil ";
        if(objPerfilAuxBE.getsPerfil().compareTo("")!=0){
            where = where + " where estado='"+estado+"' and upper(Perfil) like upper('%"+objPerfilAuxBE.getsPerfil()+"%')";
        }     else
            where = where + " where estado='"+estado+"'  ";

          query = query + where + "order by CodPerfil";
          try {
               comando =  cnxConexion.getConexion().createStatement();
               ResultSet rsl = comando.executeQuery(query);

                while ( rsl.next()){
                    objPerfilBE = new PerfilBE();
                    objPerfilBE.setiCodPerfil(rsl.getInt("CodPerfil"));
                    objPerfilBE.setsPerfil(rsl.getString("Perfil"));
                    objPerfilBE.setsEstado(rsl.getString("Estado"));
                    lstPerfilBE.add(objPerfilBE);
                }
                rsl.close();
                cnxConexion.getConexion().close();
                return lstPerfilBE;

         }
         catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
 public int buscarPerfilIDMax() {
        int idMax = 0;

        try {
            cnxConexion = new Conexion();
            try {
                comando =  cnxConexion.getConexion().createStatement();
                String query = "select * from "+cnxConexion.getStrEsquema()+".Perfil " +
                "where CodPerfil = (Select MAX(CodPerfil) from Perfil);";
                ResultSet rsl = comando.executeQuery(query);

                if (rsl.next()) {
                    idMax = rsl.getInt("CodPerfil");
                }
                rsl.close();
                cnxConexion.getConexion().close();
                return idMax;
            }
            catch(Exception ex) {
                System.out.println(ex.toString());
                cnxConexion.getConexion().close();
                return 0;
            }
        }
        catch(Exception ex) {
            System.out.println(ex.toString());
            return 0;
            //ex.getMessage();
        }
    }
 public PerfilBE buscarPerfilNombre(String Perfil){
        PerfilBE objPerfilBE = new PerfilBE();
        try {
            cnxConexion = new Conexion();
            try {
                comando =  cnxConexion.getConexion().createStatement();
                String query = "select * from "+cnxConexion.getStrEsquema()+".Perfil"+
                " where Perfil = '"+Perfil+"';";
                ResultSet rs = comando.executeQuery(query);
                if (rs.next()) {
                    objPerfilBE.setiCodPerfil(rs.getInt("CodPerfil"));
                    objPerfilBE.setsPerfil(rs.getString("Perfil"));
                    objPerfilBE.setsEstado(rs.getString("Estado"));
                }
                rs.close();
            }
            catch(Exception ex) {
                return null;
                //ex.getMessage();
            }
            cnxConexion.getConexion().close();
            return objPerfilBE;
        }
        catch(Exception ex) {
            return null;
            //ex.getMessage();
        }
    }
}
