// -------------------- PARAMETROS FORMULARIOS -------------------- //	
 FORM_JS_EDIT_FUNDADOR = 'editFundador';
 FORM_JS_EDIT_FECHA_ALTA = 'editFechaAlta';
 FORM_JS_EDIT_ACTIVO = 'editActivo';
 

// Tienen que estar sincronizados con los parametros definidos en Constantes.java
 FORM_JS_OPER_UPDATE = "update";
 FORM_JS_OPER_DELETE = "delete";
 FORM_JS_OPER = '?oper';
 FORM_JS_EMAIL = 'email';
 FORM_JS_EDIT_EMAIL = 'editEmail';
 FORM_JS_NOMBRE = 'nombre';
 FORM_JS_FUNDADOR = 'fundador';
 FORM_JS_FECHA_ALTA = 'fechaAlta';
 FORM_JS_ACTIVO = 'activo';
 
$(document).ready(function(){
	

$("#btnEdit").click(function(){
  var elementSelect = checkStatusCheckbox(); 
  if(elementSelect.length > 0){
  $(".containerAdd").fadeOut();
  //$("#editEmail").val(elementSelect[0].ColumnEmail);
  //$("#editFundador").val(elementSelect[0].ColumnFundador);
  $("#"+FORM_JS_EDIT_EMAIL).val(elementSelect[0].ColumnEmail);
  $("#"+FORM_JS_EDIT_FUNDADOR).val(elementSelect[0].ColumnFundador);
  $("#"+FORM_JS_EDIT_FECHA_ALTA).val(elementSelect[0].ColumnFechaAlta);
  $("#"+FORM_JS_EDIT_ACTIVO).val(elementSelect[0].ColumnActivo);
  $(".containerEdit").fadeIn();
  }
  else{
    alert("Por favor, selecciona la fila a modificar");
  }
});


//$("#btnRemove").click(function(){
//    var elementSelect = checkStatusCheckbox(); 
//  if(elementSelect.length > 0){
//  $(".containerEdit").fadeOut();
//  $(".containerAdd").fadeOut();
//
//            var email = $.map($("#tablaDinamica").bootstrapTable('getSelections'), function (row) {
//                return row.ColumnEmail;
//            });
//           /* var activo = $.map($("#tablaDinamica").bootstrapTable('getSelections'), function (row) {
//                return row.ColumnActivo;
//            });*/
//            $("#tablaDinamica").bootstrapTable('remove', {
//                field: 'ColumnEmail',
//                values: email
//            });
// 
//            //var params = "?oper=delete&email="+email+"&activo="+activo;
//            //var params = "?oper=delete&email="+email;
//            var params = FORM_JS_OPER+"="+FORM_JS_OPER_DELETE+"&"+FORM_JS_EMAIL+"="+email;
//
//            $("#params").val(params);
//
//            document.getElementById('actualizaSocios').submit(); 	  
//}
//    else{
//    alert("Por favor, selecciona la fila a eliminar");
//  }
//
//});
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
  var identificadorInput, FundadorInput, indiceFila, fechaAltaInput, activoInput;
  //identificadorInput = $("#editEmail").val().replace("@","arroba");
  identificadorInput = $("#"+FORM_JS_EDIT_EMAIL).val().replace("@","arroba");
  identificadorInput = identificadorInput.replace(".","punto");
  //FundadorInput = $("#editFundador").val();
  FundadorInput = $("#"+FORM_JS_EDIT_FUNDADOR).val();
  fechaAltaInput = $("#"+FORM_JS_EDIT_FECHA_ALTA).val();
  activoInput = $("#"+FORM_JS_EDIT_ACTIVO).val();
  
  indiceFila = $("#"+identificadorInput).attr("data-index");

$("#tablaDinamica").bootstrapTable('updateRow', {
                index: indiceFila,
                row: {
                    ColumnState : false,
                    ColumnId : identificadorInput,
                    ColumnFundador: FundadorInput,
                    ColumnFechaAlta : fechaAltaInput,
                    ColumnActivo : activoInput
                }
            });  
annadeEtiquetas(identificadorInput,indiceFila);
//var email= document.getElementById("editEmail").value;
//var fundador = document.getElementById("editFundador").value; 
//var params = "?oper=update&email="+email+"&fundador="+fundador;
var email= document.getElementById(FORM_JS_EDIT_EMAIL).value;
var fundador = document.getElementById(FORM_JS_EDIT_FUNDADOR).value; 
var fechaAlta = document.getElementById(FORM_JS_EDIT_FECHA_ALTA).value;
var activo = document.getElementById(FORM_JS_EDIT_ACTIVO).value;
var params = FORM_JS_OPER+"="+FORM_JS_OPER_UPDATE+"&"+FORM_JS_EMAIL+"="+email+"&"+FORM_JS_FUNDADOR+"="+fundador+"&"+FORM_JS_FECHA_ALTA+"="+fechaAlta+"&"+FORM_JS_ACTIVO+"="+activo;
$("#params").val(params);

document.getElementById('actualizaSocios').submit();
}



function checkStatusCheckbox(){
return $("#tablaDinamica").bootstrapTable('getSelections');
}


function annadeEtiquetas(identificadorInput,indexRowSelected){
    var elementosFila = '';
    var fila = '';
      $("tr").each(function(index){
        if($(this).attr("data-index")== indexRowSelected){
          fila = $(this);
            elementosFila = $(this)[0].childNodes;
        }
      });
    fila.attr("id",identificadorInput);
    elementosFila[8].className = "ColumnFundador";
}