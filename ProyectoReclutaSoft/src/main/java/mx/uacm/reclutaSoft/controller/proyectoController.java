package mx.uacm.reclutaSoft.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import mx.uacm.reclutaSoft.constantes.Error;
import mx.uacm.reclutaSoft.domain.Proyecto;
import mx.uacm.reclutaSoft.domain.Usuario;
import mx.uacm.reclutaSoft.excepcion.AppExcepcion;
import mx.uacm.reclutaSoft.service.ProyectoService;
import mx.uacm.reclutaSoft.service.UsuarioService;


@Controller
@RequestMapping("/registrarProyecto")
public class proyectoController {
	
	
private final Logger log = LogManager.getLogger(proyectoController.class);
	
	@Autowired
	private ProyectoService proyectoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private HttpSession httpSession; 
	
	
//	@GetMapping("/obtenerProyectos")
//	public String obtenerProyectos() {
//		log.debug("Entrando a ProyectoController.obtenerProyectos");
//		Map <String, Object> model = new HashMap<>();
//		List<Proyecto> proyectos = new ArrayList<Proyecto>();
//		
//		try {
//			proyectos = proyectoService.findPoryectos();
//			model.put("proyectos", proyectos);
//		} catch (AppExcepcion e) {
//			model.put("error", e.getMessage());
//			return "redirect:/error";
//		}
//		
//		return "preubasMarco";
//	}
	
	
	@RequestMapping(value="/registrarProject", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
//	public Map<String, String> registrarProyecto(Map <String, Object> model, @RequestBody final Proyecto proyecto) {
	public Map<String, String> registrarProyecto(@RequestBody Map <?, ?> proyecto) {
		log.debug("Entrando a ProyectoController.registrarProyecto");
		
		
		log.debug(proyecto.get("nombre"));
		log.debug(proyecto.get("descripcion"));
		log.debug(proyecto.get("roles"));
		
		List<String> rolesTemp = new ArrayList<String>();
		
		rolesTemp = (List<String>) proyecto.get("roles");
		
		log.debug(rolesTemp.get(0));
		
		log.debug(proyecto.get("correoLider"));
		log.debug(proyecto.get("correoDesigners"));
		log.debug(proyecto.get("correoAnalyst"));
		log.debug(proyecto.get("correoDevelopers"));
		log.debug(proyecto.get("correoTester"));
		
		Map <String, String> JSON = new HashMap<String, String>();
		
		try {
			Proyecto regreso = proyectoService.alta(proyecto);
			JSON.put("exito", "exito al registrar proyecto");
		} catch (AppExcepcion e) {
			switch (e.getMessage()) {
			case Error.MAL_NOM_PROYECTO:
				JSON.put("errorAlRegistrar", "No se logro registrar tu proyecto");
				return JSON;
			
			case Error.MAL_DES_PROYECTO:
				JSON.put("errorAlRegistrar", "No se logro registrar tu proyecto");
				return JSON;
				
			case Error.MAL_ROLES:
				JSON.put("errorAlRegistrar", "No se logro registrar tu proyecto");
				return JSON;
				
			default:
				break;
			}
		}
		
		
		//return new ModelAndView("action", model);
		
		return JSON;
	}
	
//	@GetMapping("/regProyecto")
//	public String regProyecto(Map <String, Object> model) {
//		
//
//		
//	log.debug("Entrando al metodo ProyectoController.obtenerUsuarios********************************************************");
//	List<Usuario> usuarios = new ArrayList<Usuario>();
//	try {
//		usuarios = usuarioService.findUsuarios();
//		
//		model.put("usuarios", usuarios);
//	} catch (AppExcepcion e) {
//		model.put("error", e.getMessage());
//		return "redirect:/error";
//	}
//	log.debug("return en proyectoController********************************************************");
//		return "registrarProyecto";
//		
//	}
//	
//	@GetMapping("/registrar")
//	public String registrar(Map <String, Object> model, @RequestParam("pagina") String pagina) {
//		
//
//		
//	log.debug("Entrando al metodo ProyectoController.obtenerUsuarios********************************************************");
//	List<Usuario> usuarios = new ArrayList<Usuario>();
////	try {
//////		usuarios = usuarioService.findUsuarios();
////		
//////		model.put("usuarios", usuarios);
////	} catch (AppExcepcion e) {
////		model.put("error", e.getMessage());
////		return "redirect:/error";
////	}
//	
//	model.put("current", pagina);
//	String current = pagina;
//	
//	
//
//	log.debug("return en proyectoController********************************************************");
//		return "action";
//		
//	}
	

}
