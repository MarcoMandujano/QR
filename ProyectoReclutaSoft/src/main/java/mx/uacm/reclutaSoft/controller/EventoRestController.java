package mx.uacm.reclutaSoft.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.uacm.reclutaSoft.service.EventoService;

@RestController
@RequestMapping("/eventoRestController")
public class EventoRestController {
	private final Logger log = LogManager.getLogger(EventoRestController.class);
	
	@Autowired
	private EventoService eventoService;
	
	@GetMapping("/listarEvento/{id}")
	public String listarEvento(@PathVariable String id) {
		log.debug("eventoRestController.listarEvento");
		
		log.debug("id: " + id);
		
		//localhost:9090/eventoRestController/listarEvento/{1}
		
		return "redirect:/info";
	}
	
	
}
