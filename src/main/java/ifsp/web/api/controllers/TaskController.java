package ifsp.web.api.controllers;

import ifsp.web.api.models.Task;
import ifsp.web.api.services.TaskService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    private TaskService taskService = new TaskService();

    @GetMapping("/usuarios/{email}/tasks")
    public ResponseEntity<?> getTaskUsuario(@PathVariable String email){
        try {
            return ResponseEntity.status(200).body(taskService.getTaskUsuario(email));
        } catch(Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PostMapping("/usuarios/{email}/tasks")
    public ResponseEntity<?> postTaskUsuario(@PathVariable String email, @Valid @RequestBody Task task,BindingResult bindingResult){
        try {
            if(bindingResult.hasErrors()){
                String mensagemError = bindingResult.getFieldError().getDefaultMessage();
                return ResponseEntity.status(400).body(mensagemError);
            }
            return ResponseEntity.status(201).body(taskService.postTaskUsuario(email, task));
        } catch (Exception e){
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<?> getDetalheTask(@PathVariable int id){
        try {
            return ResponseEntity.status(200).body(taskService.getDetalheTask(id));
        } catch (Exception e){
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<?> putTak(@PathVariable int id, @Valid @RequestBody Task task, BindingResult bindingResult){
        try {
            if (bindingResult.hasErrors()){
                String mensagemError = bindingResult.getFieldError().getDefaultMessage();
                return ResponseEntity.status(400).body(mensagemError);
            }
            return ResponseEntity.status(200).body(taskService.putTask(id,task));
        } catch (Exception e){
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable int id){
        try {
            return ResponseEntity.status(200).body(taskService.deleteTask(id));
        } catch (Exception e){
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }


}
