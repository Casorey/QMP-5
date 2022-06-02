import java.util.List;

public class Fashonista {

    AppClima estadoDelTiempo;
    Guardarropas guardarropas;

    public Atuendo sugerirAtuendo(String direccion, Guardarropas guardarrpas) {

     List<Atuendo> atuendos = guardarropas.atuendosDisponibles;
     Atuendo unAtuendo =atuendos.stream()
             .filter(atuendoSugerido -> atuendoSugerido.esAptoParaClima(temperatura(),estalloviendo()))
             .findFirst()
             .get();
     return unAtuendo;

    }

    double temperatura(){
        return estadoDelTiempo.temperatura();
    }
    boolean estalloviendo(){
        return estadoDelTiempo.vaALlover();
    }
}
