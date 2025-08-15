package Desafio.Foro_Hub_G8.service.implementacion;

import Desafio.Foro_Hub_G8.dto.DatosCreacionTopico;
import Desafio.Foro_Hub_G8.excepcion.ValidacionDeIntegridad;
import Desafio.Foro_Hub_G8.model.Topico;
import Desafio.Foro_Hub_G8.repository.TopicoRepository;
import Desafio.Foro_Hub_G8.service.TopicoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TopicoServiceImplementacion implements TopicoService {

    private final TopicoRepository topicoRepository;

    public TopicoServiceImplementacion(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

    @Override
    public Topico crearTopico(DatosCreacionTopico datos) {
        // Validación de duplicados
        if (topicoRepository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje())) {
            throw new ValidacionDeIntegridad("Ya existe un tópico con el mismo título y mensaje.");
        }
        Topico topico = new Topico(datos);
        return topicoRepository.save(topico);
    }

    @Override
    public Page<Topico> obtenerTodosLosTopicos(Pageable paginacion) {
        // Spring Data JPA se encarga de la paginación y ordenamiento automáticamente
                return topicoRepository.findAll(paginacion);
    }

    @Override
    public Topico obtenerTopicoPorId(Long id) {
        return topicoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tópico con id " + id + " no encontrado"));
    }

    @Override
    public Topico actualizarTopico(Long id, DatosCreacionTopico datos) {
        // Primero, se busca si el tópico existe. Si no, lanza una excepción.
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tópico con id " + id + " no encontrado"));

        // Se actualizan los campos
        topico.setTitulo(datos.titulo());
        topico.setMensaje(datos.mensaje());
        topico.setAutor(datos.autor());
        topico.setCurso(datos.curso());

        // Spring Data JPA detecta los cambios y los guarda en la base de datos
        // gracias a la anotación @Transactional en el controlador.
        return topico;
    }

    @Override
    public void eliminarTopico(Long id) {
        if (!topicoRepository.existsById(id)) {
            throw new EntityNotFoundException("Tópico con id " + id + " no encontrado");
        }
        topicoRepository.deleteById(id);
    }
}