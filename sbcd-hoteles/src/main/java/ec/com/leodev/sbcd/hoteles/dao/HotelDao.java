package ec.com.leodev.sbcd.hoteles.dao;

import ec.com.leodev.sbcd.hoteles.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HotelDao implements IHotelDao {

    @Lazy
    @Autowired
    private HotelJpaSpring hotelDB;

    @Override
    public List<Hotel> devolverHoteles(){
        return hotelDB.findAll();
    }
}
