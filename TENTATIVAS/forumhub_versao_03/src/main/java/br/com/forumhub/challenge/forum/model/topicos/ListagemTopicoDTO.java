package br.com.forumhub.challenge.forum.model.topicos;

import java.time.LocalDateTime;

public record ListagemTopicoDTO(
String titulo,
String mensagem,
LocalDateTime dataCriacao,
boolean estadoTopico,
String autor,
String curso
) {
    public ListagemTopicoDTO(TopicoEntity topico) {
        this(
            topico.getTitulo(),
            topico.getMensagem(),
            topico.getDataCriacao(),
            topico.getEstadoTopico(),
            topico.getUsuario().getNome(),
            topico.getCursos().getNome()
        );
    }

}
