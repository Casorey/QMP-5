public abstract class Propuesta {
    private Prenda unaPrenda;
    private TipoPropuesta tipoDePropuesta;

    private EstadoPropuesta estadoPropuesta;



    public Prenda getUnaPrenda(){
        return unaPrenda;
    }
    public void setEstadoPropuesta(EstadoPropuesta estadoPropuesta) {
        this.estadoPropuesta = estadoPropuesta;
    }


    public EstadoPropuesta getEstadoPropuesta() {return estadoPropuesta;
    }

    public void serRechazada() {
        setEstadoPropuesta(EstadoPropuesta.RECHAZADA);
    }

    public void serAceptada(Guardarropas unGuardarropas) {setEstadoPropuesta(EstadoPropuesta.ACEPTADA);
        this.procesarPropuesta(unGuardarropas);
    }

    public void procesarPropuesta(Guardarropas unGuardarropas) {
    }
    public void deshacer(Guardarropas unGuardarropas){
        this.estadoPropuesta=EstadoPropuesta.ESPERANDO;
        this.deshacerCambio(unGuardarropas);
    }

    public void deshacerCambio(Guardarropas unGuardarropas) {
    }


}

