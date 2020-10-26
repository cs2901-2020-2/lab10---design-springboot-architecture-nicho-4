package data.repositories;

import data.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    void findUsuarioByEmailAndPasswd(String email, String passwd);
    void findUsuarioByEmail(String email);

}
