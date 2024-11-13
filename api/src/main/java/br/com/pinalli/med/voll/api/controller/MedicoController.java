package br.com.pinalli.med.voll.api.controller;


import br.com.pinalli.med.voll.api.medico.DataRegister;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @PostMapping
    public void register(@RequestBody DataRegister data){

    }
}
