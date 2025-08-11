package br.com.forumhub.challenge.forum.model.topicos;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;



@Component
public interface TopicoRepository extends JpaRepository<TopicoEntity, Long> {

    Page<TopicoEntity> findAllByEstadoTopicoTrue(Pageable pageable);
    
}
