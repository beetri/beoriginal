/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessLogic;

/**
 *
 * @author Administador
 */
import BusinessEntity.PerfilBE;
import BusinessEntity.UsuarioBE;
import DataAccess.PerfilDA;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class PerfilBL {
        private PerfilDA objPerfilDA;

//    public boolean registrarPerfil(PerfilBE objPerfil, int [] arre, int idUsuario){
    public boolean registrarPerfil(PerfilBE objPerfil, int [] arre){
        objPerfilDA = new PerfilDA();
        try{
//            return objPerfilDA.registrarPerfil(objPerfil,arre,idUsuario);
            return objPerfilDA.registrarPerfil(objPerfil,arre);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public PerfilBE buscarPerfil(int idPerfil){
        objPerfilDA = new PerfilDA();
        try{
            return objPerfilDA.buscarPerfil(idPerfil);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }
    public List<PerfilBE> buscarPerfiles(PerfilBE objPerfil ){
        objPerfilDA = new PerfilDA();
        try{
            return objPerfilDA.buscarperfiles(objPerfil);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public PerfilBE buscarPerfilNombre(String strNombre){
        objPerfilDA = new PerfilDA();
        try{
            return objPerfilDA.buscarPerfilNombre(strNombre);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }


}
