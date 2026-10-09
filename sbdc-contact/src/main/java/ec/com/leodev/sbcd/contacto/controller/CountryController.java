package ec.com.leodev.sbcd.contacto.controller;

import ec.com.leodev.sbcd.contacto.model.Country;
import ec.com.leodev.sbcd.contacto.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    @Autowired
    private ICountryService countryService;


    @GetMapping(value = "/countries", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Country> countries() {
        return countryService.findCountries();
    }

    @GetMapping(value = "/countries/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Country> countries(@PathVariable("name") String name) {
        return countryService.findCountries(name);
    }
}
