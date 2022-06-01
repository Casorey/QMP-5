public class Fashonista {

    public Atuendo sugerirAtuendo(String direccion, Guardarropas guardarrpas) {

      //completar fashonista

      List<Atuendo> combinaciones = guardarropas.todasLasPosiblesCombinaciones()
      return combinaciones
          .filter(combinacion -> combinacion.aptaParaTemperatura(estadoDelTiempo.temperatura))
          .filter(combinacion -> combinacion.aptaParaHumedad(estadoDelTiempo.humedad))
          .first();

    }
}
