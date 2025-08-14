package Desafio.Foro_Hub_G8.dto;

import jakarta.validation.constraints.NotBlank;

public record DatosCreacionTopico(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotBlank String autor,
        @NotBlank String curso
) {}