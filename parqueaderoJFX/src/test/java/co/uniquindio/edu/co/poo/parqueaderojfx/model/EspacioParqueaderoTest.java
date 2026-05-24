package co.uniquindio.edu.co.poo.parqueaderojfx.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EspacioParqueaderoTest {

    @Test
    void asignarEspacio() {
        Vehiculo vehiculo = new Vehiculo("VRK42F", "Majo", 1004446220, "03:00", "03:30", null, TipoVehiculo.MOTOCICLETA, null,EstadoVehiculo.DENTRO);
        EspacioParqueadero espacio= new EspacioParqueadero(1, TipoVehiculo.MOTOCICLETA);
        espacio.asignarEspacio(vehiculo);
        assertEquals(EstadoEspacio.OCUPADO, espacio.getEstadoEspacio());
    }

    @Test
    void liberarEspacio() {
        Vehiculo vehiculo = new Vehiculo("VRK42F", "Majo", 1004446220, "03:00", "03:30", null, TipoVehiculo.MOTOCICLETA, null,EstadoVehiculo.DENTRO);
        EspacioParqueadero espacio= new EspacioParqueadero(1, TipoVehiculo.MOTOCICLETA);
        espacio.asignarEspacio(vehiculo);
        espacio.liberarEspacio();
        assertEquals(EstadoEspacio.DISPONIBLE, espacio.getEstadoEspacio());
    }

    @Test
    void cambiarEstadoMantenimiento() {
        EspacioParqueadero espacio= new EspacioParqueadero(1, TipoVehiculo.MOTOCICLETA);
        espacio.cambiarEstadoMantenimiento();
        assertEquals(EstadoEspacio.MANTENIMIENTO, espacio.getEstadoEspacio());
    }

    @Test
    void getCodigo() {
        EspacioParqueadero espacio= new EspacioParqueadero(1, TipoVehiculo.MOTOCICLETA);
        assertEquals(1, espacio.getCodigo());
    }

    @Test
    void setCodigo() {
        EspacioParqueadero espacio= new EspacioParqueadero(1, TipoVehiculo.MOTOCICLETA);
        espacio.setCodigo(2);
        assertEquals(2, espacio.getCodigo());
    }

    @Test
    void getEstadoEspacio() {
        EspacioParqueadero espacio= new EspacioParqueadero(1, TipoVehiculo.MOTOCICLETA);
        assertEquals(EstadoEspacio.DISPONIBLE, espacio.getEstadoEspacio());
    }

    @Test
    void setEstadoEspacio() {
        EspacioParqueadero espacio= new EspacioParqueadero(1, TipoVehiculo.MOTOCICLETA);
        espacio.setEstadoEspacio(EstadoEspacio.OCUPADO);
        assertEquals(EstadoEspacio.OCUPADO, espacio.getEstadoEspacio());
    }

    @Test
    void getTipoVehiculo() {
        EspacioParqueadero espacio= new EspacioParqueadero(1, TipoVehiculo.MOTOCICLETA);
        assertEquals(TipoVehiculo.MOTOCICLETA, espacio.getTipoVehiculo());
    }

    @Test
    void setTipoVehiculo() {
        EspacioParqueadero espacio= new EspacioParqueadero(1, TipoVehiculo.MOTOCICLETA);
        espacio.setTipoVehiculo(TipoVehiculo.CARRO);
        assertEquals(TipoVehiculo.CARRO, espacio.getTipoVehiculo());
    }

    @Test
    void getTheVehiculo() {
        Vehiculo vehiculo = new Vehiculo("VRK42F", "Majo", 1004446220, "03:00", "03:30", null, TipoVehiculo.MOTOCICLETA, null,EstadoVehiculo.DENTRO);
        EspacioParqueadero espacio= new EspacioParqueadero(1, TipoVehiculo.MOTOCICLETA);
        espacio.asignarEspacio(vehiculo);
        assertEquals(vehiculo, espacio.getTheVehiculo());

    }
}