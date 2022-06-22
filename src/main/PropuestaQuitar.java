package main;

public class PropuestaQuitar extends Propuesta{
    public PropuestaQuitar(Prenda unaPrenda, TipoPropuesta quitar) {
        super();
    }

    @Override
    public void procesarPropuesta(Guardarropas unGuardarropas){
        unGuardarropas.quitarPrenda(this.getUnaPrenda());
    }

    @Override
    public void deshacerCambio(Guardarropas unGuardarropas){
        unGuardarropas.agregarPrenda(this.getUnaPrenda());
    }
}
