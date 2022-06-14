import java.util.List;
import java.util.Scanner;

public class Usuario {

    private List<Guardarropas> guardarropasConocidos; //no es necesariamente dueño
    private List<Guardarropas> guardarropasQueLePertenecen;

    public void sugerirUnaPrenda(Prenda unaPrenda, Guardarropas unGuardarropas) throws NoConoceEsteGuardarropa {
        if (guardarropasConocidos.contains(unGuardarropas)) {
            unGuardarropas.agregaPrendaSugerencia(unaPrenda);
        } else {
            throw new NoConoceEsteGuardarropa("No tiene a este guardarropas registrado como conocido");
        }
    }

    public void sugerirQuitarUnaPrenda(Prenda unaPrenda, Guardarropas unGuardarropas) throws NoConoceEsteGuardarropa, PrendaNoEstaEnGuardaropa {
        if (guardarropasConocidos.contains(unGuardarropas)) {
            unGuardarropas.agregaSugerenciaPrendaAQuitar(unaPrenda);
        } else {
            throw new NoConoceEsteGuardarropa("No tiene a este guardarropas registrado como conocido");
        }
    }

    public void crearGuardaroppasNuevo() {
        Guardarropas unGuardarropa = new Guardarropas(this);
        guardarropasQueLePertenecen.add(unGuardarropa);

    }

    public void sacarGuardarropas(Guardarropas guardarropas) throws NoConoceEsteGuardarropa {
        if (!guardarropasQueLePertenecen.contains(guardarropas)) {
            throw new NoConoceEsteGuardarropa("no se conoce al guardarropas a quitar");
        }
        guardarropasQueLePertenecen.remove(guardarropas);
        guardarropas.quitarUsuario(this);
    }

    public void compartirGuardarropasCon(Guardarropas unGuardarropas, Usuario unUsuario) throws NoConoceEsteGuardarropa {
        if (guardarropasQueLePertenecen.contains(unGuardarropas)) {
            unGuardarropas.agregarUsuario(unUsuario);
        } else {
            throw new NoConoceEsteGuardarropa("no se conoce al guardarropas elegido");
        }
    }

    public void rechazarPropueta(Propuesta unaPropuesta, Guardarropas unGuardarropa) throws NoConoceEsteGuardarropa {
        if (!guardarropasQueLePertenecen.contains(unGuardarropa)) {
            throw new NoConoceEsteGuardarropa("no le pertenece el guardarropas");
        }
        unaPropuesta.serRechazada();

    }

    public void aceptarPropueta(Propuesta unaPropuesta, Guardarropas unGuardarropa) throws NoConoceEsteGuardarropa {
        if (!guardarropasQueLePertenecen.contains(unGuardarropa)) {
            throw new NoConoceEsteGuardarropa("no le pertenece el guardarropas");
        }
        unaPropuesta.serAceptada();
    }

    public void evaluarPropuesta(Propuesta unaPropuesta) {


    }
}