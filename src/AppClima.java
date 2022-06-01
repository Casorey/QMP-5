import java.util.List;
import java.util.Map;

public class AppClima {

  Map<String, Object> condicionesClima;

  AppClima(){
    AccuWeatherAPI apiClima = new AccuWeatherAPI();
    List<Map<String, Object>> condicionesClimaticas = apiClima.getWeather("Buenos Aires, Argentina");
    this.condicionesClima = condicionesClimaticas.get(0);
  }

  public boolean esDeDia(){
    return (boolean) condicionesClima.get("IsDaylight");
  }

  public boolean vaALlover(){
    return (int) condicionesClima.get("PrecipitationProbabili") >= 0.5;
  }

  public double temperatura(){
    return (((double) condicionesClima.get("Temperature") - 32) / 1.8);
  }

}
