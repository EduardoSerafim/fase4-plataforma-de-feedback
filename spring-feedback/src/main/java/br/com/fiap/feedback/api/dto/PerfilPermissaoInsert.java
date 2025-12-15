package br.com.fiap.feedback.api.dto;

public record PerfilPermissaoInsert(
        String recurso,
        Boolean view,
        Boolean insert,
        Boolean update,
        Boolean delete) {
}
