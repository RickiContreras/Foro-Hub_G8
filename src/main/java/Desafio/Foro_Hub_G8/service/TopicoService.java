package Desafio.Foro_Hub_G8.service;

import Desafio.Foro_Hub_G8.dto.DatosCreacionTopico;
import Desafio.Foro_Hub_G8.model.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TopicoService {
    Topico crearTopico(DatosCreacionTopico datos);
    Page<Topico> obtenerTodosLosTopicos(Pageable paginacion);
    Topico obtenerTopicoPorId(Long id);
    Topico actualizarTopico(Long id, DatosCreacionTopico datos);
    void eliminarTopico(Long id);
}