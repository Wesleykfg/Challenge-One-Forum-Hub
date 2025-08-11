package br.com.alura.forumhub.domain.topico;

import java.time.LocalDateTime;

public record DadosDetalhamentoTopico(Long id, String nome, String mensagem, LocalDateTime data, Long idAutor, Long idCurso) {
    public DadosDetalhamentoTopico(Topico topico) {
        this(topico.getId(), topico.getNome(), topico.getMensagem(), topico.getData(), topico.getAutor().getId(), topico.getCurso().getId());
    }
}
