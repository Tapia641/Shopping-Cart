/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.util.*; 
import javax.*; 
import javax.activation.*;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
/**
 *
 * @author Tapia
 */
public class FinalizarControlador implements Initializable {
    public static String Username = "";
    public static String PassWord = "";
    String Mensage = "";
    String To = "";
    String Subject = "";
    @FXML 
    private TextField Nombre;
    
    @FXML 
    private TextField Direccion;
    
    @FXML 
    private TextField Correo;
    
    @FXML 
    private TextField Telefono;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    
    
    @FXML
    public void ClickFinalizar(javafx.scene.input.MouseEvent event) {
	//Pon tu contrasenia y correo
        Username = "correo";
        PassWord = "contrasenia";
        Mensage += "¡Hola! " + Nombre.getText() + " gracias por comprar con nostros, te estaremos informando sobre tu pedido, con un numero de rastreo ... \n\n\n\n\n\n\n" + Direccion.getText()+ "\n" +  Telefono.getText() ;
        To += Correo.getText();
        Subject += "Detalles de tu compra :)";
        
        SendMail();
        System.out.println("Sen envió");
        /*Enviamos por correo*/
    }

    


 public void SendMail() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
 
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(Username, PassWord);
                    }
                });
 
        try {
 
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(Username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(To));
            message.setSubject(Subject);
            message.setText(Mensage);
 
            Transport.send(message);
            JOptionPane.showMessageDialog(null, "Su mensaje ha sido enviado");
 
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
