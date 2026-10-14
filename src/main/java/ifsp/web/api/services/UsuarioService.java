package ifsp.web.api.services;

import ifsp.web.api.models.Usuario;
import ifsp.web.api.repositories.UsuarioRepository;

import java.util.List;

public class UsuarioService {
    private UsuarioRepository usuarioRepository = new UsuarioRepository();

    public List<Usuario> getUsuarios() throws Exception {
        List<Usuario> listaUsuarios = usuarioRepository.getUsuarios();

        if(listaUsuarios != null){
            return listaUsuarios;
        }
        throw new Exception("Lista nao foi iniciada.");
    }

    public Usuario getUsuariosEmail(String email) throws Exception {
        Usuario usuario = usuarioRepository.getUsuariosEmail(email);
        if(usuario == null) {
            throw new Exception("Usuario nao esta cadastrado");
        }
        return usuario;
    }

    public Usuario postUsuario(Usuario usuario) throws Exception {
        if(usuarioRepository.getUsuariosEmail(usuario.getEmail()) != null){
            throw new Exception("Esse email ja esta cadastrado");
        }
        return usuarioRepository.postUsuario(usuario);
    }

    public Usuario putUsuario(String email, Usuario usuario) throws Exception{
        Usuario usuarioAtualizado = usuarioRepository.getUsuariosEmail(email);
        if(usuarioAtualizado == null){
            throw new Exception("Usuario nao cadastrado");
        }
        if (usuarioRepository.getUsuariosEmail(usuario.getEmail()) != null){
            throw new Exception("Esse email ja pertence a outro usuario");
        }
        return usuarioRepository.putUsuario(usuario, usuarioAtualizado);
    }

    public Usuario deleteUsuario(String email) throws Exception {
        Usuario usuarioDelete = usuarioRepository.getUsuariosEmail(email);
        if(usuarioDelete == null){
            throw new Exception("Usuario nao cadastrado");
        }
        return usuarioRepository.deleteUsuario(usuarioDelete);
    }

}
