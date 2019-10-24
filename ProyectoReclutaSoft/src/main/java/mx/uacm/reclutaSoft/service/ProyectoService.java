package mx.uacm.reclutaSoft.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import mx.uacm.reclutaSoft.domain.Proyecto;
import mx.uacm.reclutaSoft.domain.Rol;
import mx.uacm.reclutaSoft.excepcion.AppExcepcion;

public interface ProyectoService {
	
	//public Proyecto alta(String nombre, String descripcion, ArrayList<Rol> roles) throws AppExcepcion;
	
	public Proyecto alta(Map <?, ?> proyecto) throws AppExcepcion;
	
	//falta probar
//	public List<Proyecto> findPoryectos() throws AppExcepcion;
	
}
