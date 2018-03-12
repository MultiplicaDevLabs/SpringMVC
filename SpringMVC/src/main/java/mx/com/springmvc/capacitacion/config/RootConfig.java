package mx.com.springmvc.capacitacion.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration //indica que eh uma classe de configuracao do Spring
@ComponentScan("mx.com.springmvc.capacitacion") //indica para o Spring onde estao os pacotes que deverao ser scanneados
@EnableWebMvc //habilita os recursos do spring MVC
public class RootConfig {

}
