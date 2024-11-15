package br.com.pinalli.med.voll.api.controller;


import br.com.pinalli.med.voll.api.model.user.DataAuthentication;
import br.com.pinalli.med.voll.api.model.user.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager manager;

    @PostMapping
    public ResponseEntity<User> login(@RequestBody @Valid DataAuthentication data) {
       var token = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var authentication = manager.authenticate(token);
        return ResponseEntity.ok().build();
    }
}
