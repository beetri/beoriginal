/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessLogic;

import BusinessEntity.UsuarioBE;
import DataAccess.UsuarioDA;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Bernabe
 */
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
    public boolean modificarUsuario(UsuarioBE objUsuario,int idUsuarioLogueado){
        objUsuarioDA = new UsuarioDA();
        try{
            return objUsuarioDA.modificarUsuario(objUsuario,idUsuarioLogueado);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }

    }
        public boolean modificarUsuarioCambiarClave(UsuarioBE objUsuario){
        objUsuarioDA = new UsuarioDA();
        System.out.printf("paso2");
        try{
            System.out.printf("paso3");
            return objUsuarioDA.modificarUsuarioCambiarClave(objUsuario);
        }catch(Exception e){
            System.out.printf("paso4");
            System.out.println(e.getMessage());
            return false;
        }

    }
    public boolean eliminarUsuario(UsuarioBE objUsuario,int idUsuarioLogueado){
        objUsuarioDA = new UsuarioDA();
        try{
            return objUsuarioDA.eliminarUsuario(objUsuario,idUsuarioLogueado);
        }catch(Exception e){
            System.out.println(e.getMessage());
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

    public ArrayList<UsuarioBE> listarUsuario(UsuarioBE objUsuario){
        objUsuarioDA = new UsuarioDA();
        try{
            return objUsuarioDA.buscarUsuarios(objUsuario);
        }catch(Exception e){
            System.out.println("Ocurrio una Excepciòn"+e.getMessage());
            return null;
        }
    }
    public int obtenerIdUsuario(){
        objUsuarioDA = new UsuarioDA();
        try{
            return objUsuarioDA.buscarUsuarioIDMax();
        }catch(Exception e){
            System.out.println("Ocurrio una Excepciòn"+e.getMessage());
            return -1;
        }
    }

}
