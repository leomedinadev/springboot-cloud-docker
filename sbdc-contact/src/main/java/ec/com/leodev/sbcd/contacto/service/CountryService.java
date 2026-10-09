package ec.com.leodev.sbcd.contacto.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import ec.com.leodev.sbcd.contacto.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Lazy
@Service
public class CountryService implements ICountryService {

    private static final String URL_SERVICE = "https://restcountries.eu/rest/v2/all";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Country> findCountries() {
        String result = restTemplate.getForObject(URL_SERVICE, String.class);
        ObjectMapper mapper = new ObjectMapper();
        List<Country> countries = new ArrayList<>();
        try {
            ArrayNode arrayNode = (ArrayNode) mapper.readTree(result);
            for(Object ob : arrayNode) {
                ObjectNode json = (ObjectNode) ob;
                countries.add(new Country(json.get("name").asText(), json.get("capital").asText(), json.get("population").asInt(), json.get("flag").asText()));
            }

        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }
        return countries;
    }

    @Override
    public List<Country> findCountries(String name) {
        return findCountries().stream().filter(p -> p.getNombre().contains(name)).collect(Collectors.toList());
    }
}
