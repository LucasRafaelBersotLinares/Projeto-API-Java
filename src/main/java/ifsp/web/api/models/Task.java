package ifsp.web.api.models;

import jakarta.validation.constraints.*;

public class Task {

    private int id = 0;

    @NotBlank(message = "O nome e obrigatorio")
    private String name;

    @NotNull(message = "O Nivel de Dificuldade e obrigatorio")
    @Min(value = 1, message = "Nivel de dificuldade tem que ter no minimo 1")
    @Max(value = 10, message = "Nivel de dificuldade tem no maximo 10")
    private Integer nivelDiff;

    @NotBlank(message = "A Descricao e obrigatoria")
    private String descricao;

    private Boolean concluida = false;

    public Task(){}

    public Task(String name, Integer nivelDiff, String descricao){
        this.name=name;
        this.nivelDiff=nivelDiff;
        this.descricao=descricao;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id+=id;
    }

    public int gerarProximoId(int id){
        return ++id;
    }

    public String getDescricao(){
        return descricao;
    }

    public void setDescricao(String descricao){
        this.descricao=descricao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public Integer getNivelDiff() {
        return nivelDiff;
    }

    public void setNivelDiff(Integer nivelDiff){
        this.nivelDiff=nivelDiff;
    }

    public Boolean getConcluida(){
        return concluida;
    }

    public void setConcluida(Boolean concluida){
        this.concluida=concluida;
    }
}
