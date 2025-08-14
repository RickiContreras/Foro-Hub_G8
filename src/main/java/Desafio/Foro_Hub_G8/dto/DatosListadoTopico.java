package Desafio.Foro_Hub_G8.dto;

import Desafio.Foro_Hub_G8.model.Topico;
import java.time.LocalDateTime;

// DTO para representar los datos de un tópico al ser listados o mostrados
public record DatosListadoTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String autor,
        String curso
) {
    public DatosListadoTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getAutor(),
                topico.getCurso()
        );
    }
}