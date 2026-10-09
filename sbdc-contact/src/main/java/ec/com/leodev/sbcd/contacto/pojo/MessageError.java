package ec.com.leodev.sbcd.contacto.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Accessors(chain = true)
public class MessageError implements IMessageError {

    protected String id;
    protected String type;
    protected String message;
    protected String url;

    /**
     * Constructor.
     *
     * @param type    The type of the message
     * @param message The message
     * @param url     The url
     * @since 2.0.0
     */
    public MessageError(String type, String message, String url) {
        this.id = String.valueOf(System.currentTimeMillis());
        this.type = type;
        this.message = message;
        this.url = url;
    }
}