public class PrendaPercudida extends EstadoPrenda {

  @Override
  public void usar(Prenda prenda) {
    throw new noSePuedeUsar("Las prendas percudidas ya no son usables");
  }

  @Override
  public boolean sugerible(){return false;}
}


