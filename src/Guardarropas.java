import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Guardarropas {

   public List<Atuendo> atuendosDisponibles;
   private List<Prenda> prendas;

  Prenda sugerirPrenda(Categoria categoria, double temperatura, boolean lluvia){
    Random rand =new Random();
    List<Prenda> listaPrendas = (prendas.stream().filter(prenda -> prenda.categoria() == categoria && prenda.esSugerible(temperatura, lluvia)))
            .collect(Collectors.toList());
    Prenda prendaRandom = listaPrendas.get(rand.nextInt(listaPrendas.size()));
    return prendaRandom;
  }

  public Prenda sugerirTorso(double temperatura, boolean lluvia){
    return sugerirPrenda(Categoria.PRENDA_SUPERIOR, temperatura, lluvia);
  }

  public Prenda sugerirPiernas(double temperatura, boolean lluvia){
    return sugerirPrenda(Categoria.PRENDA_INFERIOR, temperatura, lluvia);
  }

  public Prenda sugerirPies(double temperatura, boolean lluvia){
    return sugerirPrenda(Categoria.CALZADO, temperatura, lluvia);
  }

  public List<Prenda> sugerirAccesorios(int cantidadDeAccesorios){
        return seleccionarVariosRandom(prendas.stream().filter(prenda -> prenda.categoria() == Categoria.ACCESORIO),cantidadDeAccesorios);
  }

  public Atuendo sugerirAtuendo(int cantidadDeAccesorios, double temperatura, boolean lluvia) {
    Atuendo nuevosAturnedo = new Atuendo(sugerirTorso(temperatura, lluvia),
            sugerirPiernas(temperatura, lluvia),
            sugerirPies(temperatura, lluvia),
            sugerirAccesorios(cantidadDeAccesorios));
    atuendosDisponibles.add(nuevosAturnedo);
    return nuevosAturnedo;
  }


}
