package Desafio.Foro_Hub_G8.service;

import Desafio.Foro_Hub_G8.dto.DatosCreacionTopico;
import Desafio.Foro_Hub_G8.model.Topico;

public interface TopicoService {
    Topico crearTopico(DatosCreacionTopico datos);
}

