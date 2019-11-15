package mx.uacm.reclutaSoft.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import mx.uacm.reclutaSoft.domain.Evento;
import mx.uacm.reclutaSoft.domain.Taller;
import mx.uacm.reclutaSoft.domain.Ubicacion;
import mx.uacm.reclutaSoft.service.EventoService;

@Controller
@RequestMapping("/eventoController")
public class EventoController {
	private final Logger log = LogManager.getLogger(UsuarioController.class);
	
	@Autowired
	private EventoService eventoService;
	
	//@PostMapping("/registrarEvento")
	@RequestMapping(value="/registrarEvento", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	/*public String registrarEvento(Map <String, Object> model, Evento evento
								, @RequestParam("talleres")List<Taller> talleres
								, Ubicacion ubicacion) {*/
	public Map<String, String> registrarEvento(@RequestBody Map <?, ?> evento) {
		log.debug("eventoController.registrarEvento");
		
		//log.debug("Nombre evento: " + evento.get("nombre"));
		
		Map <String, String> JSON = new HashMap<String, String>();
		try {
			Evento eventoRegresado = new Evento();
			//eventoRegresado = eventoService.alta(evento, talleres, ubicacion);
			eventoRegresado = eventoService.alta(evento);
			JSON.put("exito", "exito al registrar proyecto");
		} catch (Exception e) {
			log.debug("Error al registrar evento." + e);
		}
		//model.put("enviado", eventoRegresado);
		//return "redirect:/index1";
		//return "registrado";
		return JSON;
	}
	
	@RequestMapping(value="/listarEventos", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Map<String, String> listarEventos() {
		log.debug("eventoController.listarEventos");
		Map <String, String> JSON = new HashMap<String, String>();
		
		List<Evento> eventos;
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			
			
			
			JSON.put("exito", "se logro aaaaaa");
			eventos = eventoService.consultarEventos();
			
			String string = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(eventos);
			log.debug(string);
					
			JSON.put("eventos", string);
			/*
			Map<String, Object> map = new HashMap<String, Object>();
			
			for (Map.Entry<String, Object > entry : map.entrySet()) {
				if (entry.getValue() instanceof String) {
					JSON.put(entry.getKey(), (String) entry.getValue());
				}
			}
			JSON.put("datos", JSON.toString());
			*/
			//JSON.put("eventos", eventos);
			
		} catch (Exception e) {
			log.debug("Error al listar eventos. " + e.getMessage());
		}
		
		return JSON;
		
	}
	
}
