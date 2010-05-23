/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessLogic;

import BusinessEntity.*;
import DataAccess.*;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Date;
import java.util.List;
/**
 *
 * @author Administador
 */
public class LogUsuarioBL {
 private LogUsuarioDA objLogUsuarioDA;
public boolean registrarLog(LogUsuarioBE objLogUsuario){
        objLogUsuarioDA = new LogUsuarioDA();

        try{
            Date fechaActual= new Date();


            // obtenemos la IP
            objLogUsuario.setIP(java.net.InetAddress.getLocalHost().getHostAddress());
            // ahora obtenemos la MAC
            InetAddress address=InetAddress.getByName(objLogUsuario.getIP());
            NetworkInterface ni = NetworkInterface.getByInetAddress(address);
            byte[] mac1 =ni.getHardwareAddress();
            String mac ="";
            for (int i=0; i<mac1.length;i++){
                if (i>0){
                    mac+=mac1[i]&0xFF;
                }
            }
            objLogUsuario.setMAC(mac);
            objLogUsuario.setFechaIngreso(fechaActual);
            objLogUsuario.setFechaSalida(fechaActual);
            //objLogUsuario.set(objEstadoBE);
            return objLogUsuarioDA.registrarLog(objLogUsuario);


        }
        catch (Exception ex){
            return false;
        }

    }
    public int obtenerIdLog(){
        objLogUsuarioDA = new LogUsuarioDA();
        try{
            return objLogUsuarioDA.retornarID();
        }catch(Exception e){
            System.out.println("Ocurrio una Excepciòn"+e.getMessage());
            return -1;
        }
    }
}
