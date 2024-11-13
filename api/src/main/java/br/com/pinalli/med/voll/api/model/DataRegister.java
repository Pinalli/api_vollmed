package br.com.pinalli.med.voll.api.model;

public record DataRegister(String nome , String email, String crm, Especialidade especialidade,
                           DadosEndereco endereco ) {
}
