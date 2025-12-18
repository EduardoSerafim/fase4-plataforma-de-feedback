package br.com.fiap.feedback.application.service;

import br.com.fiap.feedback.api.dto.FeedbackLambdaInput;
import br.com.fiap.gh.jpa.entities.FeedbackEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {

    private final RestTemplate restTemplate = new RestTemplate();

    private final String servelessFunctionNotification = "https://gfxs3x7yytoc3zysfgoo7rhdhy0fpczu.lambda-url.us-east-1.on.aws/";
//            System.getenv( "AWS_LAMBDA_NOTIFICATION_URL");

    public NotificationService() {
    }

    public void sendNewNotificationWhenUrgent(FeedbackEntity feedback) {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
//        AuthenticationService
//                headers.set("x-api-key", apiKey)//bearer

                var input = FeedbackLambdaInput.create(feedback);

                HttpEntity<FeedbackLambdaInput> requestContent =
                        new HttpEntity<>(input, headers);

                try {

                    restTemplate.postForObject(
                            servelessFunctionNotification,
                            requestContent,
                            String.class
                    );

                } catch (RestClientException ex) {
                    // Loga e segue o fluxo — notificação não pode quebrar o sistema
                    System.out.println("Erro ao chamar Lambda de notificação "+ ex.getMessage());
                }
            }
        }

