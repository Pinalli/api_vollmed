package br.com.pinalli.med.voll.api.model;

import jakarta.validation.constraints.NotNull;


public record DataUpdatePatient(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DataAddressPatient endereco) {
}
