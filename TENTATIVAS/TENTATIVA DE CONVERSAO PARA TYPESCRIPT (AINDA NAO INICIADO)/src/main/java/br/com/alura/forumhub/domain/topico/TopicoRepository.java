package br.com.alura.forumhub.domain.topico;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Range;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    //Page<Topico> findAllByEstadoTopicoTrue(Pageable pageable);

    Page<Topico> findAllByAtivoTrue(Pageable paginacao);

    Object findAtivoById(@NotNull Long aLong);

    //Object existsByAutorId(@NotNull Long , Object , Object );
}
