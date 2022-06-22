package main;

import com.sun.applet2.AppletParameters;

import java.util.*;

public final class AccuWeatherAPI {


  public final List<Map<String, Object>> getWeather(String ciudad) {
    return Arrays.asList(new HashMap<String, Object>(){ {
      put("DateTime", "2019-05-03T01:00:00-03:00");
      put("EpochDateTime", 1556856000);
      put("WeatherIcon", 33);
      put("IconPhrase", "Clear");
      put("IsDaylight", false);
      put("PrecipitationProbability", 0);
      put("MobileLink", "http://m.accuweather.com/en/ar/villa-vil/7984/");
      put("Link", "http://www.accuweather.com/en/ar/villa-vil/7984");
      put("Temperature", new HashMap<String, Object>(){{
        put("Value", 57);
        put("Unit", "F");
        put("UnitType", 18);
      }});
    }});
  }

  public Map<String,List<String>> getAlerts(String city){
    return new HashMap <String, List<String>>(){
      {
        put("Buenos Aires", (new ArrayList<String>(Arrays.asList("Granizo","Tormenta"))) );
      }
    };
  }


  public void nuevaAlerta(HashMap<String, List<String>> filaNueva) {
    alertas.put(filaNueva);//porque en realidad la api tendria que poder devolver las alertas, pero este es de ejemplo
  }
}