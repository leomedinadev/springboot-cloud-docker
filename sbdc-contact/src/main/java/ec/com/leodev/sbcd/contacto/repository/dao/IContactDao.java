package ec.com.leodev.sbcd.contacto.repository.dao;

import ec.com.leodev.sbcd.contacto.entity.ContactEntity;

import java.util.List;


public interface IContactDao {

    void addContact(ContactEntity entity);

    ContactEntity findContact(String email);

    void deleteContact(String mail);

    List<ContactEntity> findAllContact();

    void deleteContact(int id);

    ContactEntity findContact(Integer id);

    void updateContact(ContactEntity entity);
}
