package ec.com.leodev.sbcd.server.eureka;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.util.Objects;

@Slf4j
@EnableEurekaServer
@SpringBootApplication
public class ServerEurekaApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(ServerEurekaApplication.class, args);
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
