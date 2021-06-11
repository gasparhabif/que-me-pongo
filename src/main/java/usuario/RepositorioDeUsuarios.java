package usuario;

import java.util.ArrayList;
import java.util.List;

public class RepositorioDeUsuarios {
    List<Usuario> usuarios = new ArrayList<>();

    public RepositorioDeUsuarios() {
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void agregarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }
}
