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

    @GetMapping //It works
    public List<Usuario> readAll(){
        return service.findAll();
    }

    @GetMapping("/{codigo}") //It works
    public Usuario read(@PathVariable ("codigo") Long codigo){
        return service.findOne(codigo);
    }

    @GetMapping("/readByEmail/{email}") //It works
    public Usuario readByEmail(@PathVariable ("email") String email){
        return service.findOneByEmail(email);
    }

    @PostMapping //It works
    public Usuario create(@RequestBody Usuario newUsuario) {
        return service.create(newUsuario);
    }

    @PutMapping("/{codigo}") //It works
    public Usuario update(@RequestBody Usuario newUsuario, @PathVariable Long codigo){
        return service.update(newUsuario, codigo);
    }

    @DeleteMapping("/{codigo}") //It works
    public void delete(@PathVariable Long codigo){
        service.delete(codigo);
    }
}