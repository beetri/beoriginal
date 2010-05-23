/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessLogic;

/**
 *
 * @author Administador
 */
import BusinessEntity.UsuarioBE;
import DataAccess.UsuarioDA;
import java.io.IOException;
import java.util.ArrayList;

public class UsuarioBL {
    private UsuarioDA objUsuarioDA;
    public boolean registrarUsuario(UsuarioBE objUsuario,int idUsuarioLogueado){
        objUsuarioDA = new UsuarioDA();
        try{
            return objUsuarioDA.registrarUsuario(objUsuario,idUsuarioLogueado);
        }catch(Exception e){
            System.out.println("Ocurrio una Excepcion en UsuarioBL"+e.getMessage());
            return false;
        }
    }
  public UsuarioBE buscarUsuarioInt(int filtroEntero){//puede idusuario
        objUsuarioDA = new UsuarioDA();
        try{
            return objUsuarioDA.buscarUsuarioInt(filtroEntero);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }
}

