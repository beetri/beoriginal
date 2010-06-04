/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;

import java.sql.Statement;
import java.util.ArrayList;
import BusinessEntity.*;
//import BusinessLogic.TransaccionBL;
import Conexion.*;
import java.sql.ResultSet;
import java.text.*;
import java.util.Date;
import java.sql.SQLException;

/**
 *
 * @author Bernabe
 */
public class UsuarioDA {
private Conexion cnxConexion;
    private char chr = 34;
    private String strConsulta = "";
    DateFormat df= new SimpleDateFormat("yyyy-MM-dd");
    private int idUsuarioLogueado;
    private String strConsultaRealizada = "";
    private String strAccion="";
//    private TransaccionBL objTransaccionBL;
    java.sql.Statement comando;
     private String correo;
//    ResultSet rs;

    public boolean registrarUsuario(UsuarioBE objUsuarioBE,int idUsuarioLogueado) throws Exception{
   try {
         cnxConexion = new Conexion();
         try {
         comando =  cnxConexion.getConexion().createStatement();

         String query = " insert into "+cnxConexion.getStrEsquema()+".t_usuario (vchnombre,vchapepaterno,vchapematerno,vchtelefono,vchdireccion,vchemail,chrsexo,intcodseccion,intcoddistrito,vchusuario,vchpassword,vchestado,intcodperfil,vchdni) " +
                        "values ('"+
                        objUsuarioBE.getNombre() +"','"+
                        objUsuarioBE.getApellidoPaterno() +"','"+
                        objUsuarioBE.getApellidoMaterno() +"','"+
                        objUsuarioBE.getTelefono() + "','" +
                        objUsuarioBE.getDireccion() + "','" +
                        objUsuarioBE.getEmail() + "','" +
                        //objUsuarioBE.getCodCargo() + "','" +
                        objUsuarioBE.getSexo() + "','" +
                        objUsuarioBE.getCodArea() + "','" +
                        objUsuarioBE.getCodDistrito() + "','" +
                        objUsuarioBE.getUsuario() + "','" +
                        objUsuarioBE.getPassword() + "','" +
                        objUsuarioBE.getEstado() + "','" +
                        objUsuarioBE.getCodPerfil() + "','" +
                        objUsuarioBE.getNumeroDocumento() +"');";

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

    public boolean modificarUsuario(UsuarioBE objUsuarioBE,int idUsuarioLogueado){
        try {
         cnxConexion = new Conexion();
         try {
         comando =  cnxConexion.getConexion().createStatement();

         String query = " update "+cnxConexion.getStrEsquema()+".t_usuario " +
                        " set vchnombre ='" +objUsuarioBE.getNombre()+"', "+
                        " vchapepaterno ='" +objUsuarioBE.getApellidoPaterno()+"', "+
                        " vchapematerno ='" +objUsuarioBE.getApellidoMaterno()+"', "+
                        " vchtelefono ='" +objUsuarioBE.getTelefono()+"', "+
                        " vchdireccion ='" +objUsuarioBE.getDireccion()+"', "+
                        " vchemail ='" +objUsuarioBE.getEmail()+"', "+
                        " intcodseccion ='" +objUsuarioBE.getCodArea()+"', "+
                        " intcoddistrito ='" +objUsuarioBE.getCodDistrito()+"', "+
                        " vchusuario ='" +objUsuarioBE.getUsuario()+"', "+
                        " intcodperfil ='" +objUsuarioBE.getCodPerfil()+"', "+
                        " vchdni ='" +objUsuarioBE.getNumeroDocumento()+"' where t_usuario.intcodusuario ="+
                        objUsuarioBE.getCodUsuario()+";";
                 
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
//            ex.getMessage();
        }
   }

    public boolean eliminarUsuario(UsuarioBE objUsuarioBE,int idUsuarioLogueado){
         try {
         cnxConexion = new Conexion();
         try {
         comando =  cnxConexion.getConexion().createStatement();

         String query = " update "+cnxConexion.getStrEsquema()+".t_usuario " +
                        " set vchestado = 'Inactivo' "+" where t_usuario.intcodusuario ="+
                        objUsuarioBE.getCodUsuario()+";";

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
//            ex.getMessage();
        }
    }

    public UsuarioBE buscarUsuarioInt(int variableEntera){

        UsuarioBE objUsuarioBE = new UsuarioBE();
        try {
            cnxConexion = new Conexion();
            try {

                comando =  cnxConexion.getConexion().createStatement();
                String query = "select * from "+cnxConexion.getStrEsquema()+".t_usuario where intcodusuario="+variableEntera+";";
                ResultSet rsl = comando.executeQuery(query);
                if (rsl.next()) {
                     objUsuarioBE = new UsuarioBE();
                    objUsuarioBE.setCodUsuario(rsl.getInt("intcodusuario"));
                    objUsuarioBE.setNombre(rsl.getString("vchnombre"));
                    objUsuarioBE.setApellidoMaterno(rsl.getString("vchapematerno"));
                    objUsuarioBE.setApellidoPaterno(rsl.getString("vchapepaterno"));
                    objUsuarioBE.setTelefono(rsl.getString("vchtelefono"));
                    objUsuarioBE.setNumeroDocumento(rsl.getString("vchdni"));
                    objUsuarioBE.setDireccion(rsl.getString("vchdireccion"));
                    objUsuarioBE.setUsuario(rsl.getString("vchusuario"));
                    objUsuarioBE.setEstado(rsl.getString("vchestado"));
                    objUsuarioBE.setCodPerfil(rsl.getInt("intcodperfil"));
                    objUsuarioBE.setCodDistrito(rsl.getInt("intcoddistrito"));
                    objUsuarioBE.setCodArea(rsl.getInt("intcodseccion"));
                    objUsuarioBE.setSexo(rsl.getString("chrsexo").charAt(0));
                    objUsuarioBE.setEmail(rsl.getString("vchemail"));
                }
                rsl.close();
            }
            catch(Exception exc) {
                return null;
                //ex.getMessage();
            }
            cnxConexion.getConexion().close();
            return objUsuarioBE;
        }
        catch(Exception exc) {
            return null;
            //ex.getMessage();
        }
    }

     public ArrayList<UsuarioBE> buscarUsuarios(UsuarioBE objUsuarioAuxBE){

        ArrayList<UsuarioBE> lstUsuarioBE = new ArrayList<UsuarioBE>();
        UsuarioBE objUsuarioBE;
        String where= "";
        String estado = "Activo";
        try{
            cnxConexion = new Conexion();
            try{
                comando =  cnxConexion.getConexion().createStatement();
                String query =" select * from "+cnxConexion.getStrEsquema()+".t_usuario ";
                //String query2 = "and (A.codDistrito= B.codDistrito and B.codprovincia = C.codprovincia and C.coddepartamento = D.coddepartamento )";
                if (objUsuarioAuxBE.getCodUsuario()!=0){
                    where = where + " where vchestado='"+estado+"' and intcodusuario="+objUsuarioAuxBE.getCodUsuario()+"  ";
                }
                else{
                    where = where + " where vchestado='"+estado+"'  ";
                }
                if(objUsuarioAuxBE.getNombre().compareTo("")!=0){
                    where = where + " and upper(vchnombre) like upper('%"+objUsuarioAuxBE.getNombre()+"%')";
                }
                if(objUsuarioAuxBE.getApellidoPaterno().compareTo("")!=0){
                where = where + " and upper(vchapepaterno) like upper('%"+objUsuarioAuxBE.getApellidoPaterno()+"%')";
                }

                if(objUsuarioAuxBE.getApellidoMaterno().compareTo("")!=0){
                where = where + " and upper(vchapematerno) like upper('%"+objUsuarioAuxBE.getApellidoMaterno()+"%')";
                }

                if(objUsuarioAuxBE.getCodPerfil()!=-1){
                where = where + " and intcodperfil = "+objUsuarioAuxBE.getCodPerfil()+";";
                }
                query = query + where +"order by intcodperfil";
                ResultSet rsl = comando.executeQuery(query);
                while ( rsl.next()){
                    objUsuarioBE = new UsuarioBE();
                    objUsuarioBE.setCodUsuario(rsl.getInt("intcodusuario"));
                    objUsuarioBE.setNombre(rsl.getString("vchnombre"));
                    objUsuarioBE.setApellidoMaterno(rsl.getString("vchapematerno"));
                    objUsuarioBE.setApellidoPaterno(rsl.getString("vchapepaterno"));
                    objUsuarioBE.setTelefono(rsl.getString("vchtelefono"));
                    objUsuarioBE.setNumeroDocumento(rsl.getString("vchdni"));
                    objUsuarioBE.setDireccion(rsl.getString("vchdireccion"));
                    objUsuarioBE.setUsuario(rsl.getString("vchusuario"));
                    objUsuarioBE.setEstado(rsl.getString("vchestado"));
                    objUsuarioBE.setCodPerfil(rsl.getInt("intcodperfil"));
                    objUsuarioBE.setCodDistrito(rsl.getInt("intcoddistrito"));
                    objUsuarioBE.setCodArea(rsl.getInt("intcodseccion"));
                    //objUsuarioBE.setCodCargo(rsl.getInt("intcodcargo"));
                    objUsuarioBE.setEmail(rsl.getString("vchemail"));
                    objUsuarioBE.setSexo(rsl.getString("chrsexo").charAt(0));
                    lstUsuarioBE.add(objUsuarioBE);
                }
                rsl.close();
                cnxConexion.getConexion().close();
                return lstUsuarioBE;
         }
         catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }catch (Exception ex) {
                return null;
            }
     }



    public int buscarUsuarioIDMax() {

        int idMax = 0;

        try {
            cnxConexion = new Conexion();
            try {
                Statement stConsulta = cnxConexion.getConexion().createStatement();
//                strConsulta = "select * from "+chr+"fn_tbUsuario_selectMax"+chr+"();";
                strConsulta = "select * from "+cnxConexion.getStrEsquema()+"fn_tbUsuario_selectMax"+chr+"();";
                ResultSet rsl = stConsulta.executeQuery(strConsulta);

                if (rsl.next()) {
                    idMax = rsl.getInt("idUsuario");
                }
                rsl.close();
                cnxConexion.getConexion().close();
                return idMax;
                // En este chrCso lo que se devuelve es una lista.
            }
            catch(Exception exc) {
                cnxConexion.getConexion().close();
                return 0;
                //ex.getMessage();
            }
        }
        catch(Exception exc) {
            return 0;
            //ex.getMessage();
        }

    }


       public boolean modificarUsuarioCambiarClave(UsuarioBE objUsuarioBE){
        System.out.printf("entro1");
        try {
            cnxConexion = new Conexion();
            try {
                Statement stmConsulta = cnxConexion.getConexion().createStatement();
                System.out.printf("entro2");
                System.out.println(objUsuarioBE.getNombre());
                System.out.println(objUsuarioBE.getApellidoPaterno());
                System.out.println(objUsuarioBE.getApellidoMaterno());
                System.out.println( objUsuarioBE.getTelefono());
                 System.out.println(objUsuarioBE.getNumeroDocumento());
                 System.out.println(objUsuarioBE.getSexo());
                  System.out.println(objUsuarioBE.getDireccion());
                  System.out.println(objUsuarioBE.getUsuario());
//                   System.out.println(String.valueOf(objUsuarioBE.getObjPerfil().getIdPerfil()));
//                   System.out.println(String.valueOf(objUsuarioBE.getObjEstado().getIdEstado()));
//                  System.out.println(String.valueOf(objUsuarioBE.getObjTipoDocumento().getIdTipoDocumento()));
                  System.out.println(objUsuarioBE.getEmail());
                  System.out.println(String.valueOf(objUsuarioBE.getUsuario()));
                  System.out.println(df.format(objUsuarioBE.getFechaCreacion()));
//                   System.out.println(String.valueOf(objUsuarioBE.getCambiarClave()));


//                strConsulta = "select "+chr+"fn_tbUsuario_update"+chr+"("+ objUsuarioBE.getCodUsuario() +",'" +
                strConsulta = "select "+cnxConexion.getStrEsquema()+"fn_tbUsuario_update"+chr+"("+ objUsuarioBE.getCodUsuario() +",'" +


                        objUsuarioBE.getNombre() +"','"+
                        objUsuarioBE.getApellidoPaterno() +"','"+
                        objUsuarioBE.getApellidoMaterno() +"','"+
                        objUsuarioBE.getTelefono() +"','"+
                        objUsuarioBE.getNumeroDocumento() +"','"+
                        objUsuarioBE.getSexo() +"','"+
                        objUsuarioBE.getDireccion() +"','"+
                        objUsuarioBE.getUsuario() +"',"+
//                        String.valueOf(objUsuarioBE.getObjPerfil().getIdPerfil()) +","+
//                        String.valueOf(objUsuarioBE.getObjEstado().getIdEstado()) +","+
//                        String.valueOf(objUsuarioBE.getObjTipoDocumento().getIdTipoDocumento()) +",'"+
                        objUsuarioBE.getEmail() +"','"+
                        String.valueOf(objUsuarioBE.getUsuario()) + "'," +
                        df.format(objUsuarioBE.getFechaCreacion()) +");";
//                        String.valueOf(objUsuarioBE.getCambiarClave())+");";
                System.out.println(strConsulta);
                ResultSet rsl = stmConsulta.executeQuery(strConsulta);
            }
            catch(Exception exc) {

                System.out.print(exc.getMessage());
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
 public String ObtenerCorreo(String Usuario) {
     String mail = null;
     try{
         cnxConexion = new Conexion();
         try {
             comando = cnxConexion.getConexion().createStatement();
             String query ="select vchemail from "+cnxConexion.getStrEsquema()+".t_usuario";
             query = query + " where vchusuario='"+Usuario+"';";
               
             ResultSet rs = comando.executeQuery(query);
             while(rs.next()){
                 mail = rs.getString(1);
                 System.out.println(mail);
             return mail ;
             }
             rs.close();
        }
        catch (SQLException ex) {
        }
     }
     catch (Exception ex){
     }
     return mail;
    }

    public boolean ActualizarContrasena(String Usuario, String NuevaContrasena) {
        cnxConexion = new Conexion();

       try {
           comando =  cnxConexion.getConexion().createStatement();
           String query = "Update "+cnxConexion.getStrEsquema()+".t_usuario "+
                        " set vchpassword ='" +NuevaContrasena+"' "+
                        " where vchusuario = '" +Usuario+"'; ";

                        ResultSet rs = comando.executeQuery(query);
         return true;

           }
         catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
     }

    }
//      public boolean registrarTransaccion() {
//        TransaccionBE objTransaccionBE = new TransaccionBE();
//        AccesoBE objAccesoBE = new AccesoBE();
//        UsuarioBE objUsuarioBE = new UsuarioBE();
//        objUsuarioBE.setIdUsuario(idUsuarioLogueado);
//        objAccesoBE.setObjUsuarioBE(objUsuarioBE);
//        Date dteFecha = new Date();
//        objTransaccionBE.setDteFecha(dteFecha);
//        objTransaccionBE.setObjAccesoBE(objAccesoBE);
//        strConsultaRealizada = strConsulta.replace(chr, ' ');
//        strConsultaRealizada = strConsultaRealizada.replace((char)(39), '´');
//        objTransaccionBE.setConsultaRealizada(strConsultaRealizada);
//        objTransaccionBE.setAccion(strAccion);
//        objTransaccionBL = new TransaccionBL();
//        return objTransaccionBL.registrarTransaccion(objTransaccionBE);
//    }
}
