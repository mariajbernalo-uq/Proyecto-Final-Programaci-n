package co.uniquindio.edu.co.poo.parqueaderojfx.controller;

import co.uniquindio.edu.co.poo.parqueaderojfx.App;

public class PrimaryController {

    private App app;

    public PrimaryController(App app) {

        this.app = app;
    }

    public void abrirOpcionesParqueadero() {

        app.openOpcionesParqueaderoView();
    }
}