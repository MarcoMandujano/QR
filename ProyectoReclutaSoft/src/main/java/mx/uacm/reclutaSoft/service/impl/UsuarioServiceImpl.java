package mx.uacm.reclutaSoft.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uacm.reclutaSoft.constantes.Regla;
import mx.uacm.reclutaSoft.constantes.Error;
import mx.uacm.reclutaSoft.domain.Habilidad;
import mx.uacm.reclutaSoft.domain.Proyecto;
import mx.uacm.reclutaSoft.domain.Usuario;
import mx.uacm.reclutaSoft.excepcion.AppExcepcion;
import mx.uacm.reclutaSoft.persistence.UsuarioRepository;
import mx.uacm.reclutaSoft.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	private static final Logger log = LogManager.getLogger(UsuarioServiceImpl.class);
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
//	public Usuario alta(String nombre, String apellidoPaterno, String apellidoMaterno, String correo, String contrasenia, 
//			String telefono, List<Habilidad> habilidades, int edad, String web, String titulo) throws AppExcepcion {
	public Usuario alta(Usuario usuario, List<String> lenguajes, List<String> idiomas) throws AppExcepcion {	
	
		log.debug("Entrando a UsuarioServiceImpl.alta");
			
		
		List<Habilidad> habilidadesTemp = new ArrayList<Habilidad>();
		
		for (String lenguaje : lenguajes) {
			log.debug("lenguaje = " + lenguaje);
			Habilidad habilidad = new Habilidad();
			habilidad.setTipo("Lenguaje de programacion");
			habilidad.setNombre(lenguaje);
			habilidad.setPuntuacion(0);
			habilidadesTemp.add(habilidad);
		}
		
		for (String idioma : idiomas) {
			log.debug("idioma = " + idioma);
			Habilidad habilidad = new Habilidad();
			habilidad.setTipo("Idioma");
			habilidad.setNombre(idioma);
			habilidad.setPuntuacion(0);
			habilidadesTemp.add(habilidad);
		}
		usuario.setHabilidades(habilidadesTemp);
//		usuario.setRol(null);		
		
//		Usuario usuario = null;
		
		if (!(usuario.getNombre().matches(Regla.REGEX_NOMBRE))) {
			throw new AppExcepcion(Error.MAL_NOMBRE, Error.NO_LETRAS_ESPACIOS);
		}
		
		if (usuario.getNombre().length() < Regla.LONG_MIN_NOMBRE || usuario.getNombre().length() > Regla.LONG_MAX_NOMBRE) {
			throw new AppExcepcion(Error.MAL_NOMBRE, Error.NO_LONGITUD);
		}
		
		if (!(usuario.getApellidoPaterno().matches(Regla.REGEX_AP_PATERNO))) {
			throw new AppExcepcion(Error.MAL_AP_PATERNO, Error.NO_LETRAS);
		}
		
		if (usuario.getApellidoPaterno().length() < Regla.LONG_MIN_PATERNO || usuario.getApellidoPaterno().length() > Regla.LONG_MAX_PATERNO) {
			throw new AppExcepcion(Error.MAL_AP_PATERNO, Error.NO_LONGITUD);
		}
		
		if (!(usuario.getApellidoMaterno().matches(Regla.REGEX_AP_MATERNO))) {
			throw new AppExcepcion(Error.MAL_AP_MATERNO, Error.NO_LETRAS);
		}
		
		if (usuario.getApellidoMaterno().length() < Regla.LONG_MIN_MATERNO || usuario.getApellidoMaterno().length() > Regla.LONG_MAX_MATERNO) {
			throw new AppExcepcion(Error.MAL_AP_MATERNO, Error.NO_LONGITUD);
		}
		
		if (!(usuario.getCorreo().matches(Regla.REGEX_CORREO))) {
			throw new AppExcepcion(Error.MAL_CORREO, Error.NO_CORREO);
		}
		
		if (usuario.getContrasenia().length() < Regla.LONG_MIN_CONTRASENIA || usuario.getContrasenia().length() > Regla.LONG_MAX_CONTRASENIA) {
			throw new AppExcepcion(Error.MAL_CONTRASENIA, Error.NO_LONGITUD);
		}
		
		if (!(usuario.getTelefono().matches(Regla.REGEX_TELEFONO))) {
			throw new AppExcepcion(Error.MAL_TELEFONO, Error.NO_NUMEROS);
		}
		
		if (usuario.getTelefono().length() != Regla.LONG_TELEFONO) {
			throw new AppExcepcion(Error.MAL_TELEFONO, Error.NO_LONGITUD);
		}
		
		if (usuario.getHabilidades().isEmpty()) {
			throw new AppExcepcion(Error.MAL_HABILIDADES, Error.NO_NULL);
		}
		
		if (usuario.getEdad() < Regla.MIN_EDAD || usuario.getEdad() > Regla.MAX_EDAD) {
			throw new AppExcepcion(Error.MAL_EDAD, Error.NO_RANGO);
		}
		
		if (!(usuario.getWeb().matches(Regla.REGEX_WEB))) {
			throw new AppExcepcion(Error.MAL_WEB, Error.NO_WEB);
		}
		
		if (!Regla.GRADO_ACADEMICO.contains(usuario.getTitulo())) {
			throw new AppExcepcion(Error.MAL_GR_ACADEMICO, Error.NO_ENCONTRADO);
		}
		
//		usuario = new Usuario();
//		usuario.setNombre(nombre);
//		usuario.setApellidoPaterno(apellidoPaterno);
//		usuario.setApellidoMaterno(apellidoMaterno);
//		usuario.setCorreo(correo);
//		usuario.setContrasenia(contrasenia);
//		usuario.setTelefono(telefono);
//		usuario.setHabilidades(habilidades);
//		usuario.setEdad(edad);
//		usuario.setWeb(web);
//		usuario.setTitulo(titulo);
		
		Usuario usuarioSalvado = usuarioRepository.save(usuario);		
		return usuarioSalvado;
	}
	
	public Usuario setReputacion(Usuario usuario, int reputacion) throws AppExcepcion {	
		log.debug("Entrando a setReputacion");
				
		if (reputacion < Regla.MIN_REPUTACION || reputacion > Regla.MAX_REPUTACION) {
			throw new AppExcepcion(Error.MAL_REPUTACION, Error.NO_RANGO);
		}
		
		String email = usuario.getCorreo();
		int columnasAfectadas = 0;
		
		
		
		log.debug(email);
		log.debug("EL update Regreso************************************************************************");
		try {
			columnasAfectadas = usuarioRepository.updateReputacionToUserByEmail(email, reputacion);
			log.debug(columnasAfectadas);
			if (columnasAfectadas == 0) {
				throw new AppExcepcion(Error.MAL_CONCECT, Error.MAL_CONCECT);
			} 
			usuario.setReputacion(reputacion);
			
		} catch (Exception e) {
			
		}
		
		
		
		//usuario.setReputacion(reputacion);
		return usuario;
	}
	
	public Usuario setPartcicipacion(Usuario usuario, Proyecto proyecto) throws AppExcepcion {
		log.debug("Entrando a setPartcicipacion");
		
		return usuario;
	}
	
	public Usuario findUsuario(String correo) throws AppExcepcion {
		log.debug("Entrando a findUsuario");
		
		if (!(correo.matches(Regla.REGEX_CORREO))) {
			throw new AppExcepcion(Error.MAL_CORREO, Error.NO_CORREO);
		}
		
		Usuario usuario = usuarioRepository.findByEmail(correo);
		
		return usuario;
	}
	
	//falta hacer test
	public Usuario findByEmailAndPassword(String correo, String contrasenia) throws AppExcepcion {
		log.debug("Entrando a UsuarioServiceImpl.findByEmailAndPassword");
		
		if (!(correo.matches(Regla.REGEX_CORREO))) {
			throw new AppExcepcion(Error.MAL_CORREO, Error.NO_CORREO);
		}
		
		if (contrasenia.length() < Regla.LONG_MIN_CONTRASENIA || contrasenia.length() > Regla.LONG_MAX_CONTRASENIA) {
			
			throw new AppExcepcion(Error.MAL_CONTRASENIA, Error.NO_LONGITUD);
		}
		
		Usuario usuario = new Usuario();
		
		usuario = usuarioRepository.findByEmailAndPassword(correo, contrasenia);
		
				
		return usuario;
	}
	
	//falta hacer test
	public List<Usuario> findUsuarios() throws AppExcepcion {
		log.debug("Entrando a UsuarioServiceImpl.findUsuarios");
		
//		List<Usuario> usuarios = Lists.newArrayList(usuarioRepository.findAll());
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios = usuarioRepository.findAllUsers();
		
		return usuarios;
	}
	
	//falta hacer test
//	public List<Usuario> findUsersByHabilidadTipoAndNombre(String tipo, String nombreHabilidad) throws AppExcepcion {
//		log.debug("Entrando a UsuarioServiceImpl.findUsersByHabilidadTipoAndNombre");
//		
//		if (!(nombreHabilidad.matches(Regla.REGEX_NOM_HABILIDAD))) {
//			throw new AppExcepcion(Error.MAL_NOM_HABILIDAD, Error.NO_LET_ESP_NUM);
//		}
//		
//		if (nombreHabilidad.length() < Regla.LONG_MIN_HABILIDAD || nombreHabilidad.length() > Regla.LONG_MAX_HABILIDAD) {
//			throw new AppExcepcion(Error.MAL_NOM_HABILIDAD, Error.NO_LONGITUD);
//		}
//		
//		if (!Regla.TIPO_HABILIDAD.contains(tipo)) {
//			throw new AppExcepcion(Error.MAL_TP_HABILIDAD, Error.NO_ENCONTRADO);
//		}
//		
//		List<Usuario> usuarios = new ArrayList<Usuario>();
//		
//		usuarios = usuarioRepository.findUsersByHabilidadTipoAndNombre(tipo, nombreHabilidad);
//		
//		return usuarios;
//	}
}
