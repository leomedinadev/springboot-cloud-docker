package ec.com.leodev.sbcd.reservas.service;

import ec.com.leodev.sbcd.reservas.dao.IReservaDAO;
import ec.com.leodev.sbcd.reservas.model.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ReservaService implements IReservaService {

    @Autowired
    private IReservaDAO reservaDAO;

    @Lazy
    @Autowired
    private RestTemplate restTemplate;

    private static final String URL_API_VUELOS = "http://api-vuelos";


    @Override
    public void realizarReserva(Reserva reserva, int totalPersonas) {
        reservaDAO.generarReserva(reserva);
        restTemplate.put(URL_API_VUELOS.concat("/vuelos/{p1}/{p2}"), null, reserva.getVuelo(), totalPersonas);
    }

    @Override
    public List<Reserva> getReservas() {
        return reservaDAO.getReservas();
    }
}
