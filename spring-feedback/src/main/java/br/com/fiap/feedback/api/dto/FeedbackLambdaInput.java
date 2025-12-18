package br.com.fiap.feedback.api.dto;

import br.com.fiap.gh.jpa.entities.FeedbackEntity;

import java.time.LocalDateTime;

public class FeedbackLambdaInput {

    public Long feedbackId;

    public String curso;
    public String aluno;
    public Integer notaAvaliacao;
    public LocalDateTime dataAvalicacao;
    public String comentario;
    public String emailDestinatario;

    public static FeedbackLambdaInput create(FeedbackEntity entity) {

        return new FeedbackLambdaInput(entity.getId(), "curso da avaliação",
                entity.getUsuario().getNome(), entity.getNota(), entity.getDataEnvio(),
                entity.getDescricao(), "schn.alessandro@gmail.com");
    }

    public FeedbackLambdaInput(Long feedbackId, String curso, String aluno, Integer notaAvaliacao, LocalDateTime dataAvalicacao, String comentario, String emailDestinatario) {
        this.feedbackId = feedbackId;
        this.curso = curso;
        this.aluno = aluno;
        this.notaAvaliacao = notaAvaliacao;
        this.dataAvalicacao = dataAvalicacao;
        this.comentario = comentario;
        this.emailDestinatario = emailDestinatario;
    }
}
