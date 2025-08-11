package br.com.alura.forumhub.domain.topico;

import java.time.LocalDateTime;

public record DadosListagemTopico(Long id, String nome, String mensagem, LocalDateTime data, Boolean ativo,
                                  Long idAutor, Long idCurso) {
    public DadosListagemTopico(Topico topico){
this(topico.getId(), topico.getNome(), topico.getMensagem(), topico.getData(), topico.getAtivo(),
        topico.getAutor().getId(), topico.getCurso().getId());
    }
}
