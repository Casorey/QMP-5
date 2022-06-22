package main.QMP6;

import main.AccuWeatherAPI;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntermediarioAPI {
  AccuWeatherAPI apiClima = new AccuWeatherAPI();
  Observer observerAsociado;

  public Map<String, List<String>> ultimasAlertas(String ciudad){
    Map<String, List<String>> alertas=apiClima.getAlerts(ciudad);
    if(alertas.containsValue("Tormenta")){
      NotificationService>>notify("Llevar paraguas")//falta implementar observer
    }
    if(alertas.containsValue("Granizo")){
      NotificationService>>notify("Salir del auto")//falta implementar observer
    }
    //envio de mail por el observer
    //seleccionar que accion del observer se ejecuta o no
    return alertas;
  }

  public void agregarAlerta(HashMap<String, List<String>> filaNueva) {
    apiClima.nuevaAlerta(filaNueva);
  }


}
