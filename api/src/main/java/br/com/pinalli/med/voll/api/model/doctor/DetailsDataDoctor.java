package br.com.pinalli.med.voll.api.model.doctor;

public record DetailsDataDoctor(
        Long id,
        String nome,
        String email,
        String telefone,
        String crm,
        SpecialtyDoctor especialidade,
        AddressDoctor endereco
) {
    public DetailsDataDoctor(Doctor doctor) {
        this(
                doctor.getId(),
                doctor.getNome(),
                doctor.getEmail(),
                doctor.getTelefone(),
                doctor.getCrm(),
                doctor.getEspecialidade(),
                doctor.getEndereco()
        );
    }
}
