package business;

import data.entities.Usuario;
import data.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    public Optional<Usuario> findOne(Long codigo){
        for (Usuario item : repository.findAll()){
            if (item.getCodigo() != null && item.getCodigo().equals(codigo)){
                return repository.findById(item.getId());
            }
        }
        return Optional.empty();
    }

    public Usuario update(Usuario newUsuario, Long codigo){
        for (Usuario item : repository.findAll()){
            if (item.getCodigo() != null && item.getCodigo().equals(codigo)){
                return repository.findById(item.getId()).map(usuario -> {
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
                    newUsuario.setCodigo(codigo);
                    return repository.save(newUsuario);
                });
            }
        }
        return null;
    }

    public void delete(Long codigo){
        for (Usuario item : repository.findAll()){
            if (item.getCodigo() != null && item.getCodigo().equals(codigo)){
                repository.deleteById(item.getId());
            }
        }
    }

    public Optional<Usuario> findOneByEmail(String email) {
        for (Usuario item : repository.findAll()){
            if (item.getEmail() != null && item.getEmail().equals(email)){
                return repository.findById(item.getId());
            }
        }
        return Optional.empty();
    }

}
