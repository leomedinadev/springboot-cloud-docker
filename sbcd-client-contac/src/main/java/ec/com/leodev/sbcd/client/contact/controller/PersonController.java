package ec.com.leodev.sbcd.client.contact.controller;

import ec.com.leodev.sbcd.client.contact.model.PersonVO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class PersonController {

    String url = "http://localhost:8080";

    @GetMapping(value = "/persons/{name}/{mail}/{age}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PersonVO>> altaPersona(@PathVariable("name") String name, @PathVariable("mail") String mail, @PathVariable("age") Integer age) {

        PersonVO personVO = new PersonVO(name, mail, age);
        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.postForLocation(url + "/contact", personVO);

            PersonVO[] personVOS = restTemplate.getForObject(url + "/contacts", PersonVO[].class);
            return new ResponseEntity<>(Arrays.asList(personVOS), HttpStatus.OK);

        } catch (HttpStatusCodeException exception) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("error", exception.getResponseBodyAsString());
            return new ResponseEntity<List<PersonVO>>(new ArrayList<>(), headers, exception.getStatusCode());
        }
    }
}
