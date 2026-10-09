package ec.com.leodev.sbcd.client.contact.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonVO {
    private String name;
    private String mail;
    private Integer age;
}
