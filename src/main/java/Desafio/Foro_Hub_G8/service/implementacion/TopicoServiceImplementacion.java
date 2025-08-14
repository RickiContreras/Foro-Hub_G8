package Desafio.Foro_Hub_G8.service.implementacion;

import Desafio.Foro_Hub_G8.dto.DatosCreacionTopico;
import Desafio.Foro_Hub_G8.model.Topico;
import Desafio.Foro_Hub_G8.repository.TopicoRepository;
import Desafio.Foro_Hub_G8.service.TopicoService;
import org.springframework.stereotype.Service;

@Service
public class TopicoServiceImplementacion implements TopicoService {

        private final TopicoRepository topicoRepository;

        public TopicoServiceImplementacion(TopicoRepository topicoRepository) {
            this.topicoRepository = topicoRepository;
        }

        @Override
        public Topico crearTopico(DatosCreacionTopico datos) {
            Topico topico = new Topico();
            topico.setTitulo(datos.titulo());
            topico.setMensaje(datos.mensaje());
            topico.setAutor(datos.autor());
            topico.setCurso(datos.curso());

            return topicoRepository.save(topico);
        }

}

