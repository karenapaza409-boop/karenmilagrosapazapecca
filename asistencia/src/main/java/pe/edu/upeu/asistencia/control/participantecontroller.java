package pe.edu.upeu.asistencia.control;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pe.edu.upeu.asistencia.enums.Carrera;
import pe.edu.upeu.asistencia.enums.TipoParticipante;
import pe.edu.upeu.asistencia.modelo.participante;
import pe.edu.upeu.asistencia.servicio.participanteservicioI;

@Controller
public class participantecontroller {
    @FXML
    private TextField txtnombre,txtdni,txtapellidos;
    @FXML
    private ComboBox<Carrera> cbxCarreras;
    @FXML
    private TableColumn<participante, String> dniColumn, nombreColumn, apellidoColumn,carreraColumn,tipoParticipantecolumn;
    @FXML
    private ComboBox<TipoParticipante> cbxTipoParticipante;
    @FXML
    private TableView<participante> tableView;
    ObservableList<participante> listaParticipante;
    @Autowired
    participanteservicioI  ps;

    @FXML
    public void initialize(){
        cbxCarreras.getItems().addAll(Carrera.values());
        cbxTipoParticipante.getItems().addAll(TipoParticipante.values());
        definircolumnas();

    }
    @FXML
    public void registrarparticipante(){
        participante p = new participante();
        p.setDni(new SimpleStringProperty(txtdni.getText()));
        p.setNombre(new SimpleStringProperty(txtnombre.getText()));
        p.setApellido(new SimpleStringProperty(txtapellidos.getText()));
        p.setCarrera(cbxCarreras.getSelectionModel().getSelectedItem());
        p.setTipoparticipante(cbxTipoParticipante.getSelectionModel().getSelectedItem());
        ps.save(p);
        listarparticipante();

    }





    public void definircolumnas(){

    dniColumn=new TableColumn("DNI");
    nombreColumn=new TableColumn("Nombre");
    apellidoColumn=new TableColumn("Apellido");
    carreraColumn=new TableColumn("Carrera");
    tipoParticipantecolumn=new TableColumn("Tipo Participante");
    tableView.getColumns().addAll(dniColumn, nombreColumn, apellidoColumn,carreraColumn,tipoParticipantecolumn);

    }
    public void listarparticipante(){
        dniColumn.setCellValueFactory(cellData->cellData.getValue().getDni() );
        nombreColumn.setCellValueFactory(cellData->cellData.getValue().getNombre() );
        apellidoColumn.setCellValueFactory(cellData->cellData.getValue().getApellido() );
        carreraColumn.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getCarrera().toString()));
        listaParticipante= FXCollections.observableArrayList(ps.findAll());
        tableView.setItems(listaParticipante);



    }

}
