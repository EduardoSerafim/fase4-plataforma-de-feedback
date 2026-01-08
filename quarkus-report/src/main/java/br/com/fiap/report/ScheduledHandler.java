package br.com.fiap.report;

import br.com.fiap.report.service.FeedbackService;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.Map;
import jakarta.inject.Inject;

public class ScheduledHandler
        implements RequestHandler<Map<String, Object>, String> {

    @Inject
    FeedbackService feedbackService;

    @Override
    public String handleRequest(Map<String, Object> event, Context context) {
        feedbackService.gerarRelatorioEEnviarEmail();
        return "Notificações via e-mail enviadas com sucesso!";
    }
}