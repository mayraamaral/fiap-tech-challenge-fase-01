package techchallenge.fiap.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import techchallenge.fiap.entities.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public Optional<Usuario> findByLogin(String login);

}
