package co.uniquindio.edu.co.poo.parqueaderojfx.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniversidadTest {

    @Test
    void obtenerVehiculoTest() {
        Universidad universidad=new Universidad("UQ",1236,"Cra 14");
        EspacioParqueadero espacioParqueadero=new EspacioParqueadero(3,TipoVehiculo.CARRO);
        Usuario usuario=new Usuario("Sofia","1092851",TipoUsuario.ESTUDIANTE);
        Vehiculo vehiculo=new Vehiculo("MXQ852", "Sofia",1092851,"08:00","12:00",null,TipoVehiculo.CARRO,null,EstadoVehiculo.FUERA);
        universidad.getListVehiculos().add(vehiculo);
        assertEquals(vehiculo,universidad.obtenerVehiculo("MXQ852"));

    }

    @Test
    void registrarVehiculoTest() {
        Universidad universidad=new Universidad("UQ",1236,"Cra 14");
        Vehiculo vehiculo=new Vehiculo("MXQ852","Sofia",1235,"02:00","05:00",null,TipoVehiculo.CARRO,null,EstadoVehiculo.DENTRO);
        universidad.getListVehiculos().add(vehiculo);
        assertEquals(true,universidad.registrarVehiculo(vehiculo));
    }

    @Test
    void registrarEntradaVehiculoTest() {
        Universidad universidad=new Universidad("UQ", 1236,"Cra 14");
        EspacioParqueadero espacioParqueadero=new EspacioParqueadero(5,TipoVehiculo.CARRO);
        universidad.getListEspaciosParqueaderos().add(espacioParqueadero);
       String resultado= universidad.registrarEntradaVehiculo("MXQ852","Sofia",1235,"02:00",TipoVehiculo.CARRO,null);
        assertEquals("Se ha añadido el vehículo exitosamente",resultado);
    }

    @Test
    void calcularTiempoPermanenciaTest() {
        Universidad universidad=new Universidad("uq",159,"34");
        Vehiculo vehiculo=new Vehiculo("mq","sofia",147,"08:00","12:00",null,TipoVehiculo.CARRO,null,EstadoVehiculo.DENTRO);
        assertEquals(4.0,universidad.calcularTiempoPermanencia("08:00","12:00"));
    }
    @Test
    void registrarSalidaVehiculoTest(){
        Universidad universidad=new Universidad("uq",159,"34");
        Vehiculo vehiculo=new Vehiculo("mq","sofia",147,"08:00","12:00",null,TipoVehiculo.CARRO,null,EstadoVehiculo.DENTRO);
        assertEquals();   }
    @Test
    void buscarEspacioDisponible() {
    }

    @Test
    void obtenerEspacio() {
    }

    @Test
    void registrarNuevoEspacio() {
    }

    @Test
    void modificarEspacio() {
    }

    @Test
    void deshabilitarEspacio() {
    }

    @Test
    void existeEspacioDisponible() {
    }

    @Test
    void consultarEstadoEspacios() {
    }

    @Test
    void consultarVehiculosEstacionados() {
    }

    @Test
    void obtenerTarifaPorTipoVehiculo() {
    }

    @Test
    void registrarTarifa() {
    }
}