package data.repositories;

import data.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findUsuarioByEmailAndPasswd(String email, String passwd);
    Usuario findUsuarioByEmail(String email);

}
