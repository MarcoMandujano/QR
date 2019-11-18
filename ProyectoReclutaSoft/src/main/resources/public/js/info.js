
var qrcode;
var t_d = 0;


$("#test").click(function(){
	
	$('#myModal').on('shown.bs.modal', function () {
		//$('#myInput').trigger('focus')
	});
	
});


$(document).ready(function() {
	
	listarEventos();
	
	var idQrDiv = document.getElementById("qrcode")
	//var idQrDiv = $('#qrcode')
	qrcode = new QRCode(idQrDiv, {
	    text: "http://jindo.dev.naver.com/collie",
	    width: 128,
	    height: 128,
	    colorDark : "#000000",
	    colorLight : "#ffffff",
	    correctLevel : QRCode.CorrectLevel.H
	});
	
	
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
	        	
	        	var tipoUsuario = 1;
	        	if (tipoUsuario == 1) {
	        		$('#containerAddTaller').hide();
	        		$('#containerAddTallerButton').hide();
				}
	        	
	        	
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
																		+ '<button id="evento' + eventos[i].id + '" type="button" class="btnEvento btn btn-info" data-toggle="modal" data-target=".bd-example-modal-lg">Detalle de evento</button>';
															        	//+ '<td><a href="/index1"><button type="button" class="btn btn-light" >Detalle de evento</button></a></td>';
    	console.log(eventos[i].talleres)
    	var talleres = eventos[i].talleres
    	for (var j = 0; j < talleres.length; j++) {
			console.log(talleres[j].id)
			console.log(talleres[j].nombre)
			//document.getElementById("inputNombreEvento").value = eventos[i].nombreEvento;
			$("#inputNombreEvento").val(eventos[i].nombreEvento);
			$("#inputDescripcionEvento").val(String(eventos[i].descripcion));
			$("#inputNombrePlantel").val(String(eventos[i].plantel));
			//$("#inputDescripcionUbicacion").val(eventos[i].nombreEvento)
			$("#inputFechaInicio").val(eventos[i].fechaInicio);
			$("#inputFechaFin").val(eventos[i].fechaFin);
//			$("#inputHoraInicio").val();
//			$("#inputHoraFin").val();
			
			
		}
    	
    	
	}
    
    
    $('.btnEvento').click(function() {
		console.log(this)
		
		var idEvento = this.id;
		
		console.log(idEvento.slice(6, idEvento.length));
		console.log(data);
		
		var id = idEvento.slice(6, idEvento.length);
		
		despliegaEvento(id, data);
		
	});
	
}


function despliegaEvento(id, data) {
	
	var eventos = JSON.parse(data.eventos);
	
	console.log(eventos[id - 1]);
	
	$("#inputNombreEvento").val(eventos[id - 1].nombreEvento)
	$("#inputDescripcionEvento").val(String(eventos[id - 1].descripcion))
	$("#inputNombrePlantel").val(String(eventos[id - 1].plantel))
	$("#inputFechaInicio").val(eventos[id - 1].fechaInicio);
	$("#inputFechaFin").val(eventos[id - 1].fechaFin);
	
		
	console.log(eventos[id - 1].talleres)
	var talleres = eventos[id - 1].talleres
	for (var j = 0; j < talleres.length; j++) {
		console.log(talleres[j].id)
		console.log(talleres[j].nombre)
		
		
		document.getElementById("tableTalleres").insertRow(-1).innerHTML = '<td>' + talleres[j].nombre + '</td>'
																		 + '<td>' + talleres[j].tallerista + '</td>'
																		 + '<td>' + talleres[j].descripcion + '</td>'
																		 + '<td>' + talleres[j].fechaInicio + '</td>'
																		 + '<td>' + talleres[j].horaInicio + '</td>'
																		 + '<td>' + talleres[j].horaFin + '</td>'
																		 + '<td>' + talleres[j].ubicacion.salon + '</td>';
		
	}
	
	addQrCode();
	
	
}


function addQrCode() {
	
	t_d = t_d + 1;
	qrcode.clear();
	qrcode.makeCode("/eventoController/listarEventos/" + t_d);
}
















