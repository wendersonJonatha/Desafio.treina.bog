package Desafio.treina.bog.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Desafio.treina.bog.dto.PostDTO;
import Desafio.treina.bog.exception.AutorNaoEncontradoException;
import Desafio.treina.bog.model.Post;
import Desafio.treina.bog.model.Usuario;
import Desafio.treina.bog.repository.ComentarioRepository;
import Desafio.treina.bog.repository.PostRepository;
import Desafio.treina.bog.repository.UsuarioRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/posts")
public class PostController {

    @GetMapping
    public List<Post> listarPosts(){
        return postRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Post> criarPost(@Valid @RequestBody PostDTO postDTO) {
        Optional<Usuario> authorOptional = usuarioRepository.findById(postDTO.getAutorId());
        if (authorOptional.isPresent()) {
            Usuario author = authorOptional.get();
            Post post = new Post();
            post.setTitulo(postDTO.getTitulo());
            post.setConteudo(postDTO.getConteudo());
            post.setAutor(author);

            // Defina a data de criação como a data atual
            post.setDataDeCriacao(new Date()); // Isso adiciona a data atual

            Post savedPost = postRepository.save(post);

            return ResponseEntity.status(HttpStatus.CREATED).body(savedPost);
        } else {
            throw new AutorNaoEncontradoException();
        }
    }

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

}
