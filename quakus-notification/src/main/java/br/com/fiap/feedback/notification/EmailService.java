package br.com.fiap.feedback.notification;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class EmailService {

    @Inject
    Mailer mailer;//erro null pointer

    public void send(NotificationDTO dto)   {
       String body =  "Curso: " + dto.curso() +
                "\nAvaliação: " + dto.notaAvaliacao() +
                "\nComentário: " + dto.comentario();

       //Mail message =
        mailer.send(Mail.withText(dto.emailDestinatario(),"Noticia urgente - quarkus", body));
    }
}
