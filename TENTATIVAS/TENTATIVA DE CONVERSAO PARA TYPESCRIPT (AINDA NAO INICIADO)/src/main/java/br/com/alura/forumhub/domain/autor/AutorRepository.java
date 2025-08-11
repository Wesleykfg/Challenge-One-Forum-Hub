package br.com.alura.forumhub.domain.autor;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    Page<Autor> findAllByAtivoTrue(Pageable paginacao);

//    @Query("""
//            select m from Autor m
//            where
//            m.ativo = true
//            and
//            m.perfil = :perfil
//            and
//            m.id not in(
//                select c.autor.id from Consulta c
//                where
//                c.data = :data
//        and
//                c.motivoCancelamento is null
//            )
//            order by rand()
//            limit 1
//""")
//    Autor escolherAutorAleatorio(Perfil perfil, @NotNull @Future LocalDateTime data);

    @Query("""
            select m.ativo
            from Autor m
            where
            m.id = :id
            """)
    Boolean findAtivoById(Long id);
}
