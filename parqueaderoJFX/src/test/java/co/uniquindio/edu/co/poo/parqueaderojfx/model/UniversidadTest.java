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
        Usuario usuario=new Usuario("Sofia","1092851",TipoUsuario.ESTUDIANTE);
        universidad.getListEspaciosParqueaderos().add(espacioParqueadero);
        universidad.getListUsuarios().add(usuario);
       String resultado= universidad.registrarEntradaVehiculo("MXQ852","Sofia",1092851,"2026-05-24 02:00",TipoVehiculo.CARRO,usuario);
        assertEquals("Se ha añadido el vehículo exitosamente",resultado);
    }

    @Test
    void calcularTiempoPermanenciaTest() {
        Universidad universidad=new Universidad("uq",159,"34");
        assertEquals(4.0,universidad.calcularTiempoPermanencia("2026-05-24 08:00","2026-05-24 12:00"));
    }
    @Test
    void registrarSalidaVehiculoTest(){
        Universidad universidad=new Universidad("uq",159,"34");
        EspacioParqueadero espacioParqueadero=new EspacioParqueadero(123,TipoVehiculo.CARRO);
        Vehiculo vehiculo=new Vehiculo("mq","sofia",147,"08:00","12:00",null,TipoVehiculo.CARRO,null,EstadoVehiculo.DENTRO);
        assertEquals("El vehiculo no se encuentra registrado en el parqueadero",universidad.registrarSalidaVehiculo(vehiculo.getPlaca(),"12:00"));   }
    @Test
    void buscarEspacioDisponibleTest() {
        Universidad universidad=new Universidad("uq",159,"34");
        EspacioParqueadero espacioParqueadero=new EspacioParqueadero(123,TipoVehiculo.CARRO);
        universidad.getListEspaciosParqueaderos().add(espacioParqueadero);
        assertEquals(espacioParqueadero,universidad.buscarEspacioDisponible(TipoVehiculo.CARRO));
    }

    @Test
    void obtenerEspacioTest() {
        Universidad universidad=new Universidad("uq",159,"34");
        EspacioParqueadero espacioParqueadero=new EspacioParqueadero(123,TipoVehiculo.CARRO);
        universidad.getListEspaciosParqueaderos().add(espacioParqueadero);
        assertEquals(3,universidad.obtenerEspacio(123));
    }

    @Test
    void registrarNuevoEspacioTest() {
        Universidad universidad=new Universidad("uq",159,"34");
        EspacioParqueadero espacioParqueadero=new EspacioParqueadero(123,TipoVehiculo.CARRO);
        universidad.getListEspaciosParqueaderos().add(espacioParqueadero);
        assertEquals(espacioParqueadero,universidad.registrarNuevoEspacio(123,TipoVehiculo.CARRO));

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