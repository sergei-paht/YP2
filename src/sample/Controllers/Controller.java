package sample.Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.Main;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button info;

    @FXML
    private Button primCom;

    @FXML
    void initialize() {
        info.setOnAction(event -> {
            info.getScene().getWindow().hide();
            Main.OpenIcon("/sample/Windows/twoWin.fxml");

        });
    }

}
