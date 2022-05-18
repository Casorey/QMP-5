import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.requireNonNull;

public class Atuendo {
  Prenda torso;
  Prenda piernas;
  Prenda pies;
  List<Prenda> accesorios = new ArrayList<Prenda>();

  Atuendo(Prenda torso , Prenda piernas , Prenda pies, List<Prenda> accesorios){
    this.torso =  requireNonNull(torso, "La Prenda para el torso es obligatoria");
    this.piernas = requireNonNull(piernas, "La Prenda para las piernas es obligatoria");
    this.pies  = requireNonNull(pies, "La Prenda para los ´pies es obligatoria");
    this.accesorios = accesorios;
  }


}
