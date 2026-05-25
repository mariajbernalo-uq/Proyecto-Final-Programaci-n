package co.uniquindio.edu.co.poo.parqueaderojfx.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    void añadirVehiculoLista() {
        Vehiculo vehiculo = new Vehiculo("VRK42F", "Majo", 1004446220, "03:00", "05:00", null, TipoVehiculo.BICICLETA, null,EstadoVehiculo.DENTRO);
        Usuario usuario= new Usuario("Maria", "1004446220", TipoUsuario.ESTUDIANTE);
        usuario.anadirVehiculoLista(vehiculo);
        assertTrue(usuario.getListVehiculos().contains(vehiculo));
    }

    @Test
    void getNombre() {
        Usuario usuario= new Usuario("Maria", "1004446220", TipoUsuario.ESTUDIANTE);
        assertEquals("Maria",usuario.getNombre());
    }

    @Test
    void setNombre() {
        Usuario usuario= new Usuario("Maria", "1004446220", TipoUsuario.ESTUDIANTE);
        usuario.setNombre("Monica");
        assertEquals("Monica",usuario.getNombre());
    }

    @Test
    void getIdentificacion() {
        Usuario usuario= new Usuario("Maria", "1004446220", TipoUsuario.ESTUDIANTE);
        assertEquals("1004446220",usuario.getIdentificacion());
    }

    @Test
    void setIdentificacion() {
        Usuario usuario= new Usuario("Maria", "1004446220", TipoUsuario.ESTUDIANTE);
        usuario.setIdentificacion("1004446221");
        assertEquals("1004446221",usuario.getIdentificacion());
    }

    @Test
    void getListVehiculos() {
        Usuario usuario= new Usuario("Maria", "1004446220", TipoUsuario.ESTUDIANTE);
        assertTrue(usuario.getListVehiculos().isEmpty());
    }

    @Test
    void setListVehiculos() {
        Usuario usuario= new Usuario("Maria", "1004446220", TipoUsuario.ESTUDIANTE);
        List<Vehiculo> listVehiculos= new ArrayList<>();
        Vehiculo vehiculo = new Vehiculo("VRK42F", "Majo", 1004446220, "03:00", "05:00", null, TipoVehiculo.BICICLETA, null,EstadoVehiculo.DENTRO);
        listVehiculos.add(vehiculo);
        usuario.setListVehiculos(listVehiculos);
        assertTrue(usuario.getListVehiculos()==listVehiculos);
    }

    @Test
    void getTipoUsuario() {
        Usuario usuario= new Usuario("Maria", "1004446220", TipoUsuario.ESTUDIANTE);
        assertEquals(TipoUsuario.ESTUDIANTE,usuario.getTipoUsuario());
    }

    @Test
    void setTipoUsuario() {
        Usuario usuario= new Usuario("Maria", "1004446220", TipoUsuario.ESTUDIANTE);
        usuario.setTipoUsuario(TipoUsuario.ADMINISTRATIVO);
        assertEquals(TipoUsuario.ADMINISTRATIVO,usuario.getTipoUsuario());
    }
}