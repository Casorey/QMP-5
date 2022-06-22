package main;

import main.QMP6.IntermediarioAPI;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Usuario {

    private List<Guardarropas> guardarropasConocidos; //no es necesariamente dueño
    private List<Guardarropas> guardarropasQueLePertenecen;
    private Atuendo atuendoDiario;
    String ciudad;
    Map<String, List<String>> ultimasAlertas=new HashMap<String, List<String>>();
    IntermediarioAPI intermediarioAsociado;


    public void setAtuendoDiario(Atuendo atuendoDiario) {
        this.atuendoDiario = atuendoDiario;
    }

    /*
    QMP6-Como usuarie de QuéMePongo, quiero poder conocer las condiciones climáticas de Buenos Aires en un momento dado para obtener sugerencias acordes.
     */
    public void recibirSugerenciaDiaria(Fashonista fashonista){
        setAtuendoDiario(fashonista.sugerirAtuendo(ciudad,guardarropasQueLePertenecen.get(0)));
    }

    /*
    QMP6-Como usuarie de QueMePongo, quiero poder conocer cuáles son las últimas alertas meteorológicas publicadas en el sistema para
     estar informado (pudiendo verlas, por ejemplo, al entrar en quemepongo.com)
     */
    public void conocerUltimasAlertas(){
        ultimasAlertas=intermediarioAsociado.ultimasAlertas(ciudad);
    }



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
        unaPropuesta.serAceptada(unGuardarropa);
    }
    public void deshacer(Propuesta unaPropuesta, Guardarropas unGuardarropa){
        unaPropuesta.deshacer(unGuardarropa);
    }

}