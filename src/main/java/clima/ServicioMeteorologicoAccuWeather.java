package clima;

import excepciones.ServicioMeteorologicoNoDisponible;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServicioMeteorologicoAccuWeather implements ServicioMeteorologico {
    private AccuWeatherAPI weatherAPI;

    public ServicioMeteorologicoAccuWeather(AccuWeatherAPI weatherAPI) {
        this.weatherAPI = weatherAPI;
    }

    public double getTemperatura() {
        try {
            Map<String, Object> temperatura = (HashMap<String, Object>) this.getCondicionesClimaticas().get("Temperature");
            return convertirFahrenheitACelsius((double) temperatura.get("Value"));
        } catch (Exception e) {
            throw new ServicioMeteorologicoNoDisponible("No se pudo obtener la temperatura.");
        }
    }

    public double getPrecipitaciones() {
        try {
            return (double) this.getCondicionesClimaticas().get("PrecipitationProbability");
        } catch (Exception e) {
            throw new ServicioMeteorologicoNoDisponible("No se pudo obtener las precipitaciones.");
        }
    }

    @Override
    public List<String> getAlertasMeteorlogicas() {
        try {
            return (List<String>) this.getCondicionesClimaticas().get("CurrentAlerts");
        } catch (Exception e) {
            throw new ServicioMeteorologicoNoDisponible("No se pudo obtener las precipitaciones.");
        }
    }

    private Map<String, Object> getCondicionesClimaticas() {
        try {
            return this.weatherAPI.getWeather(CIUDAD).get(0);
        } catch (Exception e){
            throw new ServicioMeteorologicoNoDisponible("No se pudo obtener las condiciones climáticas.");
        }
    }
}
