package br.com.pinalli.med.voll.api.controller;


import br.com.pinalli.med.voll.api.model.consultation.DataSchedulingConsultation;

import br.com.pinalli.med.voll.api.service.ToScheduleConsultation;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/consultas")
public class ConsultationController {

    @Autowired
    private ToScheduleConsultation toScheduleConsultation;

    @PostMapping
    @Transactional
    public ResponseEntity<Object> toSchedule(@RequestBody @Valid DataSchedulingConsultation data) {
        var dto = toScheduleConsultation.toSchedule(data);
        return ResponseEntity.ok(dto);

    }
}
