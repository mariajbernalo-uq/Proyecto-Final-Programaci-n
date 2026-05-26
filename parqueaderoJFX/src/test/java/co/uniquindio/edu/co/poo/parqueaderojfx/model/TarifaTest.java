package co.uniquindio.edu.co.poo.parqueaderojfx.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TarifaTest {

    @Test
    void asignarTarifaTest() {

        Tarifa tarifa = new Tarifa(TipoVehiculo.CARRO);
        double resultado = tarifa.asignarTarifa();
        assertEquals(3000, resultado);
    }

    @Test
    void calcularDescuento() {
        TipoUsuario tipoUsuario= TipoUsuario.ESTUDIANTE;
        Tarifa tarifa = new Tarifa(TipoVehiculo.MOTOCICLETA);
        tarifa.calcularDescuento(tipoUsuario);
        assertTrue(tarifa.getDescuento()==0.10);
    }

    @Test
    void calcularTotal() {
        Tarifa tarifa = new Tarifa(TipoVehiculo.BICICLETA);
        double calculo= tarifa.calcularTotal(5,TipoUsuario.DOCENTE);
        double esperado= (tarifa.getValorPorHora()*5)-(tarifa.getValorPorHora()*5*tarifa.getDescuento());
        assertEquals(esperado, calculo);
    }

    @Test
    void getValorPorHora() {
        Tarifa tarifa = new Tarifa(TipoVehiculo.MOTOCICLETA);
        assertEquals(2000,tarifa.getValorPorHora());
    }

    @Test
    void setValorPorHora() {
        Tarifa tarifa = new Tarifa(TipoVehiculo.BICICLETA);
        tarifa.setValorPorHora(1500);
        assertEquals(1500,tarifa.getValorPorHora());
    }

    @Test
    void getDescuento() {
        Tarifa tarifa = new Tarifa(TipoVehiculo.MOTOCICLETA);
        tarifa.calcularDescuento(TipoUsuario.DOCENTE);
        assertEquals(0.15,tarifa.getDescuento());
    }

    @Test
    void setDescuento() {
        Tarifa tarifa = new Tarifa(TipoVehiculo.MOTOCICLETA);
        tarifa.setDescuento(0.50);
        assertEquals(0.50,tarifa.getDescuento());
    }

    @Test
    void getTipoVehiculo() {
        Tarifa tarifa = new Tarifa(TipoVehiculo.MOTOCICLETA);
        assertEquals(TipoVehiculo.MOTOCICLETA,tarifa.getTipoVehiculo());
    }

    @Test
    void setTipoVehiculo() {
        Tarifa tarifa = new Tarifa(TipoVehiculo.MOTOCICLETA);
        tarifa.setTipoVehiculo(TipoVehiculo.CARRO);
        assertEquals(TipoVehiculo.CARRO,tarifa.getTipoVehiculo());
    }
}