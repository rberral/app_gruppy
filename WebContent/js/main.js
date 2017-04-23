/*
 * Mensajes de error al validar las fechas
 */
//error_fecha_formato = 'El formato de fecha debe ser dd/mm/yyyy';
//alert(error_superada_fecha_maxima + " " + fechaMaxima);

/*
function navega(pagina){

	document.getElementById("tipoExportacion").value = tipo;
	
	var params="?oper=exportFU" + 
	"&tipoExportacion=" + tipo;

	$("#params").val(params);
	document.getElementById("exportar").submit();
}
*/

 
function checkFrmProfile(){
	//recogemos valores
	var nombre = $("input[name='first_name']").val();
	var apel = $("input[name='second_name']").val();
	var pass = $("input[name='password']").val();
	var email = $("input[name='email']").val();
	var f_nac = $("input[name='fecha_nac']").val();
	var phone =  $("input[name='phone']").val();
	//var activo = $("input[name='activo']").val();
	//var fundador = $("input[name='fundador']").val();
	//var rol = $("input[name='rol']").val();
	
	//chequeamos valores
	
	
	//$("#updateProfileForm").submit();
    document.getElementById("updateProfileForm").submit();	
}

function checkFrmAsociacion(){
	//recogemos valores
	var nombre = $("input[name='name_asoc']").val();
	var desc = $("input[name='descripcion_asoc']").val();
	var direccion = $("input[name='direccion_asoc']").val();
	var email = $("input[name='email_asoc']").val();
	var telefono = $("input[name='telefono_asoc']").val();
	var fecha =  $("input[name='fecha_fundacion_asoc']").val();

	//chequeamos valores
	if((nombre.length == 0) || (desc.length == 0) || (direccion.length == 0) || (fecha.length == 0)){
		alert("Introduce valores obligatorios");
	}
	else{
		//$("#updateProfileForm").submit();
	    document.getElementById("updateAsociacionForm").submit();	
	}
}

function checkFrmPublish(){
	var asunto = $("input[name='asunto']").val();
	var desc = $("textarea[name='descripcion']").val();

	//chequeamos valores
	if((asunto.length == 0) || (desc.length == 0)){
		alert("Introduce valores obligatorios");
	}
	else{	
	document.getElementById("publishCommentForm").submit();	
	}
}