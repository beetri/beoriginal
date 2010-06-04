/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessLogic;

import BusinessEntity.*;
import DataAccess.*;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.URL;
import java.util.Date;
import java.util.List;
/**
 *
 * @author Bernabe Yanac
 */
public class LogUsuarioBL {
    private LogUsuarioDA objLogUsuarioDA;
public boolean registrarLog(LogUsuarioBE objLogUsuario){
        objLogUsuarioDA = new LogUsuarioDA();

        try{
            Date fechaActual= new Date();

            // Probamos una conexion para obtener la verdadera IP y no el localhost
            URL url = new URL("http://www.pucp.edu.pe");
            String host = url.getHost();
            Socket socket = new Socket(host, 80);

            //Obtenemos la IP del usuario
            InetAddress DireccionIP = socket.getLocalAddress();
  
            // Asignamos la direccion IP del usuario
            objLogUsuario.setIP(DireccionIP.toString());
            NetworkInterface ni = NetworkInterface.getByInetAddress(DireccionIP);

            // Obtenemos la MAC del usuario
            byte[] Aux_MAC =ni.getHardwareAddress();
            String MAC ="";
            for (int i=0; i<Aux_MAC.length;i++){
                if (i>0){
                    MAC+=Aux_MAC[i]&0xFF;
                }
            }

            // Asignamos la direccion MAC del usuario
            objLogUsuario.setMAC(MAC);
            objLogUsuario.setFechaIngreso(fechaActual);
            objLogUsuario.setFechaSalida(fechaActual);
            //objLogUsuario.set(objEstadoBE);
            return objLogUsuarioDA.registrarLog(objLogUsuario);


        }
        catch (Exception ex){
            return false;
        }

    }

    public List<LogUsuarioBE> buscarLogs(LogUsuarioBE objLogUsuarioAuxBE){
        objLogUsuarioDA = new LogUsuarioDA();
        try {
              return objLogUsuarioDA.buscarLogs(objLogUsuarioAuxBE);
        }
        catch(Exception exc) {
            return null;
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
