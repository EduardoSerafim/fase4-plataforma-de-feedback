package br.com.fiap.report;

import br.com.fiap.report.service.FeedbackService;
import io.quarkus.arc.profile.IfBuildProfile;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.annotation.PostConstruct;

@IfBuildProfile("dev")
@ApplicationScoped
public class LocalRunner {

    @Inject
    FeedbackService feedbackService;

    @PostConstruct
    void run() {
        System.out.println("Executando runner local...");
        feedbackService.gerarRelatorioEEnviarEmail();
        System.out.println("Execução local finalizada.");
    }
}
