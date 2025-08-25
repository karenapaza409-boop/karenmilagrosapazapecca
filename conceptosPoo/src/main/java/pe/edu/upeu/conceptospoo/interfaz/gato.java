package pe.edu.upeu.conceptospoo.interfaz;

public class gato implements animal{

    @Override
    public void emitirsonido() {
        System.out.println("miau miauuuu");
    }

    @Override
    public void dormir() {
        System.out.println("zzzzzzzzzzzz");

    }
}
