package mx.uacm.reclutaSoft.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/eventoController")
public class EventoController {
	private final Logger log = LogManager.getLogger(UsuarioController.class);
	
	@Autowired
	private EventoService eventoService;
	
	@PostMapping("/registrarEvento")
	public String registrarEvento(Map <String>)
}
