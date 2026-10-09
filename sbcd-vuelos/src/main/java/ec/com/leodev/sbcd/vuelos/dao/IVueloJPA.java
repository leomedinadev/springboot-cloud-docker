package ec.com.leodev.sbcd.vuelos.dao;

import ec.com.leodev.sbcd.vuelos.model.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVueloJPA extends JpaRepository<Vuelo, Integer> {
}
