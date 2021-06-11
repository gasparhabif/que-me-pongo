package clima;

import java.util.List;

public interface ServicioMeteorologico {
    String CIUDAD = "Buenos Aires, Argentina";

    double getTemperatura();
    double getPrecipitaciones();
    default double convertirFahrenheitACelsius(double temperatura) {
        return (temperatura - 32) * 5 / 9;
    }

    List<String> getAlertasMeteorlogicas();
}
