package br.com.alura.forumhub.domain.curso;

import br.com.alura.forumhub.domain.topico.Topico;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Table(name = "cursos")
@Entity(name = "Curso")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;

    /*@OneToMany(mappedBy = "cursos")
    private List<Topico> topicos = new ArrayList<>();*/

    public Curso(DadosDetalhamentoCurso curso) {
        this.id = curso.id();
        this.nome = curso.nome();
    }

}
