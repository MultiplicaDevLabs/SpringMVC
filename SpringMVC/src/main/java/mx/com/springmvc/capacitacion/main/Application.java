package mx.com.springmvc.capacitacion.main;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.Import;

import mx.com.springmvc.capacitacion.config.RootConfig;
import mx.com.springmvc.capacitacion.config.SpringMvcConfig;

@SpringBootApplication
@Import(RootConfig.class)
public class Application{
    
    public static void main(String args[]) {        
        SpringApplication.run(Application.class, args);
    }

}