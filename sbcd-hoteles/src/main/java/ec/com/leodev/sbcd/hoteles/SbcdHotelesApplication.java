package ec.com.leodev.sbcd.hoteles;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;

@Slf4j
//@EntityScan(basePackages = {"model"})
@SpringBootApplication(scanBasePackages = {"ec.com.leodev.sbcd.hoteles"})
public class SbcdHotelesApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(SbcdHotelesApplication.class, args);
            log.info("*********************************** Inicio de sistema ******************************************");
        } catch(Exception throwable) {
            if (!Objects.equals(throwable.getClass().getName(), "org.springframework.boot.devtools.restart.SilentExitExceptionHandler$SilentExitException")
                    && log.isErrorEnabled()) {
                log.error("*************************************Ha ocurrido una exception**********************************");
                log.error("Exception: " + throwable.toString());
                log.error("Root Cause: " + ExceptionUtils.getRootCause(throwable).toString());
            }
        }
    }

}
