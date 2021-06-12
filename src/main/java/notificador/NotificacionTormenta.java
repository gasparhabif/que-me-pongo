package notificador;

import usuario.Usuario;

import java.util.List;

public class NotificacionTormenta implements Notificacion {
    @Override
    public void notificar(Usuario usuario, List<String> nuevasAlertas) {
        if(nuevasAlertas.contains("TORMENTA")) {
            // Enviar notificacion al usuario para que lleve paraguas
            notify();
            System.out.println("Paraguas");
        }
    }
}
