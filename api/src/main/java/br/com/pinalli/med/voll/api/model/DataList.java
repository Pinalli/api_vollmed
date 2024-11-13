package br.com.pinalli.med.voll.api.model;

public record DataList(
        String nome,
        String email,
        String crm,
        Especialidade especialidade) {

    public DataList(Medico medico) {
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
