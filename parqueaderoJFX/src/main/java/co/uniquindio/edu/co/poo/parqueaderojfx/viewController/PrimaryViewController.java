package co.uniquindio.edu.co.poo.parqueaderojfx.viewController;

import co.uniquindio.edu.co.poo.parqueaderojfx.App;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class PrimaryViewController {

    private App app;

    private co.uniquindio.edu.co.poo.parqueaderojfx.controller.PrimaryController primaryController;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label welcomeText;

    @FXML
    void onOpenOpcionesParqueadero() {

        primaryController.abrirOpcionesParqueadero();
    }

    @FXML
    void initialize() {

    }

    public void setApp(App app) {

        this.app = app;

        this.primaryController =
                new co.uniquindio.edu.co.poo.parqueaderojfx.controller.PrimaryController(app);
    }
}