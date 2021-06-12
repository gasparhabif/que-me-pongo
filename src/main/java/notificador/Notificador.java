package notificador;

import clima.ServicioMeteorologico;
import usuario.RepositorioDeUsuarios;
import usuario.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Notificador {

  private final List<String> alertasMeteorologicas = new ArrayList<>();

  private final ServicioMeteorologico servicioMeteorologico;
  private final RepositorioDeUsuarios repositorioDeUsuarios;

  private Notificador(ServicioMeteorologico servicioMeteorologico,
                      RepositorioDeUsuarios repositorioDeUsuarios) {
    this.servicioMeteorologico = servicioMeteorologico;
    this.repositorioDeUsuarios = repositorioDeUsuarios;
  }

  // Disparar proceso de consulta y actualizacion de alertas
  public void actualizarAlertasMeteorologicas() {
    List<String> nuevasAlertas = servicioMeteorologico.getAlertasMeteorlogicas();
    alertasMeteorologicas.addAll(nuevasAlertas);

    repositorioDeUsuarios.getUsuarios().forEach(usuario -> {
      usuario.enviarNotificaciones(nuevasAlertas);
    });
  }

  // Conocer alertar meteorologicas publicadas
  private List<String> getAlertasMeteorologicas() {
    return alertasMeteorologicas;
  }
}
