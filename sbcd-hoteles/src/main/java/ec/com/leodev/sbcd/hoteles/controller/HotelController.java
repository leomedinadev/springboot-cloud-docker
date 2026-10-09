package ec.com.leodev.sbcd.hoteles.controller;

import ec.com.leodev.sbcd.hoteles.model.Hotel;
import ec.com.leodev.sbcd.hoteles.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class HotelController {

    @Autowired
    private IHotelService hotelService;


    @GetMapping(value = "hoteles", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Hotel> devolverHoteles() {
        return hotelService.devolverHotelesDispobibles();
    }
}
