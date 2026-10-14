package ifsp.web.api.repositories;

import ifsp.web.api.models.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository {
    private static ArrayList<Usuario> usuarios = new ArrayList<>();

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public Usuario getUsuariosEmail(String email){
        for (Usuario usuario : usuarios){
            if(usuario.getEmail().equals(email)){
                return usuario;
            }
        }
        return null;
    }

    public Usuario postUsuario(Usuario usuario){
        usuarios.add(usuario);
        return usuario;
    }

    public Usuario putUsuario(Usuario usuario, Usuario usuarioAtualizado){
        usuarioAtualizado.setEmail(usuario.getEmail());
        usuarioAtualizado.setNome(usuario.getNome());
        return usuarioAtualizado;
    }

    public Usuario deleteUsuario(Usuario usuario){
        usuarios.remove(usuario);
        return usuario;
    }


}
