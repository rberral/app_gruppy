// -------------------- PARAMETROS FORMULARIOS -------------------- //	
 FORM_JS_EDIT_ANNO = 'editAnno';
 FORM_JS_EDIT_MENSUALIDAD = 'editMensualidad';
 FORM_JS_EDIT_COSTE = 'editCoste';
 FORM_JS_EDIT_USUARIO = 'usuario';
 

// Tienen que estar sincronizados con los parametros definidos en Constantes.java
 FORM_JS_OPER_UPDATE = "update";
 FORM_JS_OPER_DELETE = "delete";
 FORM_JS_OPER = '?oper';
 FORM_JS_EMAIL = 'email';
 FORM_JS_MENSUALIDAD = 'mensualidad';
 FORM_JS_ANNO = 'anno';
 FORM_JS_COSTE = 'coste';
 
$(document).ready(function(){
	

$("#btnEditAdicional").click(function(){
  var elementSelect = checkStatusCheckbox(); 
  if(elementSelect.length > 0){
  $(".containerAddAdicional").fadeOut();
  $("#"+FORM_JS_EDIT_ANNO).val(elementSelect[0].ColumnAnno);
  $("#"+FORM_JS_EDIT_MENSUALIDAD).val(elementSelect[0].ColumnMensualidad);
  $("#"+FORM_JS_EDIT_COSTE).val(elementSelect[0].ColumnCoste);
  $(".containerEditAdicional").fadeIn();
  }
  else{
    alert("Por favor, selecciona la fila a modificar");
  }
});

$("#btnEditMensualidad").click(function(){
	  var elementSelect = checkStatusCheckbox(); 
	  if(elementSelect.length > 0){
	  $(".containerAddMensualidad").fadeOut();
	  $("#"+FORM_JS_EDIT_ANNO).val(elementSelect[0].ColumnAnno);
	  $("#"+FORM_JS_EDIT_MENSUALIDAD).val(elementSelect[0].ColumnMensualidad);
	  $("#"+FORM_JS_EDIT_COSTE).val(elementSelect[0].ColumnCoste);
	  $(".containerEditMensualidad").fadeIn();
	  }
	  else{
	    alert("Por favor, selecciona la fila a modificar");
	  }
	});



});


   
function tratamientoFila(accion){
  switch (accion){

    case "actualiza":
    actualizaFila();
    $(".containerEdit").fadeOut();
    break;
  }
}



function actualizaFila(){
  var usuarioInput, MensualidadInput, indiceFila, CosteInput, AnnoInput;
  usuarioInput = $("#"+FORM_JS_EDIT_USUARIO).val();
  MensualidadInput = $("#"+FORM_JS_EDIT_MENSUALIDAD).val();
  CosteInput = $("#"+FORM_JS_EDIT_COSTE).val();
  AnnoInput =  $("#"+FORM_JS_EDIT_ANNO).val();
  
  indiceFila = $("#"+identificadorInput).attr("data-index");

$("#tablaDinamica").bootstrapTable('updateRow', {
                index: indiceFila,
                row: {
                    ColumnState : false,
                    ColumnId : identificadorInput,
                    ColumnAnno: AnnoInput,
                    ColumnMensualidad : MensualidadInput,
                    ColumnCoste : CosteInput
                }
            });  
//var email= document.getElementById("editEmail").value;
//var fundador = document.getElementById("editFundador").value; 
//var params = "?oper=update&email="+email+"&fundador="+fundador;
var anno= document.getElementById(FORM_JS_EDIT_ANNO).value;
var mensualidad = document.getElementById(FORM_JS_EDIT_MENSUALIDAD).value; 
var coste = document.getElementById(FORM_JS_EDIT_COSTE).value;
var params = FORM_JS_OPER+"="+FORM_JS_OPER_UPDATE+"&"+FORM_JS_EMAIL+"="+email+"&"+FORM_JS_ANNO+"="+anno+"&"+FORM_JS_MENSUALIDAD+"="+mensualidad+"&"+FORM_JS_COSTE+"="+coste;
$("#params").val(params);

document.getElementById('actualizaPagos').submit();
}



function checkStatusCheckbox(){
return $("#tablaDinamica").bootstrapTable('getSelections');
}