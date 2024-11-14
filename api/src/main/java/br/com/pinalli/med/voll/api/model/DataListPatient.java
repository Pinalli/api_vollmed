package br.com.pinalli.med.voll.api.model;

public record DataListPatient(Long id, String nome, String email, String cpf) {

    public DataListPatient(Patient patient) {
        this(patient.getId(), patient.getNome(), patient.getEmail(), patient.getCpf());
    }

}
