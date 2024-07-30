package Desafio.treina.bog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    private String titulo;
    private String conteudo;
    private String dataDeCriacao;
    private Long autorId;
    
}
