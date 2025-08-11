package br.com.alura.forumhub.domain.topico;

import br.com.alura.forumhub.domain.autor.Autor;
import br.com.alura.forumhub.domain.curso.Curso;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String mensagem;
    private LocalDateTime data;
    //private Boolean estadoTopico;
    private Boolean ativo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private @NotNull Autor autor;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private @NotNull Curso curso;

    public Topico(DadosCadastroTopico dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.mensagem = dados.mensagem();
    }


    public void atualizarTopico(DadosAtualizacaoTopico dados) {
        if(dados.nome() != null) {
            this.nome = dados.nome();
        }
        if(dados.mensagem() != null) {
            this.mensagem = dados.mensagem();
        }

    }

    public void excluir() {
        this.ativo = false;
    }
}
