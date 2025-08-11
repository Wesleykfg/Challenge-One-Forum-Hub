package br.com.alura.forumhub.domain.topico;

import br.com.alura.forumhub.domain.autor.Autor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosCadastroTopico(@NotBlank String nome,
                                  @NotBlank String mensagem,
                                  LocalDateTime data,
                                  Boolean ativo,
                                  Long idAutor,
                                  Long idCurso) {
}
