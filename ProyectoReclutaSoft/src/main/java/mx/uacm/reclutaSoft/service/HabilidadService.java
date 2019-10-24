package mx.uacm.reclutaSoft.service;

import java.util.List;

import mx.uacm.reclutaSoft.domain.Habilidad;
import mx.uacm.reclutaSoft.excepcion.AppExcepcion;

public interface HabilidadService {
	public Habilidad alta (String nombre, String tipo, int puntuacion) throws AppExcepcion;
	
	//falta hacer test
	public List<Habilidad> findHabilidadByUserName(String nombre) throws AppExcepcion;
}
