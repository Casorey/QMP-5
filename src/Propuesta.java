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

    public void serAceptada() {setEstadoPropuesta(EstadoPropuesta.ACEPTADA);
    }

    public void procesarPropuesta(Guardarropas unGuardarropas){}


}

