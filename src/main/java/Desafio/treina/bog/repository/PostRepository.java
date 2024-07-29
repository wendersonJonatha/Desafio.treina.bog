package Desafio.treina.bog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Desafio.treina.bog.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
