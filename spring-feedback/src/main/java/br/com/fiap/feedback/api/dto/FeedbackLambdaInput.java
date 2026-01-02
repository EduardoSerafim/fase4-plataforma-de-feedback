package br.com.fiap.feedback.api.dto;

import br.com.fiap.gh.jpa.entities.FeedbackEntity;

import java.time.LocalDateTime;

public class FeedbackLambdaInput {

    public Long feedbackId;

    public String disciplina;
    public String aluno;
    public Integer notaAvaliacao;
    public LocalDateTime dataAvalicacao;
    public String comentario;
    public String emailDestinatario;

    public static FeedbackLambdaInput create(FeedbackEntity entity) {

        return new FeedbackLambdaInput(entity.getId(), entity.getDisciplina(),
                entity.getAluno().getNome(), entity.getNota(), entity.getDataEnvio(),
                entity.getDescricao(), entity.getProfessor().getEmail());
    }

    public FeedbackLambdaInput(Long feedbackId, String disciplina, String aluno, Integer notaAvaliacao, LocalDateTime dataAvalicacao, String comentario, String emailDestinatario) {
        this.feedbackId = feedbackId;
        this.disciplina = disciplina;
        this.aluno = aluno;
        this.notaAvaliacao = notaAvaliacao;
        this.dataAvalicacao = dataAvalicacao;
        this.comentario = comentario;
        this.emailDestinatario = emailDestinatario;
    }
}
