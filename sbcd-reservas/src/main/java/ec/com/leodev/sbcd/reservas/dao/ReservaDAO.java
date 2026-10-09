package ec.com.leodev.sbcd.reservas.dao;

import ec.com.leodev.sbcd.reservas.model.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReservaDAO implements IReservaDAO{

    @Autowired
    private IReservaJPA reservaJPA;

    @Override
    public void generarReserva(Reserva reserva) {
        reservaJPA.save(reserva);
    }

    @Override
    public List<Reserva> getReservas(){
        return reservaJPA.findAll();
    }
}
