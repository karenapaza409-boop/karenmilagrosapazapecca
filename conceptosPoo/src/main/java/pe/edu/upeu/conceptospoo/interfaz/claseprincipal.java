package pe.edu.upeu.conceptospoo.interfaz;

public class claseprincipal {
    public static void main(String[] args) {
        animal animal = new loro();
        animal.emitirsonido();
        animal.dormir();

        animal  = new gato();
        animal.emitirsonido();
        animal.dormir();

    }

}
