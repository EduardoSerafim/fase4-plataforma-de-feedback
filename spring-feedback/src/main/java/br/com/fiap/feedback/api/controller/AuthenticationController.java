package br.com.fiap.feedback.api.controller;

import br.com.fiap.feedback.api.doc.AuthenticationDocControler;
import br.com.fiap.feedback.api.dto.AuthRequest;
import br.com.fiap.feedback.api.dto.AuthResponse;
import br.com.fiap.feedback.application.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController implements AuthenticationDocControler {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> authenticate(@RequestBody @Valid AuthRequest authRequest) {
        var token = authenticationService.authenticate(authRequest.username(), authRequest.password());
        return ResponseEntity.ok(new AuthResponse(token));
    }

    @Override
    @PostMapping("/validar-token")
    public ResponseEntity<String> validarToken(@RequestHeader String authorization) {
//        authenticationService.validarToken(authorization);
        return ResponseEntity.ok("Token recebido: " + authorization);
    }

}
