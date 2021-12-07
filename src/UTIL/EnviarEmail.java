/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UTIL;

import javax.swing.JOptionPane;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author mardio
 */
public class EnviarEmail {
//Bibliotecas
// commons-email-1.5.jar
//mail-1.4.7.jar

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

    }

    public void enviarEmail(String Mensagem) {
        String meuEmail = "mardiodev@vivaldi.net";
        String minhaSenha = "twsbatwsba@1978";

        SimpleEmail email = new SimpleEmail();
        email.setHostName("smtp.vivaldi.net");
        email.setSmtpPort(587);
        email.setAuthenticator(new DefaultAuthenticator(meuEmail, minhaSenha));
        email.setSSLOnConnect(true);

        try {
            email.setFrom(meuEmail);
            email.setSubject("Help Controle de Sistema");
            email.setMsg(Mensagem);
            email.addTo(meuEmail);
            email.send();
            JOptionPane.showMessageDialog(null, "Email enviado com Sucesso!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
