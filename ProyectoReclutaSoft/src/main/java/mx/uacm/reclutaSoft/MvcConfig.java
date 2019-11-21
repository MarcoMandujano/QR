package mx.uacm.reclutaSoft;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//@EnableWebMvc
//@EnableWebMvc
//@ComponentScan
//@EnableAutoConfiguration
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
	
	
	private static final String[] RESOURCE_LOCATIONS = {
			"classpath:/META-INF/resources/", "classpath:/resources/",
			"classpath:/static/", "classpath:/public/", "classpath:/public/js/" };
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		//Redirecciona a la vista index.
		registry.addViewController("/").setViewName("index");
		//Redireccionando a la vista request cada vez que ponga /peticion.
		registry.addViewController("/peticion").setViewName("request");
		
		registry.addViewController("/registro").setViewName("registro");
		
		registry.addViewController("/pruebasMarco").setViewName("pruebasMarco");
		
		registry.addViewController("/pruebasJavier").setViewName("pruebasJavier");
		registry.addViewController("/registraProyectoCandidatos").setViewName("registraProyectoCandidatos");
		registry.addViewController("/action").setViewName("action");
		registry.addViewController("/perfil").setViewName("perfil");
		registry.addViewController("/error").setViewName("error");
		//añadir nuevas paginas aqui
		registry.addViewController("/registrarProyecto").setViewName("registrarProyecto");
		//----------------------------------------------------------------------------------------
		registry.addViewController("/index1").setViewName("index1");
		registry.addViewController("/info").setViewName("info");
		registry.addViewController("/vistaEsperanza").setViewName("vistaEsperanza");
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/webjars/**")
        .addResourceLocations("classpath:/META-INF/resources/webjars/");
		registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/public/");
		registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
		
//		registry.addResourceHandler("/**")
//        .addResourceLocations("classpath:/**");
		if (!registry.hasMappingForPattern("/**")) {
			registry.addResourceHandler("/**").addResourceLocations(
					RESOURCE_LOCATIONS);
		}
		
	}
}






























