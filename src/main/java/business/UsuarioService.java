package business;

import data.entities.Usuario;
import data.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> findAll(){
        return repository.findAll();
    }

    public Usuario create(Usuario newUsuario){
        return repository.save(newUsuario);
    }

    public Usuario findOne(Long codigo) throws Exception{
        return repository.findById(codigo).orElseThrow(() -> new Exception("El usuario no ha sido encontrado!"));
    }

    public Usuario update(Usuario newUsuario, Long codigo){
        return repository.findById(codigo).map(usuario -> {
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

    public void delete(Long codigo){
        repository.deleteById(codigo);
    }

    public Usuario findOneByEmail(String email) {
        for (Usuario item : repository.findAll())
            if (item.getEmail() != null && item.getEmail().equals(email))
                repository.findById(item.getCodigo());
        return null;
    }

}
