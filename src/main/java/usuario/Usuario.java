package usuario;
;
import excepciones.GuardarropasNoExistente;
import guardarropas.Guardarropas;
import notificador.*;
import prenda.Prenda;
import propuesta.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Usuario {
  private final List<Guardarropas> guardarropas = new ArrayList<>();
  private final List<Propuesta> propuestas = new ArrayList<>();
  private Atuendo atuendoSugeridoDiario;
  // Las notificaciones deseadas estaran en la lista y las no deseadas seran eliminadas
  private List<Notificacion> notificacionesDeseadas =
      Arrays.asList(new NotificacionTormenta(),
          new NotificacionGranizo(),
          new NotificacionMail(),
          new NotificacionSugerencia());

  private Usuario() {

  }

  public void crearGuardarropas(List<Prenda> prendas, String descripcion) {
    Guardarropas nuevoGuardarropas = new Guardarropas(prendas, descripcion);
    guardarropas.add(nuevoGuardarropas);
  }

  public void agregarGuardarropasExistente(Guardarropas guadarropasExistente) {
    this.guardarropas.add(guadarropasExistente);
  }

  public void agregarPrendaAGuardarropas(Prenda prenda, String idGuardarropasDeseado){
    getGuardarropas(idGuardarropasDeseado).agregarPrenda(prenda);
  }

  public List<Propuesta> getPropuestas() {
    return propuestas;
  }

  public void recibirPropuesta(Prenda prenda, AccionPropuesta accion, String idGuardarropas) {
    Propuesta nuevaPropuesta = new Propuesta(idGuardarropas, prenda, accion);
    propuestas.add(nuevaPropuesta);
  }

  public void aceptarPropuesta(Propuesta propuesta) {
    propuesta.aceptarPropuesta();
    propuesta.ejecutarAccionPropuesta(this);
  }

  public void rechazarPropuesta(Propuesta propuesta) {
    propuesta.rechazarPropuesta();
  }

  public void quitarPrendaDeGuardarropas(Prenda prenda, String idGuardarropas) {
    getGuardarropas(idGuardarropas).quitarPrenda(prenda);
  }

  private Guardarropas getGuardarropas(String idGuardarropas) {
    return guardarropas.stream()
        .filter(guardarropa -> guardarropa.getIdGuardarropas().equals(idGuardarropas))
        .findFirst().orElseThrow(GuardarropasNoExistente::new);
  }

  public List<Guardarropas> getTodosLosGuardarropas() {
    return guardarropas;
  }

  public void setAtuendoSugeridoDiario(Atuendo atuendoSugeridoDiario) {
    this.atuendoSugeridoDiario = atuendoSugeridoDiario;
  }

  public Atuendo obtenerSugerenciaDiaria() {
    return atuendoSugeridoDiario;
  }

  public List<Notificacion> getNotificacionesDeseadas() {
    return notificacionesDeseadas;
  }

  public void agregarNotificacionDeseada(Notificacion notificacion) {
    this.notificacionesDeseadas.add(notificacion);
  }

  public void removerNotificacion(Notificacion notificacion) {
    this.notificacionesDeseadas.remove(notificacion);
  }
}
