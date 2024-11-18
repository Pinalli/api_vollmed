package br.com.pinalli.med.voll.api.model.consultation;

import br.com.pinalli.med.voll.api.model.doctor.SpecialtyDoctor;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
                                //DTO
public record  DataSchedulingConsultation(

    Long idDoctor,

    @NotNull
    Long idPatient,

    @NotNull
    @Future
    LocalDateTime data,

    SpecialtyDoctor specialtyDoctor){

    }

