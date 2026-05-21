package co.uniquindio.edu.co.poo.parqueaderojfx.viewController;

import co.uniquindio.edu.co.poo.parqueaderojfx.App;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class UniversidadViewController {

    private App app;

    @FXML
    private TextArea txtAreaReportes;

    @FXML
    void onConsultarEstadoEspacios() {

        String reporte =
                app.universidad.consultarEstadoEspacios();

        txtAreaReportes.setText(reporte);
    }

    @FXML
    void onConsultarVehiculos() {

        txtAreaReportes.setText(
                app.universidad.getListVehiculos().toString()
        );
    }

    @FXML
    void onVolver() {

        app.openOpcionesParqueaderoView();
    }

    public void setApp(App app) {

        this.app = app;
    }
}
