package controller.config;

import business.UsuarioService;
import data.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios/")
public class AuthenticationController {

    @Autowired
    private UsuarioService service;

    //CRUD  CREATE (POST) , READ (GET), UPDATE (PUT), DELETE (DELETE)

    @GetMapping //It works
    public ResponseEntity<List<Usuario>> readAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{codigo}") //It works
    public ResponseEntity<Optional<Usuario>> read(@PathVariable ("codigo") Long codigo){
        return ResponseEntity.ok(service.findOne(codigo));
    }

    @GetMapping("/readByEmai/{email}") //It works
    public ResponseEntity<Optional<Usuario>> readByEmail(@PathVariable ("email") String email){
        return ResponseEntity.ok(service.findOneByEmail(email));
    }

    @PostMapping //It works
    public ResponseEntity<Usuario> create(@RequestBody Usuario newUsuario) {
        try{
            return ResponseEntity.created(new URI("/usuarios"+service.create(newUsuario).getId())).body(service.create(newUsuario));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/{codigo}") //It works
    public ResponseEntity<Usuario> update(@RequestBody Usuario newUsuario, @PathVariable Long codigo){
        return ResponseEntity.ok(service.update(newUsuario, codigo));
    }

    @DeleteMapping("/{codigo}") //It works
    public ResponseEntity<Void> delete(@PathVariable Long codigo){
        service.delete(codigo);
        return ResponseEntity.ok().build();
    }
}