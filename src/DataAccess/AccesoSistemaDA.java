/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

/**
 *
 * @author Bernabe & tRufA
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

    public UsuarioBE validarCuenta(AccesoSistemaBE objAccesoSistemaBE) {
        UsuarioBE objUsuarioBE = new UsuarioBE();

        try {

            Conexion conexion = new Conexion();
            
            comando = conexion.getConexion().createStatement();

            try {
                String query = "select intcodusuario as codigo, vchusuario as usr, vchpassword as passwd, intcodperfil as codperfil from " + conexion.getStrEsquema() + ".t_usuario where vchusuario = '" + objAccesoSistemaBE.getStrUsuario() + "'; ";
                //String query = "select " + chr + "intcodusuario" +chr+ " as codigo, "+chr+"vchusuario"+chr+" as user, "+chr+"vchpassword"+chr+
                //   " as passwd, "+chr+"intcodperfil"+chr+" as codperfil from "+conexion.getStrEsquema()+".t_usuario where "+chr+"vchusuario"+chr+" = '"+objAccesoSistemaBE.getStrUsuario()+"'; ";

                rs = comando.executeQuery(query);

                if (rs.next()) {
                    objUsuarioBE = setearUsuario(rs, objUsuarioBE);
                }
                rs.close();
                //conexion.conBD.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return objUsuarioBE;
    }

    public UsuarioBE setearUsuario(ResultSet rs, UsuarioBE objUsuarioBE) {
        try {
            objUsuarioBE.setCodUsuario(rs.getInt("codigo"));
            objUsuarioBE.setUsuario(rs.getString("usr"));
            objUsuarioBE.setPassword(rs.getString("passwd"));
            objUsuarioBE.setCodPerfil(rs.getInt("codperfil"));
        } catch (SQLException ex) {
            //Logger.getLogger(AccesoDA.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error en Seteo UsuarioBE. Clase AccesoSistemaAD");
        }
        return objUsuarioBE;
    }
}
