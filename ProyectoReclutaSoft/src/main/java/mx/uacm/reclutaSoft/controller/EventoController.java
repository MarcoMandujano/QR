package mx.uacm.reclutaSoft.controller;

import java.io.File;
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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

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
		String eventosString;
		List<Evento> eventos;
		
		ObjectMapper mapper = new ObjectMapper();
		
		//Gson gson = new Gson();
		
		try {
			
			JSON.put("exito", "se logro aaaaaa");
			eventos = eventoService.consultarEventos();
			
			//mapper.writeValue(new File("c:\\test\\staff.json"),eventos); 
			
			eventosString = mapper.writeValueAsString(eventos);
			log.debug("eventosString: " + eventosString);
			//eventosString = gson.toJson(eventos);
			
			JSON.put("eventos", eventosString);
			
		} catch (Exception e) {
			log.debug("Error al listar eventos." + e.getMessage());
			JSON.put("errorAlListar", "Error");
		}
		
		return JSON;
		
	}
	
	
}
