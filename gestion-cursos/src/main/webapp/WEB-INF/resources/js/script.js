$.noConflict();
jQuery( document ).ready(function( $ ) {
	
	$('#ocultar').hide();
	$("#boton").on("click",function(e){
		
		//$("#email").empty();
		//$("#nombre").empty();
		$('#ocultar').show();
		alert($("#buscar").val());
		//alert("HOLA");
		//console.log($('#buscar').val());
		url='http://localhost:8080/gestioncursos/api/cursos/'+$("#buscar").val();
		 $.ajax({
			  url : url,
			  dataType : "json",
			  success: function (data) {
				  if (data.length > 0) {
					  txt ="<table data-table='cursos' id='tablaCursos' class='rwd-table'><thead><tr>"
		                    +"<th>Nombre</th>"
		                    +"<th>Codigo</th>"
		                    +"<th></th></tr></thead><tbody>";
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
				  }
		 });
		 
		
	});
	 function parseCurso (curso){
		    let nombre = curso.nombre;
		    let codigo = curso.codigo;
		   /* let apellidos = alumno.apellidos;
		    let email = alumno.email;
		    let dni = alumno.dni;*/
		  /*  let htmlEdit ="<button>Editar</button>";*/
		    let htmlEdit='<div class="dropdown"><button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">';
		    htmlEdit+='Acciones';
		    htmlEdit+='<span class="caret"></span></button>';
		    htmlEdit+='<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">' ;
		    htmlEdit+= ' <li><a href="#">Editar</a></li>' ;
		    htmlEdit+= ' <li><a href="#">Borrar</a></li>'  ;

		  /*  htmlEdit+='<li role="separator" class="divider"></li>';
		    htmlEdit+= '<li><a href="#">Separated link</a></li>';*/
		    htmlEdit+='</ul></div>';
		  /*  let htmlDelete ="<button>Borrar</button>";*/

		    let texto = "<tr><td><input type='checkbox' value='" + codigo + "'></td><td>"+nombre+"</td><td>"+htmlEdit+"</td></tr>";

		    return texto;






		}
	
     
})