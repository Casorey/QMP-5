package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Guardarropas {

   public List<Atuendo> atuendosDisponibles;
   private List<Prenda> prendas = new ArrayList<>();

   private Usuario propietario;
   private List<Usuario> genteQueLoConoce = new ArrayList<>();
   private List<Propuesta> propuestas = new ArrayList<>();

   Guardarropas(Usuario propietario){
       this.propietario = propietario;
   }

   public List<Propuesta> getSugerenciasPrendasAAgregar(){return propuestas;}



   public void agregaSugerenciaPrendaAQuitar(Prenda unaPrenda) throws PrendaNoEstaEnGuardaropa {
       if (prendas.contains(unaPrenda)){
           Propuesta unaPropuestaNueva = new PropuestaQuitar(unaPrenda, TipoPropuesta.QUITAR);
           propuestas.add(unaPropuestaNueva);
       } else {
           throw new PrendaNoEstaEnGuardaropa("no existe esta prenda en el guardarropas");
       }
   }

   public void agregaPrendaSugerencia(Prenda unaPrenda){
       Propuesta unaPropuestaNueva = new PropuestaAgregar(unaPrenda, TipoPropuesta.AGREGAR);
       propuestas.add(unaPropuestaNueva);
   }

   public void agregarUsuario(Usuario unUsuario){
     genteQueLoConoce.add(unUsuario);
   }

   public void quitarUsuario(Usuario unUsuario){
     genteQueLoConoce.remove(unUsuario);
   }

   public void agregarPrenda(Prenda unaPrenda){
     prendas.add(unaPrenda);
   }

   public void sacarPrendar(Prenda unaPrenda) throws PrendaNoEstaEnGuardaropa {
     if(!prendas.contains(unaPrenda)){
       throw new PrendaNoEstaEnGuardaropa("La prenda no esta en este guardaropa");
     }
     prendas.remove(unaPrenda);
   }

  public Prenda sugerirPrenda(Categoria categoria, double temperatura, boolean lluvia){
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
    Random rand = new Random();
    List<Prenda> listaPrendas = (prendas.stream().filter(prenda -> prenda.categoria() == Categoria.ACCESORIO))
            .collect(Collectors.toList());
    List<Prenda> accesoriosRandom = new ArrayList<>();
    Prenda accesorioRandom;

    for (int i = 0; i < cantidadDeAccesorios; i++){
      accesorioRandom = listaPrendas.get(rand.nextInt(listaPrendas.size()));
      accesoriosRandom.add(accesorioRandom);
      listaPrendas.remove(accesorioRandom);

    }
        return accesoriosRandom;
  }

  public Atuendo sugerirAtuendo(int cantidadDeAccesorios, double temperatura, boolean lluvia) {
    Atuendo nuevosAturnedo = new Atuendo(sugerirTorso(temperatura, lluvia),
            sugerirPiernas(temperatura, lluvia),
            sugerirPies(temperatura, lluvia),
            sugerirAccesorios(cantidadDeAccesorios));
    atuendosDisponibles.add(nuevosAturnedo);
    return nuevosAturnedo;
  }


    public void sacarSugerencia(Propuesta propuestaAgregar) {
        propuestas.remove(propuestaAgregar);
    }

    public void quitarPrenda(Prenda unaPrenda) {
       prendas.remove(unaPrenda);
    }
}
