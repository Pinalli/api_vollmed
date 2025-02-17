package br.com.pinalli.med.voll.api.model.patient;

import jakarta.validation.constraints.NotNull;


public record DataUpdateRegisterPatient(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DataAddressPatient endereco) {
}
