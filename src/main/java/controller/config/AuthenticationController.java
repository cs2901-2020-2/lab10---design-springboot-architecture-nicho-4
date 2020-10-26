package controller.config;

import business.UsuarioService;
import data.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class AuthenticationController {

    @Autowired
    private UsuarioService service;

    //CRUD  CREATE (POST) , READ (GET), UPDATE (PUT), DELETE (DELETE)

    @GetMapping
    public List<Usuario> readAll(){
        return service.findAll();
    }

    @GetMapping("/{codigo}")
    public Usuario read(@PathVariable Long codigo) throws Exception {
        return service.findOne(codigo);
    }

    @GetMapping("/{email}")
    public Usuario readByEmail(@PathVariable String email){
        return service.findOneByEmail(email);
    }

    @PostMapping
    public Usuario create(@RequestBody Usuario newUsuario) {
        return service.create(newUsuario);
    }

    @PutMapping("/{codigo}")
    public Usuario update(@RequestBody Usuario newUsuario, @PathVariable Long codigo){
        return service.update(newUsuario, codigo);
    }

    @DeleteMapping("/{codigo}")
    void delete(@PathVariable Long codigo){
        service.delete(codigo);
    }
}