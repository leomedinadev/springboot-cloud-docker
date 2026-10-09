package ec.com.leodev.sbcd.contacto.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
@Entity(name = "CONTACTO")
public class ContactEntity implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NOMBRE", length = 60)
    private String name;

    @Column(name = "CORREO", length = 40)
    private String mail;

    @Column(name = "EDAD")
    private Integer age;
}
