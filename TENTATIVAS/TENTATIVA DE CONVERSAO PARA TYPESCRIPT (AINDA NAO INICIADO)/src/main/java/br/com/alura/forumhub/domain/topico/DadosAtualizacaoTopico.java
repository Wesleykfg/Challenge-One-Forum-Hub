package br.com.alura.forumhub.domain.topico;

import br.com.alura.forumhub.domain.autor.Perfil;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoTopico(
        @NotNull
        Long id,
        String nome,
        String mensagem,
        Boolean ativo
) {
}
