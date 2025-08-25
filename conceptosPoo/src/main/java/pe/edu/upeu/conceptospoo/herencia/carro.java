package pe.edu.upeu.conceptospoo.herencia;

public class carro extends vehiculo{
    String color="BLANCO";
    String modelo="HILUX";



    void caracteristicas(){
        marca="toyota";
        System.out.println("TIENE LAS SIGUIENTES CARACTERISTICAS: "+marca);
        System.out.println("Marca DE este vehiculo es: "+marca);
        System.out.println("MODELO: "+modelo);
        System.out.println("COLOR: "+color);
        System.out.println("emite el siguiente sonido" +sonido());

    }
    public static void main(String[] args) {
        carro carro=new carro();
        carro.caracteristicas();

    }
}
