package mx.uacm.reclutaSoft.service;

import java.util.Map;

import mx.uacm.reclutaSoft.domain.Evento;
import mx.uacm.reclutaSoft.excepcion.AppExcepcion;

public interface EventoService {
	
	public Evento alta(Map <?, ?> evento) throws AppExcepcion;
	
}
