public class PrendaSucia extends EstadoPrenda {

  @Override
  public void usar(Prenda prenda) {
    prenda.setEstado(new PrendaPercudida());
  }

  @Override
  public boolean sugerible(){return true;}
}

  @Override
  public void lavarPrenda(Prenda prenda){
    prenda.setCantidadUsos(0);
    prenda.setEstado(new PrendaLimpia());
  }
}
  public void ponerseALavar(Prenda prenda, Lavadero lavadero){
    lavadero.ponerPrendaALavar(prenda);
  }
