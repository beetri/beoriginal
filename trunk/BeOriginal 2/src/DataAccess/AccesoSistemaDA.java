/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;

/**
 *
 * @author Administador
 */
import BusinessEntity.AccesoSistemaBE;
import BusinessEntity.UsuarioBE;
import Conexion.*;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AccesoSistemaDA {
   ResultSet rs;
         char chr = 34;
         java.sql.Statement comando;


    public UsuarioBE validarCuenta(AccesoSistemaBE objAccesoBE){
        UsuarioBE objUsuarioBE = new UsuarioBE();

        try {

                Conexion conexion = new Conexion();
                //ConexionLocal conexion = new ConexionLocal();

                //comando =  conexion.conBD.createStatement();
                comando=conexion.getConexion().createStatement();

                try {

                        //String query = "select codusuario as codigo, usr as user, pwd as passwd from public.Usuario ";
                        String query = "select "+chr+"codusuario"
                                +chr+" as codigo, "+chr+"usr"+chr+" as user, "+chr+"pwd"+chr+
                                        " as passwd, "+chr+"codperfil"+chr+" as codperfil from "+conexion.getStrEsquema()+".Usuario where "+chr+"usr"+chr+" = '"+objAccesoBE.getStrUsuario()+"'; ";

                         rs = comando.executeQuery(query);
                       
                        if ( rs.next()){
                          objUsuarioBE = setearUsuario(rs,objUsuarioBE);
                        }
                        rs.close();
                        //conexion.conBD.close();
                    }
                    catch( Exception e ){
                    System.out.println(e.getMessage());
                     }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return objUsuarioBE;
    }

    public UsuarioBE setearUsuario(ResultSet rs,UsuarioBE objUsuarioBE)
    {   try {

            objUsuarioBE.setCodUsuario(rs.getInt("codigo"));
            objUsuarioBE.setUsuario(rs.getString("user"));
            objUsuarioBE.setPassword(rs.getString("passwd"));
            objUsuarioBE.setCodPerfil(rs.getInt("codperfil"));


            } catch (SQLException ex) {
            //Logger.getLogger(AccesoDA.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error Seteo");
        }
        return objUsuarioBE;
    }

}
