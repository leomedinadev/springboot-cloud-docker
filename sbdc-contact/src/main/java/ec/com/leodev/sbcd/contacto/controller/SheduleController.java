package ec.com.leodev.sbcd.contacto.controller;

import javax.validation.Valid;
import ec.com.leodev.sbcd.contacto.entity.ContactEntity;
import ec.com.leodev.sbcd.contacto.exceptions.SDCDException;
import ec.com.leodev.sbcd.contacto.service.ISheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class SheduleController {

    @Autowired
    private ISheduleService sheduleSerive;

    @GetMapping(value = "contacts", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ContactEntity> findAll() {
        return sheduleSerive.findContacts();
    }

    @GetMapping("contact/{id}")
    public ContactEntity find(@PathVariable("id") Integer id) {
        return sheduleSerive.findContact(id);
    }

    @PostMapping("contact")
    public void saveContact(@RequestBody @Valid ContactEntity contactEntity, BindingResult result) throws Exception{
        if (result.hasErrors()) {
            throw new SDCDException("Valores nulos en los parametros enviados, por favor verifique.");
        }
        sheduleSerive.addContact(contactEntity);
    }

    @PutMapping(value = "contact")
    public void updateContact(@RequestBody ContactEntity contactEntity) {
        sheduleSerive.updateContact(contactEntity);
    }

    @DeleteMapping(value = "contacts/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        sheduleSerive.deleteContact(id);
    }

    @PostMapping(value = "exampleAsync")
    public void exampleAsync() {

    }
}
