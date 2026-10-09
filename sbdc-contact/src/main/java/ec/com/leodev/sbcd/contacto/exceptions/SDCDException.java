package ec.com.leodev.sbcd.contacto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SDCDException extends Exception {

    public SDCDException(String message) {
        super(message);
    }
}
