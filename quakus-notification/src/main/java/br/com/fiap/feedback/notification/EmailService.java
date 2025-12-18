package br.com.fiap.notification;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class EmailService {

    public void send(FeedbackInput dto) throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(
                                "clinicafiap@gmail.com",
                                "zoop xoed phcx xhrm"
                        );
                    }
                });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("notificacao@feedback.com"));
        message.setRecipients(
                Message.RecipientType.TO,
                InternetAddress.parse(dto.emailDestinatario)
        );
        message.setSubject("Feedback urgente");
        message.setText(
                "Curso: " + dto.curso +
                        "\nAvaliação: " + dto.notaAvaliacao +
                        "\nComentário: " + dto.comentario
        );

        Transport.send(message);
    }
}
