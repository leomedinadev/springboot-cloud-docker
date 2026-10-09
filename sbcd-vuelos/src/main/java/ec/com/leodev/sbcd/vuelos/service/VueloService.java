package ec.com.leodev.sbcd.vuelos.service;

import ec.com.leodev.sbcd.vuelos.dao.IVueloDAO;
import ec.com.leodev.sbcd.vuelos.model.Vuelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VueloService implements IVueloService{

    @Autowired
    private IVueloDAO vueloDAO;

    @Override
    public List<Vuelo> recuperarVuelosDisponibles(Integer plazas) {
        return vueloDAO.devolverVuelos().stream().filter(x -> x.getPlazas() >= plazas).collect(Collectors.toList());
    }

    @Override
    public void actualizarPlazas(Integer id, Integer plazas){
        Vuelo vuelo = vueloDAO.devolverVuelo(id);
        if (vuelo != null) {
            vuelo.setPlazas(plazas);
            vueloDAO.actualizarVuelo(vuelo);
        }
    }
}
