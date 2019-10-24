package mx.uacm.reclutaSoft.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uacm.reclutaSoft.constantes.Error;
import mx.uacm.reclutaSoft.constantes.Regla;
import mx.uacm.reclutaSoft.domain.Habilidad;
import mx.uacm.reclutaSoft.excepcion.AppExcepcion;
import mx.uacm.reclutaSoft.persistence.HabilidadRepository;
import mx.uacm.reclutaSoft.service.HabilidadService;

@Service
public class HabilidadServiceImpl implements HabilidadService {

	private static final Logger log = LogManager.getLogger(HabilidadServiceImpl.class);
	
	@Autowired
	private HabilidadRepository habilidadRepository;
	
	public Habilidad alta (String nombre, String tipo, int puntuacion) throws AppExcepcion {
		log.debug("Entrando a alta");
		
		Habilidad habilidad = null;
		
		if (!(nombre.matches(Regla.REGEX_NOM_HABILIDAD))) {
			throw new AppExcepcion(Error.MAL_NOM_HABILIDAD, Error.NO_LET_ESP_NUM);
		}
		
		if (nombre.length() < Regla.LONG_MIN_HABILIDAD || nombre.length() > Regla.LONG_MAX_HABILIDAD) {
			throw new AppExcepcion(Error.MAL_NOM_HABILIDAD, Error.NO_LONGITUD);
		}
		
		if (!Regla.TIPO_HABILIDAD.contains(tipo)) {
			throw new AppExcepcion(Error.MAL_TP_HABILIDAD, Error.NO_ENCONTRADO);
		}
		
		if (puntuacion < Regla.MIN_PUNTUACION || puntuacion > Regla.MAX_PUNTUACION) {
			throw new AppExcepcion(Error.MAL_PT_HABILIDAD, Error.NO_RANGO);
		}
		
		habilidad = new Habilidad();
		habilidad.setNombre(nombre);
		habilidad.setTipo(tipo);
		habilidad.setPuntuacion(puntuacion);
		//habilidadRepository.save(habilidad);
		
		return habilidad;
	}
	
	
	//falta hacer test
	public List<Habilidad> findHabilidadByUserName(String nombre) throws AppExcepcion {
		log.debug("Entrando a UsuarioServiceImpl.findHabilidadByUserName");
			
		if (!(nombre.matches(Regla.REGEX_NOMBRE))) {
			throw new AppExcepcion(Error.MAL_NOMBRE, Error.NO_LETRAS_ESPACIOS);
		}
		
		List<Habilidad> habilidades = new ArrayList<Habilidad>();
		
		habilidades = habilidadRepository.findHabilidadesByUserName(nombre);
				
		return habilidades;
	}
	
	
}
