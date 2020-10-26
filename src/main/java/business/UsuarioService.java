package business;

import data.entities.Usuario;
import data.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> findAll(){
        return repository.findAll();
    }

    public Usuario create(Usuario newUsuario){
        return repository.save(newUsuario);
    }

    public Usuario findOne(Long Id) throws Exception{
        return repository.findById(Id).orElseThrow(() -> new Exception("El usuario no ha sido encontrado!"));
    }

    public Usuario update(Usuario newUsuario, Long Id){
        return repository.findById(Id).map(usuario -> {
            usuario.setHash(newUsuario.getHash());
            usuario.setSexo(newUsuario.getSexo());
            usuario.setPrimerNombre(newUsuario.getPrimerNombre());
            usuario.setVigencia(newUsuario.getVigencia());
            usuario.setApellidoPaterno(newUsuario.getApellidoPaterno());
            usuario.setApellidoMaterno(newUsuario.getApellidoMaterno());
            usuario.setEmail(newUsuario.getEmail());
            usuario.setNombre(newUsuario.getNombre());
            usuario.setPasswd(newUsuario.getPasswd());
            usuario.setSegundoNombre(newUsuario.getSegundoNombre());
            usuario.setFechaCese(newUsuario.getFechaCese());
            usuario.setDni(newUsuario.getDni());
            return repository.save(usuario);
        }).orElseGet(()->{
            newUsuario.setId(Id);
            return repository.save(newUsuario);
        });
    }

    public void delete(Long codigo){
        repository.deleteById(codigo);
    }

    public Usuario findOneByEmail(String email) {
        for (Usuario item : repository.findAll())
            if (item.getEmail() != null && item.getEmail().equals(email))
                repository.findById(item.getId());
        return null;
    }

}
