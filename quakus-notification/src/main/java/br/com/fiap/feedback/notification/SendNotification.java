package br.com.fiap.feedback.notification;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import javax.print.DocFlavor;

public class SendNotification implements RequestHandler<NotificationDTO, String> {


    @Override
    public String handleRequest(NotificationDTO input, Context context) {
        EmailService service = new EmailService();
        service.send(input);
        return "Email enviado  -> " + input.emailDestinatario();
    }
}
