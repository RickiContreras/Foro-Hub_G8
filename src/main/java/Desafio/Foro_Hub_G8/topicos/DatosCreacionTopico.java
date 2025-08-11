package Desafio.Foro_Hub_G8.topicos;

public record DatosCreacionTopico(
        String titulo,
        String mensaje,
        Long usuarioId,
        Long foroId
) {
}
