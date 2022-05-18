import java.util.ArrayList;
import java.util.List;

public class Lavadero {
  private List<Prenda> prendasALavar = new ArrayList<Prenda>();

  public void ponerPrendaALavar(Prenda prenda){
    prendasALavar.add(prenda);
  }

  public boolean seEstaLavando(Prenda prenda){
    return prendasALavar.contains(prenda);
  }

  public void lavarPrendas(){
    prendasALavar.stream().forEach(prenda -> prenda.lavar());
  }
}
