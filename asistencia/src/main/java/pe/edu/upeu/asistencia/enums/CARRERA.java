package pe.edu.upeu.asistencia.enums;

public enum CARRERA {


    Sistemas(FACULTAD.FIA),
    civil(FACULTAD.FIA),
    general(FACULTAD.GENERAL);

    private  FACULTAD facultad;
    private CARRERA(FACULTAD facultad) {
        this.facultad = facultad;


    }
    public FACULTAD getFacultad() {return facultad;}

}
