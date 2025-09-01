package pe.edu.upeu.asistencia.control;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pe.edu.upeu.asistencia.modelo.participante;
import pe.edu.upeu.asistencia.servicio.participanteservicioI;


@Controller
public class asistenciacontrol {

    @Autowired
    participanteservicioI esi;

    @FXML
    private Label idMsg;
    @FXML
    TextField txtDato;
    @FXML
    Button btnEnviar;

    @FXML
    void enviar(){
        System.out.println("enviar asistencia");
        idMsg.setText(txtDato.getText());
    }

    @FXML
    public void regestudiante(){
        participante e = new participante();
        e.setNombre(new SimpleStringProperty(txtDato.getText()));
        e.setEstado(new SimpleBooleanProperty(true));

        esi.save(new participante());

        listaestudiantes();

    }

    void listaestudiantes(){
        for(participante e: esi.findAll()){
            System.out.println(e.getNombre());
        }
    }


}
