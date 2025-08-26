package pe.edu.upeu.conceptospoo.enums;
enum GENERO{M,F}
enum NACIONALIDAD{Peruano,venezolano,boliviano}

public class persona {
    static String nombre;
    static GENERO genero = GENERO.M;
    static NACIONALIDAD nacionalidad = NACIONALIDAD.Peruano;

    public static void main(String[] args) {
        nombre = "karen";
        System.out.println(nombre + "es" + nacionalidad + "y" + genero);
        for (GENERO XX : GENERO.values()) {
            System.out.println(XX);
        }


      for (NACIONALIDAD x: NACIONALIDAD.values()) {
        System.out.println(x);
    }

}

}
