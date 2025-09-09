package pe.edu.upeu.asistencia.control;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pe.edu.upeu.asistencia.enums.Carrera;
import pe.edu.upeu.asistencia.enums.TipoParticipante;
import pe.edu.upeu.asistencia.modelo.participante;
import pe.edu.upeu.asistencia.repositorio.participanterepositorio;
import pe.edu.upeu.asistencia.servicio.participanteservicioI;

@Controller
public class participantecontroller {
    @FXML
    private TextField txtnombre,txtdni,txtapellidos;
    @FXML
    private ComboBox<Carrera> cbxCarreras;
    @FXML
    private TableColumn<participante, String> dniColumn, nombreColumn, apellidoColumn,carreraColumn,tipoParticipantecolumn;
    private TableColumn<participante, Void> opcColum;


    @FXML
    private ComboBox<TipoParticipante> cbxTipoParticipante;
    @FXML
    private TableView<participante> tableView;


    ObservableList<participante> listaParticipante;
    @Autowired
    participanteservicioI  ps;

    int indexE=-1;



    @FXML
    public void initialize(){
        cbxCarreras.getItems().addAll(Carrera.values());
        cbxTipoParticipante.getItems().addAll(TipoParticipante.values());
        definircolumnas();
        listarparticipante();

    }
    @FXML
    public void registrarparticipante(){
        participante p = new participante();
        p.setDni(new SimpleStringProperty(txtdni.getText()));
        p.setNombre(new SimpleStringProperty(txtnombre.getText()));
        p.setApellido(new SimpleStringProperty(txtapellidos.getText()));
        p.setCarrera(cbxCarreras.getSelectionModel().getSelectedItem());
        p.setTipoparticipante(cbxTipoParticipante.getSelectionModel().getSelectedItem());
        if(indexE==-1){
            ps.save(p);
        }else {
            ps.update(p, indexE);
        }
        listarparticipante();

    }





    public void definircolumnas(){

    dniColumn=new TableColumn("DNI");
    nombreColumn=new TableColumn("Nombre");
    apellidoColumn=new TableColumn("Apellido");
    carreraColumn=new TableColumn("Carrera");
    tipoParticipantecolumn=new TableColumn("Tipo Participante");
    opcColum=new TableColumn("opciones");
    tableView.getColumns().addAll(dniColumn, nombreColumn, apellidoColumn,carreraColumn,tipoParticipantecolumn,opcColum);

    }
    public void agregaraccionbotones(){
        Callback<TableColumn<participante, Void>, TableCell<participante, Void>> cellFactory = param->new TableCell<>(){
            private final Button editarBtn = new Button("Editar");
            private final Button eliminarBtn = new Button("Eliminar");
            {

                editarBtn.setOnAction(event -> {
                    participante p = getTableView().getItems().get(getIndex());
                  editardatos(p,getIndex());
                });
                eliminarBtn.setOnAction(event -> {
                    System.out.println("eliminando participante"+getIndex());
                   eliminarParticipante(getIndex());
                });

            }


            @Override
            public void updateItem(Void item, boolean empty){
                super.updateItem(item, empty);
                if(empty){
                    setGraphic(null);
                }else{
                    HBox hbox = new HBox(editarBtn, eliminarBtn);
                    hbox.setSpacing(10);
                    setGraphic(hbox);
                }
            }
        };
        opcColum.setCellFactory(cellFactory);



    }

    public void listarparticipante(){
        dniColumn.setCellValueFactory(cellData->cellData.getValue().getDni() );
        nombreColumn.setCellValueFactory(cellData->cellData.getValue().getNombre() );
        apellidoColumn.setCellValueFactory(cellData->cellData.getValue().getApellido() );
        carreraColumn.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getCarrera().toString()));
        agregaraccionbotones();
        listaParticipante= FXCollections.observableArrayList(ps.findAll());
        tableView.setItems(listaParticipante);

    }

    public void eliminarParticipante(int index){
        ps.delete(index);
        listarparticipante();
    }
    public void editardatos(participante p, int index){
        txtdni.setText(p.getDni().getValue());
        txtnombre.setText(p.getNombre().getValue());
        txtapellidos.setText(p.getApellido().getValue());
        cbxCarreras.getSelectionModel().select(p.getCarrera());
        cbxTipoParticipante.getSelectionModel().select(p.getTipoparticipante());
        indexE=index;
    }

}
