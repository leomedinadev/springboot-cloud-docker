package ec.com.leodev.sbcd.reservas;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Slf4j
@SpringBootApplication(scanBasePackages = {"ec.com.leodev.sbcd.reservas"})
public class SbcdReservasApplication {

    public static void main(String[] args) {

        try {
            SpringApplication.run(SbcdReservasApplication.class, args);
            log.info("*********************************** Inicio de sistema ******************************************");
        } catch(Exception throwable) {
            if (!Objects.equals(throwable.getClass().getName(), "org.springframework.boot.devtools.restart.SilentExitExceptionHandler$SilentExitException")
                    && log.isErrorEnabled()) {
                log.error("*************************************Ha ocurrido una exception**********************************");
                if (throwable != null) {
                    log.error("Exception: " + throwable.toString());
                    log.error("Root Cause: " + ExceptionUtils.getRootCause(throwable).toString());
                }

            }
        }
    }

    @LoadBalanced
    @Bean
    public RestTemplate crearTemplate() {
        return new RestTemplate();
    }

}
