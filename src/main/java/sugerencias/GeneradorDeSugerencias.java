package sugerencias;

import clima.ServicioMeteorologico;
import guardarropas.Guardarropas;
import usuario.Atuendo;

import java.util.List;

public class GeneradorDeSugerencias {
  private final ServicioMeteorologico servicioMeteorologico;

  public GeneradorDeSugerencias(ServicioMeteorologico servicioMeteorologico) {
    this.servicioMeteorologico = servicioMeteorologico;
  }

  public Atuendo obtenerSugerenciaDeAtuendo(List<Guardarropas> guardarropas) {
    double temperatura = servicioMeteorologico.getTemperatura();
    return null;
  }
}
