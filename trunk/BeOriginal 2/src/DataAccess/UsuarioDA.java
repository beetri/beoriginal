/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;

/**
 *
 * @author Administador
 */
    import java.sql.Statement;
    import java.util.ArrayList;
    import BusinessEntity.*;
    import Conexion.*;
    import java.sql.ResultSet;
    import java.text.*;
    import java.util.Date;
    import java.sql.SQLException;
public class UsuarioDA {

    private Conexion cnxConexion;
    private char chr = 34;
    private String strConsulta = "";
    DateFormat df= new SimpleDateFormat("yyyy-MM-dd");
    private int idUsuarioLogueado;
    private String strConsultaRealizada = "";
    private String strAccion="";
    java.sql.Statement comando;
     private String correo;
    public boolean registrarUsuario(UsuarioBE objUsuarioBE,int idUsuarioLogueado) throws Exception{
   try {
         cnxConexion = new Conexion();
         try {

         comando=cnxConexion.getConexion().createStatement();
         String query = " insert into "+cnxConexion.getStrEsquema()+".Usuario (Nombre,ApePaterno,ApeMaterno,Telefono,Direccion,Email,CodCargo,Sexo,CodArea,CodDistrito,Usr,Pwd,Estado,CodPerfil,CodTipoDocumento,numerodocumento) " +
                        "values ('"+
                        objUsuarioBE.getNombre() +"','"+
                        objUsuarioBE.getApellidoPaterno() +"','"+
                        objUsuarioBE.getApellidoMaterno() +"','"+
                        objUsuarioBE.getTelefono() + "','" +
                        objUsuarioBE.getDireccion() + "','" +
                        objUsuarioBE.getEmail() + "','" +
                        objUsuarioBE.getCodCargo() + "','" +
                        objUsuarioBE.getSexo() + "','" +
                        objUsuarioBE.getCodArea() + "','" +
                        objUsuarioBE.getCodDistrito() + "','" +
                        objUsuarioBE.getUsuario() + "','" +
                        objUsuarioBE.getPassword() + "','" +
                        objUsuarioBE.getEstado() + "','" +
                        objUsuarioBE.getCodPerfil() + "','" +
                        objUsuarioBE.getCodTipoDocumento() + "','" +
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

    public UsuarioBE buscarUsuarioInt(int variableEntera){

        UsuarioBE objUsuarioBE = new UsuarioBE();
        try {
            cnxConexion = new Conexion();
            try {

                comando =  cnxConexion.getConexion().createStatement();
                String query = "select * from "+cnxConexion.getStrEsquema()+".Usuario where CodUsuario="+variableEntera+";";
                ResultSet rsl = comando.executeQuery(query);
                if (rsl.next()) {
                     objUsuarioBE = new UsuarioBE();
                    objUsuarioBE.setCodUsuario(rsl.getInt("CodUsuario"));
                    objUsuarioBE.setNombre(rsl.getString("Nombre"));
                    objUsuarioBE.setApellidoMaterno(rsl.getString("ApeMaterno"));
                    objUsuarioBE.setApellidoPaterno(rsl.getString("ApePaterno"));
                    objUsuarioBE.setTelefono(rsl.getString("Telefono"));
                    objUsuarioBE.setNumeroDocumento(rsl.getString("NumeroDocumento"));
                    objUsuarioBE.setDireccion(rsl.getString("Direccion"));
                    objUsuarioBE.setUsuario(rsl.getString("Usr"));
                    objUsuarioBE.setEstado(rsl.getString("Estado"));
                    objUsuarioBE.setCodTipoDocumento(rsl.getInt("CodTipoDocumento"));
                    objUsuarioBE.setCodPerfil(rsl.getInt("CodPerfil"));
                    objUsuarioBE.setCodDistrito(rsl.getInt("CodDistrito"));
                    objUsuarioBE.setCodArea(rsl.getInt("CodArea"));
                    objUsuarioBE.setCodCargo(rsl.getInt("CodCargo"));
                    objUsuarioBE.setSexo(rsl.getString("Sexo").charAt(0));
                    objUsuarioBE.setEmail(rsl.getString("Email"));
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
}
