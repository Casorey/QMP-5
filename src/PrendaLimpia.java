public class PrendaLimpia extends EstadoPrenda {

  @Override
  public void usar(Prenda prenda) {
    if (prenda.getCantidadDeUsos() == 3) {
      prenda.setEstado(new PrendaSucia());
    }
  }

  @Override
  public boolean sugerible(){return true;}

}
