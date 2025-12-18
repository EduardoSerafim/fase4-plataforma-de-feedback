package br.com.fiap.notification;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 * https://docs.aws.amazon.com/lambda/latest/dg/java-handler.html
 *
 */
public class NotificationHandler {

    private final ObjectMapper mapper = new ObjectMapper();
    private final EmailService emailService = new EmailService();


    public APIGatewayProxyResponseEvent handleRequest(
            APIGatewayProxyRequestEvent event,
            Context context) {

        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        try {
            FeedbackInput inputDTO =
                    mapper.readValue(event.getBody(), FeedbackInput.class);

            System.out.println("chegou - " + inputDTO.emailDestinatario);

            emailService.send(inputDTO);

            return new APIGatewayProxyResponseEvent()
                    .withStatusCode(200)
                    .withBody("OK");

        } catch (Exception e) {
            e.printStackTrace();

            return new APIGatewayProxyResponseEvent()
                    .withStatusCode(500)
                    .withBody("Erro");
        }
    }
}
