package Desafio.Foro_Hub_G8.controller;

import Desafio.Foro_Hub_G8.dto.DatosAutenticacion;
import Desafio.Foro_Hub_G8.model.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final AuthenticationManager authenticationManager;

    public LoginController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody DatosAutenticacion datosAutenticacion) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(datosAutenticacion.email(),
                datosAutenticacion.clave());
        authenticationManager.authenticate(authToken);
        return ResponseEntity.ok("Usuario autenticado correctamente");
    }
}