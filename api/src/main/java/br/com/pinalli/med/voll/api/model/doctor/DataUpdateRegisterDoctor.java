package br.com.pinalli.med.voll.api.model.doctor;

import jakarta.validation.constraints.NotNull;

public record DataUpdateRegisterDoctor(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DataAddressDoctor endereco) {
}
