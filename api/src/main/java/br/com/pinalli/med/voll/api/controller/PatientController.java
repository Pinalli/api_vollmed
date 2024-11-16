package br.com.pinalli.med.voll.api.controller;
import br.com.pinalli.med.voll.api.model.DataListPatient;
import br.com.pinalli.med.voll.api.model.DataRegisterPatient;
import br.com.pinalli.med.voll.api.model.DataUpdateRegisterPatient;
import br.com.pinalli.med.voll.api.model.Patient;
import br.com.pinalli.med.voll.api.repository.PatitentRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PatientController {

    @Autowired
    private final PatitentRepository repository;


    public PatientController(PatitentRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid DataRegisterPatient data) {
        repository.save(new Patient(data));
    }

    @GetMapping
    public Page<DataListPatient> list(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DataListPatient::new);
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid DataUpdateRegisterPatient dados) {
        var patient = repository.getReferenceById(dados.id());
        patient.updateData(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        var patient = repository.getReferenceById(id);
        patient.delete();
    }


}
