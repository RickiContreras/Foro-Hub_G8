package Desafio.Foro_Hub_G8.controller;

import Desafio.Foro_Hub_G8.topicos.DatosCreacionTopico;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    @PostMapping
    public void crearTopico (@RequestBody DatosCreacionTopico datos){



    }

}
