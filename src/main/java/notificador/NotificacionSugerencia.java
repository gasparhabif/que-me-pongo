package notificador;

import usuario.Usuario;

import java.util.List;

public class NotificacionSugerencia implements Notificacion {
    @Override
    public void notificar(Usuario usuario, List<String> nuevasAlertas) {
        if (!nuevasAlertas.isEmpty()) {
          usuario.obtenerSugerenciaDiaria();
        }
    }
}
