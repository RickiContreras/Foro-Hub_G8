package Desafio.Foro_Hub_G8.infra.manejoDeErrores;

import Desafio.Foro_Hub_G8.excepcion.ValidacionDeIntegridad;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErrores {

    // Maneja la excepción cuando un recurso no es encontrado (404 Not Found)
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarError404() {
        return ResponseEntity.notFound().build();
    }

    // Maneja la excepción cuando la validación de un DTO falla (400 Bad Request)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarError400(MethodArgumentNotValidException e) {
        var errores = e.getFieldErrors().stream().map(DatosErrorValidacion::new).toList();
        return ResponseEntity.badRequest().body(errores);
    }

    // Maneja la excepción de duplicidad personalizada (409 Conflict)
    @ExceptionHandler(ValidacionDeIntegridad.class)
    public ResponseEntity tratarErrorValidacionesDeIntegridad(ValidacionDeIntegridad e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    // DTO interno para el manejo de errores de validación
    private record DatosErrorValidacion(String campo, String error) {
        public DatosErrorValidacion(org.springframework.validation.FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}