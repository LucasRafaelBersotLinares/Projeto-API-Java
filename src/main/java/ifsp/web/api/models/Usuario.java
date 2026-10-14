package ifsp.web.api.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jdk.jfr.Name;

public class Usuario {
    private int id = 0;

    @NotBlank(message = "E-mail e uma cmapo obrigatorio.") @Email(message = "Escreva uma email valido.")
    private String email;

    @NotBlank(message = "Nome e um campo obrigatorio.")
    private String nome;

    private String img_url;

    public Usuario(){}

    public Usuario(String email, String nome){
        this.email=email;
        this.nome=nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
