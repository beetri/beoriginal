/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import com.thoughtworks.xstream.XStream;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


/**
 *
 * @author tRufA
 */
public class Conexion {

    private static Conexion objconexion;
    private Connection conexion;
    private String strDriver,  strServidor,  strPuerto,  strNombreBD,  strEsquema,  strUsuario,  strPassword;

    public static Conexion getInstancia() {
        if (objconexion == null) {
            objconexion = new Conexion();
        }
        return objconexion;
    }

    public Connection getConexion() {

        if (conexion == null) {

            ArchivoConexionBD archivoConexionBD = new ArchivoConexionBD();
            try {

                XStream xs = new XStream();
                configureXStream(xs);
                FileReader fr = new FileReader("configuracionBD.xml");
                archivoConexionBD = (ArchivoConexionBD) xs.fromXML(fr);
                fr.close();
                strDriver = archivoConexionBD.getDriver();
                strServidor = archivoConexionBD.getServidor();
                strPuerto = archivoConexionBD.getPuerto();
                strNombreBD = archivoConexionBD.getBasedatos();
                setStrEsquema(archivoConexionBD.getEsquema());
                strUsuario = archivoConexionBD.getUsuario();
                strPassword = archivoConexionBD.getPassword();

                String connectString = "jdbc:postgresql://" + strServidor + ":" + strPuerto + "/" + strNombreBD;//+" ["+usuario+" on "+esquema+"]";
                Class.forName(strDriver);
                conexion = DriverManager.getConnection(connectString, strUsuario, strPassword);

            } catch (Exception er) {
                JOptionPane.showMessageDialog(null, "No se ha podido cargar el archivo!!", "", JOptionPane.ERROR_MESSAGE);
            }

        }

        return conexion;

    }

    public boolean CerrarConexion() {
        try {
            if(conexion != null){
                conexion.close();
                conexion = null;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexion de la BD");
            return false;
        }
        return true;
    }

    private static void configureXStream(XStream xs) {
        xs.alias("ArchivoConexionBD", ArchivoConexionBD.class);
    }

    /**
     * @return the strEsquema
     */
    public String getStrEsquema() {
        return strEsquema;
    }

    /**
     * @param strEsquema the strEsquema to set
     */
    public void setStrEsquema(String strEsquema) {
        this.strEsquema = strEsquema;
    }
}
class ArchivoConexionBD {

    private String driver;
    private String servidor;
    private String puerto;
    private String basedatos;
    private String esquema;
    private String usuario;
    private String password;

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public String getBasedatos() {
        return basedatos;
    }

    public void setBasedatos(String basedatos) {
        this.basedatos = basedatos;
    }

    public String getEsquema() {
        return esquema;
    }

    public void setEsquema(String esquema) {
        this.esquema = esquema;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}