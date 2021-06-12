package notificador;

import usuario.Usuario;

import java.util.List;

public class NotificacionMail implements Notificacion {
    @Override
    public void notificar(Usuario usuario, List<String> nuevasAlertas) {
        // Enviar por mail las nuevas alertas al usuario
        // MailSender.send(usuario.getMail(), "Hay nuevas alertas meteorologicas: " + nuevasAlertas...)
    }
}
