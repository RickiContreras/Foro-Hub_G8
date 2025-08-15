package Desafio.Foro_Hub_G8.repository;

import Desafio.Foro_Hub_G8.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long>{
//     Metodo para verificar si ya existe un tópico con el mismo título y mensaje
    boolean existsByTituloAndMensaje(String titulo, String mensaje);
}