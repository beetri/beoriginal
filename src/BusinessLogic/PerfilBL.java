/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessLogic;

import BusinessEntity.PerfilBE;
import BusinessEntity.UsuarioBE;
import DataAccess.PerfilDA;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;


/**
 *
 * @author Bernabe
 */
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
//    public boolean modificarPerfil(PerfilBE objPerfil,int [] arre,int idUsuarioBE ){
    public boolean modificarPerfil(PerfilBE objPerfil,int [] arre, int codPerfil){
        objPerfilDA = new PerfilDA();
        try{
//            return objPerfilDA.modificarPerfil(objPerfil,arre, idUsuarioBE);
            return objPerfilDA.modificarPerfil(objPerfil,arre,codPerfil);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }

    }
    public boolean eliminarperfil(PerfilBE objPerfil,int idUsuarioBE ){
        objPerfilDA = new PerfilDA();
        try{
            return objPerfilDA.eliminarPerfil(objPerfil,idUsuarioBE);
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
public List<PerfilBE> buscarPerfiles1(PerfilBE objPerfil,Date s1, Date s2 ){
        objPerfilDA = new PerfilDA();
        try{
            return objPerfilDA.buscarperfiles1(objPerfil,s1,s2);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

     public List<PerfilBE> buscarPerfiles2(int idFuncionalidad){
        objPerfilDA = new PerfilDA();
        try{
            return objPerfilDA.buscarperfiles2( idFuncionalidad);
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
     public ArrayList<PerfilBE> listarPerfil(PerfilBE objPerfil){
        objPerfilDA = new PerfilDA();
        try{
            return objPerfilDA.buscarperfiles(objPerfil);
        }catch(Exception e){
            System.out.println("Ocurrio una Excepciòn"+e.getMessage());
            return null;
        }
    }
     public ArrayList<PerfilBE> listarPerfilModulo(PerfilBE objPerfil,String Modulo){
        objPerfilDA = new PerfilDA();
        try{
            return objPerfilDA.buscarperfilesModulo(objPerfil,Modulo);
        }catch(Exception e){
            System.out.println("Ocurrio una Excepciòn"+e.getMessage());
            return null;
        }
    }

}
