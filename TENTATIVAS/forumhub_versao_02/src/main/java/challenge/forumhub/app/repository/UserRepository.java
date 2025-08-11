package challenge.forumhub.app.repository;

import challenge.forumhub.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    //CRIANDO METODOS DO REPOSITORY

    List<User> findAllByActiveTrue();

    Optional<User> findByIdAndActiveTrue(long id);

    Optional<User> findByEmailAndActiveTrue(String email);

    boolean existsByEmailAndActiveTrue(String email);
}
