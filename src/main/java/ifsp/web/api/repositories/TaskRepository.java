package ifsp.web.api.repositories;

import ifsp.web.api.models.Task;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
    private static ArrayList<Task> tasks = new ArrayList<>();

    public List<Task> getTaskUsuario(String email){
        List<Task> taskUser = new ArrayList<Task>();
        for(Task task:tasks){
            if(task.getEmail_usuario().equals(email)){
                taskUser.add(task);
            }
        }
        return taskUser;
    }

    public Task postTaskUsuario(Task task){
        tasks.add(task);
        return task;
    }

    public Task getDetalheTask(int id) {
        for (Task task:tasks){
            if(task.getId() == id){
                return task;
            }
        }
        return null;
    }

    public Task deleteTask(Task task) {
        tasks.remove(task);
        return task;
    }
}
