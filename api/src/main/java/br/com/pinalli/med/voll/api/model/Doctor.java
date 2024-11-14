package br.com.pinalli.med.voll.api.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private SpecialtyDoctor especialidade;

    @Embedded
    private AddressDoctor endereco;

    private boolean active;

    public Doctor(DataRegisterDoctor data) {
        this.active = true;
        this.nome = data.nome();
        this.email= data.email();
        this.telefone = data.telefone();
        this.crm = data.crm();
        this.especialidade = data.especialidade();
        this.endereco = new AddressDoctor(data.endereco());
    }


    public void updateData(@Valid DataUpdateRegisterDoctor update) {
        if(update.nome() != null){
            this.nome = update.nome();
        }
        if(update.telefone() != null){
            this.telefone = update.telefone();
        }
        if(update.endereco() != null){
            this.endereco.updateAddressDoctor(update.endereco());
        }
    }

    public void delete() {
        this.active = false;
    }
}
