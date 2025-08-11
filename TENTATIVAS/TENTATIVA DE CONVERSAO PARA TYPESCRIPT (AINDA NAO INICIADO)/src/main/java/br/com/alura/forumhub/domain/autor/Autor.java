package br.com.alura.forumhub.domain.autor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "autores")
@Entity(name = "Autor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    @Enumerated(EnumType.STRING)
    private Perfil perfil;
    private Boolean ativo;

    public Autor(DadosCadastroAutor dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.perfil = dados.perfil();
    }

    public void atualizarInformacoes(DadosAtualizacaoAutor dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.email() != null) {
            this.email = dados.email();
        }

    }

    public void excluir() {
        this.ativo = false;
    }
}
