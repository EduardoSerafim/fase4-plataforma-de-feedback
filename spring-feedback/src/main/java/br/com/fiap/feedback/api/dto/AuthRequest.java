package br.com.fiap.feedback.api.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthRequest(
        @NotBlank
        String username,

        @NotBlank
        String password) {
}
