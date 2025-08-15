package Desafio.Foro_Hub_G8.excepcion;

public class ValidacionDeIntegridad extends RuntimeException {
    public ValidacionDeIntegridad(String message) {
        super(message);
    }
}