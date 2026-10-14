package ifsp.web.api.controllers;

import ifsp.web.api.models.Usuario;
import ifsp.web.api.services.UsuarioService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private UsuarioService usuarioService = new UsuarioService();

    @GetMapping
    public ResponseEntity<?> getUsuarios(){
        try {
            return ResponseEntity.status(200).body(usuarioService.getUsuarios());
        } catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/{email}")
    public ResponseEntity<?> getUsuariosEmail(@PathVariable String email) {
        try {
            return ResponseEntity.status(200).body(usuarioService.getUsuariosEmail(email));
        } catch (Exception e){
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> postUsuario(@Valid @RequestBody Usuario usuario){
        try {
            return ResponseEntity.status(201).body(usuarioService.postUsuario(usuario));
        } catch(MethodArgumentNotValidException e){
            String mensagemError = e.getBindingResult().getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(mensagemError);
        } catch(Exception e){
            return ResponseEntity.internalServerError().body("Erro interno: " + e.getMessage());
        }
    }

    @PutMapping("/{email}")
    public ResponseEntity<?> putUsuario(@PathVariable String email, @Valid @RequestBody Usuario usuario, BindingResult bindingResult){
        try {
            if(bindingResult.hasErrors()){
                String mensagemError = bindingResult.getFieldError().getDefaultMessage();
                return ResponseEntity.status(400).body(mensagemError);
            }
            return ResponseEntity.status(200).body(usuarioService.putUsuario(email,usuario));
        } catch(Exception e){
            return ResponseEntity.internalServerError().body("Erro interno: " + e.getMessage());
        }
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<?> deleteUsuario(@PathVariable String email){
        try{
            return ResponseEntity.status(200).body(usuarioService.deleteUsuario(email));
        } catch (Exception e){
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
}
