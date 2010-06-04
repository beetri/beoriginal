/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 package GUI.Principal;
 import java.util.Properties;

 import javax.mail.*;
 import javax.mail.internet.*;

/**
 *
 * @author tRufA
 */

 public class EnvioContrasenha {
 final static String CONFIG_FILE = "mail.props";
 static String sServidorCorreo;
 static String sCorreoOrigen;
 static String[] asCorreoDestino;

    /**
     * Método para inicializar los valores del seridor de correo,
     * se cargan desde un fichero de configuración con los siguientes valores:
     * app.servidorCorreo=smtp.xxxx
     * app.correoOrigen=origenxxx@xxx.com
     * app.correoDestino=dst1@xxx.com,dst2@xxx.com,...,dstn@xxx.com
     */
    public static void enviarCorreo (String correoDestino, String contrasenha) throws AddressException, MessagingException {
        Properties props = new Properties();

        // Nombre del host de correo, es smtp.gmail.com
        props.setProperty("mail.smtp.host", "smtp.gmail.com");

        // TLS si está disponible
        props.setProperty("mail.smtp.starttls.enable", "true");

        // Puerto de gmail para envio de correos
        props.setProperty("mail.smtp.port","587");

        // Nombre del usuario que envia el correo
        props.setProperty("mail.smtp.user", "DP1.BeOriginal@gmail.com");

        // Si requiere o no usuario y password para conectarse.
        props.setProperty("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);

        // Para obtener un log de salida más extenso
        session.setDebug(true);

        /*texto normalito no ma*/
        MimeMessage message = new MimeMessage(session);

        // Quien envia el correo
        message.setFrom(new InternetAddress("DP1.BeOriginal@gmail.com"));

        // A quien va dirigido
        //message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoDestino));
        message.addRecipient(Message.RecipientType.TO,new InternetAddress(correoDestino));
        message.setSubject("[BeOriginal] Nueva Contraseña");
        String texto= "Su nueva contraseña de acceso al sistema es: ";
        texto+= contrasenha;
        message.setText(texto);

/*enviar mensaje*/
        Transport t = session.getTransport("smtp");

        // Aqui usuario y password de gmail
        t.connect("DP1.BeOriginal","JustDoIt");
        t.sendMessage(message,message.getAllRecipients());
        t.close();

    }
}
