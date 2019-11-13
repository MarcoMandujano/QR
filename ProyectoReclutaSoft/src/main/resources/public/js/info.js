


$(document).ready(function() {
	
	listarEventos();
	
	
	
});


function listarEventos() {
	
	
	$.ajax({
	    url: "/eventoController/listarEventos", 
	    type: 'POST', 
	    dataType: 'json', 
	    //data: evento, 
	    contentType: 'application/json',
	    mimeType: 'application/json',
	    success: function(data) { 
	        console.log(data);
	        if (data.hasOwnProperty('errorAlListar')) {
	        	alert("Erro al listar eventos");
	        }
	        
	        if (data.hasOwnProperty('exito')) {
	        	alert("listar eventos exitoso");
	        	//despliegaEventos(data.eventos);
	        	
	        }
	      
	    },
	    error:function(data, status, er) { 
	        alert("error: " + data + " status: " + status + " er:" + er);
	    }
	});
	
}



function despliegaEventos(eventos) {
	
	for (i = 0; i < eventos.legth(); i++) {
		console.log(eventos[i]);
	}
	
}