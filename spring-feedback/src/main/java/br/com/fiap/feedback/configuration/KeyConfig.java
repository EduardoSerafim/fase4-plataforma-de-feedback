package br.com.fiap.feedback.configuration;

import br.com.fiap.feedback.infrastructure.certificate.PemUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.Key;

@Configuration
public class KeyConfig {
    @Bean
    public Key jwtSigningKey(
            @Value("${jwt.private-key-base64}") String base64Key
    ) {
        return PemUtils.loadPrivateKeyFromBase64(base64Key);
    }
}
