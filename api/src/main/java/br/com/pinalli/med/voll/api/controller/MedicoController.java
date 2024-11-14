package br.com.pinalli.med.voll.api.controller;

import br.com.pinalli.med.voll.api.model.DataList;
import br.com.pinalli.med.voll.api.model.DataRegister;
import br.com.pinalli.med.voll.api.model.Medico;
import br.com.pinalli.med.voll.api.repository.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    private final MedicoRepository repository;

    public MedicoController(MedicoRepository medicoRepository) {
        this.repository = medicoRepository;
    }

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid DataRegister data){
        repository.save(new Medico(data));
    }

    @GetMapping
    public Page<DataList> list(Pageable pagination){
        return repository.findAll(pagination).map(DataList::new);
    }
}
