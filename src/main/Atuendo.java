package main;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.requireNonNull;

public class Atuendo {
  Prenda torso;
  Prenda piernas;
  Prenda pies;
  List<Prenda> accesorios = new ArrayList<Prenda>();

  Atuendo(Prenda torso , Prenda piernas , Prenda pies, List<Prenda> accesorios){
    this.torso =  requireNonNull(torso, "La main.Prenda para el torso es obligatoria");
    this.piernas = requireNonNull(piernas, "La main.Prenda para las piernas es obligatoria");
    this.pies  = requireNonNull(pies, "La main.Prenda para los ´pies es obligatoria");
    this.accesorios = accesorios;
  }

  boolean esAptoParaClima(double temperatura, boolean lluvia) {
    return torso.esSugerible(temperatura, lluvia) &&
           piernas.esSugerible(temperatura, lluvia) &&
           pies.esSugerible(temperatura, lluvia);
  }


}