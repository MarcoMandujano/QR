package mx.uacm.reclutaSoft.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mx.uacm.reclutaSoft.constantes.Error;
import mx.uacm.reclutaSoft.domain.Habilidad;
import mx.uacm.reclutaSoft.domain.Usuario;
import mx.uacm.reclutaSoft.excepcion.AppExcepcion;
import mx.uacm.reclutaSoft.service.UsuarioService;

@Controller
@RequestMapping("/usuarioController")
public class UsuarioController {
	private final Logger log = LogManager.getLogger(UsuarioController.class);
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private HttpSession httpSession; 
	
	@PostMapping("/registrarUsuario")
	public String registrarUsuario(Map <String, Object> model, Usuario usuario,
			                       @RequestParam("lenguaje") List<String>lenguajes,
			                       @RequestParam("idioma") List<String>idiomas) {
		log.debug("Entrando al metodo UsuarioController.registrarUsuario");
	
		
		Usuario usuarioRegresado = new Usuario();
		
		try {
			usuarioRegresado = usuarioService.alta(usuario, lenguajes, idiomas);
		} catch (AppExcepcion e) {
//			String excepcion = e.getMessage();
			switch (e.getMessage()) {
			case Error.MAL_NOMBRE:
				log.debug("Error MAL_NOMBRE");
				model.put("error", Error.MAL_NOMBRE);
				return "redirect:/error";
				
			case Error.MAL_AP_PATERNO:
				log.debug("Error MAL_AP_PATERNO");
				model.put("error", Error.MAL_AP_PATERNO);
				return "redirect:/error";
				
			case Error.MAL_AP_MATERNO:
				log.debug("Error MAL_AP_MATERNO");
				model.put("error", Error.MAL_AP_MATERNO);
				return "redirect:/error";
			
			case Error.MAL_CORREO:
				log.debug("Error MAL_CORREO");
				model.put("error", Error.MAL_CORREO);
				return "redirect:/error";
				
			case Error.MAL_CONTRASENIA:
				log.debug("Error MAL_CONTRASENIA");
				model.put("error", Error.MAL_CONTRASENIA);
				return "redirect:/error";
				
			case Error.MAL_TELEFONO:
				log.debug("Error MAL_TELEFONO");
				model.put("error", Error.MAL_TELEFONO);
				return "redirect:/error";
				
			case Error.MAL_HABILIDADES:
				log.debug("Error MAL_HABILIDADES");
				model.put("error", Error.MAL_HABILIDADES);
				return "redirect:/error";
			
			case Error.MAL_EDAD:
				log.debug("Error MAL_EDAD");
				model.put("error", Error.MAL_EDAD);
				return "redirect:/error";
				
			case Error.MAL_WEB:
				log.debug("Error MAL_WEB");
				model.put("error", Error.MAL_WEB);
				return "redirect:/error";	
			
			case Error.MAL_GR_ACADEMICO:
				log.debug("Error MAL_GR_ACADEMICO");
				model.put("error", Error.MAL_GR_ACADEMICO);
				return "redirect:/error";
				
			default:
				break;
			}
		}
		model.put("enviado", usuarioRegresado);
		return "redirect:/perfil";
	}
	
//	@PostMapping("/login")
//	public ModelAndView login(Map <String, Object> model, Usuario usuario) {
//		log.debug("Entrando al metodo UsuarioController.login");
//		String correo = usuario.getCorreo();
//		String contrasenia = usuario.getContrasenia();
//		
//		Usuario usuarioRegresado = new Usuario();
//		
//		List<Usuario> usuarios = new ArrayList<Usuario>();
//		
//		try {
//			usuarioRegresado = usuarioService.findByEmailAndPassword(correo, contrasenia);
//			
////			log.debug(usuarioRegresado.getCorreo());
//			usuarios = usuarioService.findUsuarios();
//			
//			if (usuarioRegresado != null) {
//				log.debug("entro a usuario regresado");
//				httpSession.setAttribute("userLoggedIn", usuarioRegresado);
//				
//				model.put("exitoso", "Login exitoso");
//				model.put("usuarios", usuarios);
////				model.setViewName("redirect:/action");
//				
//				
//			} else {
//				model.put("error", "Error en el correo de usuario o en la contrasenia");
//				return new ModelAndView("redirect:/", model);
//				
//				//return "redirect:/error";
//			}
//		} catch (Exception e) {
//			switch (e.getMessage()) {
//			case Error.MAL_CORREO:
//				model.put("error", Error.MAL_CORREO);
//				return new ModelAndView("redirect:/", model);
////				break;
////				return "redirect:/error";
//				
//			case Error.MAL_CONTRASENIA:
//				
//				model.put("error", Error.MAL_CONTRASENIA);
//				return new ModelAndView("redirect:/", model);
////				break;
////				return "redirect:/error";
//
//			default:
//				break;
//			}
//		}
//		return new ModelAndView("action", model);
//		//return new ModelAndView("redirect:/action", model);
//		//return model;
//	}
	

	@PostMapping("/login")
	public ModelAndView login(Map <String, Object> model, Usuario usuario) {
		log.debug("Entrando al metodo UsuarioController.login");
		String correo = usuario.getCorreo();
		String contrasenia = usuario.getContrasenia();
		
		Usuario usuarioRegresado = new Usuario();
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		try {
			usuarioRegresado = usuarioService.findByEmailAndPassword(correo, contrasenia);
			
			usuarios = usuarioService.findUsuarios();
			
			if (usuarioRegresado != null) {
				log.debug("entro a usuario regresado");
				//log.debug(usuarioRegresado.getHabilidades().get(0));
				httpSession.setAttribute("userLoggedIn", usuarioRegresado);
				model.put("nombreUsuario", usuarioRegresado.getNombre());
				model.put("correoUsuario", usuarioRegresado.getCorreo());
				model.put("apellidoPaternoUsuario",usuarioRegresado.getApellidoPaterno());
				model.put("apellidoMaternoUsuario",usuarioRegresado.getApellidoMaterno());
				model.put("tituloUsuario",usuarioRegresado.getTitulo());
				model.put("webSiteUsuario",usuarioRegresado.getWeb());
				model.put("reputacionUsuario",usuarioRegresado.getReputacion());
				model.put("habilidadesUsuario",usuarioRegresado.getHabilidades());
				model.put("exitoso", "Login exitoso");
				model.put("usuarios", usuarios);
				
				
			} else {
				model.put("error", "Error en el correo de usuario o en la contrasenia");
				return new ModelAndView("redirect:/", model);
			}
		} catch (Exception e) {
			switch (e.getMessage()) {
			case Error.MAL_CORREO:
				model.put("error", Error.MAL_CORREO);
				return new ModelAndView("redirect:/", model);
				
			case Error.MAL_CONTRASENIA:
				
				model.put("error", Error.MAL_CONTRASENIA);
				return new ModelAndView("redirect:/", model);

			default:
				break;
			}
		}
		return new ModelAndView("action", model);
	}
	
	
	
	
	
	
	
	
	
	
//	@GetMapping("/obtenerUsuarios")
//	public ModelAndView obtenerUsuarios(Map <String, Object> model) {
//		
//		log.debug("Entrando al metodo UsuarioController.obtenerUsuarios********************************************************");
//		List<Usuario> usuarios = new ArrayList<Usuario>();
//		try {
//			usuarios = usuarioService.findUsuarios();
//			
//			
////			for (Usuario usuario : usuarios) {
////				log.debug(usuario.getCorreo());
////			}
//			
//			model.put("usuarios", usuarios);
//		} catch (AppExcepcion e) {
//			model.put("error", e.getMessage());
////			return "redirect:/error";
//		}
//		
//		
//		return new ModelAndView("redirect:/action", model);
//	}
//	
//	@GetMapping("/obtenerUsuariosDos")
//	public String obtenerUsuariosDos(Model model) {
//		log.debug("Entrando al metodo UsuarioController.obtenerUsuarios2********************************************************");
//		
//		List<Usuario> usuarios = new ArrayList<Usuario>();
//		
//		try {
//			
//			
//			model.addAttribute("usuarios", usuarioService.findUsuarios());
//		} catch (AppExcepcion e) {
//			
//			return "usuarios";
//		}
//		
//		
//		return null;
//	}
	
	
//	@GetMapping("/obtenerUsuariosPorNombreYTipoDeHabilidad")
//	public String obtenerUsuariosPorNombreYTipoDeHabilidad(Map <String, Object> model, 
//														   @RequestParam("tipo") String tipo, 
//														   @RequestParam("nombre") String nombre) {
//		log.debug("Entrando al metodo UsuarioController.obtenerUsuariosPorNombreYTipoDeHabilidad");
//			
//		List<Usuario> usuarios = new ArrayList<Usuario>();
//		
//		try {
//			usuarios = usuarioService.findUsersByHabilidadTipoAndNombre(tipo, nombre);
//			
//			model.put("usuarios", usuarios);
//		} catch (AppExcepcion e) {
//			
//			switch (e.getMessage()) {
//			case Error.MAL_NOM_HABILIDAD:
//				log.debug("Error MAL_NOM_HABILIDAD");
//				model.put("error", Error.MAL_NOM_HABILIDAD);
//				return "redirect:/error";
//				
//			case Error.MAL_TP_HABILIDAD:
//				log.debug("Error MAL_TP_HABILIDAD");
//				model.put("error", Error.MAL_TP_HABILIDAD);
//				return "redirect:/error";
//				
//			default:
//				break;
//			}
//		}
//		
//		return "pruebasMarco";
//	
//	}
	
	
	
	
	
}
