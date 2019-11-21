var talleres = []

function agregarFila() {
	var taller = {}
	taller.nombreTaller = $("#inputNombreTaller").val();
	taller.nombreTallerista = $("#inputNombreTallerista").val();
	taller.descripcionTaller = $("#inputDescripcionTaller").val();
	taller.fechaTaller = $("#inputFechaTaller").val();
//	taller.horaInicioTaller = $("#inputHoraInicioTaller").val();
//	taller.horaFinTaller = $("#inputHoraFinTaller").val();
	taller.horaInicioTaller = document.getElementById("inputHoraInicioTaller").value;
	taller.horaFinTaller = document.getElementById("inputHoraFinTaller").value;
	taller.salorTaller = $("#inputSalonTaller").val();
	taller.inputDescipcionUbicacionTaller = $("#inputDescipcionUbicacionTaller").val();
	talleres.push(taller);
	

	document.getElementById("tablaprueba").insertRow(-1).innerHTML = '<td>' + taller.nombreTaller + '</td>'
																	+ '<td>' + taller.nombreTallerista + '</td>'
																	+ '<td>' + taller.descripcionTaller + '</td>'
																	+ '<td>' + taller.fechaTaller + '</td>'
																	+ '<td>' + taller.horaInicioTaller + '</td>'
																	+ '<td>' + taller.horaFinTaller + '</td>'
																	+ '<td>' + taller.salorTaller + '</td>';
	
}

function eliminarFila() {
	var table = document.getElementById("tablaprueba");
	var rowCount = table.rows.length;
	// console.log(rowCount);

	if (rowCount <= 1) {
		alert('No se puede eliminar el encabezado');
	} else {
		table.deleteRow(rowCount - 1);
		talleres.pop();
	}

}

$(document).ready(function() {
	
	$("#guardarEvento").click(function() {
		  registrarEvento();
	});
	
});

function registrarEvento() {
	
	var evento = {};
	evento.nombre = $("#inputNombreEvento").val();
	evento.descripcion = $("#inputDescripcionEvento").val();
	evento.plantel = $("#inputNombrePlantel").val();
	//evento.salon = $("#inputSalon").val();
	evento.descripcionUbicacion = $("#inputDescripcionUbicacion").val();
	evento.fechaInicio = $("#inputFechaInicio").val();
	evento.fechaFin = $("#inputFechaFin").val();
	evento.horaInicio = $("#inputHoraInicio").val();
	evento.horaFin = $("#inputHoraFin").val();
	
	evento.horaInicio = document.getElementById("inputHoraInicio");
	evento.horaFin = document.getElementById("inputHoraFin");
	
	
	evento.talleres = talleres;
	
	console.log(evento);
	evento = JSON.stringify(evento);
	console.log(evento);
	
	
	$.ajax({ 
	    url: "/eventoController/registrarEvento", 
	    type: 'POST', 
	    dataType: 'json', 
	    data: evento, 
	    contentType: 'application/json',
	    mimeType: 'application/json',
	    success: function(data) { 
	        //console.log(data.nombre);
	        console.log(data);
	        if (data.hasOwnProperty('errorAlRegistrar')) {
	        	alert("Erro al registrar evento");
	        	//$("#content").html(data.errorAlRegistrar);
	        	//$("#aviso").modal("show");
	        }
	        
	        if (data.hasOwnProperty('exito')) {
	        	alert("Evvento registrado");
	        	//$("#content").html(data.exito);
	        	//$("#aviso").modal("show");
	        }
	      
	    },
	    error:function(data, status, er) { 
	        alert("error: " + data + " status: " + status + " er:" + er);
	    }
	});
	
	
//	$.post("localhost:9090/registrarProyecto/registerproyecto",JSON.stringify(proyecto),function(data){
//		console.log(data);
//	});
}