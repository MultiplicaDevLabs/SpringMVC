package mx.com.springmvc.capacitacion.config;

import org.springframework.context.MessageSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import mx.com.springmvc.capacitacion.web.conversor.TipoSexoConverter;

//essa eh a classe onde se configura os componentes do spring mvc que iremos utilziar.
@Configuration
@EnableWebMvc
public class SpringMvcConfig extends WebMvcConfigurerAdapter {

	/**
	 * indica o tipo de template que se ira utilizar, nesse caso seria JSP e JSTL
	 */
	@Bean
	public InternalResourceViewResolver viewResolver() {
		
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		
		return resolver;
	}

	/**
	 * adiciona os converters que se utilizara na aplicacao
	 */
	@Override
	public void addFormatters(FormatterRegistry registry) {

		registry.addConverter(new TipoSexoConverter());
	}
	
	/**
	 * informa ao Spring que havera um arquivo de mensagens. nesse caso o BeanValidation se utiliza disso.
	 */
	@Bean
	public MessageSource messageSource() {
		
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasename("messages");
		
		return source;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		//indica onde estao os arquivos estaticos da aplicacao
		registry.addResourceHandler("/static/**").addResourceLocations("/WEB-INF/resources/bootstrap/");
	}
	
}
