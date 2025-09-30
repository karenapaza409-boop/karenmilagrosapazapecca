package pe.edu.upeu.asistencia.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum Carrera {


    SISTEMAS(Facultad.FIA,"sistemas"),
    civil(Facultad.FIA,"civil"),
    general(Facultad.GENERAL,"general"),;

    private Facultad facultad;
    private String descripcion;

}