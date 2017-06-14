$.noConflict();
jQuery( document ).ready(function( $ ) {
	
	$('#ocultar').hide();
	$("#boton").on("click",function(e){
		
		//$("#email").empty();
		//$("#nombre").empty();
		$('#ocultar').show();
	//	alert($("#buscar").val());
		var str = $("#buscar").val();
		var res = str.toUpperCase();
	//	alert(res);
		//console.log($('#buscar').val());
		url='http://localhost:8080/gestioncursos/api/cursos/'+res;
		alert(url);
		 $.ajax({
			  url : url,
			  dataType : "json",
			  success: function (data) {
				  if (data.length > 0) {
					  txt ="<table data-table='cursos' id='tablaCursos' class='rwd-table'><thead><tr>"
		                    +"<th>Nombre</th>"
		                    +"<th>Codigo</th>"
		                    +"<th>Acciones</th></tr></thead><tbody>";
				 // $.each(data,function(i){
					  //alert(data.length);
			      //  var txtnombre = "<p>"+data[i].nombre+"</p>";
			      //  $("#nombre").append(txtnombre);
			       /// var txtcodigo = "<p>"+data[i].codigo+"</p>";
			       // $("#codigo").append(txtemail); 	 
		               
		                for (i = 0; i < data.length; i++) {
		                    let curso = data[i];
		                   /* console.log("CATEGORIA:" +categoria);*/
		                    txt += parseCurso(curso);
		                }
		        
			        txt+="</tbody><tfoot><tr><td colspan='3'></td></tr></tfoot></table>";
		            }else{
		                txt ="no se encuentran cursos en la BBDD";
		            }
				    
			        $("#ocultar").append(txt); 
				 },

				 error: function (parsedjson, textStatus, errorThrown) {
					  console.log("parsedJson: " + JSON.stringify(parsedjson));
					  txt ="No hay conexion a BBDD";
				  }
		 });
		 
		
	});
	 function parseCurso (curso){
		    let nombre = curso.nombre;
		    let codigo = curso.codigo;
		    let id= curso.id;
		  

		    let texto = "<tr><td>"+nombre+"</td><td>"+codigo+"</td></tr>";

		    return texto;


		}
	
     
})