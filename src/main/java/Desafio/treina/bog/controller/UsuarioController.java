package Desafio.treina.bog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

import Desafio.treina.bog.model.Usuario;
import Desafio.treina.bog.repository.UsuarioRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    

    @PostMapping
    public Usuario cadastrarUsuario(@Valid @RequestBody Usuario idUsuario){
        return usuarioRepository.save(idUsuario);
    }

    @GetMapping
    public List<Usuario> listaUsuarios(){
        return usuarioRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deletarUsuarioPeloId(@PathVariable("id") Long idUsuario){
        usuarioRepository.deleteById(idUsuario);
    }
    @PutMapping("/{id}")
    public Usuario atualizarUsuarioPeloId(@Valid @PathVariable ("id") Long idUsuario, @RequestBody Usuario usuario){
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(idUsuario);
        if(usuarioExistente.isPresent()){
            Usuario usuarioObj = usuarioExistente.get();
            usuarioObj.setNome(usuario.getNome());
            usuarioObj.setSobreNome(usuario.getSobreNome());
            usuarioObj.setEmail(usuario.getEmail());
      

            return usuarioRepository.save(usuarioObj);
        }
        return null;
    }

    @Autowired
    private UsuarioRepository usuarioRepository;
}
