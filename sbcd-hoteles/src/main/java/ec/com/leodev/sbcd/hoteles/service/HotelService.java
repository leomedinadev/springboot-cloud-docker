package ec.com.leodev.sbcd.hoteles.service;

import ec.com.leodev.sbcd.hoteles.dao.IHotelDao;
import ec.com.leodev.sbcd.hoteles.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelService implements IHotelService {

    @Autowired
    private IHotelDao hotelDao;

    @Override
    public List<Hotel> devolverHotelesDispobibles() {
        List<Hotel> hoteles = hotelDao.devolverHoteles();
        if (hoteles != null) {
            return hoteles.stream().filter(Hotel::getDisponible).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}
