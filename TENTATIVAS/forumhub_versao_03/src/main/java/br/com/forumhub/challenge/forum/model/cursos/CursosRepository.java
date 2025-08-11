package br.com.forumhub.challenge.forum.model.cursos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CursosRepository extends JpaRepository<CursosEntity, Long> {

    Optional<CursosEntity> findByNome(String nomeCurso);

}
