package techchallenge.fiap.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import techchallenge.fiap.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
