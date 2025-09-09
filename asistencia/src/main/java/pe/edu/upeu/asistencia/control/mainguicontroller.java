package pe.edu.upeu.asistencia.control;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import javax.naming.Context;
import java.util.Map;

@Controller
public class mainguicontroller {
    @FXML
    private BorderPane bp;
    @FXML
    MenuBar menuBar;
    @FXML
    TabPane tabPane;
    @FXML
    MenuItem menuItem1,menuItemC;
    ComboBox<String> combobox;
    Menu menuestilos=new Menu("cambiar nombres");

    CustomMenuItem customMenuItem;

    @Autowired
    ApplicationContext Context;


   @FXML
    public void initialize(){
       combobox=new ComboBox<>();
       customMenuItem=new CustomMenuItem(combobox);
       combobox.getItems().addAll("estilo por defecto","estilo oscuro","estilo rosado","estilo verde","estilo azul");
       combobox.setOnAction(e->cambiarestilo());

       customMenuItem.setHideOnClick(false);
       menuestilos.getItems().addAll(customMenuItem);
       menuBar.getMenus().addAll(menuestilos);


       menuItemlistener mIL=new menuItemlistener();
       menuItem1.setOnAction (mIL::handle);
       menuItemC.setOnAction (mIL::handle);



   }


   public void cambiarestilo() {
       String estilo = combobox.getSelectionModel().getSelectedItem();
       Scene scene = bp.getScene();
       scene.getStylesheets().clear();
       switch(estilo){
           case "estilo oscuro":scene.getStylesheets().add(getClass().getResource("/css/estilo-oscuro.css").toExternalForm());break;
           case "estilo rosado":scene.getStylesheets().add(getClass().getResource("/css/estilo-rosado.css").toExternalForm());break;
           case "estilo verde":scene.getStylesheets().add(getClass().getResource("/css/estilo-verde.css").toExternalForm());break;
           case "estilo azul":scene.getStylesheets().add(getClass().getResource("/css/estilo-azul.css").toExternalForm());break;


default:break;




       }
   }




   class menuItemlistener{
       Map<String, String[]>menuConfig= Map.of(
               "menuItem1",new String[]{"/FXMLKAREN/main_participante.fxml","Reg.Participante","T"},
               "menuItemC",new String[]{"/FXMLKAREN/login.fxml","salir","C"}


       );


       public void handle(ActionEvent e){
           String id=((MenuItem)e.getSource()).getId();
           if(menuConfig.containsKey(id)){
               String[] items=menuConfig.get(id);
               if(items[2].equals("C")){
                   Platform.exit();
                   System.exit(0);
               }else {
                   abrirtabPaneFXML(items[0], items[1]);

               }

           }


       }

       private void abrirtabPaneFXML(String fxmlPath, String tittle){
           try {
               FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));
               fxmlLoader.setControllerFactory(Context::getBean);
               Parent root = fxmlLoader.load();

               ScrollPane scrollPane = new  ScrollPane(root);
               scrollPane.setFitToWidth(true);
               scrollPane.setFitToWidth(true);

               Tab newTab = new Tab(tittle, scrollPane);
               tabPane.getTabs().clear();




               tabPane.getTabs().add(newTab);



           }catch (Exception ex){

               throw new RuntimeException(ex);

           }
       }




   }
    class menulistener{
       public void handle(Event e){

       }

    }

}