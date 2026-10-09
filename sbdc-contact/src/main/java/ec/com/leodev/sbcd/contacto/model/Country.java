package ec.com.leodev.sbcd.contacto.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Country {

    private String nombre;
    private String capital;
    private int poblacion;
    private String bandera;
}
