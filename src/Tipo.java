import java.util.ArrayList;

enum Categoria{ PRENDA_SUPERIOR, PRENDA_INFERIOR, CALZADO, ACCESORIO};

public class Tipo{
    Categoria categoria;
    ArrayList<Material> materialesValidos;

    Tipo(Categoria categoria, ArrayList<Material> materialesValidos){
        this.categoria = categoria;
    }

    Categoria categoria(){
        return categoria;
    }
}
