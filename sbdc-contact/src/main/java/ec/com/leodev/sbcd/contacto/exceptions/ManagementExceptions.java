package ec.com.leodev.sbcd.contacto.exceptions;


import com.fasterxml.jackson.core.JsonParseException;
import ec.com.leodev.sbcd.contacto.pojo.MessageError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

/**
 * Management Exceptions.
 * @author leonardo
 */
@RestControllerAdvice
public class ManagementExceptions {

    /*@ExceptionHandler(Exception.class)
    public ResponseEntity<String> messageError(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }*/

    /**
     * Json Parse exception.
     *
     * @param ex Exception exception.
     * @return ResponseEntity with specific code.
     */
    @ExceptionHandler(JsonParseException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<MessageError> jsonParseException(HttpServletRequest request, Exception ex) {
        return buildResponseEntity(request, HttpStatus.BAD_REQUEST,ex);
    }

    /**
     * Null Pointer exception.
     *
     * @param ex Exception exception.
     * @return ResponseEntity with specific code.
     */
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<MessageError> nullPointerException(HttpServletRequest request, Exception ex) {
        return buildResponseEntity(request, HttpStatus.INTERNAL_SERVER_ERROR,ex);
    }

    /**
     * Entity Not Found, personalized exception.
     *
     * @param ex Exception exception.
     * @return ResponseEntity with specific code.
     */
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<MessageError> entityNotFoundException(HttpServletRequest request, Exception ex) {
        return buildResponseEntity(request, HttpStatus.INTERNAL_SERVER_ERROR,ex);
    }

    /**
     * Constraint Violation exception.
     *
     * @param ex Exception exception.
     * @return ResponseEntity with specific code.
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<MessageError> constraintViolationException(HttpServletRequest request,
                                                                     Exception ex) {
        return buildResponseEntity(request, HttpStatus.INTERNAL_SERVER_ERROR,ex);
    }

    /**
     * Http Request Method Not Supported exception.
     *
     * @param ex Exception exception.
     * @return ResponseEntity with specific code.
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<MessageError> httpRequestMethodNotSupportedException(HttpServletRequest request, Exception ex) {
        return buildResponseEntity(request, HttpStatus.INTERNAL_SERVER_ERROR,ex);
    }

    /**
     * Build response entity.
     * @param request HttpServletRequest
     * @param status HttpStatus
     * @param ex Exception
     * @return ResponseEntity MessageError
     */
    private ResponseEntity<MessageError> buildResponseEntity(HttpServletRequest request, HttpStatus status, Exception ex) {
        MessageError error=new MessageError(
                status.toString(),
                ex.getMessage(),
                request.getRequestURI()
        );
        return new ResponseEntity<>(error,status);
    }

}
