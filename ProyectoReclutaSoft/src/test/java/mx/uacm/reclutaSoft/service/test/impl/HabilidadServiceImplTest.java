package mx.uacm.reclutaSoft.service.test.impl;

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
import mx.uacm.reclutaSoft.excepcion.AppExcepcion;
import mx.uacm.reclutaSoft.service.HabilidadService;
import mx.uacm.reclutaSoft.service.impl.HabilidadServiceImpl;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Application.class)
public class HabilidadServiceImplTest {
	private static final Logger log = LogManager.getLogger(HabilidadServiceImplTest.class);
	
	@Autowired
	private HabilidadService habilidadService;
	
//	private HabilidadService habilidadService = new HabilidadServiceImpl();
		
	@Test
	public void testNombreMin() {
		log.debug("Entrando a testNombreMin");
		
		String nombre = "";
		String tipo = "";		
		int puntuacion = 0;
				
		try {
			habilidadService.alta(nombre, tipo, puntuacion);
			
		} catch (AppExcepcion e) {
			Assert.assertEquals(Error.MAL_NOM_HABILIDAD, e.getMessage());
		}
	}
	
	@Test
	public void testNombreMax() {
		log.debug("Entrando a testNombreMax");
		
		String nombre = "a";
		
		for (int i = 0; i < Regla.LONG_MAX_HABILIDAD; i++) {
			nombre += "a";
		}
		
		String tipo = "";		
		int puntuacion = 0;
				
		try {
			habilidadService.alta(nombre, tipo, puntuacion);
			
		} catch (AppExcepcion e) {
			Assert.assertEquals(Error.MAL_NOM_HABILIDAD, e.getMessage());
		}
	}
	
	@Test
	public void testNombreCaracteres() {
		log.debug("Entrando a testNombreCaracteres");
		
		String nombre = "#$%&!";
		String tipo = "";		
		int puntuacion = 0;
				
		try {
			habilidadService.alta(nombre, tipo, puntuacion);
			
		} catch (AppExcepcion e) {
			Assert.assertEquals(Error.MAL_NOM_HABILIDAD, e.getMessage());
		}
	}
	
	@Test
	public void testTipoHabilidad() {
		log.debug("Entrando a testTipoHabilidad");
		
		String nombre = "C";
		String tipo = "Comer";		
		int puntuacion = 0;
				
		try {
			habilidadService.alta(nombre, tipo, puntuacion);
			
		} catch (AppExcepcion e) {
			Assert.assertEquals(Error.MAL_TP_HABILIDAD, e.getMessage());
		}
	}
	
	@Test
	public void testPuntosMin() {
		log.debug("Entrando a testPuntosMin");
		
		String nombre = "C";
		String tipo = "Lenguaje de programación";		
		int puntuacion = -1;
				
		try {
			habilidadService.alta(nombre, tipo, puntuacion);
			
		} catch (AppExcepcion e) {
			Assert.assertEquals(Error.MAL_PT_HABILIDAD, e.getMessage());
		}
	}
	
	@Test
	public void testPuntosMax() {
		log.debug("Entrando a testPuntosMax");
		
		String nombre = "C";
		String tipo = "Lenguaje de programación";		
		int puntuacion = 6;
				
		try {
			habilidadService.alta(nombre, tipo, puntuacion);
			
		} catch (AppExcepcion e) {
			Assert.assertEquals(Error.MAL_PT_HABILIDAD, e.getMessage());
		}
	}
	
	@Test
	public void testAlta() throws AppExcepcion {
		log.debug("Entrando a testAlta");
		
		String nombre = "C";
		String tipo = "Lenguaje de programación";		
		int puntuacion = 5;
				
		Habilidad habilidad = habilidadService.alta(nombre, tipo, puntuacion);
		
		Assert.assertNotNull(habilidad);
	}
}
