/**
 * 
 */
saveme();
function saveme (){
	 $.ajax({
        type: "POST",
        url: "http://localhost:8080/Usuarios/Lista", //ruta de la API consultaremos.
      
        success: function(data) {
			lista = document.getElementById("cuerpoTabla");
			//lista.innerHTML ='';
	        $.each(data, function(i, item) {
	        
	        var tr = document.createElement("tr");
			//var idtr = document.createAttribute("id");
			//idtr.value=item.cedulaUsuario;
			//tr.setAttributeNode(idtr);
			
	       var columna1 = document.createElement("td");
	        columna1.innerHTML = item.cedulaUsuario;
	        var columna2 = document.createElement("td");
	        columna2.innerHTML = item.emailUsuario;
	        var columna3 = document.createElement("td");
	        columna3.innerHTML = item.nombreUsuario;
	        var columna4 = document.createElement("td");
	        columna4.innerHTML = item.password;
	        var columna5 = document.createElement("td");
	        columna5.innerHTML = item.usuario;

			var columna6 = document.createElement("td");
			var button = document.createElement("button");
	        var idbutton = document.createAttribute("id");
			idbutton.value=item.cedulaUsuario;
			button.setAttributeNode(idbutton);
			
			var classbutton = document.createAttribute("class");
			classbutton.value="btn btn-primary btnConsultar";
			button.setAttributeNode(classbutton);
			
			var icon = document.createElement("i");
	        var classicon = document.createAttribute("class");
			classicon.value="fa fa-search";
			icon.setAttributeNode(classicon);	
	        
			var button2 = document.createElement("button");
	        var idbutton2 = document.createAttribute("id");
			idbutton2.value=item.cedulaUsuario;
			button2.setAttributeNode(idbutton2);
			
			var classbutton2 = document.createAttribute("class");
			classbutton2.value="btn btn-danger btnEliminar";
			button2.setAttributeNode(classbutton2);
			
			var icon2 = document.createElement("i");
	        var classicon2 = document.createAttribute("class");
			classicon2.value="fa fa-trash";
			icon2.setAttributeNode(classicon2);
	        
			lista.appendChild(tr);
	        tr.appendChild(columna1);
	        tr.appendChild(columna2);
	        tr.appendChild(columna3);
			tr.appendChild(columna4);
			tr.appendChild(columna5);
			tr.appendChild(columna6);
			columna6.appendChild(button);
			button.appendChild(icon);
			columna6.appendChild(button2);
			button2.appendChild(icon2);
       
         });
        }
	})
};

//GET = Consulta, SELECT
$('table').on('click', '.btnConsultar', function(){
	var cedula= $(this).attr('id');
	console.log(cedula);
	$.ajax({
		type:"GET",
		url:"http://localhost:8080/Usuarios/" + cedula,
		dataType: "json",
		error: function(){
			alert("Error en la petición");
		}
	}).done(function(data){
		console.log(data.nombreUsuario);
		var infoNombre = document.getElementById('nombreUsuario');
		infoNombre.innerHTML = data.nombreUsuario;
		var infoContrasena = document.getElementById('contrasenaUsuario');
		infoContrasena.innerHTML = data.password;
		
	})
})

//DELETE = Eliminar
$('table').on('click', '.btnEliminar', function(){
	var cedula= $(this).attr('id');
	console.log(cedula);
	$.ajax({
		type:"DELETE",
		url:"http://localhost:8080/Usuarios/" + cedula,
		//contentType: "application/json",
		//success: function(response){
		//	alert("El usuario fue eliminado");
		//}
	})
	location.reload();
	//Averiguar un javascript que recargue y vuelva a dibujar la tabla
})

//PUT = Actualizar, UPDATE
//POST = Crear, INSERT