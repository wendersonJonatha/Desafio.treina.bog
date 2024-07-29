package Desafio.treina.bog.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import Desafio.treina.bog.model.Comentario;
import Desafio.treina.bog.model.Post;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

    List<Comentario> findByPost(Post post);

}
