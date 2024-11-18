package br.com.pinalli.med.voll.api.model.consultation;


import br.com.pinalli.med.voll.api.model.doctor.Doctor;
import br.com.pinalli.med.voll.api.model.patient.Patient;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "consultas")
@Entity(name = "Consulta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id")
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private Patient patient;

    private LocalDateTime data;

    public Consultation(Object o, Long aLong, @NotNull Long aLong1, @NotNull @Future LocalDateTime data, Object o1) {
    }
}
