package ec.com.leodev.sbcd.reservas.dao;

import ec.com.leodev.sbcd.reservas.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReservaJPA extends JpaRepository<Reserva, Integer> {


}
