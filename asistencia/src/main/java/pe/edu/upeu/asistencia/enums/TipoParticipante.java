package pe.edu.upeu.asistencia.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter

public enum TipoParticipante {


    ORGANIZADOR("ORGANIZADOR"),
    ASISTENTE("ASISTENTE"),
    PONENTE("PONENTE");

    private String descripcion;





}
