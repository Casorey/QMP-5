import java.util.ArrayList;
import java.util.List;

public class Guardarropas {
  private List<Prenda> prendas = new ArrayList<Prenda>();

  Prenda sugerirPrenda(Categoria categoria){
    return seleccionarRandom(prendas.stream().filter(prenda -> prenda.categoria() == categoria && prenda.esSugerible()));
  }

  Prenda sugerirTorso(){
    return sugerirPrenda(Categoria.PRENDA_SUPERIOR);
  }

  Prenda sugerirPiernas(){
    return sugerirPrenda(Categoria.PRENDA_INFERIOR);
  }

  Prenda sugerirPies(){
    return sugerirPrenda(Categoria.PRENDA_CALZADO);
  }

  List<Prenda> sugerirAccesorios(int cantidadDeAccesorios){
    return seleccionarVariosRandom(prendas.stream().filter(prenda -> prenda.categoria() == Categoria.ACCESORIO),cantidadDeAccesorios);
  }

  public Atuendo sugerirAtuendo(int cantidadDeAccesorios) {
    return Atuendo(sugerirTorso(),sugerirPiernas(),sugerirPies(), sugerirAccesorios(cantidadDeAccesorios));
  }
}
