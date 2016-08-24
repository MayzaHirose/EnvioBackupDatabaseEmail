/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.mhcs.backupmail.envioemail;

import br.com.mhcs.backupmail.util.Utilities;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

/**
 *
 * @author MayzaHirose
 */
public class EnvioEmail {
    static LocalDateTime now = LocalDateTime.now();
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    static String date = now.format(formatter);

    public static void sendEmail() throws EmailException {
        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath(Utilities.createPath + "backup" + date + ".sql"); 
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setName("backup" + date + ".sql");
        
        // Cria a mensagem de e-mail.
        MultiPartEmail email = new MultiPartEmail();
        email.setHostName(Utilities.gmailHostName); // o servidor SMTP para envio do e-mail
        email.setSmtpPort(465);
        email.addTo(Utilities.recipient); //destinatario
        email.addTo(Utilities.recipient2);
        email.setSSL(true);
        email.setAuthentication(Utilities.sender, Utilities.senderAuth);
        email.setFrom(Utilities.sender, Utilities.senderName); //remetente
        email.setSubject(Utilities.subject); //Assunto     
        email.attach(attachment); // adiciona o anexo à mensagem
        email.send();// envia o e-mail
    }
}
