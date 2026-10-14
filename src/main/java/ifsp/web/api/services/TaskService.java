package ifsp.web.api.services;

import ifsp.web.api.models.Task;
import ifsp.web.api.repositories.TaskRepository;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class TaskService {
    private UsuarioService usuarioService = new UsuarioService();
    private TaskRepository taskRepository = new TaskRepository();
    private int proximoId = 0;

    public List<Task> getTaskUsuario(String email) throws Exception {
        List<Task> taskUser = new ArrayList<>();
        taskUser = taskRepository.getTaskUsuario(email);
        if(taskUser == null){
            throw new Exception("Lista nao inicializada.");
        }
        return taskUser;
    }

    public Task postTaskUsuario(String email, Task task) throws Exception {
        if (usuarioService.getUsuariosEmail(email) == null){
            throw new Exception("Usuario com este email nao esta cadastrado no sistema.");
        }
        task.setEmail_usuario(email);
        task.setId(proximoId);
        proximoId = task.gerarProximoId(proximoId);
        return taskRepository.postTaskUsuario(task);
    }

    public Task getDetalheTask(int id) throws Exception {
        Task task = taskRepository.getDetalheTask(id);
        if(task == null){
            throw new Exception("Task com este id nao esta cadastrada no sistema.");
        }
        return task;
    }

    public Task putTask(int id, Task task) throws Exception {
        Task taskAtualizar = taskRepository.getDetalheTask(id);
        if(taskAtualizar == null){
            throw new Exception("Task com este id nao esta cadastrada no sistema.");
        }
        taskAtualizar.setTitulo_task(task.getTitulo_task());
        taskAtualizar.setDescricao_task(task.getDescricao_task());
        taskAtualizar.setData_inicio_task(task.getData_inicio_task());
        taskAtualizar.setData_fim_task(task.getData_fim_task());
        return taskAtualizar;
    }

    public Task deleteTask(int id) throws Exception {
        Task task = taskRepository.getDetalheTask(id);
        if (task == null){
            throw new Exception("Task com este id nao esta cadastrada no sistema.");
        }
        return taskRepository.deleteTask(task);
    }
}
