package ec.com.leodev.sbcd.contacto.service;

import ec.com.leodev.sbcd.contacto.model.Country;

import java.util.List;

public interface ICountryService {

    List<Country> findCountries();

    List<Country> findCountries(String name);
}
