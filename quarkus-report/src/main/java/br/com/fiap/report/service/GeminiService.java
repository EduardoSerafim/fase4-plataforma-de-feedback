package br.com.fiap.report.service;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.List;

@ApplicationScoped
public class GeminiService {
    @Inject
    @ConfigProperty(name = "gemini.api.key")
    String geminiApiKey;

    public String resumirComentarios(List<String> comentarios) {
        try {
            String prompt = montarPrompt(comentarios);
            Client client = Client.builder()
                    .apiKey(geminiApiKey)
                    .build();

            GenerateContentResponse response =
                    client.models.generateContent("gemini-2.5-flash", prompt, null);

            return response.text();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao chamar API do Gemini"+ e.getMessage());
        }
    }

    private String montarPrompt(List<String> textos) {
        StringBuilder sb = new StringBuilder();
        sb.append("Gere um resumo curto e objetivo com base nos textos abaixo:\n\n");

        for (int i = 0; i < textos.size(); i++) {
            sb.append("Texto ").append(i + 1).append(": ").append(textos.get(i)).append("\n");
        }

        return sb.toString();
    }
}
