package br.com.pinalli.med.voll.api.controller;

import br.com.pinalli.med.voll.api.model.DataRegister;
import br.com.pinalli.med.voll.api.model.Medico;
import br.com.pinalli.med.voll.api.repository.MedicoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    private final MedicoRepository repository;

    public MedicoController(MedicoRepository medicoRepository) {
        this.repository = medicoRepository;
    }

    @PostMapping
    public void register(@RequestBody DataRegister data){
        repository.save(new Medico(data));
    }
}
