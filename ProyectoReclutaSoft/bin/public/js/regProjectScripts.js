var correoDevelopersList = [];
var correoTestersList = [];
var correoDesignersList = [];

$(document).ready(function() {

	
    
    var tableLider2 = $('#tbLiderList2').DataTable( {
        select: true
    });
    
    $('#tbLiderList2 tbody').on( 'click', 'tr', function () {
	    console.log( tableLider2.row( this ).data() );
	    //var id= tableLider2.row( this ).data()[0];
	    console.log("hiciste clic");
	    var nombre = tableLider2.row( this ).data()[0];
	    var correo = tableLider2.row( this ).data()[2];
	    console.log("mi id es" + listaUsuarios)
	    $("#liderChoice").html("<strong> "+ nombre + "</strong>");
	    sessionStorage.setItem("correoLiderElegido",correo);
	    
	    
	} );
    
    var tableDesigners2 = $('#tbDisignersList2').DataTable( {
        select: true
    });
    
    $('#tbDisignersList2 tbody').on( 'click', 'tr', function () {
	    console.log( tableDesigners2.row( this ).data() );
	    //var id= tableLider2.row( this ).data()[0];
	    
	    var nombre = tableDesigners2.row( this ).data()[0];
	    var correo = tableDesigners2.row( this ).data()[2];
	    console.log("mi id es" + listaUsuarios)
	    $("#diseniadoresChoice").append("<br></br><strong> "+ nombre + "</strong>");
	    correoDesignersList.push(correo);
//	    if( sessionStorage.getItem("correoDesingLista") != null){
//	    	//var correoDesignerList = sessionStorage.getItem("correoDesingLista");
//	    	correoDesignerList.push(correo);
//	    	//sessionStorage.setItem("correoDesingLista",correoDesignerList);
//	    }else{
//	    	
//	    //	var correoDesignerList=[];
//	    	correoDesignerList.push(correo);
//	    	//sessionStorage.setItem("correoDesingLista",correoDesignerList);
//	    	
//	    }
	    $(this).remove();
	    
	    
	} );
    var tableDevelopers2 = $('#tbDevelopersList2').DataTable( {
        select: true
    });
    
    $('#tbDevelopersList2 tbody').on( 'click', 'tr', function () {
	    console.log( tableDevelopers2.row( this ).data() );
	    //var id= tableLider2.row( this ).data()[0];
	    
	    var nombre = tableDevelopers2.row( this ).data()[0];
	    var correo = tableDevelopers2.row( this ).data()[2];
	    console.log("mi id es" + listaUsuarios)
	    $("#developersChoice").append("<br></br><strong> "+ nombre + "</strong>");
	    correoDevelopersList.push(correo);
//	    if( sessionStorage.getItem("correoDevelopersLista") != null){
//	    	var correoList = new Array();
//	    	correoList =sessionStorage.getItem("correoDevelopersLista");
//	    	console.log(correoList);
//	    	correoList.push(correo);
//	    	sessionStorage.setItem("correoDevelopersLista",correoList);
//	    }else{
//	    	
//	    	var correoList = new Array(correo);
//	    	//correoList.push(correo);
//	    	console.log(correoList);
//	    	sessionStorage.setItem("correoDevelopersLista",correoList);
//	    	
//	    }
	    $(this).remove();
	    
	    
	} );
	
	 var tableTesters2 = $('#tbTestersList2').DataTable( {
	        select: true
	    });
	    
	    $('#tbTestersList2 tbody').on( 'click', 'tr', function () {
		    console.log( tableTesters2.row( this ).data() );
		    //var id= tableLider2.row( this ).data()[0];
		    
		    var nombre = tableTesters2.row( this ).data()[0];
		    var correo = tableTesters2.row( this ).data()[2];
		    console.log("mi id es" + listaUsuarios)
		    $("#testersChoice").append("<br></br><strong> "+ nombre + "</strong>");
		    correoTestersList.push(correo);
//		    if( sessionStorage.getItem("correoTestersLista") != null){
//		    	var correoList = sessionStorage.getItem("correoTestersLista");
//		    	correoList.push(correo);
//		    	sessionStorage.setItem("correoTestersLista",correoList);
//		    }else{
//		    	
//		    	var correoLiderList=[];
//		    	correoLiderList.push(correo);
//		    	sessionStorage.setItem("correoTestersLista",correoLiderList);
//		    	
//		    }
		    $(this).remove();	    
		} );
	    
	    $("#divLider").hide();
	    $("#divDevelopers").hide();
	    $("#divDesigners").hide();
	    $("#divTester").hide();
	    
	    $("#cbLider").change(function (){
	    	console.log("onchange lider");
	    	
	    	 if(document.getElementById('cbLider').checked){
	    		 console.log("cblider is checked");
	    		 $("#divLider").show();
	    	 }else {
	    		 $("#divLider").hide();
	    	 }
	    	
	    });
	    
	    $("#cbProgramador").change(function (){
	    	
	    	 if(document.getElementById('cbProgramador').checked){
	    		 $("#divDevelopers").show();
	    	 }else {
	    		 $("#divDevelopers").hide();
	    	 }
	    	
	    });
	    
	    $("#cbDiseniador").change(function (){
	    	
	    	 if(document.getElementById('cbDiseniador').checked){
	    		 $("#divDesigners").show();
	    	 }else {
	    		 $("#divDesigners").hide();
	    	 }
	    	
	    });
	    
	    $("#cbTester").change(function (){
	    	
	    	 if(document.getElementById('cbTester').checked){
	    		 $("#divTester").show();
	    	 }else {
	    		 $("#divTester").hide();
	    	 }
	    	
	    });
});
	


function hacerPost(table) {
	
	var proyecto = {};
	proyecto.nombre = $("#inputNombreProyecto").val();
	proyecto.descripcion= $("#inputDescripcionProyecto").val();
//	proyecto.descripcion= $("#inputDescripcionProyecto").val();
	
	
	
	roles = [];
	for(var i = 0; i< document.getElementsByName("roles").length; i ++) {
		roles.push(document.getElementsByName("roles")[i].value);
	}
	proyecto.roles = roles;
	//Asi me lo debes de mandar. Los correos deben de ser diferentes con la exepcion del dueño
	 
	proyecto.correoLider = sessionStorage.getItem("correoLiderElegido");
	proyecto.correoDesigners = correoDesignersList[0];
	proyecto.correoAnalyst = "generic@mail.com";
	proyecto.correoDevelopers = correoDevelopersList[0];
	proyecto.correoTester = correoTestersList[0];
//	
//	proyecto.correoDuenio = "garcia@gmail.com";
	
	proyecto = JSON.stringify(proyecto);
	console.log(proyecto);
	
	
	$.ajax({ 
	    url: "/registrarProyecto/registrarProject", 
	    type: 'POST', 
	    dataType: 'json', 
	    data: proyecto, 
	    contentType: 'application/json',
	    mimeType: 'application/json',
	    success: function(data) { 
	        //console.log(data.nombre);
	        console.log(data);
	        if(data.hasOwnProperty('errorAlRegistrar')){
	        	$("#content").html(data.errorAlRegistrar);
	        	$("#aviso").modal("show");
	        	}
	        
	        if(data.hasOwnProperty('exito')){
	        	$("#content").html(data.exito);
	        	$("#aviso").modal("show");
	        	}
	      
	    },
	    error:function(data,status,er) { 
	        alert("error: "+data+" status: "+status+" er:"+er);
	    }
	});
	
	
//	$.post("localhost:9090/registrarProyecto/registerproyecto",JSON.stringify(proyecto),function(data){
//		console.log(data);
//	});
}