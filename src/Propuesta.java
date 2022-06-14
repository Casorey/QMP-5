public class Propuesta {
    private Prenda unaPrenda;
    private TipoPropuesta tipoDePropuesta;

    private EstadoPropuesta estadoPropuesta;


    Propuesta(Prenda unaPrenda, TipoPropuesta tipoDePropuesta){
        this.unaPrenda = unaPrenda;
        this.tipoDePropuesta = tipoDePropuesta;
        this.estadoPropuesta = EstadoPropuesta.ESPERANDO;
    }

    public void setEstadoPropuesta(EstadoPropuesta estadoPropuesta) {
        this.estadoPropuesta = estadoPropuesta;
    }
}

