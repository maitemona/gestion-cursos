function buscar() {
	
	    var x = document.forms["myForm"]["busca"].value;
	    if (x == "") {
	        alert("Name must be filled out");
	        return false;
	    }
	 
}
 




/*$.noConflict();
jQuery( document ).ready(function( $ ) {
	alert("HOL");
	$('#ocultar').hide();
	
	
		//url='http://localhost:8080/gestioncursos/api/cursos/'+$('select[name=categoria]').val();

		 $.ajax({
			  url : url,
			  dataType : "json",
			  success: function (data) {
				  $.each(data,function(i){
					// var email = data[i].email;
					 console.log("Vuelta"+i);
					// $('#ocultar').show();
			        var txtnombre = "<p>"+data[i].ncontacto+"</p>";
			        $("#nombre").append(txtnombre);
			        var txtemail = "<p>"+data[i].email+"</p>";
			        $("#codigo").append(txtemail); 	 
				  });
				 },

				 error: function (parsedjson, textStatus, errorThrown) {
					  console.log("parsedJson: " + JSON.stringify(parsedjson));
				  }
		 });
	});*/
	
	/* $('#fichero').on('change', function(e) {
   	  var fileName = e.target.files[0].name;
   	  $("#archivo").val(fileName);
     });
    
     
})

*/