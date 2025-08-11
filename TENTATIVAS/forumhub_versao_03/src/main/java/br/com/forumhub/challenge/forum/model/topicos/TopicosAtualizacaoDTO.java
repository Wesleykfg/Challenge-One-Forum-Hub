package br.com.forumhub.challenge.forum.model.topicos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicosAtualizacaoDTO(
    @NotNull
    Long id,

    @NotBlank
    String titulo,

    @NotBlank
    String mensagem

) {
    
    

}
