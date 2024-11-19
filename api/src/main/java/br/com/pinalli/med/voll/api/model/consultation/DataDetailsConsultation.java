package br.com.pinalli.med.voll.api.model.consultation;

import java.time.LocalDateTime;

public record  DataDetailsConsultation (Long id, Long idDoctor, Long idPatient, LocalDateTime data){

    public DataDetailsConsultation(Consultation consultation){
        this(consultation.getId(), consultation.getDoctor().getId(), consultation.getPatient().getId(),
                consultation.getData());
    }
}
