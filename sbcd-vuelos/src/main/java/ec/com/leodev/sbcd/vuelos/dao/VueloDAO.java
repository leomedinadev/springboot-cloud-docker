package ec.com.leodev.sbcd.vuelos.dao;

import ec.com.leodev.sbcd.vuelos.model.Vuelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VueloDAO implements IVueloDAO {

    @Autowired
    private IVueloJPA vueloJPA;


    @Override
    public List<Vuelo> devolverVuelos() {
        return vueloJPA.findAll();
    }

    @Override
    public Vuelo devolverVuelo(int id) {
        return vueloJPA.getById(id);
    }

    @Override
    public void actualizarVuelo(Vuelo vuelo) {
        vueloJPA.save(vuelo);
    }
}
