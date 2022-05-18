public class PrendaLimpia extends EstadoPrenda {

  @Override
  public void usar(Prenda prenda) {
    prenda.serUsada();

    if (prenda.getCantidadDeUsos() == 3) {
      prenda.setEstado(new PrendaSucia());
    }
  }

  @Override
  public boolean sugerible(){return true;}

}
