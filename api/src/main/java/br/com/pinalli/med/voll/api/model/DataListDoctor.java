package br.com.pinalli.med.voll.api.model;

public record DataListDoctor(
        Long id,
        String nome,
        String email,
        String crm,
        SpecialtyDoctor especialidade) {

    public DataListDoctor(Doctor medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
