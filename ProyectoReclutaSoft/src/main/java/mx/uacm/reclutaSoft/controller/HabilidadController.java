package mx.uacm.reclutaSoft.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mx.uacm.reclutaSoft.constantes.Error;
import mx.uacm.reclutaSoft.domain.Habilidad;
import mx.uacm.reclutaSoft.service.HabilidadService;

@Controller
@RequestMapping("/habilidadController")
public class HabilidadController {
	private final Logger log = LogManager.getLogger(HabilidadController.class);
	
	@Autowired
	private HabilidadService habilidadService;
	
//	@GetMapping("/obtenerHabilidades")
//	public String buscarHabilidadesPorNombreDeUsuario(Map <String, Object> model,
//			                                          @RequestParam("nombre") String nombre) {
//		log.debug("Entrando al metodo HabilidadController.buscarHabilidadesPorNombreDeUsuario");
//		
//		List<Habilidad> habilidades = new ArrayList<Habilidad>();
//		
//		try {
//			habilidades = habilidadService.findHabilidadByUserName(nombre);
//			
//		} catch (Exception e) {
//			switch (e.getMessage()) {
//			case Error.MAL_NOMBRE:
//				log.debug("Error MAL_NOMBRE");
//				model.put("error", Error.MAL_NOMBRE);
//				return "redirect:/error";
//				
//			default:
//				break;
//			}
//		}
//		
//		return "pruebasMarco";
//	}
	
}
