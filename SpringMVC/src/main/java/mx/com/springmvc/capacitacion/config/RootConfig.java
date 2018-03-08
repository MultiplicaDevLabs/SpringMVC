package mx.com.springmvc.capacitacion.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("mx.com.springmvc.capacitacion")
@EnableWebMvc
@Import(SpringMvcConfig.class)
public class RootConfig {

}
