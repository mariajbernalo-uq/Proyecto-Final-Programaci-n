package co.uniquindio.edu.co.poo.parqueaderojfx.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static co.uniquindio.edu.co.poo.parqueaderojfx.model.TipoVehiculo.CARRO;
import static co.uniquindio.edu.co.poo.parqueaderojfx.model.TipoVehiculo.MOTOCICLETA;
import static org.junit.jupiter.api.Assertions.*;

class UniversidadTest {

    @Test
    void obtenerVehiculoTest() {
        Universidad universidad=new Universidad("UQ",1256,"Cra 14");
        EspacioParqueadero espacioParqueadero=new EspacioParqueadero(3, CARRO);
        Usuario usuario=new Usuario("Sofia","1092851",TipoUsuario.ESTUDIANTE);
        Vehiculo vehiculo=new Vehiculo("MXQ852", "Sofia",1092851,"08:00","12:00",null, CARRO,null,EstadoVehiculo.FUERA);
        universidad.getListVehiculos().add(vehiculo);
        assertEquals(vehiculo,universidad.obtenerVehiculo("MXQ852"));

    }

    @Test
    void registrarVehiculoTest() {
        Universidad universidad=new Universidad("UQ",1236,"Cra 14");
        Vehiculo vehiculo=new Vehiculo("MXQ852","Sofia",1235,"02:00","05:00",null, CARRO,null,EstadoVehiculo.DENTRO);
        universidad.getListVehiculos().add(vehiculo);
        assertEquals(true,universidad.registrarVehiculo(vehiculo));
    }

    @Test
    void registrarEntradaVehiculoTest() {
        Universidad universidad=new Universidad("uq1",541,"cra13");
        EspacioParqueadero espacioParqueadero=new EspacioParqueadero(5, CARRO);
        universidad.getListEspaciosParqueaderos().add(espacioParqueadero);
        String resultado= universidad.registrarEntradaVehiculo("MXQ852","Sofia",1235,"02:00", CARRO,null);
        assertEquals("Se ha añadido el vehículo exitosamente",resultado);
    }

    @Test
    void calcularTiempoPermanenciaTest() {
        Universidad universidad=new Universidad("uq",159,"34");
        Vehiculo vehiculo=new Vehiculo("mq","Sofia",147,"08:00","12:00",null, CARRO,null,EstadoVehiculo.DENTRO);
        assertEquals(4.0,universidad.calcularTiempoPermanencia("05:00","08:00"));
    }
    @Test
    void registrarSalidaVehiculoTest(){
        Universidad universidad=new Universidad("uq",159,"34");
        EspacioParqueadero espacioParqueadero1=new EspacioParqueadero(2, CARRO);
        Vehiculo vehiculo=new Vehiculo("mq","sofia",147,"08:00","12:00",espacioParqueadero1, CARRO,null,EstadoVehiculo.DENTRO);
        espacioParqueadero1.setEstadoEspacio(EstadoEspacio.OCUPADO);
        vehiculo.setTheEspacioParqueadero(espacioParqueadero1);
        universidad.getListVehiculos().add(vehiculo);
        String resultado=universidad.registrarSalidaVehiculo("mq","12:00");
        assertEquals("La salida del vehiculo " + vehiculo.getPlaca() + " se ha completado correctamente",resultado);
    }
    @Test
    void buscarEspacioDisponibleTest() {
        Universidad universidad=new Universidad("uq",159,"34");
        EspacioParqueadero espacioParqueadero=new EspacioParqueadero(3, CARRO);
        universidad.getListEspaciosParqueaderos().add(espacioParqueadero);
        assertEquals(espacioParqueadero,universidad.buscarEspacioDisponible(CARRO));
    }
    @Test
    void obtenerEspacioTest() {
        Universidad universidad=new Universidad("uq",159,"34");
        EspacioParqueadero espacioParqueadero1=new EspacioParqueadero(4, TipoVehiculo.CARRO);
        EspacioParqueadero espacioParqueadero2=new EspacioParqueadero(5,TipoVehiculo.MOTOCICLETA);
        universidad.getListEspaciosParqueaderos().add(espacioParqueadero1);
        universidad.getListEspaciosParqueaderos().add(espacioParqueadero2);
        EspacioParqueadero resultado=universidad.obtenerEspacio(4);
        assertEquals(4,resultado.getCodigo());
    }

    @Test
    void registrarNuevoEspacioTest() {
        Universidad universidad=new Universidad("uq",159,"34");
        EspacioParqueadero espacioParqueadero=new EspacioParqueadero(5, CARRO);
        universidad.getListEspaciosParqueaderos().add(espacioParqueadero);
        assertEquals("Espacio registrado correctamente",universidad.registrarNuevoEspacio(123, CARRO));
    }

    @Test
    void modificarEspacioTest() {
        Universidad universidad=new Universidad("uq",159,"34");
        EspacioParqueadero espacioParqueadero=new EspacioParqueadero(6, CARRO);
        universidad.getListEspaciosParqueaderos().add(espacioParqueadero);
        espacioParqueadero.setEstadoEspacio(EstadoEspacio.OCUPADO);
        assertEquals("Espacio modificado correctamente",universidad.modificarEspacio(espacioParqueadero));
    }

    @Test
    void deshabilitarEspacioTest() {
        Universidad universidad=new Universidad("uq",159,"34");
        EspacioParqueadero espacioParqueadero=new EspacioParqueadero(7, CARRO);
        universidad.getListEspaciosParqueaderos().add(espacioParqueadero);
        assertEquals("Espacio deshabilitado correctamente",universidad.deshabilitarEspacio(espacioParqueadero));

    }

    @Test
    void existeEspacioDisponibleTest() {
        Universidad universidad=new Universidad("uq",159,"34");
        EspacioParqueadero espacioParqueadero=new EspacioParqueadero(8, CARRO);
        universidad.getListEspaciosParqueaderos().add(espacioParqueadero);
        assertTrue(universidad.existeEspacioDisponible());

    }

    @Test
    void consultarEstadoEspaciosTest() {
        Universidad universidad=new Universidad("uq",159,"34");
        EspacioParqueadero espacioParqueadero1=new EspacioParqueadero(9, CARRO);
        EspacioParqueadero espacioParqueadero2=new EspacioParqueadero(10,TipoVehiculo.MOTOCICLETA);
        espacioParqueadero1.setEstadoEspacio(EstadoEspacio.OCUPADO);
        espacioParqueadero2.setEstadoEspacio(EstadoEspacio.MANTENIMIENTO);
        universidad.getListEspaciosParqueaderos().add(espacioParqueadero1);
        universidad.getListEspaciosParqueaderos().add(espacioParqueadero2);
        assertEquals("Total: 2\nDisponibles: 0\nOcupados: 1\nEn mantenimiento: 1",universidad.consultarEstadoEspacios());
    }
    @Test
    void consultarVehiculosEstacionadosTest() {
        Universidad universidad = new Universidad("uq", 159, "34");
        EspacioParqueadero espacioParqueadero12 = new EspacioParqueadero(526, CARRO);
        EspacioParqueadero espacioParqueadero13 = new EspacioParqueadero(521, TipoVehiculo.MOTOCICLETA);
        Vehiculo vehiculo1 = new Vehiculo("mq12", "Sofia", 152, "08:00", "12:00", espacioParqueadero12, CARRO, null, EstadoVehiculo.DENTRO);
        Vehiculo vehiculo2 = new Vehiculo("mq13", "Majo", 185, "10:00", "12:00", espacioParqueadero13, TipoVehiculo.MOTOCICLETA, null, EstadoVehiculo.DENTRO);
        espacioParqueadero12.setEstadoEspacio(EstadoEspacio.OCUPADO);
        espacioParqueadero13.setEstadoEspacio(EstadoEspacio.OCUPADO);
        universidad.getListEspaciosParqueaderos().add(espacioParqueadero12);
        universidad.getListEspaciosParqueaderos().add(espacioParqueadero13);
        universidad.getListVehiculos().add(vehiculo1);
        universidad.getListVehiculos().add(vehiculo2);
        assertEquals("=== VEHICULOS ACTUALMENTE ESTACIONADOS ===\n" +
                "Placa: mq12 | Tipo: CARRO | Hora ingreso: 08:00 | Espacio: 526\n" +
                "Placa: mq13 | Tipo: MOTOCICLETA | Hora ingreso: 10:00 | Espacio: 521\n", universidad.consultarVehiculosEstacionados());
    }
    @Test
    void obtenerTarifaPorTipoVehiculoTest() {
        Universidad universidad=new Universidad("UQ", 5456,"Cra 14");
        Tarifa tarifa1=new Tarifa(CARRO);
        Tarifa tarifa2=new Tarifa(MOTOCICLETA);
        universidad.getListTarifas().add(tarifa1);
        universidad.getListTarifas().add(tarifa2);
        Tarifa resultado=universidad.obtenerTarifaPorTipoVehiculo(CARRO);
        assertEquals(3000,resultado.getValorPorHora());
    }
    @Test
    void registrarTarifaTest() {
        Universidad universidad=new Universidad("UQ",741,"CRA 14");
        Tarifa tarifa=new Tarifa(CARRO);
        universidad.getListTarifas().add(tarifa);
        String resultado=universidad.registrarTarifa(CARRO,TipoUsuario.ESTUDIANTE);
        assertEquals("La tarifa para este vehículo ya se encuentra creada",resultado);
    }

    @Test
    void eliminarTarifaTest() {
        Universidad universidad=new Universidad("UQ",745,"CRA 14");
        Tarifa tarifa=new Tarifa(CARRO);
        universidad.getListTarifas().add(tarifa);
        String resultado=universidad.eliminarTarifa(CARRO);
        assertEquals("Tarifa eliminada correctamente",resultado);
    }
    @Test
    void modificarTarifaTest() {
        Universidad universidad=new Universidad("UQ",845,"CRA 14");
        Tarifa tarifa=new Tarifa(MOTOCICLETA);
        universidad.getListTarifas().add(tarifa);
        String resultado=universidad.modificarTarifa(5000,0.2, MOTOCICLETA);
        assertEquals("La tarifa ha sido modificada correctamente",resultado);
    }

    @Test
    void generarFacturaTest() {
        Universidad universidad=new Universidad("UQ",548,"CRA 14");
        EspacioParqueadero espacioParqueadero14=new EspacioParqueadero(74, CARRO);
        Usuario usuario=new Usuario("Sofia","1095",TipoUsuario.ESTUDIANTE);
        Tarifa tarifa=new Tarifa(CARRO);
        Vehiculo vehiculo1 = new Vehiculo("mq12", "Sofia", 152, "08:00", "12:00", espacioParqueadero14, CARRO, usuario, EstadoVehiculo.DENTRO);
        universidad.getListVehiculos().add(vehiculo1);
        String resultado=universidad.generarFactura("mq12","12:00");
        assertEquals("Factura de salida del vehículo\n"+ "Placa: mq12" + "\n"+ "Tipo de vehículo: CARRO" + "\n"+
                "Tiempo de permanencia: 4.0 " + " hora(s)\n"+
                "Valor por hora: $" + tarifa.asignarTarifa() + "\n"+
                "Descuento aplicado: " + tarifa.calcularDescuento(TipoUsuario.ESTUDIANTE) * 100 + "%\n"+
                "Total a pagar: $" + tarifa.calcularTotal(4.0,TipoUsuario.ESTUDIANTE) + "\n", resultado);

    }
    @Test
    void obtenerUsuarioTest() {
        Universidad universidad=new Universidad("UQ",548,"CRA 14");
        Usuario usuario=new Usuario("Sofia","1095",TipoUsuario.ESTUDIANTE);
        universidad.getListUsuarios().add(usuario);
        assertEquals(usuario,universidad.obtenerUsuario(usuario.getIdentificacion()));
    }
    @Test
    void registrarUsuarioTest() {
        Universidad universidad=new Universidad("UQ",548,"CRA 14");
        Usuario usuario1=new Usuario("Sofia","1095",TipoUsuario.ESTUDIANTE);
        universidad.getListUsuarios().add(usuario1);
        String respuesta=universidad.registrarUsuario("Majo","1094",TipoUsuario.ESTUDIANTE);
        assertEquals("El usuario Majo ha sido registrado en el sistema exitosamente", respuesta);
    }
    @Test
    void modificarUsuarioTest() {
        Universidad universidad=new Universidad("UQ",548,"CRA 14");
        Usuario usuario1=new Usuario("Sofia","1095",TipoUsuario.ESTUDIANTE);
        universidad.getListUsuarios().add(usuario1);
        String resultado=universidad.modificarUsuario("Sofia","1095",TipoUsuario.ESTUDIANTE);
        assertEquals("El usuario Sofia ha sido modificado correctamente", resultado);
    }
    @Test
    void eliminarUsuarioTest() {
        Universidad universidad=new Universidad("UQ",548,"CRA 14");
        Usuario usuario1=new Usuario("Sofia","1095",TipoUsuario.ESTUDIANTE);
        universidad.getListUsuarios().add(usuario1);
        String respuesta=universidad.eliminarUsuario("1095");
        assertEquals("Usuario eliminado correctamente", respuesta);
    }
    @Test
    void listarUsuariosTest() {
        Universidad universidad=new Universidad("UQ",548,"CRA 14");
        Usuario usuario1=new Usuario("Sofia","1095",TipoUsuario.ESTUDIANTE);
        Usuario usuario2=new Usuario("Majo","1094",TipoUsuario.ESTUDIANTE);
        universidad.getListUsuarios().add(usuario1);
        universidad.getListUsuarios().add(usuario2);
        String resultado=universidad.listarUsuarios();
        assertEquals( "=== LISTA DE USUARIOS ===\n" +
                        usuario1.toString() + "\n" +
                        usuario2.toString() + "\n", universidad.listarUsuarios());
    }
    @Test
    void controlarRolTest() {
        Universidad universidad=new Universidad("UQ",548,"CRA 14");
        Usuario usuario1=new Usuario("Sofia","1095",TipoUsuario.ADMINISTRATIVO);
        String respuesta=universidad.controlarRol(usuario1);
        assertEquals("Administrador",respuesta);
    }
    @Test
    void iniciarSesionTest() {
        Universidad universidad=new Universidad("UQ",548,"CRA 14");
        Usuario usuario1=new Usuario("Sofia","1095",TipoUsuario.ADMINISTRATIVO);
        universidad.getListUsuarios().add(usuario1);
        String respuesta=universidad.iniciarSesion("1095");
        assertEquals("Sesión iniciada correctamente para Sofia",respuesta);
    }
    @Test
    void validarPermisoAdministradorTest() {
        Universidad universidad=new Universidad("UQ",548,"CRA 14");
        Usuario usuario1=new Usuario("Sofia","1095",TipoUsuario.ADMINISTRATIVO);
        universidad.getListUsuarios().add(usuario1);
        String respuesta= universidad.validarPermisoAdministrador(usuario1);
        assertEquals("Permiso de administrador concedido.",respuesta);
    }
    @Test
    void validarPermisoOperadorTest() {
        Universidad universidad=new Universidad("UQ",548,"CRA 14");
        Usuario usuario1=new Usuario("Sofia","1095",TipoUsuario.ESTUDIANTE);
        universidad.getListUsuarios().add(usuario1);
        String respuesta= universidad.validarPermisoOperador(usuario1);
        assertEquals("Permiso de operador concedido.",respuesta);
    }
    @Test
    void generarReporteTest() {
        Universidad universidad = new Universidad("uq", 159, "34");
        EspacioParqueadero espacioParqueadero1 = new EspacioParqueadero(520, CARRO);
        EspacioParqueadero espacioParqueadero2 = new EspacioParqueadero(519, TipoVehiculo.MOTOCICLETA);
        Vehiculo vehiculo1 = new Vehiculo("mq12", "Sofia", 152, "08:00", "12:00", espacioParqueadero1, CARRO, null, EstadoVehiculo.DENTRO);
        Vehiculo vehiculo2 = new Vehiculo("mq13", "Majo", 185, "10:00", "12:00", espacioParqueadero2, TipoVehiculo.MOTOCICLETA, null, EstadoVehiculo.FUERA);
        espacioParqueadero1.setEstadoEspacio(EstadoEspacio.OCUPADO);
        espacioParqueadero2.setEstadoEspacio(EstadoEspacio.OCUPADO);
        universidad.getListVehiculos().add(vehiculo1);
        universidad.getListVehiculos().add(vehiculo2);
        universidad.getListEspaciosParqueaderos().add(espacioParqueadero1);
        universidad.getListEspaciosParqueaderos().add(espacioParqueadero2);
        assertEquals("=== REPORTE GENERAL DEL PARQUEADERO ===\n" +
                        "Total vehículos registrados: 2\n" +
                        "Vehículos dentro: 1\n" +
                        "Vehículos fuera: 1\n" +
                        "Espacios totales: 2\n" +
                        "Espacios disponibles: 1\n" +
                        "Ingresos generados hoy: $" +
                        universidad.ingresosGeneradosDia() + "\n" +
                        "Tiempo promedio de permanencia hoy: " +
                        universidad.tiempoPromedioPermanencia() +
                        " horas\n" +
                        "Vehículos que permanecieron más de 4 horas: \n" +
                        universidad.vehiculosMasDeDeterminadasHoras(4),
                universidad.generarReporte());
    }
    @Test
    void ingresosGeneradosDiaTest() {
        Universidad universidad=new Universidad("UQ",548,"CRA 14");
        EspacioParqueadero espacioParqueadero14=new EspacioParqueadero(74, CARRO);
        Tarifa tarifa=new Tarifa(CARRO);
        Vehiculo vehiculo1 = new Vehiculo("mq12", "Sofia", 152, "08:00", "12:00", espacioParqueadero14, CARRO, null, EstadoVehiculo.DENTRO);
        double ingresos=universidad.ingresosGeneradosDia();
    }
    @Test
    void tiempoPromedioPermanenciaTest() {
        Universidad universidad=new Universidad("UQ", 250,"CRA 14");
        EspacioParqueadero espacioParqueadero1 = new EspacioParqueadero(520, CARRO);
        EspacioParqueadero espacioParqueadero2 = new EspacioParqueadero(519, TipoVehiculo.MOTOCICLETA);
        Vehiculo vehiculo1=new Vehiculo("mq12", "Sofia", 152, "08:00", "12:00", espacioParqueadero1, CARRO, null, EstadoVehiculo.DENTRO);
        Vehiculo vehiculo2 =new Vehiculo("mq13", "Maria", 185, "10:00", "12:00", espacioParqueadero2, TipoVehiculo.MOTOCICLETA, null, EstadoVehiculo.FUERA);
        universidad.getListVehiculos().add(vehiculo1);
        universidad.getListVehiculos().add(vehiculo2);
        assertEquals(3.0,universidad.tiempoPromedioPermanencia(),0.001);
    }

    @Test
    void vehiculosMasDeDeterminadasHorasTest() {
        Universidad universidad=new Universidad("UQ", 250,"CRA 14");
        EspacioParqueadero espacioParqueadero1 = new EspacioParqueadero(520, CARRO);
        EspacioParqueadero espacioParqueadero2 = new EspacioParqueadero(519, TipoVehiculo.MOTOCICLETA);
        Vehiculo vehiculo1=new Vehiculo("mq12", "Sofia", 152, "2026-05-24 08:00", "2026-05-24 14:00", espacioParqueadero1, CARRO, null, EstadoVehiculo.FUERA);
        Vehiculo vehiculo2 =new Vehiculo("mq13", "Maria", 185, "2026-05-24 10:00", "2026-05-24 12:00", espacioParqueadero2, TipoVehiculo.MOTOCICLETA, null, EstadoVehiculo.FUERA);
        universidad.getListVehiculos().add(vehiculo1);
        universidad.getListVehiculos().add(vehiculo2);
        assertEquals("Placa: mq12 | Tipo: CARRO | Tiempo de permanencia: 6.0 horas\n", universidad.vehiculosMasDeDeterminadasHoras(4));
    }
    @Test
    void getNombreTest() {
        Universidad universidad=new Universidad("UQ", 1254,"CRA 14");
        assertEquals("UQ",universidad.getNombre());
    }
    @Test
    void setNombreTest() {
        Universidad universidad=new Universidad("UQ", 1254,"CRA 14");
        universidad.setNombre("Uniquindio");
        assertEquals("Uniquindio",universidad.getNombre());
    }
    @Test
    void getNitTest() {
        Universidad universidad=new Universidad("UQ", 1254,"CRA 14");
        assertEquals(1254,universidad.getNit());
    }
    @Test
    void setNitTest() {
        Universidad universidad=new Universidad("UQ", 1254,"CRA 14");
        universidad.setNit(1256);
        assertEquals(1256,universidad.getNit());
    }
    @Test
    void getDireccionTest() {
        Universidad universidad=new Universidad("UQ", 1254,"CRA 14");
        assertEquals("CRA 14",universidad.getDireccion());
    }
    @Test
    void setDireccionTest() {
        Universidad universidad=new Universidad("UQ", 1254,"CRA 14");
        universidad.setDireccion("CRA13");
        assertEquals("CRA13",universidad.getDireccion());
    }
    @Test
    void getListUsuariosTest() {
        Universidad universidad=new Universidad("UQ",1236,"CRA 15");
        Usuario usuario1=new Usuario("Sofia", "123654",TipoUsuario.ESTUDIANTE);
        Usuario usuario2=new Usuario("Majo", "123687",TipoUsuario.ESTUDIANTE);
        universidad.getListUsuarios().add(usuario1);
        universidad.getListUsuarios().add(usuario2);
        assertEquals(2,universidad.getListUsuarios().size());
    }
    @Test
    void setListUsuariosTest() {
        Universidad universidad=new Universidad("UQ",1236,"CRA 15");
        ArrayList<Usuario>listUsuarios=new ArrayList<>();
        Usuario usuario1=new Usuario("Sofia", "123654",TipoUsuario.ESTUDIANTE);
        listUsuarios.add(usuario1);
        universidad.setListUsuarios(listUsuarios);
        assertEquals(listUsuarios, universidad.getListUsuarios());
    }
    @Test
    void getListVehiculosTest() {
        Universidad universidad=new Universidad("UQ",1236,"CRA 15");
        Vehiculo vehiculo1=new Vehiculo("mq12", "Sofia", 152, "2026-05-24 08:00", "2026-05-24 12:00", null, CARRO, null, EstadoVehiculo.FUERA);
        Vehiculo vehiculo2=new Vehiculo("mq13", "Majo", 187, "2026-05-24 10:00", "2026-05-24 14:00", null, CARRO, null, EstadoVehiculo.FUERA);
        universidad.getListVehiculos().add(vehiculo1);
        universidad.getListVehiculos().add(vehiculo2);
        assertEquals(2,universidad.getListVehiculos().size());
    }
    @Test
    void setListVehiculostest() {
        Universidad universidad=new Universidad("UQ",1236,"CRA 15");
        ArrayList<Vehiculo>listVehiculos=new ArrayList<>();
        Vehiculo vehiculo1=new Vehiculo("mq12", "Sofia", 152, "2026-05-24 08:00", "2026-05-24 12:00", null, CARRO, null, EstadoVehiculo.FUERA);
        listVehiculos.add(vehiculo1);
        universidad.setListVehiculos(listVehiculos);
        assertEquals(listVehiculos, universidad.getListVehiculos());
    }
    @Test
    void getListEspaciosParqueaderosTest() {
        Universidad universidad=new Universidad("UQ",1236,"CRA 15");
        EspacioParqueadero espacioParqueadero1=new EspacioParqueadero(1, CARRO);
        EspacioParqueadero espacioParqueadero2=new EspacioParqueadero(2,MOTOCICLETA);
        universidad.getListEspaciosParqueaderos().add(espacioParqueadero1);
        universidad.getListEspaciosParqueaderos().add(espacioParqueadero2);
        assertEquals(2,universidad.getListEspaciosParqueaderos().size());
    }
    @Test
    void setListEspaciosParqueaderosTest() {
        Universidad universidad=new Universidad("UQ",1236,"CRA 15");
        ArrayList<EspacioParqueadero>listEspaciosParqueadero=new ArrayList<>();
        EspacioParqueadero espacioParqueadero1=new EspacioParqueadero( 12,MOTOCICLETA);
        listEspaciosParqueadero.add(espacioParqueadero1);
        universidad.setListEspaciosParqueaderos(listEspaciosParqueadero);
        assertEquals(listEspaciosParqueadero, universidad.getListEspaciosParqueaderos());
    }
    @Test
    void getListTarifas() {
        Universidad universidad=new Universidad("UQ",1236,"CRA 15");
        Tarifa tarifa1=new Tarifa(CARRO);
        Tarifa tarifa2=new Tarifa(MOTOCICLETA);
        universidad.getListTarifas().add(tarifa1);
        universidad.getListTarifas().add(tarifa2);
        assertEquals(2,universidad.getListTarifas().size());
    }
    @Test
    void setListTarifas() {
        Universidad universidad=new Universidad("UQ",1236,"CRA 15");
        ArrayList<Tarifa>listTarifas=new ArrayList<>();
        Tarifa tarifa1=new Tarifa(CARRO);
        listTarifas.add(tarifa1);
        universidad.setListTarifas(listTarifas);
        assertEquals(listTarifas, universidad.getListTarifas());
    }
}