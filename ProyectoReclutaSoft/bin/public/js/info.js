

$("#test").click(function(){
	
	$('#myModal').on('shown.bs.modal', function () {
		//$('#myInput').trigger('focus')
	});
	
});


$(document).ready(function() {
	
	listarEventos();
	
	var id = document.getElementById("qrcode")
	//var id = $('#qrcode')
	
	var qrcode = new QRCode(id, {
	    text: "http://jindo.dev.naver.com/collie",
	    width: 128,
	    height: 128,
	    colorDark : "#000000",
	    colorLight : "#ffffff",
	    correctLevel : QRCode.CorrectLevel.H
	});
	qrcode.makeCode("texto");
	
	
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
	        console.log(JSON.parse(data.eventos))
	        console.log(JSON.parse(data.eventos)[0].nombreEvento)
	        console.log()
	    	//eventosJson = JSON.stringify(data.eventos);
	    	
	    	
	        if (data.hasOwnProperty('errorAlListar')) {
	        	alert("Erro al listar eventos");
	        }
	        
	        if (data.hasOwnProperty('exito')) {
	        	//alert("listar eventos exitoso");
	        	
	        	despliegaEventos(data);
	        	
	        }
	      
	    },
	    error:function(data, status, er) { 
	        alert("error: " + data + " status: " + status + " er:" + er);
	    }
	});
	
}



function despliegaEventos(data) {
	
	var eventos = JSON.parse(data.eventos);
    console.log(eventos[0])
    
    for (var i = 0; i < eventos.length; i++) {
    	console.log(eventos[i].id)
    	console.log(eventos[i].tipoEvento)
    	console.log(eventos[i].nombreEvento)
    	console.log(eventos[i].descripcion)
    	console.log(eventos[i].fechaFin)
    	console.log(eventos[i].fechaInicio)
    	console.log(eventos[i].plantel)
    	
    	document.getElementById("tablaEventos").insertRow(-1).innerHTML = '<td>' + eventos[i].id + '</td>'
																		+ '<td>' + eventos[i].nombreEvento + '</td>'
																		+ '<td>' + eventos[i].fechaInicio + '</td>'
																		+ '<td>' + eventos[i].fechaFin + '</td>'
																		+ '<td>' + eventos[i].tipoEvento + '</td>'
																		+ '<td>' + eventos[i].descripcion + '</td>'
																		+ '<td>' + eventos[i].plantel + '</td>'
															        	+ '<td><a href="/index1"><button type="button" class="btn btn-light" >Detalle de evento</button></a></td>';
    	console.log(eventos[i].talleres)
    	var talleres = eventos[i].talleres
    	for (var j = 0; j < talleres.length; j++) {
			console.log(talleres[j].id)
			console.log(talleres[j].nombre)
			document.getElementById("inputNombreEvento").value = eventos[i].nombreEvento;
			$("#inputNombreEvento").text(eventos[i].nombreEvento)
			$("#inputDescipcionEvento").text(eventos[i].descripcion)
			$("#inputNombrePlantel").text(eventos[i].plantel)
			
		}
    	
    	
	}
	
}