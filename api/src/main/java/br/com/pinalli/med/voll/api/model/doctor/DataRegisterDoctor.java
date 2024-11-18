package br.com.pinalli.med.voll.api.model.doctor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


public record DataRegisterDoctor(


        @NotBlank
        String nome ,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefone,

        @NotBlank
        @Pattern(regexp="\\d{4,6}")
        String crm,

        @NotNull
        SpecialtyDoctor especialidade,

        @NotNull
        @Valid
        DataAddressDoctor endereco ) {
}
