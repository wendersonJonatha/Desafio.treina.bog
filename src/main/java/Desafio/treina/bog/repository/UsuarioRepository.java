package Desafio.treina.bog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Desafio.treina.bog.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findBynome(String nome);

   
}
