package co.uniquindio.edu.co.poo.parqueaderojfx.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniversidadTest {

    @Test
    void obtenerVehiculoTest() {
        Universidad universidad=new Universidad("UQ",1256,"Cra 14");
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
        EspacioParqueadero espacioParqueadero=new EspacioParqueadero(1,TipoVehiculo.CARRO);
        Vehiculo vehiculo=new Vehiculo("MXQ852","Sofia",1235,"02:00","05:00",null,TipoVehiculo.CARRO,null,EstadoVehiculo.DENTRO);
        universidad.getListVehiculos().add(vehiculo);
//Terminar
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
        EspacioParqueadero espacioParqueadero=new EspacioParqueadero(2,TipoVehiculo.CARRO);
        Vehiculo vehiculo=new Vehiculo("mq","sofia",147,"08:00","12:00",123,TipoVehiculo.CARRO,null,EstadoVehiculo.DENTRO);
        assertEquals("El vehiculo no se encuentra registrado en el parqueadero",universidad.registrarSalidaVehiculo(vehiculo.getPlaca(),"12:00"));   }
    @Test
    void buscarEspacioDisponibleTest() {
        Universidad universidad=new Universidad("uq",159,"34");
        EspacioParqueadero espacioParqueadero=new EspacioParqueadero(3,TipoVehiculo.CARRO);
        universidad.getListEspaciosParqueaderos().add(espacioParqueadero);
        assertEquals(espacioParqueadero,universidad.buscarEspacioDisponible(TipoVehiculo.CARRO));
    }

    @Test
    void obtenerEspacioTest() {
        Universidad universidad=new Universidad("uq",159,"34");
        EspacioParqueadero espacioParqueadero=new EspacioParqueadero(4,TipoVehiculo.CARRO);
        universidad.getListEspaciosParqueaderos().add(espacioParqueadero);
        assertEquals(espacioParqueadero,universidad.obtenerEspacio(123));
    }

    @Test
    void registrarNuevoEspacioTest() {
        Universidad universidad=new Universidad("uq",159,"34");
        EspacioParqueadero espacioParqueadero=new EspacioParqueadero(5,TipoVehiculo.CARRO);
        universidad.getListEspaciosParqueaderos().add(espacioParqueadero);
        assertEquals(espacioParqueadero,universidad.registrarNuevoEspacio(123,TipoVehiculo.CARRO));
    }

    @Test
    void modificarEspacioTest() {
        Universidad universidad=new Universidad("uq",159,"34");
        EspacioParqueadero espacioParqueadero=new EspacioParqueadero(6,TipoVehiculo.CARRO);
        assertEquals("Espacio modificado correctamente",universidad.modificarEspacio(espacioParqueadero));
    }

    @Test
    void deshabilitarEspacioTest() {
        Universidad universidad=new Universidad("uq",159,"34");
        EspacioParqueadero espacioParqueadero=new EspacioParqueadero(7,TipoVehiculo.CARRO);
        universidad.getListEspaciosParqueaderos().add(espacioParqueadero);
        assertEquals("Espacio deshabilitado correctamente",universidad.deshabilitarEspacio(espacioParqueadero));

    }

    @Test
    void existeEspacioDisponibleTest() {
        Universidad universidad=new Universidad("uq",159,"34");
        EspacioParqueadero espacioParqueadero=new EspacioParqueadero(8,TipoVehiculo.CARRO);
        universidad.getListEspaciosParqueaderos().add(espacioParqueadero);
        assertTrue(universidad.existeEspacioDisponible());

    }

    @Test
    void consultarEstadoEspaciosTest() {
        Universidad universidad=new Universidad("uq",159,"34");
        EspacioParqueadero espacioParqueadero1=new EspacioParqueadero(9,TipoVehiculo.CARRO);
        EspacioParqueadero espacioParqueadero2=new EspacioParqueadero(10,TipoVehiculo.MOTOCICLETA);
        espacioParqueadero1.setEstadoEspacio(EstadoEspacio.OCUPADO);
        espacioParqueadero2.setEstadoEspacio(EstadoEspacio.MANTENIMIENTO);
        universidad.getListEspaciosParqueaderos().add(espacioParqueadero1);
        universidad.getListEspaciosParqueaderos().add(espacioParqueadero2);
        assertEquals("Total= 3" + "/nOcupados:1" + "/nEn Mantenimiento:1",universidad.consultarEstadoEspacios());
    }

    @Test
    void consultarVehiculosEstacionados() {
        Universidad universidad=new Universidad("uq",159,"34");
        EspacioParqueadero espacioParqueadero12=new EspacioParqueadero(526,TipoVehiculo.CARRO);
        EspacioParqueadero espacioParqueadero13=new EspacioParqueadero(521,TipoVehiculo.MOTOCICLETA);
        Vehiculo vehiculo1=new Vehiculo("mq12","Sofia",152,"08:00","12:00",espacioParqueadero12,TipoVehiculo.CARRO,null,EstadoVehiculo.DENTRO);
        Vehiculo vehiculo2=new Vehiculo("mq13","Majo",185,"10:00","12:00",espacioParqueadero13,TipoVehiculo.MOTOCICLETA,null,EstadoVehiculo.DENTRO);

    }

    @Test
    void obtenerTarifaPorTipoVehiculo() {
    }

    @Test
    void registrarTarifa() {
    }

    @Test
    void eliminarTarifa() {
    }

    @Test
    void modificarTarifa() {
    }

    @Test
    void generarFactura() {
    }

    @Test
    void obtenerUsuario() {
    }

    @Test
    void registrarUsuario() {
    }

    @Test
    void modificarUsuario() {
    }

    @Test
    void eliminarUsuario() {
    }

    @Test
    void listarUsuarios() {
    }

    @Test
    void controlarRol() {
    }

    @Test
    void iniciarSesion() {
    }

    @Test
    void validarPermisoAdministrador() {
    }

    @Test
    void validarPermisoOperador() {
    }

    @Test
    void generarReporte() {
    }

    @Test
    void ingresosGeneradosDia() {
    }

    @Test
    void tiempoPromedioPermanencia() {
    }

    @Test
    void vehiculosMasDeDeterminadasHoras() {
    }

    @Test
    void getNombre() {
    }

    @Test
    void setNombre() {
    }

    @Test
    void getNit() {
    }

    @Test
    void setNit() {
    }

    @Test
    void getDireccion() {
    }

    @Test
    void setDireccion() {
    }

    @Test
    void getListUsuarios() {
    }

    @Test
    void setListUsuarios() {
    }

    @Test
    void getListVehiculos() {
    }

    @Test
    void setListVehiculos() {
    }

    @Test
    void getListEspaciosParqueaderos() {
    }

    @Test
    void setListEspaciosParqueaderos() {
    }

    @Test
    void getListTarifas() {
    }

    @Test
    void setListTarifas() {
    }
}