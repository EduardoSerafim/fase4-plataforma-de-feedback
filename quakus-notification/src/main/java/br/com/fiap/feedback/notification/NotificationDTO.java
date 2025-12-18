package br.com.fiap.feedback.notification;

import java.time.LocalDateTime;

public record NotificationDTO(
        Long feedbackId,
         String curso,
         String aluno,
         Integer notaAvaliacao,
         LocalDateTime dataAvalicacao,
         String comentario,
         String emailDestinatario) {
}
