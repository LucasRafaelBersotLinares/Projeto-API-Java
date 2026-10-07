package ifsp.web.api.services;

import ifsp.web.api.models.Task;
import ifsp.web.api.repositories.TaskRepository;

import java.util.ArrayList;
import java.util.List;

public class TaskService {
    private TaskRepository taskRepository = new TaskRepository();
    private int proximoId = 1;

    public List<Task> getTask(){
        List<Task> listaTask = taskRepository.getTask();

        if(listaTask == null){
            throw new RuntimeException("Lista não foi iniciada.");
        }
        return listaTask;
    }

    public Task getTaskId(int id){
        return validacaoId(id);
    }

    public void postTask(Task task){
        task.setId(proximoId);
        proximoId = task.gerarProximoId(proximoId);
        taskRepository.postTask(task);
    }

    public void deleteTask(){
        taskRepository.deleteTask();
    }

    public void deleteTaskId(int id){
        taskRepository.deleteTaskId(validacaoId(id));
    }

    public void putTask(int id, Task taskBody){
        taskRepository.putTask(validacaoId(id), taskBody);
    }

    public void taskConcluida(int id){
        taskRepository.taskConcluida(validacaoId(id));
    }

    private Task validacaoId(int id){
        if(id < 1 ){
            throw new RuntimeException("O Id precisa ser maior ou igual a 1");
        }
        Task task = taskRepository.getTaskId(id);
        if(task != null){
            return task;
        }
        throw new RuntimeException("Nao existe uma Task com o id informado.");
    }

}
