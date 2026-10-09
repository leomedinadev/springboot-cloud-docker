package ec.com.leodev.sbcd.reservas.service;

import ec.com.leodev.sbcd.reservas.model.Reserva;

import java.util.List;

public interface IReservaService {

    void realizarReserva(Reserva reserva, int totalPersonas);

    List<Reserva> getReservas();
}
