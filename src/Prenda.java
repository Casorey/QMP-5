import static java.util.Objects.requireNonNull;
import java.util.ArrayList;

enum Trama {LISA, RAYADA, CUADROS};

public class Prenda {

  Tipo tipo;
  Material material;
  Trama trama;
  Color color;
  Color colorSecundario;
  double temperaturaMaxima;
  double temperaturaMinima;
  boolean aptoParaLluvia;

  Prenda(Tipo tipo,Material material,Trama trama,Color color, Color colorSecundario, double temperaturaMaxima,double temperaturaMinima, boolean aptoParaLluvia) {
    this.tipo = tipo;
    this.material = material;
    this.trama = trama;
    this.color = color;
    this.colorSecundario = colorSecundario;
    this.temperaturaMaxima = temperaturaMaxima;
    this.temperaturaMinima = temperaturaMinima;
    this.aptoParaLluvia = aptoParaLluvia;
  }

  Categoria categoria(){
    return tipo.categoria();
  }

  private int cantidadDeUsos = 0;
  private EstadoPrenda estadoPrenda= new PrendaLimpia();

  public void serUsada(){
    nuevoUso();
    estadoPrenda.usar(this);}

  public void lavar(){
    estadoPrenda.lavarPrenda(this);
  }
  public void nuevoUso(){
    this.cantidadDeUsos+=1;
  }

  public int getCantidadDeUsos() {
    return 0;
  }
  public void setEstado(EstadoPrenda estado){
    this.estadoPrenda =  estado;
  }

  public void setCantidadUsos(int i) {
    this.cantidadDeUsos = i;
  }

  boolean esSugerible(double temperatura, boolean lluvia){

    if(lluvia) {
      return estadoPrenda.sugerible() &&
              this.aptoTemperatura(temperatura) &&
              this.isAptoParaLluvia();
    } else {

      return estadoPrenda.sugerible() &&
             this.aptoTemperatura(temperatura);


    }
  }

  boolean aptoTemperatura(double temperatura){
    return temperaturaMinima <= temperatura && temperatura <= temperaturaMaxima;
  }

  boolean isAptoParaLluvia(){
    return aptoParaLluvia;
  }
}

class Borrador{

  Tipo tipo;
  Material material;
  Trama trama = Trama.LISA;
  Color color;
  Color colorSecundario;
  double temperaturaMaxima;
  double temperaturaMinima;
  boolean aptoParaLluvia;

  Borrador(Tipo tipo){
    requireNonNull(tipo, "es necesario ingresar un tipo");
    this.tipo = tipo;
  }

  void definirMaterial(Material materia){
    requireNonNull(material, "es necesario ingresar un material");
    this.elMaterialEsValidoConElTipo(material);
    this.material = materia;
  }

  void definirTrama(Trama trama){
    requireNonNull(material, "es necesario ingresar un material");
    this.trama = trama;
  }

  void definirColorPrimario(Color color){
    requireNonNull(color, "es necesario ingresar un color");
    this.color = color;
  }

  void definirTemperaturaMaxima(double tempMaxima){
    this.temperaturaMaxima = tempMaxima;
  }

  void definirTemperaturaMinima(double tempMin){
    this.temperaturaMinima = tempMin;
  }

  void definirAptoParaLluvia(boolean esAptoParaLluvia){
    this.aptoParaLluvia = esAptoParaLluvia;
  }

  void definirColorSecundario(Color color){
    this.colorSecundario = color;
  }
  Prenda crearPrenda(){
    return new Prenda(tipo,material,trama,color,colorSecundario,temperaturaMaxima, temperaturaMinima, aptoParaLluvia);
  }
}

class Uniforme{

  Prenda prendaSuperior;
  Prenda prendaInferior;
  Prenda calzado;
  ArrayList<Prenda> Accesorios;

  Uniforme(Prenda prendaSuperior,Prenda prendaInferior, Prenda calzado){
    this.prendaSuperior = prendaSuperior;
    this.prendaInferior = prendaInferior;
    this.calzado = calzado;
  }
}

abstract class Sastreria{

  Uniforme crearUniforme() {
    return new Uniforme(
            this.crearPrendaSuperior(),
            this.crearPrendaInferior(),
            this.crearCalzado()
    );
  }
    abstract Prenda crearPrendaSuperior();
    abstract Prenda crearPrendaInferior();
    abstract Prenda crearCalzado();

};

class SastreriaSanJuan extends Sastreria{
  Prenda crearPrendaSuperior(){
    Borrador borrador = new Borrador(new Tipo(Categoria.PRENDA_SUPERIOR,[Material.ALGODON]));
    borrador.definirColorPrimario(new Color(0,255,0));
    borrador.definirMaterial(Material.ALGODON);
    return borrador.crearPrenda();
  };

  Prenda crearPrendaInferior(){
    Borrador borrador = new Borrador(new Tipo(Categoria.PRENDA_INFERIOR,[Material.ACETATO]));
    borrador.definirColorPrimario(new Color(100,100,100));
    borrador.definirMaterial(Material.ACETATO);
    return borrador.crearPrenda();
  };

  Prenda crearCalzado(){
    Borrador borrador = new Borrador(new Tipo(Categoria.CALZADO,[Material.CAUCHO]));
    borrador.definirColorPrimario(new Color(0,0,0));
    borrador.definirMaterial(Material.CAUCHO);
    return borrador.crearPrenda();
  };

}

class SastreriaJohnson extends Sastreria{
  Prenda crearPrendaSuperior(){
    Borrador borrador = new Borrador(new Tipo(Categoria.PRENDA_SUPERIOR,[Material.LINO]));
    borrador.definirColorPrimario(new Color(255,255,255));
    borrador.definirMaterial(Material.LINO);
    return borrador.crearPrenda();
  };

  Prenda crearPrendaInferior(){
    Borrador borrador = new Borrador(new Tipo(Categoria.PRENDA_INFERIOR,[Material.SARGA]));
    borrador.definirColorPrimario(new Color(0,0,0));
    borrador.definirMaterial(Material.SARGA);
    return borrador.crearPrenda();
  };

  Prenda crearCalzado(){
    Borrador borrador = new Borrador(new Tipo(Categoria.CALZADO,[Material.CUERO,Material.CUERINA]));
    borrador.definirColorPrimario(new Color(0,0,0));
    borrador.definirMaterial(Material.CUERO);
    return borrador.crearPrenda();
  };
}

