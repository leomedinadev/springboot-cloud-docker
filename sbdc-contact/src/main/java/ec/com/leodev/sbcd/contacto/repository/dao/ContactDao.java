package ec.com.leodev.sbcd.contacto.repository.dao;

import ec.com.leodev.sbcd.contacto.entity.ContactEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContactDao implements IContactDao {

    @Autowired
    IContactJPA db;

    @Override
    public void addContact(ContactEntity entity) {
        db.save(entity);
    }

    @Override
    public ContactEntity findContact(String email) {
        return db.findByMail(email);
    }

    @Override
    public void deleteContact(String mail) {
        db.deleteByMail(mail);
    }

    @Override
    public List<ContactEntity> findAllContact() {
        return db.findAll();
    }

    @Override
    public void deleteContact(int id) {
        db.deleteById(id);
    }

    @Override
    public ContactEntity findContact(Integer id) {
        return db.findById(id).orElse(null);
    }

    @Override
    public void updateContact(ContactEntity entity) {
        db.save(entity);
    }
}
