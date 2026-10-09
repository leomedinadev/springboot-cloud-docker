package ec.com.leodev.sbcd.contacto.repository.dao;

import ec.com.leodev.sbcd.contacto.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface IContactJPA extends JpaRepository<ContactEntity, Integer> {

    ContactEntity findByMail(String mail);

    @Transactional
    @Modifying
    @Query("Delete from CONTACTO c where c.mail=?1")
    void deleteByMail(String mail);
}
