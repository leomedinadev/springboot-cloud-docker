package ec.com.leodev.sbcd.server.config;
import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

import java.util.Objects;

@Slf4j
@EnableConfigServer
@SpringBootApplication
public class ServerConfigApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(ServerConfigApplication.class, args);
            log.info("*********************************** Inicio de sistema ******************************************");
        } catch(Exception throwable) {
            if (!Objects.equals(throwable.getClass().getName(), "org.springframework.boot.devtools.restart.SilentExitExceptionHandler$SilentExitException")
                    && log.isErrorEnabled()) {
                log.error("*************************************Ha ocurrido una exception**********************************");
                log.error("Exception: " + throwable.toString());
                //log.error("Root Cause: " + ExceptionUtils.getRootCause(throwable).toString());
            }
        }
    }

}
