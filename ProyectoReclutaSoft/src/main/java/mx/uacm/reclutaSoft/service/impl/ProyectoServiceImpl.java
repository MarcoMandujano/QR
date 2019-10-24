package mx.uacm.reclutaSoft.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uacm.reclutaSoft.constantes.Regla;
import mx.uacm.reclutaSoft.constantes.Error;
import mx.uacm.reclutaSoft.domain.Proyecto;
import mx.uacm.reclutaSoft.domain.Rol;
import mx.uacm.reclutaSoft.domain.Usuario;
import mx.uacm.reclutaSoft.excepcion.AppExcepcion;
import mx.uacm.reclutaSoft.persistence.ProyectoRepository;
import mx.uacm.reclutaSoft.persistence.UsuarioRepository;
import mx.uacm.reclutaSoft.service.ProyectoService;

@Service
public class ProyectoServiceImpl implements ProyectoService {
	
	private static final Logger log = LogManager.getLogger(ProyectoServiceImpl.class);
	
	@Autowired
	private ProyectoRepository proyectoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
//	public Proyecto alta(String nombre, String descripcion, ArrayList<Rol> roles) throws AppExcepcion {
	public Proyecto alta(Map <?, ?> proyecto) throws AppExcepcion {
	
		log.debug("Entrando a ProyectoServiceImpl.alta");
		
		Proyecto project = new Proyecto();
		
		String nombre = (String) proyecto.get("nombre");
		String descripcion = (String) proyecto.get("descripcion");
		
		List<String> rolesTemp = new ArrayList<String>();
		
		rolesTemp = (List<String>) proyecto.get("roles");
		
//		if (proyecto.containsKey("")) {
//			
//		}
		List<Usuario> usuariosEnRoles = new ArrayList<Usuario>();
		
		String emailLider = (String) proyecto.get("correoLider");
		Usuario usuarioLider = usuarioRepository.findByEmail(emailLider);
		usuariosEnRoles.add(usuarioLider);
		
		String emailDevelopers = (String) proyecto.get("correoDevelopers");
		Usuario usuarioDeveloper = usuarioRepository.findByEmail(emailDevelopers);
		usuariosEnRoles.add(usuarioDeveloper);
		
		String emailDesigners = (String) proyecto.get("correoDesigners");
		Usuario usuarioDesigner = usuarioRepository.findByEmail(emailDesigners);
		usuariosEnRoles.add(usuarioDesigner);
		
		String emailAnalyst = (String) proyecto.get("correoAnalyst");
		Usuario usuarioAnalyst = usuarioRepository.findByEmail(emailAnalyst);
		usuariosEnRoles.add(usuarioAnalyst);
		
		String emailTester = (String) proyecto.get("correoTester");
		Usuario usuarioTester = usuarioRepository.findByEmail(emailTester);
		usuariosEnRoles.add(usuarioTester);
		 
		String emailDuenio = (String) proyecto.get("correoDuenio");
		Usuario usuarioDuenio = usuarioRepository.findByEmail(emailDuenio);
		
		for (int i = 0; i < usuariosEnRoles.size(); i++) {
			log.debug(usuariosEnRoles.get(i));
		}
		
//		ArrayList<Rol> roles = new ArrayList<Rol>();
		int i = 0;
		for (String rolString : rolesTemp) {
			Rol rol = new Rol();
			rol.setNombre(rolString);
//			log.debug(rolString);
			rol.setUsuario(usuariosEnRoles.get(i));
			project.setRol(rol);
//			roles.add(rol);
			i++;
		}
		
		
		
		project.setUsuario(usuarioDuenio);
		project.setNombre(nombre);
		project.setDescripcion(descripcion);
//		project.setRoles(roles);
		
		
		
		
		
		
		
//		Proyecto proyecto = null;
				
		if (project.getNombre().length() < Regla.MIN_NOM_PROYECTO || project.getNombre().length() > Regla.MAX_NOM_PROYECTO) {
			throw new AppExcepcion(Error.MAL_NOM_PROYECTO, Error.NO_LONGITUD);
		}
		
		if (project.getDescripcion().length() < Regla.MIN_DES_PROYECTO || project.getDescripcion().length() > Regla.MAX_DES_PROYECTO) {
			throw new AppExcepcion(Error.MAL_DES_PROYECTO, Error.NO_LONGITUD);
		}
				
		if (project.getRoles().isEmpty()) {
			throw new AppExcepcion(Error.MAL_ROLES, Error.NO_NULL);
		}
				
//		proyecto = new Proyecto();
//		proyecto.setNombre(nombre);
//		proyecto.setDescripcion(descripcion);
//		proyecto.setRoles(roles);
				
		proyectoRepository.save(project);		
		return project;
	}	
	
	
	//falta probar
//	public List<Proyecto> findPoryectos() throws AppExcepcion {
//		log.debug("Entrando a ProyectoServiceImpl.findPoryectos");
//		
//		List<Proyecto> proyectos = new ArrayList<Proyecto>();
//		
//		proyectos = proyectoRepository.findAllProjects();
//		
//		return proyectos;
//	}
}
