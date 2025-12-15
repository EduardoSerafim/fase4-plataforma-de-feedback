package br.com.fiap.feedback.infrastructure.repository;

import br.com.fiap.gh.jpa.entities.FeedbackEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface FeedbackRepository extends JpaRepository<FeedbackEntity, Long> {

    List<FeedbackEntity> findByUrgencia(String urgencia);

    List<FeedbackEntity> findByDataEnvioBetween(LocalDateTime inicio, LocalDateTime fim);
}
