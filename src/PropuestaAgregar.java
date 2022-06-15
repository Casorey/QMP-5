public class PropuestaAgregar extends Propuesta{


    public PropuestaAgregar(Prenda unaPrenda, TipoPropuesta agregar) {
        super();
    }

    @Override
    public void procesarPropuesta(Guardarropas unGuardarropas){
        unGuardarropas.agregarPrenda(this.getUnaPrenda());
    }

    @Override
    public void deshacerCambio(Guardarropas unGuardarropas){
        unGuardarropas.quitarPrenda(this.getUnaPrenda());
    }
}
