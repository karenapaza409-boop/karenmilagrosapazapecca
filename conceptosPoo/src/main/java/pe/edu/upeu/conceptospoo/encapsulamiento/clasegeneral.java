package pe.edu.upeu.conceptospoo.encapsulamiento;

public class clasegeneral {
    public static void main(String[] args) {
        persona persona = new persona();
        persona.setNombre("karen");
        persona.setEdad(18);

        System.out.println("nombre"+persona.getNombre());
        System.out.println("edad"+persona.getNombre());

        persona.saludar();

    }
}
