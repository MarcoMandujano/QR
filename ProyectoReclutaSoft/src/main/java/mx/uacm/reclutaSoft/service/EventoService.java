package mx.uacm.reclutaSoft.service;

import java.util.List;
import java.util.Map;

import mx.uacm.reclutaSoft.domain.Evento;
import mx.uacm.reclutaSoft.domain.Taller;
import mx.uacm.reclutaSoft.domain.Ubicacion;
import mx.uacm.reclutaSoft.excepcion.AppExcepcion;

public interface EventoService {
	
	//public Evento alta(Evento evento, List<Taller> talleres, Ubicacion ubicacion) throws AppExcepcion;
	public Evento alta(Map <?, ?> evento) throws AppExcepcion;
}
