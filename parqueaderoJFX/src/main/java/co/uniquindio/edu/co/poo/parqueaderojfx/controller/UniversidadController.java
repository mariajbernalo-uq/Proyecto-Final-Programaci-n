package co.uniquindio.edu.co.poo.parqueaderojfx.controller;

import co.uniquindio.edu.co.poo.parqueaderojfx.model.Universidad;

public class UniversidadController {

    private Universidad universidad;

    public UniversidadController(Universidad universidad) {
        this.universidad = universidad;
    }

    public String generarReporteGeneral() {
        return universidad.generarReporte();
    }

    public String consultarEstadoEspacios() {
        return universidad.consultarEstadoEspacios();
    }

    public String consultarVehiculosEstacionados() {
        return universidad.consultarVehiculosEstacionados();
    }

    public double calcularIngresosGeneradosDia() {
        return universidad.ingresosGeneradosDia();
    }

    public double calcularTiempoPromedioPermanencia() {
        return universidad.tiempoPromedioPermanencia();
    }

    public String consultarVehiculosMasDeHoras(double horas) {
        return universidad.vehiculosMasDeDeterminadasHoras(horas);
    }
}
