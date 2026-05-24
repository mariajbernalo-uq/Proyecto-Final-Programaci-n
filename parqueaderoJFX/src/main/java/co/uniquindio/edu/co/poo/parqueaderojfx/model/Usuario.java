package co.uniquindio.edu.co.poo.parqueaderojfx.model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private String identificacion;
    private List<Vehiculo> listVehiculos;
    private TipoUsuario tipoUsuario;

    /**
     * Metodo constructor de la clase Usuario
     * @param nombre del usuario
     * @param identificacion del usuario
     * @param tipoUsuario del usuario
     */
    public Usuario(String nombre, String identificacion, TipoUsuario tipoUsuario) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.listVehiculos = new ArrayList<>();
        this.tipoUsuario = tipoUsuario;
    }

    /**
     * Método para añadir los vehículos que pertenecen al usuario a la lista de vehículos
     * @param vehiculo a añadir a la lista
     */
    public void anadirVehiculoLista(Vehiculo vehiculo){
        listVehiculos.add(vehiculo);
    }

    //Getters y Setters de la clase Usuario
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public List<Vehiculo> getListVehiculos() {
        return listVehiculos;
    }

    public void setListVehiculos(List<Vehiculo> listVehiculos) {
        this.listVehiculos = listVehiculos;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
