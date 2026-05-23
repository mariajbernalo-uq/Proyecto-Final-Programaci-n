package co.uniquindio.edu.co.poo.parqueaderojfx.viewController;

import co.uniquindio.edu.co.poo.parqueaderojfx.App;
import co.uniquindio.edu.co.poo.parqueaderojfx.controller.UniversidadController;
import co.uniquindio.edu.co.poo.parqueaderojfx.controller.VehiculoController;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class UniversidadViewController {

    private App app;
    private UniversidadController universidadController;

    @FXML
    private TextField txtHoras;

    @FXML
    private TextArea txtAreaReportes;

    @FXML
    void onGenerarReporteGeneral() {

        String reporte = universidadController.generarReporteGeneral();

        txtAreaReportes.setText(reporte);
    }

    @FXML
    void onConsultarEstadoEspacios() {

        String reporte = universidadController.consultarEstadoEspacios();

        txtAreaReportes.setText(reporte);
    }


    @FXML
    void onConsultarVehiculos() {

        String reporte= universidadController.consultarVehiculosEstacionados();
        txtAreaReportes.setText(reporte);
    }

    @FXML
    void onCalcularIngresosDiarios() {
        double reporte= universidadController.calcularIngresosGeneradosDia();
        txtAreaReportes.setText(String.valueOf(reporte));
    }

    @FXML
    void onCalcularTiempoPermanencia() {
        double reporte= universidadController.calcularTiempoPromedioPermanencia();
        txtAreaReportes.setText(String.valueOf(reporte));
    }

    @FXML
    void onConsultarVehiculosHoras() {

        try {

            double horas = Double.parseDouble(txtHoras.getText());

            String reporte = universidadController
                    .consultarVehiculosMasDeHoras(horas);

            txtAreaReportes.setText(reporte);

        } catch (NumberFormatException e) {
            txtAreaReportes.setText("Ingrese un número válido.");
        }

    }
    @FXML
    void onRegresar() {
        app.openOpcionesParqueaderoView();
    }

    public void setApp(App app) {
        this.app = app;
        this.universidadController = new UniversidadController(app.universidad);

    }
}
