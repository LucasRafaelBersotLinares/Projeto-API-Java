package ifsp.web.api.repositories;

import ifsp.web.api.models.Task;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
    private ArrayList<Task> listaTask = new ArrayList<>();

    public List<Task> getTask(){
        return listaTask;
    }

    public void postTask(Task newTask){
        listaTask.add(newTask);
    }

    public void deleteTask(){
        listaTask = new ArrayList<>();
    }

    public void deleteTaskId(Task task){
        listaTask.remove(task);
    }

    public Task getTaskId(int id){
        for(Task t:listaTask) {
            if(t.getId() == id){
                return t;
            }
        }
        return null;
    }

    public void putTask(Task task, Task taskBody){
        task.setName(taskBody.getName());
        task.setNivelDiff(taskBody.getNivelDiff());
        task.setDescricao(taskBody.getDescricao());
    }

    public void taskConcluida(Task task){
        task.setConcluida(true);
    }

}
