package mx.uacm.reclutaSoft.test.controller;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import mx.uacm.reclutaSoft.Application;
import mx.uacm.reclutaSoft.constantes.Error;
import mx.uacm.reclutaSoft.excepcion.AppExcepcion;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Application.class)
@AutoConfigureMockMvc
public class UsuarioControllerTest {
	private final static Logger log = Logger.getLogger(UsuarioControllerTest.class);
	
	@Autowired
	private MockMvc mvc;
	
//	@Test
//	public void testObtenerUsuarios() throws AppExcepcion {
//		log.debug("Entrando a UsuarioControllerTest.testObtenerUsuarios");
//		
//		try {
//			mvc.perform(post("/usuarioController/login")
//						.param("correo", "marco.mandujano.hernandezgmail.com")
//						.param("contrasenia", "qazwsxed12")
//						).andExpect(model().attribute("error", Error.MAL_CORREO));
//		} catch (Exception e) {
//			log.debug("entro a la exception");
//			log.debug(e.getMessage());
//		}
//	}
	
	@Test
	public void testLoginMalCorreo() throws AppExcepcion {
		log.debug("Entrando a UsuarioControllerTest.testLoginMalCorreo");
		
		try {
			mvc.perform(post("/usuarioController/login")
						.param("correo", "marco.mandujano.hernandezgmail.com")
						.param("contrasenia", "qazwsxed12")
						).andExpect(model().attribute("error", Error.MAL_CORREO));
		} catch (Exception e) {
			log.debug("entro a la exception");
			log.debug(e.getMessage());
		}
	}
	
	@Test
	public void testLoginMalContrasenia() throws AppExcepcion {
		log.debug("Entrando a UsuarioControllerTest.testLoginMalContrasenia");
		
		try {
			mvc.perform(post("/usuarioController/login")
						.param("correo", "marco.mandujano.hernandez@gmail.com")
						.param("contrasenia", "")
						).andExpect(model().attribute("error", Error.MAL_CONTRASENIA));
		} catch (Exception e) {
			log.debug("entro a la exception");
			log.debug(e.getMessage());
		}
	}
	
//	@Test
//	public void testLogin() throws AppExcepcion {
//		log.debug("Entrando a UsuarioControllerTest.testLogin");
//		
//		try {
//			mvc.perform(post("/usuarioController/login")
//						.param("correo", "marco.mandujano.hernandez@gmail.com")
//						.param("contrasenia", "qazwsxed12")
//						).andExpect(redirectedUrl("action")
////						 .andExpect(model().size(10))
////						 .andExpect(model().attributeExists("nombreUsuario"))
////						 .andExpect(model().attributeExists("correoUsuario"))
////						 .andExpect(model().attributeExists("apellidoPaternoUsuario"))
////						 .andExpect(model().attributeExists("apellidoMaternoUsuario"))
////					     .andExpect(model().attributeExists("tituloUsuario"))
////					     .andExpect(model().attributeExists("webSiteUsuario"))
////					     .andExpect(model().attributeExists("reputacionUsuario"))
////					     .andExpect(model().attributeExists("habilidadesUsuario"))
////					     .andExpect(model().attributeExists("exitoso"))
////					     .andExpect(model().attributeExists("usuarios")
//					     );
//		} catch (Exception e) {
//			log.debug("entro a la exception");
//			log.debug(e.getMessage());
//		}
//	}
	
	@Test
	public void testRegistrarUsuarioMalHabilidad() throws AppExcepcion {
		log.debug("Entrando a UsuarioControllerTest.testRegistrarUsuarioMalHabilidad");
		
		try {
			mvc.perform(post("/usuarioController/registrarUsuario")
					   	.param("nombre", "Marco")
					   	.param("apellidoPaterno", "Mandujano")
						.param("apellidoMaterno", "Hernandez")
						.param("correo", "marco.mandujano.hernandez@gmail.com")
						.param("contrasenia", "qazwsxed12")
						.param("telefono", "1547896326")
						.param("edad", "20")
						.param("web", "http://marcoantoniomandujanohrdz.com/info")
						.param("titulo", "Estudiante")
						.param("lenguaje", "")
						.param("idioma", "")
						).andExpect(redirectedUrl("/error"));
						//).andExpect(model().attribute("error", is(equalTo(Error.MAL_NOMBRE))));
		} catch (Exception e) {
			log.debug("entro a la exception");
			log.debug(e.getMessage());
		}
	}
	
	@Test
	public void testRegistrarUsuarioMalTitulo() throws AppExcepcion {
		log.debug("Entrando a UsuarioControllerTest.testRegistrarUsuarioMalTitulo");
		
		try {
			mvc.perform(post("/usuarioController/registrarUsuario")
					   	.param("nombre", "Marco")
					   	.param("apellidoPaterno", "Mandujano")
						.param("apellidoMaterno", "Hernandez")
						.param("correo", "marco.mandujano.hernandez@gmail.com")
						.param("contrasenia", "qazwsxed12")
						.param("telefono", "1547896326")
						.param("edad", "20")
						.param("web", "http://marcoantoniomandujanohrdz.com/info")
						.param("titulo", "Tecnico")
						.param("lenguaje", "c")
						.param("idioma", "ingles")
						).andExpect(redirectedUrl("/error"));
						//).andExpect(model().attribute("error", is(equalTo(Error.MAL_NOMBRE))));
		} catch (Exception e) {
			log.debug("entro a la exception");
			log.debug(e.getMessage());
		}
	}
	
	@Test
	public void testRegistrarUsuarioMalWeb() throws AppExcepcion {
		log.debug("Entrando a UsuarioControllerTest.testRegistrarUsuarioMalWeb");
		
		try {
			mvc.perform(post("/usuarioController/registrarUsuario")
					   	.param("nombre", "Marco")
					   	.param("apellidoPaterno", "Mandujano")
						.param("apellidoMaterno", "Hernandez")
						.param("correo", "marco.mandujano.hernandez@gmail.com")
						.param("contrasenia", "qazwsxed12")
						.param("telefono", "1547896326")
						.param("edad", "20")
						.param("web", "http://marcoantoniomandujanohrdzcom/info")
						.param("titulo", "Estudiante")
						.param("lenguaje", "c")
						.param("idioma", "ingles")
						).andExpect(redirectedUrl("/error"));
						//).andExpect(model().attribute("error", is(equalTo(Error.MAL_NOMBRE))));
		} catch (Exception e) {
			log.debug("entro a la exception");
			log.debug(e.getMessage());
		}
	}
	
	@Test
	public void testRegistrarUsuarioMalEdad() throws AppExcepcion {
		log.debug("Entrando a UsuarioControllerTest.testRegistrarUsuarioMalEdad");
		
		try {
			mvc.perform(post("/usuarioController/registrarUsuario")
					   	.param("nombre", "Marco")
					   	.param("apellidoPaterno", "Mandujano")
						.param("apellidoMaterno", "Hernandez")
						.param("correo", "marco.mandujano.hernandez@gmail.com")
						.param("contrasenia", "qazwsxed12")
						.param("telefono", "1547896326")
						.param("edad", "15")
						.param("web", "http://marcoantoniomandujanohrdz.com/info")
						.param("titulo", "Estudiante")
						.param("lenguaje", "c")
						.param("idioma", "ingles")
						).andExpect(redirectedUrl("/error"));
						//).andExpect(model().attribute("error", is(equalTo(Error.MAL_NOMBRE))));
		} catch (Exception e) {
			log.debug("entro a la exception");
			log.debug(e.getMessage());
		}
	}
	
	@Test
	public void testRegistrarUsuarioMalTelefono() throws AppExcepcion {
		log.debug("Entrando a UsuarioControllerTest.testRegistrarUsuarioMalTelefono");
		
		try {
			mvc.perform(post("/usuarioController/registrarUsuario")
					   	.param("nombre", "Marco")
					   	.param("apellidoPaterno", "Mandujano")
						.param("apellidoMaterno", "Hernandez")
						.param("correo", "marco.mandujano.hernandez@gmail.com")
						.param("contrasenia", "qazwsxed12")
						.param("telefono", "15478")
						.param("edad", "24")
						.param("web", "http://marcoantoniomandujanohrdz.com/info")
						.param("titulo", "Estudiante")
						.param("lenguaje", "c")
						.param("idioma", "ingles")
						).andExpect(redirectedUrl("/error"));
						//).andExpect(model().attribute("error", is(equalTo(Error.MAL_NOMBRE))));
		} catch (Exception e) {
			log.debug("entro a la exception");
			log.debug(e.getMessage());
		}
	}
	
	@Test
	public void testRegistrarUsuarioMalContrasenia() throws AppExcepcion {
		log.debug("Entrando a UsuarioControllerTest.testRegistrarUsuarioMalContrasenia");
		
		try {
			mvc.perform(post("/usuarioController/registrarUsuario")
					   	.param("nombre", "Marco")
					   	.param("apellidoPaterno", "Mandujano")
						.param("apellidoMaterno", "Hernandez")
						.param("correo", "marco.mandujano.hernandez@gmail.com")
						.param("contrasenia", "")
						.param("telefono", "1547896326")
						.param("edad", "24")
						.param("web", "http://marcoantoniomandujanohrdz.com/info")
						.param("titulo", "Estudiante")
						.param("lenguaje", "c")
						.param("idioma", "ingles")
						).andExpect(redirectedUrl("/error"));
						//).andExpect(model().attribute("error", is(equalTo(Error.MAL_NOMBRE))));
		} catch (Exception e) {
			log.debug("entro a la exception");
			log.debug(e.getMessage());
		}
	}
	
	@Test
	public void testRegistrarUsuarioMalCorreo() throws AppExcepcion {
		log.debug("Entrando a UsuarioControllerTest.testRegistrarUsuarioMalCorreo");
		
		try {
			mvc.perform(post("/usuarioController/registrarUsuario")
					   	.param("nombre", "Marco")
					   	.param("apellidoPaterno", "Mandujano")
						.param("apellidoMaterno", "Hernandez")
						.param("correo", "marco.mandujano.hernandezgmail.com")
						.param("contrasenia", "qazwsxed12")
						.param("telefono", "1547896326")
						.param("edad", "24")
						.param("web", "http://marcoantoniomandujanohrdz.com/info")
						.param("titulo", "Estudiante")
						.param("lenguaje", "c")
						.param("idioma", "ingles")
						).andExpect(redirectedUrl("/error"));
						//).andExpect(model().attribute("error", is(equalTo(Error.MAL_NOMBRE))));
		} catch (Exception e) {
			log.debug("entro a la exception");
			log.debug(e.getMessage());
		}
	}
	
	@Test
	public void testRegistrarUsuarioMalApMaterno() throws AppExcepcion {
		log.debug("Entrando a UsuarioControllerTest.testRegistrarUsuarioMalApMaterno");
		
		try {
			mvc.perform(post("/usuarioController/registrarUsuario")
					   	.param("nombre", "Marco")
					   	.param("apellidoPaterno", "Mandujano")
						.param("apellidoMaterno", "Hernandez2")
						.param("correo", "marco.mandujano.hernandez@gmail.com")
						.param("contrasenia", "qazwsxed12")
						.param("telefono", "1547896326")
						.param("edad", "24")
						.param("web", "http://marcoantoniomandujanohrdz.com/info")
						.param("titulo", "Estudiante")
						.param("lenguaje", "c")
						.param("idioma", "ingles")
						).andExpect(redirectedUrl("/error"));
						//).andExpect(model().attribute("error", is(equalTo(Error.MAL_NOMBRE))));
		} catch (Exception e) {
			log.debug("entro a la exception");
			log.debug(e.getMessage());
		}
	}
	
	@Test
	public void testRegistrarUsuarioMalApPaterno() throws AppExcepcion {
		log.debug("Entrando a UsuarioControllerTest.testRegistrarUsuarioMalApPaterno");
		
		try {
			mvc.perform(post("/usuarioController/registrarUsuario")
					   	.param("nombre", "Marco")
					   	.param("apellidoPaterno", "Mandujano2")
						.param("apellidoMaterno", "Hernandez")
						.param("correo", "marco.mandujano.hernandez@gmail.com")
						.param("contrasenia", "qazwsxed12")
						.param("telefono", "1547896326")
						.param("edad", "24")
						.param("web", "http://marcoantoniomandujanohrdz.com/info")
						.param("titulo", "Estudiante")
						.param("lenguaje", "c")
						.param("idioma", "ingles")
						).andExpect(redirectedUrl("/error"));
						//).andExpect(model().attribute("error", is(equalTo(Error.MAL_NOMBRE))));
		} catch (Exception e) {
			log.debug("entro a la exception");
			log.debug(e.getMessage());
		}
	}
	
	@Test
	public void testRegistrarUsuarioMalNombre() throws AppExcepcion {
		log.debug("Entrando a UsuarioControllerTest.testRegistrarUsuarioMalNombre");
		
		try {
			mvc.perform(post("/usuarioController/registrarUsuario")
					   	.param("nombre", "Marco2")
					   	.param("apellidoPaterno", "Mandujano")
						.param("apellidoMaterno", "Hernandez")
						.param("correo", "marco.mandujano.hernandez@gmail.com")
						.param("contrasenia", "qazwsxed12")
						.param("telefono", "1547896326")
						.param("edad", "24")
						.param("web", "http://marcoantoniomandujanohrdz.com/info")
						.param("titulo", "Estudiante")
						.param("lenguaje", "c")
						.param("idioma", "ingles")
						).andExpect(redirectedUrl("/error"));
						//).andExpect(model().attribute("error", is(equalTo(Error.MAL_NOMBRE))));
		} catch (Exception e) {
			log.debug("entro a la exception");
			log.debug(e.getMessage());
		}
	}
	
	
	@Test
	public void testRegistrarUsuario() throws AppExcepcion {
		log.debug("Entrando a UsuarioControllerTest.testRegistrarUsuario");
		
		List<String> lenguajes = new ArrayList<String>();
		
		lenguajes.add("c");
		lenguajes.add("c++");
		
		List<String> idiomas = new ArrayList<String>();
		
		idiomas.add("ingles");
		
		
		try {
			mvc.perform(post("/usuarioController/registrarUsuario")
					   	.param("nombre", "Marco")
						.param("apellidoPaterno", "Mandujano")
						.param("apellidoMaterno", "Hernandez")
						.param("correo", "marco.mandujano.hernandez@gmail.com")
						.param("contrasenia", "qazwsxed12")
						.param("telefono", "1547896326")
						.param("edad", "24")
						.param("web", "http://marcoantoniomandujanohrdz.com/info")
						.param("titulo", "Estudiante")
						.param("lenguaje", "c")
						.param("idioma", "ingles")
						).andExpect(redirectedUrl("/perfil"));
		} catch (Exception e) {
			log.debug("entro a la exception");
			log.debug(e.getMessage());
		}
	}
	
}
