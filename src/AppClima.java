import java.util.List;
import java.util.Map;

public class AppClima {

  Map<String, Object> condicionesClima;
  Duration tiempoExpiracion = Duration("12:00:00");
  DateTime tiempoLlamadaAnterior;

  public void actualizarDatos(){
    if(this.expiro() || this.condicionesClima == NULL){
      AccuWeatherAPI apiClima = new AccuWeatherAPI();
      List<Map<String, Object>> condicionesClimaticas = apiClima.getWeather("Buenos Aires, Argentina");
      this.condicionesClima = condicionesClimaticas.get(0);
      this.tiempoLlamadaAnterior = condicionesClima.get("DateTime");
    }
  }

  private boolean expiro() {
    return DateTime.now > tiempoLlamadaAnterior + tiempoExpiracion;
  }

  public boolean vaALlover(){
    return (int) condicionesClima.get("PrecipitationProbabili") >= 0.8;
  }

  public double temperatura(){
    return (((double) condicionesClima.get("Temperature") - 32) / 1.8);
  }

}
