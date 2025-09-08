package pe.edu.upeu.asistencia.repositorio;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import pe.edu.upeu.asistencia.enums.Carrera;
import pe.edu.upeu.asistencia.enums.TipoParticipante;
import pe.edu.upeu.asistencia.modelo.participante;

import java.util.ArrayList;
import java.util.List;

public abstract class participanterepositorio {
    public List<participante> listaestudiantes=new ArrayList<>();

public List<participante> findAll(){

    listaestudiantes.add(new participante(


            new SimpleStringProperty("77098082"),
            new SimpleStringProperty("juan"),
            new SimpleStringProperty("apaza"),
            new SimpleBooleanProperty(true), Carrera.Sistemas,
            TipoParticipante.ASISTENTE

           )
    );
    listaestudiantes.add(new participante(
            new SimpleStringProperty("0254852"),
            new SimpleStringProperty("pedro"),
            new SimpleStringProperty("GUTIERREZ"),

            new SimpleBooleanProperty(true), Carrera.Sistemas,
                    TipoParticipante.ASISTENTE


            )
    );

    return listaestudiantes;

}

}
