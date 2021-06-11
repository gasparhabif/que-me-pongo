package notificador;

import usuario.Usuario;

import java.util.List;

public class NotificacionGranizo implements Notificacion {
    @Override
    public void notificar(Usuario usuario, List<String> nuevasAlertas) {
        if(nuevasAlertas.contains("GRANIZO")) {
            // Enviar notificacion al usuario para que guarde el auto
            System.out.println("Guarda el auto");
        }
    }
}
