package sugerencias;

import usuario.Atuendo;
import usuario.RepositorioDeUsuarios;
import usuario.Usuario;

import java.util.List;

public class ServicioDeSugerencias {

    private final RepositorioDeUsuarios repositorioDeUsuarios;
    private final GeneradorDeSugerencias generadorDeSugerencias;

    public ServicioDeSugerencias(RepositorioDeUsuarios repositorioDeUsuarios, GeneradorDeSugerencias generadorDeSugerencias) {
        this.repositorioDeUsuarios = repositorioDeUsuarios;
        this.generadorDeSugerencias = generadorDeSugerencias;
    }

    // Ejecutado por el empleado de forma diaria o para el bonus, ejecutado por un crontab de manera automatica
    // Tambien, se ejecuta automaticamente cuando se detectan nuevas alertas metorologicas.
    public void calcularSugerencias() {
        List<Usuario> todosLosUsuarios = repositorioDeUsuarios.getUsuarios();
        todosLosUsuarios.forEach(usuario -> {
            Atuendo atuendo = generadorDeSugerencias.obtenerSugerenciaDeAtuendo(usuario.getTodosLosGuardarropas());
            usuario.setAtuendoSugeridoDiario(atuendo);
        });
    }
}
