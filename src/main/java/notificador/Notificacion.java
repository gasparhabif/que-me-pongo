package notificador;

import usuario.Usuario;

import java.util.List;

public interface Notificacion {
    void notificar(Usuario usuario, List<String> nuevasAlertas);
}
