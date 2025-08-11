package br.com.alura.forumhub.domain.autor;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoAutor(
        @NotNull
        Long id,
        String nome,
        String email,
        Perfil perfil
) {
}
