package mx.uacm.reclutaSoft.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uacm.reclutaSoft.domain.Evento;
import mx.uacm.reclutaSoft.domain.Taller;
import mx.uacm.reclutaSoft.domain.Ubicacion;
import mx.uacm.reclutaSoft.excepcion.AppExcepcion;
import mx.uacm.reclutaSoft.persistence.EventoRepository;
import mx.uacm.reclutaSoft.service.EventoService;

@Service
public class EventoServiceImpl implements EventoService {
	
	private static final Logger log = LogManager.getLogger(EventoServiceImpl.class);
	
	@Autowired
	private EventoRepository eventoRepository;
	
	//public Evento alta(Evento evento, List<Taller> talleres, Ubicacion ubicacion) throws AppExcepcion {
	public Evento alta(Map <?, ?> evento) throws AppExcepcion {
		log.debug("EventoServiceImpl.alta");
		log.debug("Nombre evento: " + evento.get("nombre"));
		log.debug("Descripcion evento: " + evento.get("descripcion"));
		log.debug("Plantel evento: " + evento.get("plantel"));
		log.debug("Fecha inicio evento: " + evento.get("fechaInicio"));
		log.debug("Fecha fin evento: " + evento.get("fechaFin"));
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat formatterHour = new SimpleDateFormat("HH:mm");
		Evento eventoASalvar = new Evento();
		
		String nombreEvento = (String) evento.get("nombre");
		String descripcionEvento = (String) evento.get("descripcion");
		String plantel = (String) evento.get("plantel");
		Date fechaInicio = null;
		Date fechaFin = null;
		try {
//			fechaInicio = formatter.parse((String) evento.get("fechaInicio"));
//			fechaFin = formatter.parse((String) evento.get("fechaFin"));
			fechaInicio = Date.valueOf((String) evento.get("fechaInicio"));
			fechaFin = Date.valueOf((String) evento.get("fechaFin"));
		} catch (Exception e) {
			log.debug("Erro: " + e);
		}
		
		
		eventoASalvar.setNombreEvento(nombreEvento);
		eventoASalvar.setDescripcion(descripcionEvento);
		eventoASalvar.setPlantel(plantel);
		eventoASalvar.setFechaInicio(fechaInicio);
		eventoASalvar.setFechaFin(fechaFin);
		
		List<Map <?, ?>> talleresTemp = new ArrayList<Map <?, ?>>();
		
		talleresTemp = (List<Map <?, ?>>) evento.get("talleres");
		
		for (Map <?, ?> tallerMap : talleresTemp) {
			
			log.debug("Nombre taller: " + tallerMap.get("nombreTaller"));
			log.debug("Nombre tallerista: " + tallerMap.get("nombreTallerista"));
			log.debug("Descripcion taller: " + tallerMap.get("descripcionTaller"));
			log.debug("Fecha taller: " + tallerMap.get("fechaTaller"));
			log.debug("Hora inicio taller: " + tallerMap.get("horaInicioTaller"));
			log.debug("Hora fin taller: " + tallerMap.get("horaFinTaller"));
			log.debug("Salon taller: " + tallerMap.get("salorTaller"));
			log.debug("Descripcion de ubicacion taller: " + tallerMap.get("inputDescipcionUbicacionTaller"));
			
			Taller taller = new Taller();
			taller.setNombre((String)tallerMap.get("nombreTaller"));
			taller.setTallerista((String)tallerMap.get("nombreTallerista"));
			taller.setDescripcion((String)tallerMap.get("descripcionTaller"));
			Date fechaTaller = null;
			Time horaInicioTaller = null;
			Time horaFinTaller = null;
			try {
				//fechaTaller = formatter.parse((String) tallerMap.get("fechaTaller"));
//				horaInicioTaller = formatterHour.parse((String) tallerMap.get("horaInicioTaller"));
//				horaFinTaller = formatterHour.parse((String) tallerMap.get("horaFinTaller"));
				fechaTaller = Date.valueOf((String) tallerMap.get("fechaTaller"));
				horaInicioTaller = Time.valueOf((String) tallerMap.get("horaInicioTaller"));
				horaFinTaller = Time.valueOf((String) tallerMap.get("horaFinTaller"));
				
				
			} catch (Exception e) {
				log.debug("Erro: " + e);
			}
			taller.setFechaInicio(fechaTaller);
			taller.setHoraInicio(horaInicioTaller);
			taller.setHoraFin(horaFinTaller);
			
			Ubicacion ubicacion = new Ubicacion();
			ubicacion.setSalon((String)tallerMap.get("salorTaller"));
			ubicacion.setDescripcion((String)tallerMap.get("inputDescipcionUbicacionTaller"));
			
			taller.setUbicacion(ubicacion);
			eventoASalvar.setTaller(taller);
			
		}
		
		
		
		/*
		for (Taller taller : talleres) {
			log.debug("Taller = " + taller.getNombre());
		}
		evento.setTalleres(talleres);
		*/
		
		
		//Evento eventoSalvado = new Evento();
		Evento eventoSalvado = eventoRepository.save(eventoASalvar);
		return eventoSalvado;
	}

	public List<Evento> consultarEventos() throws AppExcepcion {
		List<Evento> eventos = new ArrayList<Evento>();
		eventos = eventoRepository.findAllEvent();
		
		log.debug(eventoRepository.findAll().toString());
		log.debug(eventos.get(0).getNombreEvento());
		/*
		int i = 0;
		for (Evento evento : eventos) {
			log.debug("evento nombre: " + evento.getNombreEvento());
			if (i == 1) {
				break;
			}
			i++;
		}
		*/
		return eventos;
		
	}
	
}
