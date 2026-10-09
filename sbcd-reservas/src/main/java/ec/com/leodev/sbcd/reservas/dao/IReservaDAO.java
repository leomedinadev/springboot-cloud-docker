package ec.com.leodev.sbcd.reservas.dao;

import ec.com.leodev.sbcd.reservas.model.Reserva;

import java.util.List;

public interface IReservaDAO {

    void generarReserva(Reserva reserva);

    List<Reserva> getReservas();
}
