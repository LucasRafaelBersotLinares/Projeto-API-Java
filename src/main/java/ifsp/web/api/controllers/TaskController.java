package ifsp.web.api.controllers;

import ifsp.web.api.models.Task;
import ifsp.web.api.services.TaskService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private TaskService taskService = new TaskService();

    @GetMapping
    public ResponseEntity<?> getTask(){
        try {
            List<Task> listaTask = taskService.getTask();
            return ResponseEntity.ok(listaTask);
        } catch(RuntimeException e){
            return ResponseEntity.status(500).body("Erro ao inicializar a lista de permanencia.");
        }
    }

    @PostMapping("/criar")
    public ResponseEntity<?> postTask(@Valid @RequestBody Task task){
            taskService.postTask(task);
            return ResponseEntity.status(201).body("Task criado com sucesso.");
    }

    @DeleteMapping("/excluir")
    public ResponseEntity<?> deleteTask(){
            taskService.deleteTask();
            return ResponseEntity.status(200).body("Todas as Task foram apagadas.");
    }

    @PutMapping("/concluida/{id}")
    public ResponseEntity<?> taskConcluida(@PathVariable int id){
        try {
            taskService.taskConcluida(id);
            return ResponseEntity.status(200).body("Task Concluida com sucesso.");
        } catch(RuntimeException e){
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> deleteTaskId(@PathVariable int id){
        try {
            taskService.deleteTaskId(id);
            return ResponseEntity.status(200).body("Task deletada com sucesso.");
        } catch(RuntimeException e){
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> putTask(@PathVariable int id, @Valid @RequestBody Task task){
        try {
            taskService.putTask(id, task);
            return ResponseEntity.status(200).body("Task atualizada com sucesso.");
        } catch(RuntimeException e){
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTaskId(@PathVariable int id){
        try {
            Task task = taskService.getTaskId(id);
            return ResponseEntity.ok(task);
        } catch(RuntimeException e){
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> tratarErro(MethodArgumentNotValidException e) {
        return ResponseEntity.badRequest().body(e.getBindingResult().getFieldError().getDefaultMessage());
    }

}
