package br.com.pinalli.med.voll.api.medico;

import br.com.pinalli.med.voll.api.endereco.DadosEndereco;

public record DataRegister(String nome , String email, String crm, Especialidade especialidade,
                           DadosEndereco endereco ) {
}
