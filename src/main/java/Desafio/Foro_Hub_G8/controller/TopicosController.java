package Desafio.Foro_Hub_G8.controller;

import Desafio.Foro_Hub_G8.dto.DatosCreacionTopico;
import Desafio.Foro_Hub_G8.model.Topico;
import Desafio.Foro_Hub_G8.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    private final TopicoService topicoService;

    // Inyección por constructor (mejor para pruebas y buenas prácticas)
    public TopicosController(TopicoService topicoService) {
        this.topicoService = topicoService;
    }

    @PostMapping
    public ResponseEntity<Topico> crearTopico(@RequestBody @Valid DatosCreacionTopico datos) {
        Topico topicoCreado = topicoService.crearTopico(datos);
        return ResponseEntity
                .status(201) // Código HTTP 201 Created
                .body(topicoCreado);
    }
}

