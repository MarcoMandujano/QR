package mx.uacm.reclutaSoft;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		//Redirecciona a la vista index.
		registry.addViewController("/").setViewName("index");
		//Redireccionando a la vista request cada vez que ponga /peticion.
		registry.addViewController("/peticion").setViewName("request");
		
		registry.addViewController("/registro").setViewName("registro");
		
		registry.addViewController("/pruebasMarco").setViewName("pruebasMarco");
		registry.addViewController("/registrarProyecto").setViewName("registrarProyecto");
		registry.addViewController("/pruebasJavier").setViewName("pruebasJavier");
		registry.addViewController("/registraProyectoCandidatos").setViewName("registraProyectoCandidatos");
		registry.addViewController("/action").setViewName("action");
		registry.addViewController("/perfil").setViewName("perfil");
		registry.addViewController("/error").setViewName("error");
		
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/webjars/**")
        .addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
}
