package ifsp.web.api.models;

import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

public class Task {
    private int id = 0;

    @NotBlank(message = "Titulo e um campo obrigatorio.")
    private String titulo_task;

    @NotBlank(message = "Descricao e um campo obrigatorio.")
    private String descricao_task;

    @NotBlank(message = "Data de inicio, e um campo obrigatorio.")
    private String data_inicio_task;

    @NotBlank(message = "Data de conclusao, e um campo obrigatorio.")
    private String data_fim_task;

    private String status_task;

    private String data_prevista;

    private String email_usuario;


    public Task(){}

    public Task(String titulo_task, String descricao_task, String data_inicio_task, String data_fim_task) {
        this.titulo_task = titulo_task;
        this.descricao_task = descricao_task;
        this.data_inicio_task = data_inicio_task;
        this.data_fim_task = data_fim_task;
    }

    public int getId(){return id;}
    public void setId(int id){this.id+=id;}
    public int gerarProximoId(int id){return ++id;}

    public String getTitulo_task() {
        return titulo_task;
    }

    public void setTitulo_task(String titulo_task) {
        this.titulo_task = titulo_task;
    }

    public String getDescricao_task() {
        return descricao_task;
    }

    public void setDescricao_task(String descricao_task) {
        this.descricao_task = descricao_task;
    }

    public String getData_inicio_task() {
        return data_inicio_task;
    }

    public void setData_inicio_task(String data_inicio_task) {
        this.data_inicio_task = data_inicio_task;
    }

    public String getData_fim_task() {
        return data_fim_task;
    }

    public void setData_fim_task(String data_fim_task) {
        this.data_fim_task = data_fim_task;
    }

    public String getData_prevista() {
        return data_prevista;
    }

    public void setData_prevista(String data_prevista) {
        this.data_prevista = data_prevista;
    }

    public String getStatus_task() {
        return status_task;
    }

    public void setStatus_task(String status_task) {
        this.status_task = status_task;
    }

    public String getEmail_usuario() {
        return email_usuario;
    }

    public void setEmail_usuario(String email_usuario) {
        this.email_usuario = email_usuario;
    }
}
