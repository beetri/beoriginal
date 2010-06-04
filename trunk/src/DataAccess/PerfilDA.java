/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;

import BusinessEntity.*;
//import BusinessLogic.FuncionalidadBL;
//import BusinessLogic.TransaccionBL;
import Conexion.Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * @author Bernabe & tRUfA
 */
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
                comando =  cnxConexion.getConexion().createStatement();

                String query =  " insert into "+cnxConexion.getStrEsquema()+".t_perfil (vchperfil,vchestado) " +
                        "values ('"+
                        objPerfilBE.getPerfil() +"','"+
                        objPerfilBE.getEstado() +"');";

                int r = comando.executeUpdate(query);
//                 registrarTransaccion();
                 for(int i=0 ;i< arre.length;i++){
                     if(arre[i]!=0)
//                     registrarFuncionalidadXPerfil(objPerfilBE.getCodPerfil(),arre[i],idUsuarioAux);
                     registrarFuncionalidadXPerfil(idper,arre[i]);
                }
            }
            catch(Exception ex) {
                System.out.println(ex.toString());
                return false;
            }
            cnxConexion.getConexion().close();
            return true;
        }
        catch(Exception ex) {
            System.out.println(ex.toString());
            return false;
            //ex.getMessage();
        }

    }
// public boolean registrarFuncionalidadXPerfil(int idper, int idfun, int idUsuarioAux){
 public boolean registrarFuncionalidadXPerfil(int idper, int idfun){
     Date dtFecha = new Date();
     String  strFecha=""; // Se crea para concatenar la fecha actual

     // Para obtener las fechas de el tipo de dato Date y asi poder almacenar en la BD
     strFecha= dtFecha.toString().substring(4,10) + " " + dtFecha.toString().substring(24,28);

     try {
            cnxConexion = new Conexion();


             try {
                comando =  cnxConexion.getConexion().createStatement();
//                idUsuario = idUsuarioAux; //se llena con el parametro pasado
//                strAccion = "Insert";
                String query = " insert into "+cnxConexion.getStrEsquema()+".t_moduloxperfil (intcodperfil,intcodmodulo,dtehoracreacion) " +
                        "values ("+
                        idper +","+
                        idfun +",'"+
                        strFecha+"');";
                 int r = comando.executeUpdate(query);
//                registrarTransaccion();
            }
            catch(Exception ex) {
                return false;
                //ex.getMessage();
            }
               cnxConexion.getConexion().close();
             return true;
        }
        catch(Exception ex) {
            return false;
            //ex.getMessage();
        }




    }
//    public boolean modificarPerfil(PerfilBE objPerfilBE,int [] arre,int idUsuarioAux){
    public boolean modificarPerfil(PerfilBE objPerfilBE,int [] arre, int codPerfil){
        try {
            PerfilBE objPerfilBEAux = new PerfilBE();
            objPerfilBEAux = buscarPerfilNombre(objPerfilBE.getPerfil());
            objPerfilBE.setCodPerfil(objPerfilBEAux.getCodPerfil());
            cnxConexion = new Conexion();
            try {
//                eliminarFuncionalidadXPerfil(objPerfilBE.getCodPerfil(),idUsuarioAux);
                eliminarFuncionalidadXPerfil(codPerfil);
                comando =  cnxConexion.getConexion().createStatement();
//                     idUsuario = idUsuarioAux; //se llena con el parametro pasado
//                strAccion = "Insert";
                String query = " update "+cnxConexion.getStrEsquema()+".t_perfil " +
                        " set vchperfil ='" +objPerfilBE.getPerfil()+"', "+
                        " vchestado = '"+objPerfilBE.getEstado()
                        +"' where t_perfil.intcodPerfil ="+
                        codPerfil+";";

                int r = comando.executeUpdate(query);
//                registrarTransaccion();
                  for(int i=0 ;i< arre.length;i++){
                     if(arre[i]!=0)
//                     registrarFuncionalidadXPerfil(objPerfilBE.getCodPerfil(),arre[i],idUsuarioAux);
                     registrarFuncionalidadXPerfil(codPerfil,arre[i]);
                }
            }
            catch(Exception ex) {
                System.out.println(ex.toString());
                return false;
                //ex.getMessage();
            }
            cnxConexion.getConexion().close();
            return true;
        }
        catch(Exception ex) {
            System.out.println(ex.toString());
            return false;
            //ex.getMessage();
        }
    }

//  public boolean eliminarFuncionalidadXPerfil(int idPerfil,int idUsuarioAux){
  public boolean eliminarFuncionalidadXPerfil(int idPerfil){

        try {
             comando =  cnxConexion.getConexion().createStatement();
//                 idUsuario = idUsuarioAux; //se llena con el parametro pasado
//                strAccion = "Insert";
//                strConsulta = "select "+ca+"fn_tbFuncionalidadXPerfil_delete"+ca+"("+ idPerfil+");";
             String query = " delete from "+cnxConexion.getStrEsquema()+".t_ModuloxPerfil " +
                     " where intcodperfil ="+idPerfil+";";
                int r = comando.executeUpdate(query);
//                registrarTransaccion();
        }
        catch(Exception ex) {
            System.out.println(ex.toString());
            return false;
            //ex.getMessage();
        }
  return true;
    }




    public boolean eliminarPerfil(PerfilBE objPerfilBE,int idUsuarioAux){

        try {
            PerfilBE objPerfilBEAux = new PerfilBE();
            objPerfilBEAux = buscarPerfilNombre(objPerfilBE.getPerfil());
            objPerfilBE.setCodPerfil(objPerfilBEAux.getCodPerfil());
            cnxConexion = new Conexion();
            try {
                eliminarFuncionalidadXPerfil(objPerfilBE.getCodPerfil());
                comando =  cnxConexion.getConexion().createStatement();
//                     idUsuario = idUsuarioAux; //se llena con el parametro pasado
//                strAccion = "Insert";
                String query = " update "+cnxConexion.getStrEsquema()+".t_perfil " +
                        " set vchestado = 'Inactivo'"+" where t_perfil.intcodperfil ="+
                        objPerfilBE.getCodPerfil()+";";
                int r = comando.executeUpdate(query);
//                registrarTransaccion();
            }
            catch(Exception ex) {
                return false;
                //ex.getMessage();
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
                String query = "select * from "+cnxConexion.getStrEsquema()+".t_perfil"+
                " where intcodperfil = "+idPerfil+";";
                ResultSet rs = comando.executeQuery(query);
                if (rs.next()) {
                    objPerfilBE.setCodPerfil(rs.getInt("intcodperfil"));
                    objPerfilBE.setPerfil(rs.getString("vchperfil"));
                    objPerfilBE.setEstado(rs.getString("vchestado"));
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
 public PerfilBE buscarPerfilNombre(String Perfil){
        PerfilBE objPerfilBE = new PerfilBE();
        try {
            cnxConexion = new Conexion();
            try {
                comando =  cnxConexion.getConexion().createStatement();
                String query = "select * from "+cnxConexion.getStrEsquema()+".t_perfil"+
                " where vchperfil = '"+Perfil+"';";
                ResultSet rs = comando.executeQuery(query);
                if (rs.next()) {
                    objPerfilBE.setCodPerfil(rs.getInt("intcodperfil"));
                    objPerfilBE.setPerfil(rs.getString("vchperfil"));
                    objPerfilBE.setEstado(rs.getString("vchestado"));
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
//
    public ArrayList<PerfilBE> buscarperfiles(PerfilBE objPerfilAuxBE){
        ArrayList<PerfilBE> lstPerfilBE = new ArrayList<PerfilBE>();
        PerfilBE objPerfilBE;
        String where= "";
        String estado = "Activo";
        try{
               cnxConexion = new Conexion();
               try {
                     comando =  cnxConexion.getConexion().createStatement();
                     String query =" select * from "+cnxConexion.getStrEsquema()+".t_perfil ";
                     if(objPerfilAuxBE.getPerfil().compareTo("")!=0){
                    where = where + " where vchestado='"+estado+"' and upper(Perfil) like upper('%"+objPerfilAuxBE.getPerfil()+"%')";
                    } else
                        where = where + " where vchestado='"+estado+"'  ";
                        query = query + where + "order by intcodPerfil";
                        ResultSet rsl = comando.executeQuery(query);
                        while ( rsl.next()){
                            objPerfilBE = new PerfilBE();
                            objPerfilBE.setCodPerfil(rsl.getInt("intCodPerfil"));
                            objPerfilBE.setPerfil(rsl.getString("vchPerfil"));
                            objPerfilBE.setEstado(rsl.getString("vchEstado"));

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
        catch (Exception ex) {
                return null;
            }
   }

     public ArrayList<PerfilBE> buscarperfilesModulo(PerfilBE objPerfilAuxBE, String Modulo){
        ArrayList<PerfilBE> lstPerfilBE = new ArrayList<PerfilBE>();
        PerfilBE objPerfilBE;
        String where= "";
        String estado = "Activo";
        try{
            cnxConexion = new Conexion();
            try{
                String query;
                comando =  cnxConexion.getConexion().createStatement();
                if(!Modulo.equals("SELECCIONE"))
                   query =" select P.intcodperfil,P.vchperfil,P.vchestado from "+cnxConexion.getStrEsquema()+".t_perfil P, "+cnxConexion.getStrEsquema()+".t_modulo M, "+cnxConexion.getStrEsquema()+".t_moduloxperfil A ";
                else
                    query=" select P.intcodperfil,P.vchperfil,P.vchestado from "+cnxConexion.getStrEsquema()+".t_perfil P ";

                if(objPerfilAuxBE.getPerfil().compareTo("")!=0){
                    where = where + " where P.vhcestado='"+estado+"' and upper(vchperfil) like upper('%"+objPerfilAuxBE.getPerfil()+"%')";
                }     else
                    where = where + " where vchestado='"+estado+"'  ";
                if(!Modulo.equals("SELECCIONE")){
                    where = where + " and M.vchmodulo = '"+Modulo+"' and M.intcodmodulo = A.intcodmodulo and A.intcodperfil = P.intcodperfil;";
                }
                query = query + where;
                ResultSet rsl = comando.executeQuery(query);
                while ( rsl.next()){
                    objPerfilBE = new PerfilBE();
                    objPerfilBE.setCodPerfil(rsl.getInt("intcodperfil"));
                    objPerfilBE.setPerfil(rsl.getString("vchperfil"));
                    objPerfilBE.setEstado(rsl.getString("vchestado"));
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
        catch (Exception ex) {
                System.out.println(ex.getMessage());
                return null;
        }
    }

//
     public List<PerfilBE> buscarperfiles2(int idFuncionalidad){

        List<PerfilBE> lstPerfilBE = new ArrayList<PerfilBE>();


                return lstPerfilBE;

    }
     public String fechaACadena(Date objDate) {
        String strFecha="";
        if (objDate != null)
            strFecha="'"+df.format(objDate)+"'";
        else
            strFecha="null";
        return strFecha;
    }

  public List<PerfilBE> buscarperfiles1(PerfilBE objPerfilAuxBE,Date s1, Date s2){

        List<PerfilBE> lstPerfilBE = new ArrayList<PerfilBE>();
        PerfilBE objPerfilBE;


                return lstPerfilBE;

    }

   public int buscarFuncionalidadXPerfilIDMax() {
        int idMax = 0;

        try {
            cnxConexion = new Conexion();
            try {
                Statement stConsulta = cnxConexion.getConexion().createStatement();
//                strConsulta = "select * from "+chr+"fn_tbFuncionalidadXPerfil_selectMax"+chr+"();";
                strConsulta = "select * from "+cnxConexion.getStrEsquema()+".fn_tbFuncionalidadXPerfil_selectMax"+chr+"();";
                ResultSet rsl = stConsulta.executeQuery(strConsulta);

                if (rsl.next()) {
                    idMax = rsl.getInt("idFuncionalidadXPerfil");
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
        }
    }

    public int buscarPerfilIDMax() {
        int idMax = 0;

        try {
            cnxConexion = new Conexion();
            try {
                comando =  cnxConexion.getConexion().createStatement();
                // Obtenemos el ultimo sequence ingresado en la tabla
                String query = "select last_value from "+cnxConexion.getStrEsquema()+".t_perfil_intcodperfil_seq;";
                ResultSet rsl = comando.executeQuery(query);

                while (rsl.next()) {
                    idMax = rsl.getInt(1);
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
// public boolean registrarTransaccion() {
//        TransaccionBE objTransaccionBE = new TransaccionBE();
//        AccesoBE objAccesoBE = new AccesoBE();
//        UsuarioBE objUsuarioBE = new UsuarioBE();
//        objUsuarioBE.setIdUsuario(idUsuario);
//        objAccesoBE.setObjUsuarioBE(objUsuarioBE);
//        Date dteFecha = new Date();
//        objTransaccionBE.setDteFecha(dteFecha);
//        objTransaccionBE.setObjAccesoBE(objAccesoBE);
//        strConsultaRealizada = strConsulta.replace(ca, ' ');
//        strConsultaRealizada = strConsultaRealizada.replace((char)(39), '´');
//        objTransaccionBE.setStrConsultaRealizada(strConsultaRealizada);
//        objTransaccionBE.setStrAccion(strAccion);
//        objTransaccionBL = new TransaccionBL();
//        return objTransaccionBL.registrarTransaccion(objTransaccionBE);
//    }


}
