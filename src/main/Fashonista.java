package main;

import java.util.List;

public class Fashonista {
    AppClima estadoDelTiempo;
    List<Usuario> usuarios;

  public Atuendo sugerirAtuendo(String direccion, Guardarropas guardarropas){
    List<Atuendo> atuendos = guardarropas.atuendosDisponibles;
    Atuendo unAtuendo =atuendos.stream()
        .filter(atuendoSugerido -> atuendoSugerido.esAptoParaClima(temperatura(),estalloviendo()))
        .findFirst()
        .get();
    return unAtuendo;
  }
/* QMP6
Como usuarie de QuéMePongo quiero que se actualice mi sugerencia diaria con las condiciones
climáticas actualizadas cuando se genere algún alerta durante el día
 */
  public void sugerirDiariamenteAUnUsuario(Usuario usuario){
    //esto tendria que ser diario, ya se sugieren solo las que son aptas para ese dia
    usuario.recibirSugerenciaDiaria(this);
  }

  public void sugerirDiariamenteATodosLosUsuarios(){
    //esto tendria que ser diario
    usuarios.forEach(usuario ->sugerirDiariamenteAUnUsuario(usuario));
  }



  double temperatura(){
        return estadoDelTiempo.temperatura();
    }
    boolean estalloviendo(){
        return estadoDelTiempo.vaALlover();
    }
}
