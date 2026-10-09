package ec.com.leodev.sbcd.vuelos.controller;

import ec.com.leodev.sbcd.vuelos.model.Vuelo;
import ec.com.leodev.sbcd.vuelos.service.IVueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class VueloController {

    @Autowired
    private IVueloService vueloService;

    @GetMapping(value = "vuelos/{plazas}")
    public List<Vuelo> devolverVuelos(@PathVariable("plazas") Integer plazas){
        return vueloService.recuperarVuelosDisponibles(plazas);
    }

    @PutMapping(value = "vuelos/{id}/{plazas}")
    public void modificarVuelo(@PathVariable("id") Integer id, @PathVariable("plazas") Integer plazas) {
        vueloService.actualizarPlazas(id, plazas);
    }

}
