public class Color {
    int rojo, verde, azul;

    Color(int rojo, int verde, int azul) {
        this.rojo = rojo;
        this.verde = verde;
        this.azul = azul;
    }

    String colorEnHexa() {
        return String.format("#%02x%02x%02x", rojo, verde, azul);
    }
}