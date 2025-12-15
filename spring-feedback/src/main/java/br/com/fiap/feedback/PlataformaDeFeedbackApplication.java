package br.com.fiap.feedback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.fiap.gh", "br.com.fiap.feedback"})
@EntityScan(basePackages = {"br.com.fiap.gh.jpa.entities"})
@EnableJpaRepositories(basePackages = {"br.com.fiap.gh.jpa.repositories","br.com.fiap.feedback.infrastructure.repository"})
public class PlataformaDeFeedbackApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlataformaDeFeedbackApplication.class, args);
	}

}
