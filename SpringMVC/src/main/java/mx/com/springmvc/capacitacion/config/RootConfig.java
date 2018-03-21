package mx.com.springmvc.capacitacion.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@ComponentScan("mx.com.springmvc.capacitacion")
@Import({SpringMvcConfig.class, SpringJPAConfig.class})
public class RootConfig {

}
