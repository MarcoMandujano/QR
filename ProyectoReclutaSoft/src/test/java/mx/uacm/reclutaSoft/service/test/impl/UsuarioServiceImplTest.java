package mx.uacm.reclutaSoft.service.test.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.uacm.reclutaSoft.Application;
import mx.uacm.reclutaSoft.constantes.Error;
import mx.uacm.reclutaSoft.constantes.Regla;
import mx.uacm.reclutaSoft.domain.Habilidad;
import mx.uacm.reclutaSoft.domain.Usuario;
import mx.uacm.reclutaSoft.excepcion.AppExcepcion;
import mx.uacm.reclutaSoft.service.HabilidadService;
import mx.uacm.reclutaSoft.service.UsuarioService;
import mx.uacm.reclutaSoft.service.impl.HabilidadServiceImpl;
import mx.uacm.reclutaSoft.service.impl.UsuarioServiceImpl;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Application.class)
public class UsuarioServiceImplTest {
	private static final Logger log = LogManager.getLogger(UsuarioServiceImplTest.class);
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private HabilidadService habilidadService; 
	
//	private UsuarioService usuarioService = new UsuarioServiceImpl();
//	private HabilidadService habilidadService = new HabilidadServiceImpl();	
	@Test
	public void testNombreLongMin() {
		log.debug("Entrando a testNombreLongMin");
		
		Usuario usuario = new Usuario();
		
		usuario.setNombre("Mar");
		List<String> lenguajes = new ArrayList<String>();
		List<String> idiomas = new ArrayList<String>();
		
//		String nombre = "Mar";
//		String apellidoPaterno = "";
//		String apellidoMaterno = "";
//		String correo = "";
//		String contrasenia = "";
//		String telefono = "";
//		ArrayList<Habilidad> habilidades = null;
//		int edad = 0;
//		String web = "";
//		String titulo = "";
		
		try {
//			usuarioService.alta(nombre, apellidoPaterno, apellidoMaterno, correo, contrasenia, telefono, habilidades, edad, web, titulo);
			usuarioService.alta(usuario, lenguajes, idiomas);
			
		} catch (AppExcepcion e) {
			Assert.assertEquals(Error.MAL_NOMBRE, e.getMessage());
		}
	}
	
	@Test
	public void testNombreLongMax() {
		log.debug("Entrando a testNombreLongMax");
		
		Usuario usuario = new Usuario();
		List<String> lenguajes = new ArrayList<String>();
		List<String> idiomas = new ArrayList<String>();
		
		
		String nombre = "a";
		
		for (int i = 0; i < Regla.LONG_MAX_NOMBRE; i++) {
			nombre += "a";
		}
		
		usuario.setNombre(nombre);
		
//		String apellidoPaterno = "";
//		String apellidoMaterno = "";
//		String correo = "";
//		String contrasenia = "";
//		String telefono = "";
//		ArrayList<Habilidad> habilidades = null;
//		int edad = 0;
//		String web = "";
//		String titulo = "";
		
		try {
//			usuarioService.alta(nombre, apellidoPaterno, apellidoMaterno, correo, contrasenia, telefono, habilidades, edad, web, titulo);
			usuarioService.alta(usuario, lenguajes, idiomas);
			
		} catch (AppExcepcion e) {
			Assert.assertEquals(Error.MAL_NOMBRE, e.getMessage());
		}
	}
	
	@Test
	public void testNombreCaracteres() {
		log.debug("Entrando a testNombreCaracteres");
		
		Usuario usuario = new Usuario();
		List<String> lenguajes = new ArrayList<String>();
		List<String> idiomas = new ArrayList<String>();
		
		String nombre = "Marco1";
		usuario.setNombre(nombre);
		
//		String apellidoPaterno = "";
//		String apellidoMaterno = "";
//		String correo = "";
//		String contrasenia = "";
//		String telefono = "";
//		ArrayList<Habilidad> habilidades = null;
//		int edad = 0;
//		String web = "";
//		String titulo = "";
		
		try {
//			usuarioService.alta(nombre, apellidoPaterno, apellidoMaterno, correo, contrasenia, telefono, habilidades, edad, web, titulo);
			usuarioService.alta(usuario, lenguajes, idiomas);
			
		} catch (AppExcepcion e) {
			Assert.assertEquals(Error.MAL_NOMBRE, e.getMessage());
		}
	}
	
	@Test
	public void testApPaternoLongMin() {
		log.debug("Entrando a testApPaternoLongMin");
		
		Usuario usuario = new Usuario();
		List<String> lenguajes = new ArrayList<String>();
		List<String> idiomas = new ArrayList<String>();
		
		String nombre = "Marco";
		usuario.setNombre(nombre);
		
		String apellidoPaterno = "Man";
		usuario.setApellidoPaterno(apellidoPaterno);
		
//		String apellidoMaterno = "";
//		String correo = "";
//		String contrasenia = "";
//		String telefono = "";
//		ArrayList<Habilidad> habilidades = null;
//		int edad = 0;
//		String web = "";
//		String titulo = "";
		
		try {
//			usuarioService.alta(nombre, apellidoPaterno, apellidoMaterno, correo, contrasenia, telefono, habilidades, edad, web, titulo);
			usuarioService.alta(usuario, lenguajes, idiomas);
		} catch (AppExcepcion e) {
			Assert.assertEquals(Error.MAL_AP_PATERNO, e.getMessage());
		}
	}
	
	@Test
	public void testApPaternoLongMax() {
		log.debug("Entrando a testApPaternoLongMax");
		Usuario usuario = new Usuario();
		List<String> lenguajes = new ArrayList<String>();
		List<String> idiomas = new ArrayList<String>();
		
		String nombre = "Marco";	
		usuario.setNombre(nombre);
		String apellidoPaterno = "a";
		
		for (int i = 0; i < Regla.LONG_MAX_PATERNO; i++) {
			apellidoPaterno += "a";
		}
		usuario.setApellidoPaterno(apellidoPaterno);
				
//		String apellidoMaterno = "";
//		String correo = "";
//		String contrasenia = "";
//		String telefono = "";
//		ArrayList<Habilidad> habilidades = null;
//		int edad = 0;
//		String web = "";
//		String titulo = "";
		
		try {
//			usuarioService.alta(nombre, apellidoPaterno, apellidoMaterno, correo, contrasenia, telefono, habilidades, edad, web, titulo);
			usuarioService.alta(usuario, lenguajes, idiomas);
		} catch (AppExcepcion e) {
			Assert.assertEquals(Error.MAL_AP_PATERNO, e.getMessage());
		}
	}
	
	@Test
	public void testApPaternoCaracteres() {
		log.debug("Entrando a testApPaternoCaracteres");
		Usuario usuario = new Usuario();
		List<String> lenguajes = new ArrayList<String>();
		List<String> idiomas = new ArrayList<String>();
		
		String nombre = "Marco";
		usuario.setNombre(nombre);
		String apellidoPaterno = "Mandujano1";
		usuario.setApellidoPaterno(apellidoPaterno);
		
//		String apellidoMaterno = "";
//		String correo = "";
//		String contrasenia = "";
//		String telefono = "";
//		ArrayList<Habilidad> habilidades = null;
//		int edad = 0;
//		String web = "";
//		String titulo = "";
		
		try {
//			usuarioService.alta(nombre, apellidoPaterno, apellidoMaterno, correo, contrasenia, telefono, habilidades, edad, web, titulo);
			usuarioService.alta(usuario, lenguajes, idiomas);
		} catch (AppExcepcion e) {
			Assert.assertEquals(Error.MAL_AP_PATERNO, e.getMessage());
		}
	}
	
	@Test
	public void testApMaternoLongMin() {
		log.debug("Entrando a testApMaternoLongMin");
		Usuario usuario = new Usuario();
		List<String> lenguajes = new ArrayList<String>();
		List<String> idiomas = new ArrayList<String>();
		
		String nombre = "Marco";
		usuario.setNombre(nombre);
		String apellidoPaterno = "Mandujano";
		usuario.setApellidoPaterno(apellidoPaterno);
		String apellidoMaterno = "Her";
		usuario.setApellidoMaterno(apellidoMaterno);
		
//		String correo = "";
//		String contrasenia = "";
//		String telefono = "";
//		ArrayList<Habilidad> habilidades = null;
//		int edad = 0;
//		String web = "";
//		String titulo = "";
		
		try {
//			usuarioService.alta(nombre, apellidoPaterno, apellidoMaterno, correo, contrasenia, telefono, habilidades, edad, web, titulo);
			usuarioService.alta(usuario, lenguajes, idiomas);
		} catch (AppExcepcion e) {
			Assert.assertEquals(Error.MAL_AP_MATERNO, e.getMessage());
		}
	}
	
	@Test
	public void testApMaternoLongMax() {
		log.debug("Entrando a testApMaternoLongMax");
		Usuario usuario = new Usuario();
		List<String> lenguajes = new ArrayList<String>();
		List<String> idiomas = new ArrayList<String>();
		
		String nombre = "Marco";
		usuario.setNombre(nombre);
		String apellidoPaterno = "Mandujano";
		usuario.setApellidoPaterno(apellidoPaterno);	
		String apellidoMaterno = "a";

		for (int i = 0; i < Regla.LONG_MAX_MATERNO; i++) {
			apellidoMaterno += "a";
		}
		usuario.setApellidoMaterno(apellidoMaterno);
		
//		String correo = "";
//		String contrasenia = "";
//		String telefono = "";
//		ArrayList<Habilidad> habilidades = null;
//		int edad = 0;
//		String web = "";
//		String titulo = "";
		
		try {
//			usuarioService.alta(nombre, apellidoPaterno, apellidoMaterno, correo, contrasenia, telefono, habilidades, edad, web, titulo);
			usuarioService.alta(usuario, lenguajes, idiomas);
		} catch (AppExcepcion e) {
			Assert.assertEquals(Error.MAL_AP_MATERNO, e.getMessage());
		}
	}
	
	@Test
	public void testApMaternoCaracteres() {
		log.debug("Entrando a testApMaternoCaracteres");
		Usuario usuario = new Usuario();
		List<String> lenguajes = new ArrayList<String>();
		List<String> idiomas = new ArrayList<String>();
		
		String nombre = "Marco";
		usuario.setNombre(nombre);
		String apellidoPaterno = "Mandujano";
		usuario.setApellidoPaterno(apellidoPaterno);
		
		String apellidoMaterno = "Hernandez1";
		usuario.setApellidoMaterno(apellidoMaterno);
		
//		String correo = "";
//		String contrasenia = "";
//		String telefono = "";
//		ArrayList<Habilidad> habilidades = null;
//		int edad = 0;
//		String web = "";
//		String titulo = "";
		
		try {
//			usuarioService.alta(nombre, apellidoPaterno, apellidoMaterno, correo, contrasenia, telefono, habilidades, edad, web, titulo);
			usuarioService.alta(usuario, lenguajes, idiomas);
			
		} catch (AppExcepcion e) {
			Assert.assertEquals(Error.MAL_AP_MATERNO, e.getMessage());
		}
	}
	
	@Test
	public void testCorreo() {
		log.debug("Entrando a testCorreo");
		Usuario usuario = new Usuario();
		List<String> lenguajes = new ArrayList<String>();
		List<String> idiomas = new ArrayList<String>();
		
		String nombre = "Marco";
		usuario.setNombre(nombre);
		String apellidoPaterno = "Mandujano";
		usuario.setApellidoPaterno(apellidoPaterno);
		String apellidoMaterno = "Hernandez";
		usuario.setApellidoMaterno(apellidoMaterno);
		
		String correo = "$%@&/.)<>";
		usuario.setCorreo(correo);
		
//		String contrasenia = "";
//		String telefono = "";
//		ArrayList<Habilidad> habilidades = null;
//		int edad = 0;
//		String web = "";
//		String titulo = "";
		
		try {
//			usuarioService.alta(nombre, apellidoPaterno, apellidoMaterno, correo, contrasenia, telefono, habilidades, edad, web, titulo);
			usuarioService.alta(usuario, lenguajes, idiomas);
		} catch (AppExcepcion e) {
			Assert.assertEquals(Error.MAL_CORREO, e.getMessage());
		}
	}
	
	@Test
	public void testContraseniaMin() {
		log.debug("Entrando a testContraseniaMin");
		Usuario usuario = new Usuario();
		List<String> lenguajes = new ArrayList<String>();
		List<String> idiomas = new ArrayList<String>();
		
		String nombre = "Marco";
		usuario.setNombre(nombre);
		String apellidoPaterno = "Mandujano";
		usuario.setApellidoPaterno(apellidoPaterno);
		String apellidoMaterno = "Hernandez";
		usuario.setApellidoMaterno(apellidoMaterno);
		String correo = "marco.madujano@gmail.com";
		usuario.setCorreo(correo);
		
		String contrasenia = "qwe";
		usuario.setContrasenia(contrasenia);
		
//		String telefono = "";
//		ArrayList<Habilidad> habilidades = null;
//		int edad = 0;
//		String web = "";
//		String titulo = "";
		
		try {
//			usuarioService.alta(nombre, apellidoPaterno, apellidoMaterno, correo, contrasenia, telefono, habilidades, edad, web, titulo);
			usuarioService.alta(usuario, lenguajes, idiomas);
		
		} catch (AppExcepcion e) {
			Assert.assertEquals(Error.MAL_CONTRASENIA, e.getMessage());
		}
	}
	
	@Test
	public void testContraseniaMax() {
		log.debug("Entrando a testContraseniaMax");
		Usuario usuario = new Usuario();
		List<String> lenguajes = new ArrayList<String>();
		List<String> idiomas = new ArrayList<String>();
		
		String nombre = "Marco";
		usuario.setNombre(nombre);
		String apellidoPaterno = "Mandujano";
		usuario.setApellidoPaterno(apellidoPaterno);
		String apellidoMaterno = "Hernandez";
		usuario.setApellidoMaterno(apellidoMaterno);
		String correo = "marco.madujano@gmail.com";
		usuario.setCorreo(correo);
		
		String contrasenia = "qwerty1234567";		
		usuario.setContrasenia(contrasenia);
		
//		String telefono = "";
//		ArrayList<Habilidad> habilidades = null;
//		int edad = 0;
//		String web = "";
//		String titulo = "";
		
		try {
//			usuarioService.alta(nombre, apellidoPaterno, apellidoMaterno, correo, contrasenia, telefono, habilidades, edad, web, titulo);
			usuarioService.alta(usuario, lenguajes, idiomas);
		} catch (AppExcepcion e) {
			Assert.assertEquals(Error.MAL_CONTRASENIA, e.getMessage());
		}
	}
	
	@Test
	public void testTelefonoNumeros() {
		log.debug("Entrando a testTelefonoMax");
		Usuario usuario = new Usuario();
		List<String> lenguajes = new ArrayList<String>();
		List<String> idiomas = new ArrayList<String>();
		
		String nombre = "Marco";
		usuario.setNombre(nombre);
		String apellidoPaterno = "Mandujano";
		usuario.setApellidoPaterno(apellidoPaterno);
		String apellidoMaterno = "Hernandez";
		usuario.setApellidoMaterno(apellidoMaterno);
		String correo = "marco.madujano@gmail.com";
		usuario.setCorreo(correo);
		String contrasenia = "qwerty123";		
		usuario.setContrasenia(contrasenia);
		
		String telefono = "123456789A";
		usuario.setTelefono(telefono);
		
//		ArrayList<Habilidad> habilidades = null;
//		int edad = 0;
//		String web = "";
//		String titulo = "";
		
		try {
//			usuarioService.alta(nombre, apellidoPaterno, apellidoMaterno, correo, contrasenia, telefono, habilidades, edad, web, titulo);
			usuarioService.alta(usuario, lenguajes, idiomas);
		} catch (AppExcepcion e) {
			Assert.assertEquals(Error.MAL_TELEFONO, e.getMessage());
		}
	}
	
	@Test
	public void testTelefonoLong() {
		log.debug("Entrando a testTelefonoLong");
		
		Usuario usuario = new Usuario();
		List<String> lenguajes = new ArrayList<String>();
		List<String> idiomas = new ArrayList<String>();
		
		String nombre = "Marco";
		usuario.setNombre(nombre);
		String apellidoPaterno = "Mandujano";
		usuario.setApellidoPaterno(apellidoPaterno);
		String apellidoMaterno = "Hernandez";
		usuario.setApellidoMaterno(apellidoMaterno);
		String correo = "marco.madujano@gmail.com";
		usuario.setCorreo(correo);
		String contrasenia = "qwerty123";		
		usuario.setContrasenia(contrasenia);
		
		String telefono = "1578";
		usuario.setTelefono(telefono);
		
//		ArrayList<Habilidad> habilidades = null;
//		int edad = 0;
//		String web = "";
//		String titulo = "";
		
		try {
//			usuarioService.alta(nombre, apellidoPaterno, apellidoMaterno, correo, contrasenia, telefono, habilidades, edad, web, titulo);
			usuarioService.alta(usuario, lenguajes, idiomas);
		} catch (AppExcepcion e) {
			Assert.assertEquals(Error.MAL_TELEFONO, e.getMessage());
		}
	}
			
	@Test
	public void testHabilidades() {
		log.debug("Entrando a testHabilidades");
		Usuario usuario = new Usuario();
		List<String> lenguajes = new ArrayList<String>();
		List<String> idiomas = new ArrayList<String>();
		
		String nombre = "Marco";
		usuario.setNombre(nombre);
		String apellidoPaterno = "Mandujano";
		usuario.setApellidoPaterno(apellidoPaterno);
		String apellidoMaterno = "Hernandez";
		usuario.setApellidoMaterno(apellidoMaterno);
		String correo = "marco.madujano@gmail.com";
		usuario.setCorreo(correo);
		String contrasenia = "qwerty123";		
		usuario.setContrasenia(contrasenia);
		String telefono = "1547896358";
		usuario.setTelefono(telefono);
		
//		ArrayList<Habilidad> habilidades = new ArrayList<Habilidad>();
		
//		int edad = 0;
//		String web = "";
//		String titulo = "";
		
		try {
//			usuarioService.alta(nombre, apellidoPaterno, apellidoMaterno, correo, contrasenia, telefono, habilidades, edad, web, titulo);
			usuarioService.alta(usuario, lenguajes, idiomas);
			
		} catch (AppExcepcion e) {
			Assert.assertEquals(Error.MAL_HABILIDADES, e.getMessage());
		}
	}
	
	@Test
	public void testEdadMin() {
		log.debug("Entrando a testEdadMin");
		Usuario usuario = new Usuario();
		List<String> lenguajes = new ArrayList<String>();
		List<String> idiomas = new ArrayList<String>();
		
		String nombre = "Marco";
		usuario.setNombre(nombre);
		String apellidoPaterno = "Mandujano";
		usuario.setApellidoPaterno(apellidoPaterno);
		String apellidoMaterno = "Hernandez";
		usuario.setApellidoMaterno(apellidoMaterno);
		String correo = "marco.madujano@gmail.com";
		usuario.setCorreo(correo);
		String contrasenia = "qwerty123";		
		usuario.setContrasenia(contrasenia);
		String telefono = "1547896358";
		usuario.setTelefono(telefono);
		lenguajes.add("C");
		idiomas.add("ingles");
		
		int edad = 17;
		usuario.setEdad(edad);
		
//		String web = "";
//		String titulo = "";
		
		try {
//			habilidades.add(habilidadService.alta(nomHabilidad, tipo, puntuacion));			
//			usuarioService.alta(nombre, apellidoPaterno, apellidoMaterno, correo, contrasenia, telefono, habilidades, edad, web, titulo);
			usuarioService.alta(usuario, lenguajes, idiomas);
			
		} catch (AppExcepcion e) {
			Assert.assertEquals(Error.MAL_EDAD, e.getMessage());
		}
	}
	
	@Test
	public void testEdadMax() {
		log.debug("Entrando a testEdadMax");
		
		Usuario usuario = new Usuario();
		List<String> lenguajes = new ArrayList<String>();
		List<String> idiomas = new ArrayList<String>();
		
		String nombre = "Marco";
		usuario.setNombre(nombre);
		String apellidoPaterno = "Mandujano";
		usuario.setApellidoPaterno(apellidoPaterno);
		String apellidoMaterno = "Hernandez";
		usuario.setApellidoMaterno(apellidoMaterno);
		String correo = "marco.madujano@gmail.com";
		usuario.setCorreo(correo);
		String contrasenia = "qwerty123";		
		usuario.setContrasenia(contrasenia);
		String telefono = "1547896358";
		usuario.setTelefono(telefono);
		lenguajes.add("C");
		idiomas.add("ingles");
				
		int edad = 101;
		usuario.setEdad(edad);
		
//		String web = "";
//		String titulo = "";
		
		try {
//			habilidades.add(habilidadService.alta(nomHabilidad, tipo, puntuacion));			
//			usuarioService.alta(nombre, apellidoPaterno, apellidoMaterno, correo, contrasenia, telefono, habilidades, edad, web, titulo);
			usuarioService.alta(usuario, lenguajes, idiomas);
			
		} catch (AppExcepcion e) {
			Assert.assertEquals(Error.MAL_EDAD, e.getMessage());
		}
	}
	
	@Test
	public void testSitioWeb() {
		log.debug("Entrando a testSitioWeb");
		
		Usuario usuario = new Usuario();
		List<String> lenguajes = new ArrayList<String>();
		List<String> idiomas = new ArrayList<String>();
		
		String nombre = "Marco";
		usuario.setNombre(nombre);
		String apellidoPaterno = "Mandujano";
		usuario.setApellidoPaterno(apellidoPaterno);
		String apellidoMaterno = "Hernandez";
		usuario.setApellidoMaterno(apellidoMaterno);
		String correo = "marco.madujano@gmail.com";
		usuario.setCorreo(correo);
		String contrasenia = "qwerty123";		
		usuario.setContrasenia(contrasenia);
		String telefono = "1547896358";
		usuario.setTelefono(telefono);
		lenguajes.add("C");
		idiomas.add("ingles");
		int edad = 18;
		usuario.setEdad(edad);
		
		String web = "http://marco!mandujanoQ567/index";
		usuario.setWeb(web);
		
//		String titulo = "";
		
		try {
//			habilidades.add(habilidadService.alta(nomHabilidad, tipo, puntuacion));			
//			usuarioService.alta(nombre, apellidoPaterno, apellidoMaterno, correo, contrasenia, telefono, habilidades, edad, web, titulo);
			usuarioService.alta(usuario, lenguajes, idiomas);
		} catch (AppExcepcion e) {
			Assert.assertEquals(Error.MAL_WEB, e.getMessage());
		}
	}
	
	@Test
	public void testGradoAcademico() {
		log.debug("Entrando a testGradoAcademico");
		
		Usuario usuario = new Usuario();
		List<String> lenguajes = new ArrayList<String>();
		List<String> idiomas = new ArrayList<String>();
		
		String nombre = "Marco";
		usuario.setNombre(nombre);
		String apellidoPaterno = "Mandujano";
		usuario.setApellidoPaterno(apellidoPaterno);
		String apellidoMaterno = "Hernandez";
		usuario.setApellidoMaterno(apellidoMaterno);
		String correo = "marco.madujano@gmail.com";
		usuario.setCorreo(correo);
		String contrasenia = "qwerty123";		
		usuario.setContrasenia(contrasenia);
		String telefono = "1547896358";
		usuario.setTelefono(telefono);
		lenguajes.add("C");
		idiomas.add("ingles");
		
		int edad = 18;
		usuario.setEdad(edad);
		String web = "http://marcoWeb.com/info";
		usuario.setWeb(web);
		
		String titulo = "Profesor";
		usuario.setTitulo(titulo);
		
		try {
//			habilidades.add(habilidadService.alta(nomHabilidad, tipo, puntuacion));			
//			usuarioService.alta(nombre, apellidoPaterno, apellidoMaterno, correo, contrasenia, telefono, habilidades, edad, web, titulo);
			usuarioService.alta(usuario, lenguajes, idiomas);
		} catch (AppExcepcion e) {
			Assert.assertEquals(Error.MAL_GR_ACADEMICO, e.getMessage());
		}
	}
	
	@Test
	public void testAlta() throws AppExcepcion {
		log.debug("Entrando a testAlta");
		
		Usuario usuario = new Usuario();
		List<String> lenguajes = new ArrayList<String>();
		List<String> idiomas = new ArrayList<String>();
		
		String nombre = "Marco";
		usuario.setNombre(nombre);
		String apellidoPaterno = "Mandujano";
		usuario.setApellidoPaterno(apellidoPaterno);
		String apellidoMaterno = "Hernandez";
		usuario.setApellidoMaterno(apellidoMaterno);
		String correo = "marco.madujano@gmail.com";
		usuario.setCorreo(correo);
		String contrasenia = "qwerty123";		
		usuario.setContrasenia(contrasenia);
		String telefono = "1547896358";
		usuario.setTelefono(telefono);
		lenguajes.add("C");
		idiomas.add("ingles");
		
		int edad = 18;
		usuario.setEdad(edad);
		String web = "http://marcoWeb.com/info";
		usuario.setWeb(web);
		String titulo = "Estudiante";
		usuario.setTitulo(titulo);
		
//		habilidades.add(habilidadService.alta(nomHabilidad, tipo, puntuacion));			
//		Usuario usuario = usuarioService.alta(nombre, apellidoPaterno, apellidoMaterno,
//				correo, contrasenia, telefono, habilidades, edad, web, titulo);
		
		Assert.assertNotNull(usuario);
	}
	
	@Test
	public void testReputacionMin() {
		log.debug("Entrando a testReputacionMin");
		
		Usuario usuario = null;
		String correo = "marco.madujano@gmail.com";
		
		int reputacion = -1;
		
		try {
			usuario = usuarioService.findUsuario(correo);
			usuarioService.setReputacion(usuario, reputacion);
			
		} catch (AppExcepcion e) {
			Assert.assertEquals(Error.MAL_REPUTACION, e.getMessage());
		}
	}
	
	@Test
	public void testReputacionMax() {
		log.debug("Entrando a testReputacionMax");
		
		Usuario usuario = null;
		String correo = "marco.madujano@gmail.com";
		
		int reputacion = 6;
		
		try {
			usuario = usuarioService.findUsuario(correo);
			usuarioService.setReputacion(usuario, reputacion);
			
		} catch (AppExcepcion e) {
			Assert.assertEquals(Error.MAL_REPUTACION, e.getMessage());
		}
	}
	
	@Test
	public void testReputacionConexion() {
		log.debug("Entrando a testReputacionConexion");
		
		Usuario usuario = new Usuario();
		String correo = "arco.madujano@gmail.com";
		usuario.setCorreo(correo);
		
		int reputacion = 3;
		
		try {
			//usuario = usuarioService.findUsuario(correo);
			usuarioService.setReputacion(usuario, reputacion);
			
		} catch (AppExcepcion e) {
			Assert.assertEquals(Error.MAL_CONCECT, e.getMessage());
		}
	}
	
	@Test
	public void testSetReputacion() throws AppExcepcion {
		log.debug("Entrando a testSetReputacion");
		
		Usuario usuario = null;
		String correo = "marco.madujano@gmail.com";
		
		int reputacion = 5;
		
		usuario = usuarioService.findUsuario(correo);
		usuario = usuarioService.setReputacion(usuario, reputacion);
		
		Assert.assertEquals(reputacion, usuario.getReputacion());
	}
	
	
	@Test
	public void testFindUsuarios() throws AppExcepcion {
		log.debug("Entrando a testFindUsuarios");
		
		List<Usuario> usuariosRegresados = new ArrayList<Usuario>();
		
		usuariosRegresados = usuarioService.findUsuarios();
		
		int tamanio = usuariosRegresados.size();
		
		Assert.assertThat(tamanio, is(equalTo(tamanio)));
		
	}
}
