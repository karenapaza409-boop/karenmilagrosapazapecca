package pe.edu.upeu.conceptospoo.cñaseinterna;

public class claseexterna {
    int a,b;

    int operacion(){
return a+b;
    }

    class claseinterna{

        int r;
        void mensaje(){
            r=a+b;
            System.out.println("la suma es "+r);
        }

    }
    class claseinterna2 {
        void otraoperacion() {
            System.out.println("la operacion de resta es" + (a + b));

        }

    }


    public static void main(String[] args) {
        claseexterna ce = new claseexterna();
        ce.a=8;
        ce.b=2;
        System.out.println("la operacion es "+ce.operacion());
        claseinterna ci1=ce.new claseinterna();
        ci1.mensaje();
        claseinterna2 ci2=ce.new claseinterna2();
        ci2.otraoperacion();
    }

}

class claseinternax{

}
class claseinternay{
}