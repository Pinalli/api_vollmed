package br.com.pinalli.med.voll.api.model.user;

import jakarta.validation.constraints.NotBlank;

//DTO
public record DataAuthentication(
        @NotBlank(message = "O login não pode estar vazio.") String login,
        @NotBlank(message = "A senha não pode estar vazia.") String senha
) {
}
