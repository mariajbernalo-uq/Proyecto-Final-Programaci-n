package co.uniquindio.edu.co.poo.parqueaderojfx.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehiculoTest {

    @Test
    void getPlaca() {
        Vehiculo vehiculo = new Vehiculo("VRK42F", "Maria Jose", 1004446220, "03:00", "03:30", null, TipoVehiculo.MOTOCICLETA, null,EstadoVehiculo.DENTRO);
        assertEquals("VRK42F", vehiculo.getPlaca());
    }

    @Test
    void setPlaca() {
        Vehiculo vehiculo = new Vehiculo("VRK42F", "Maria Jose", 1004446220, "03:00", "03:30", null, TipoVehiculo.MOTOCICLETA, null,EstadoVehiculo.DENTRO);
        vehiculo.setPlaca("VRK42P");
        assertEquals("VRK42P", vehiculo.getPlaca());
    }

    @Test
    void getNombreConductor() {
        Vehiculo vehiculo = new Vehiculo("VRK42F", "Maria Jose", 1004446220, "03:00", "03:30", null, TipoVehiculo.MOTOCICLETA, null,EstadoVehiculo.DENTRO);
        assertEquals("Maria Jose", vehiculo.getNombreConductor());
    }

    @Test
    void setNombreConductor() {
        Vehiculo vehiculo = new Vehiculo("VRK42F", "Maria Jose", 1004446220, "03:00", "03:30", null, TipoVehiculo.MOTOCICLETA, null,EstadoVehiculo.DENTRO);
        vehiculo.setNombreConductor("Sofia");
        assertEquals("Sofia", vehiculo.getNombreConductor());
    }

    @Test
    void getIdentificacionConductor() {
        Vehiculo vehiculo = new Vehiculo("VRK42F", "Maria Jose", 1004446220, "03:00", "03:30", null, TipoVehiculo.MOTOCICLETA, null,EstadoVehiculo.DENTRO);
        assertEquals(1004446220, vehiculo.getIdentificacionConductor());
    }

    @Test
    void setIdentificacionConductor() {
        Vehiculo vehiculo = new Vehiculo("VRK42F", "Maria Jose", 1004446220, "03:00", "03:30", null, TipoVehiculo.MOTOCICLETA, null,EstadoVehiculo.DENTRO);
        vehiculo.setIdentificacionConductor(1004446221);
        assertEquals(1004446221, vehiculo.getIdentificacionConductor());
    }

    @Test
    void getHoraIngreso() {
        Vehiculo vehiculo = new Vehiculo("VRK42F", "Maria Jose", 1004446220, "03:00", "03:30", null, TipoVehiculo.MOTOCICLETA, null,EstadoVehiculo.DENTRO);
        assertEquals("03:00", vehiculo.getHoraIngreso());
    }

    @Test
    void setHoraIngreso() {
        Vehiculo vehiculo = new Vehiculo("VRK42F", "Maria Jose", 1004446220, "03:00", "03:30", null, TipoVehiculo.MOTOCICLETA, null,EstadoVehiculo.DENTRO);
        vehiculo.setHoraIngreso("09:00");
        assertEquals("09:00", vehiculo.getHoraIngreso());
    }

    @Test
    void getHoraSalida() {
        Vehiculo vehiculo = new Vehiculo("VRK42F", "Maria Jose", 1004446220, "03:00", "03:30", null, TipoVehiculo.MOTOCICLETA, null,EstadoVehiculo.DENTRO);
        assertEquals("03:30", vehiculo.getHoraSalida());
    }

    @Test
    void setHoraSalida() {
        Vehiculo vehiculo = new Vehiculo("VRK42F", "Maria Jose", 1004446220, "03:00", "03:30", null, TipoVehiculo.MOTOCICLETA, null,EstadoVehiculo.DENTRO);
        vehiculo.setHoraSalida("15:00");
        assertEquals("15:00", vehiculo.getHoraSalida());
    }

    @Test
    void getTheEspacioParqueadero() {
        EspacioParqueadero espacio= new EspacioParqueadero(1, TipoVehiculo.MOTOCICLETA);
        Vehiculo vehiculo = new Vehiculo("VRK42F", "Maria Jose", 1004446220, "03:00", "03:30", espacio, TipoVehiculo.MOTOCICLETA, null,EstadoVehiculo.DENTRO);
        assertEquals(espacio, vehiculo.getTheEspacioParqueadero());
    }

    @Test
    void setTheEspacioParqueadero() {
        EspacioParqueadero espacio= new EspacioParqueadero(1, TipoVehiculo.MOTOCICLETA);
        Vehiculo vehiculo = new Vehiculo("VRK42F", "Maria Jose", 1004446220, "03:00", "03:30", espacio, TipoVehiculo.MOTOCICLETA, null,EstadoVehiculo.DENTRO);
        EspacioParqueadero espacioNuevo= new EspacioParqueadero(2, TipoVehiculo.BICICLETA);
       vehiculo.setTheEspacioParqueadero(espacioNuevo);
        assertEquals(espacioNuevo, vehiculo.getTheEspacioParqueadero());
    }

    @Test
    void getTipoVehiculo() {
        Vehiculo vehiculo = new Vehiculo("VRK42F", "Maria Jose", 1004446220, "03:00", "03:30", null, TipoVehiculo.MOTOCICLETA, null,EstadoVehiculo.DENTRO);
        assertEquals(TipoVehiculo.MOTOCICLETA, vehiculo.getTipoVehiculo());
    }

    @Test
    void setTipoVehiculo() {
        Vehiculo vehiculo = new Vehiculo("VRK42F", "Maria Jose", 1004446220, "03:00", "03:30", null, TipoVehiculo.MOTOCICLETA, null,EstadoVehiculo.DENTRO);
        vehiculo.setTipoVehiculo(TipoVehiculo.BICICLETA);
        assertEquals(TipoVehiculo.BICICLETA, vehiculo.getTipoVehiculo());
    }


    @Test
    void getTheUsuario() {
        Usuario usuario= new Usuario("Maria", "1004446220", TipoUsuario.ESTUDIANTE);
        Vehiculo vehiculo = new Vehiculo("VRK42F", "Maria Jose", 1004446220, "03:00", "03:30", null, TipoVehiculo.MOTOCICLETA, usuario,EstadoVehiculo.DENTRO);
        assertEquals(usuario, vehiculo.getTheUsuario());
    }

    @Test
    void setTheUsuario() {
        Usuario usuario= new Usuario("Maria", "1004446220", TipoUsuario.ESTUDIANTE);
        Vehiculo vehiculo = new Vehiculo("VRK42F", "Maria Jose", 1004446220, "03:00", "03:30", null, TipoVehiculo.MOTOCICLETA, usuario,EstadoVehiculo.DENTRO);
        Usuario usuarioNuevo= new Usuario("Mario", "1004446228", TipoUsuario.ADMINISTRATIVO);
        vehiculo.setTheUsuario(usuarioNuevo);
        assertEquals(usuarioNuevo, vehiculo.getTheUsuario());
    }

    @Test
    void getEstadoVehiculo() {
        Vehiculo vehiculo = new Vehiculo("VRK42F", "Maria Jose", 1004446220, "03:00", "03:30", null, TipoVehiculo.MOTOCICLETA, null,EstadoVehiculo.DENTRO);
        assertEquals(EstadoVehiculo.DENTRO, vehiculo.getEstadoVehiculo());
    }


    @Test
    void setEstadoVehiculo() {
        Vehiculo vehiculo = new Vehiculo("VRK42F", "Maria Jose", 1004446220, "03:00", "03:30", null, TipoVehiculo.MOTOCICLETA, null,EstadoVehiculo.DENTRO);
        vehiculo.setEstadoVehiculo(EstadoVehiculo.FUERA);
        assertEquals(EstadoVehiculo.FUERA, vehiculo.getEstadoVehiculo());
    }
}