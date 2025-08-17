package Desafio.Foro_Hub_G8.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DatosAutenticacion(
        @NotBlank
        @Email
        String email,

        @NotBlank
        String clave
) {}