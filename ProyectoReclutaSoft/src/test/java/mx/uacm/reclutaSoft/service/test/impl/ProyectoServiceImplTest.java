package mx.uacm.reclutaSoft.service.test.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import mx.uacm.reclutaSoft.domain.Proyecto;
import mx.uacm.reclutaSoft.domain.Rol;
import mx.uacm.reclutaSoft.excepcion.AppExcepcion;
import mx.uacm.reclutaSoft.service.ProyectoService;
import mx.uacm.reclutaSoft.service.impl.ProyectoServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Application.class)
public class ProyectoServiceImplTest {
	private static final Logger log = LogManager.getLogger(ProyectoServiceImplTest.class);
	
	@Autowired
	private ProyectoService proyectoService;
	
//	private ProyectoService proyectoService = new ProyectoServiceImpl();
		
//	@Test
//	public void testfindPoryectos() throws AppExcepcion {
//		log.debug("Entrando a testfindPoryectos");
//		
//		List<Proyecto> proyectos = new ArrayList<Proyecto>();
//		
//		proyectos = proyectoService.findPoryectos();
//		
//		int tamanio = proyectos.size();
//		Assert.assertThat(tamanio, is(equalTo(tamanio)));
//	}
	
	
	@Test
	public void testNombreMin() {
		log.debug("Entrando a testNombreMin");
		
		Map<Object, Object> JSON = new HashMap<Object, Object>();
		
		String nombre = "";
		String descripcion = "";
		List<Rol> roles = new ArrayList<Rol>();
		
		JSON.put("nombre", nombre);
		JSON.put("descripcion", descripcion);
		JSON.put("roles", roles);
				
		try {
			proyectoService.alta(JSON);
			
		} catch (AppExcepcion e) {
			Assert.assertEquals(Error.MAL_NOM_PROYECTO, e.getMessage());
		}
	}
	
	@Test
	public void testNombreMax() {
		log.debug("Entrando a testNombreMax");
		
		Map<Object, Object> JSON = new HashMap<Object, Object>();
		
		String nombre = "a";
		
		for (int i = 0; i < Regla.MAX_NOM_PROYECTO; i++) {
			nombre += "a";
		}
		
		String descripcion = "";
		List<Rol> roles = new ArrayList<Rol>();
		
		JSON.put("nombre", nombre);
		JSON.put("descripcion", descripcion);
		JSON.put("roles", roles);
				
		try {
			proyectoService.alta(JSON);
			
		} catch (AppExcepcion e) {
			Assert.assertEquals(Error.MAL_NOM_PROYECTO, e.getMessage());
		}
	}
		
	@Test
	public void testDescripcionMin() {
		log.debug("Entrando a testDescripcionMin");
		Map<Object, Object> JSON = new HashMap<Object, Object>();

		String nombre = "Proyecto Alcancia Digital";
		String descripcion = "";
		List<Rol> roles = new ArrayList<Rol>();
		
		JSON.put("nombre", nombre);
		JSON.put("descripcion", descripcion);
		JSON.put("roles", roles);
		try {
			proyectoService.alta(JSON);
			
		} catch (AppExcepcion e) {
			Assert.assertEquals(Error.MAL_DES_PROYECTO, e.getMessage());
		}
	}
	
	@Test
	public void testDescripcionMax() {
		log.debug("Entrando a testDescripcionMax");
		Map<Object, Object> JSON = new HashMap<Object, Object>();
		
		String nombre = "Proyecto Alcancia Digital";
		String descripcion = "a";
		
		for (int i = 0; i < Regla.MAX_DES_PROYECTO; i++) {
			descripcion += "a";
		}
		
		List<Rol> roles = new ArrayList<Rol>();
		
		JSON.put("nombre", nombre);
		JSON.put("descripcion", descripcion);
		JSON.put("roles", roles);
				
		try {
			proyectoService.alta(JSON);
			
		} catch (AppExcepcion e) {
			Assert.assertEquals(Error.MAL_DES_PROYECTO, e.getMessage());
		}
	}
	
	@Test
	public void testRoles() {
		log.debug("Entrando a testRoles");
		Map<Object, Object> JSON = new HashMap<Object, Object>();
		
		String nombre = "Proyecto Alcancia Digital";
		String descripcion = "Proyecto #1 de la historia";		
		List<Rol> roles = new ArrayList<Rol>();
		
		JSON.put("nombre", nombre);
		JSON.put("descripcion", descripcion);
		JSON.put("roles", roles);
				
		try {
			proyectoService.alta(JSON);
			
		} catch (AppExcepcion e) {
			Assert.assertEquals(Error.MAL_ROLES, e.getMessage());
		}
	}
	
	@Test
	public void testAlta() throws AppExcepcion {
		log.debug("Entrando a testAlta");
		Map<Object, Object> JSON = new HashMap<Object, Object>();
		
		String nombre = "Proyecto Alcancia Digital";
		String descripcion = "Proyecto #1 de la historia";
		
		List<String> roles = new ArrayList<String>();
//		Rol rol = new Rol();
//		rol.setNombre("Programador");
//		
//		roles.add(rol);
		
		roles.add("lider");
		roles.add("programador");
		roles.add("deseniador");
		roles.add("analista");
		roles.add("tester");
		
		
		JSON.put("nombre", nombre);
		JSON.put("descripcion", descripcion);
		JSON.put("roles", roles);
		
		
		Proyecto proyecto =	proyectoService.alta(JSON);
		
		Assert.assertNotNull(proyecto);
	}
}
