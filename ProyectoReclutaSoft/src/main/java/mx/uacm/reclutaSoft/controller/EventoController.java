package mx.uacm.reclutaSoft.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	private final Logger log = LogManager.getLogger(EventoController.class);
	
	@Autowired
	private EventoService eventoService;
	
	@Autowired
	private HttpSession httpSession; 
	
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
	
	@GetMapping("/listarEvento/{id}")
	//@RequestMapping(value="/listarEvento/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	//public Map<String, String> listarEventos(@PathVariable String id) {
	public ModelAndView  listarEventos(Map <String, Object> model, @PathVariable String id) {
		log.debug("eventoController.listarEvento");
		//localhost:9090/eventoController/listarEvento?acc={"id":"1"}
		//localhost:9090/eventoController/listarEvento?data={"id":"1"}
		//localhost:9090/eventoController/listarEvento?data=%7B%22id%22%3A%221%22%7D
		//localhost:9090/eventoController/listarEvento1
		
		Map <String, String> JSON = new HashMap<String, String>();
		ObjectMapper mapper = new ObjectMapper();
		String eventosString;
		Evento evento = new Evento();
		
		try {
			evento = eventoService.consultarEvento(Integer.parseInt(id));
			log.debug(id);
			eventosString = mapper.writeValueAsString(evento);
			log.debug("Evento:::: " + eventosString);
			//JSON.put()
			//model.put("evento",evento.getNombreEvento());
			
			model.put("evento", evento);
			
		} catch (Exception e) {
			log.debug("Error al listar evento********." + e.getMessage());
			JSON.put("errorAlListar", "Error");
		}
		
		//return JSON;
		return new ModelAndView("info", model);
		//return "redirect:/info";
	}
	
	
	@RequestMapping(value="/listarEvento2",  method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Map<String, String> listarEvento2(@RequestBody Map <?, ?> idEvento) {
		Map <String, String> JSON = new HashMap<String, String>();
		
		try {
			
			log.debug(idEvento);
			
			JSON.put("exito", "se logro aaaaaa");
			
			
		} catch (Exception e) {
			log.debug("Error al listar evento2********." + e.getMessage());
			JSON.put("errorAlListar", "Error");
		}
		
		return JSON;
	}
	
	
}
