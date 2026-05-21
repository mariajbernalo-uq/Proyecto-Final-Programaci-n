package co.uniquindio.edu.co.poo.parqueaderojfx;

import co.uniquindio.edu.co.poo.parqueaderojfx.controller.PrimaryController;
import co.uniquindio.edu.co.poo.parqueaderojfx.model.TipoUsuario;
import co.uniquindio.edu.co.poo.parqueaderojfx.model.TipoVehiculo;
import co.uniquindio.edu.co.poo.parqueaderojfx.model.Universidad;
import co.uniquindio.edu.co.poo.parqueaderojfx.viewController.*;
import co.uniquindio.edu.co.poo.parqueaderojfx.viewController.PrimaryViewController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    private Stage primaryStage;

    public Universidad universidad =
            new Universidad(
                    "Universidad del Quindío",
                    123456789,
                    "Armenia"
            );

    @Override
    public void start(Stage stage) {

        this.primaryStage = stage;

        inicializarDatosBase();

        openPrimaryView();
    }

    private void inicializarDatosBase() {

        universidad.registrarNuevoEspacio(1, TipoVehiculo.CARRO);
        universidad.registrarNuevoEspacio(2, TipoVehiculo.CARRO);
        universidad.registrarNuevoEspacio(3, TipoVehiculo.MOTOCICLETA);
        universidad.registrarNuevoEspacio(4, TipoVehiculo.BICICLETA);

        universidad.registrarUsuario(
                "Administrador",
                "1001",
                TipoUsuario.ADMINISTRATIVO
        );

        universidad.registrarTarifa(TipoVehiculo.CARRO, TipoUsuario.VISITANTE);
        universidad.registrarTarifa(TipoVehiculo.MOTOCICLETA, TipoUsuario.VISITANTE);
        universidad.registrarTarifa(TipoVehiculo.BICICLETA, TipoUsuario.VISITANTE);
    }

    public void openPrimaryView() {

        try {

            FXMLLoader loader =
                    new FXMLLoader(
                            App.class.getResource("Primary.fxml")
                    );

            Scene scene = new Scene(loader.load());

            PrimaryViewController controller =
                    loader.getController();

            controller.setApp(this);

            primaryStage.setScene(scene);
            primaryStage.setTitle("PARKUQ - Bienvenida");
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openOpcionesParqueaderoView() {

        try {

            FXMLLoader loader =
                    new FXMLLoader(
                            App.class.getResource("OpcionesParqueadero.fxml")
                    );

            Scene scene = new Scene(loader.load());

            OpcionesParqueaderoViewController controller =
                    loader.getController();

            controller.setApp(this);

            primaryStage.setScene(scene);
            primaryStage.setTitle("PARKUQ - Opciones");
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openVehiculoView() {

        try {

            FXMLLoader loader =
                    new FXMLLoader(
                            App.class.getResource("Vehiculo.fxml")
                    );

            Scene scene = new Scene(loader.load());

            VehiculoViewController controller =
                    loader.getController();

            controller.setApp(this);

            primaryStage.setScene(scene);
            primaryStage.setTitle("Gestión de Vehículos");
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openUsuarioView() {

        try {

            FXMLLoader loader =
                    new FXMLLoader(
                            App.class.getResource("Usuario.fxml")
                    );

            Scene scene = new Scene(loader.load());

            UsuarioViewController controller =
                    loader.getController();

            controller.setApp(this);

            primaryStage.setScene(scene);
            primaryStage.setTitle("Gestión de Usuarios");
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openTarifaView() {

        try {

            FXMLLoader loader =
                    new FXMLLoader(
                            App.class.getResource("Tarifa.fxml")
                    );

            Scene scene = new Scene(loader.load());

            TarifaViewController controller =
                    loader.getController();

            controller.setApp(this);

            primaryStage.setScene(scene);
            primaryStage.setTitle("Gestión de Tarifas");
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openEspacioParqueaderoView() {

        try {

            FXMLLoader loader =
                    new FXMLLoader(
                            App.class.getResource("EspacioParqueadero.fxml")
                    );

            Scene scene = new Scene(loader.load());

            EspacioParqueaderoViewController controller =
                    loader.getController();

            controller.setApp(this);

            primaryStage.setScene(scene);
            primaryStage.setTitle("Gestión de Espacios");
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openUniversidadView() {

        try {

            FXMLLoader loader =
                    new FXMLLoader(
                            App.class.getResource("Universidad.fxml")
                    );

            Scene scene = new Scene(loader.load());

            UniversidadViewController controller =
                    loader.getController();

            controller.setApp(this);

            primaryStage.setScene(scene);
            primaryStage.setTitle("Reportes del Parqueadero");
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cerrarAplicacion() {
        primaryStage.close();
    }

    public static void main(String[] args) {
        launch();
    }
}