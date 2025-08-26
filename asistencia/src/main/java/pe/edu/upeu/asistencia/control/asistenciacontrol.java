package pe.edu.upeu.asistencia.control;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pe.edu.upeu.asistencia.modelo.estudiante;
import pe.edu.upeu.asistencia.servicio.estudianteservioI;


@Controller
public class asistenciacontrol {

    @Autowired
    estudianteservioI esi;

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
        estudiante e = new estudiante();
        e.setNombre(new SimpleStringProperty(txtDato.getText()));
        e.setEstado(new SimpleBooleanProperty(true));

        esi.saveentidad(new estudiante());

        listaestudiantes();

    }

    void listaestudiantes(){
        for(estudiante e: esi.findallentidades()){
            System.out.println(e.getNombre());
        }
    }


}
