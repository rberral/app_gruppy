// -------------------- PARAMETROS FORMULARIOS -------------------- //	
 FORM_JS_EDIT_IDENTIFICADOR = 'editIdentificador';
FORM_JS_EDIT_FECHA = 'editFecha';
 FORM_JS_EDIT_NOMBRE = 'editNombre';
 FORM_JS_EDIT_OBSERVACIONES = 'editObservaciones';
 

// Tienen que estar sincronizados con los parametros definidos en Constantes.java
 FORM_JS_OPER_UPDATE = "update";
 FORM_JS_OPER_DELETE = "delete";
 FORM_JS_OPER = '?oper';
 FORM_JS_IDENTIFICADOR = 'identificador'
 FORM_JS_NOMBRE = 'nombre';
 FORM_JS_FECHA = 'fecha';
 FORM_JS_OBSERVACIONES = 'observaciones';
 
$(document).ready(function(){
	

$("#btnEdit").click(function(){
  var elementSelect = checkStatusCheckbox(); 
  if(elementSelect.length > 0){
  $(".containerAdd").fadeOut();
  $("#"+FORM_JS_EDIT_IDENTIFICADOR).val(elementSelect[0].ColumnId);
  $("#"+FORM_JS_EDIT_NOMBRE).val(elementSelect[0].ColumnNombre);
  $("#"+FORM_JS_EDIT_FECHA).val(elementSelect[0].ColumnFecha);
  $("#"+FORM_JS_EDIT_OBSERVACIONES).val(elementSelect[0].ColumnObservaciones);
  $(".containerEdit").fadeIn();
  }
  else{
    alert("Por favor, selecciona la fila a modificar");
  }
});


$("#btnRemove").click(function(){
    var elementSelect = checkStatusCheckbox(); 
  if(elementSelect.length > 0){
  $(".containerEdit").fadeOut();
  $(".containerAdd").fadeOut();

            var id = $.map($("#tablaDinamica").bootstrapTable('getSelections'), function (row) {
                return row.ColumnIdentificador;
            });
           /* var activo = $.map($("#tablaDinamica").bootstrapTable('getSelections'), function (row) {
                return row.ColumnActivo;
            });*/
            $("#tablaDinamica").bootstrapTable('remove', {
                field: 'ColumnIdentificador',
                values: id
            });
 
            var params = FORM_JS_OPER+"="+FORM_JS_OPER_DELETE+"&"+FORM_JS_IDENTIFICADOR+"="+id;

            $("#params").val(params);

            document.getElementById('actualizaInvitados').submit(); 	  
}
    else{
    alert("Por favor, selecciona la fila a eliminar");
  }

});
});


   
function tratamientoFila(accion){
  switch (accion){

  case "alta":
	    insertaFila();
	    break;
	    
    case "actualiza":
    actualizaFila();
    $(".containerEdit").fadeOut();
    break;
  }
}


function actualizaFila(){
  var identificadorInput, nombreInput, indiceFila, fechaInput, observacionesInput;
  identificadorInput = $("#"+FORM_JS_IDENTIFICADOR).val();
  nombreInput = $("#"+FORM_JS_EDIT_NOMBRE).val();
  fechaInput = $("#"+FORM_JS_EDIT_FECHA).val();
  observacionesInput = $("#"+FORM_JS_EDIT_OBSERVACIONES).val();
  
  indiceFila = $("#"+identificadorInput).attr("data-index");

$("#tablaDinamica").bootstrapTable('updateRow', {
                index: indiceFila,
                row: {
                    ColumnState : false,
                    ColumnId : identificadorInput,
                    ColumnNombre: nombreInput,
                    ColumnFecha : fechaInput,
                    ColumnObservaciones : observacionesInput
                }
            });  
annadeEtiquetas(identificadorInput,indiceFila);
var nombre= document.getElementById(FORM_JS_EDIT_NOMBRE).value;
var fecha = document.getElementById(FORM_JS_EDIT_FECHA).value; 
var observaciones = document.getElementById(FORM_JS_EDIT_OBSERVACIONES).value;
var params = FORM_JS_OPER+"="+FORM_JS_OPER_UPDATE+"&"+FORM_JS_NOMBRE+"="+nombre+"&"+FORM_JS_FECHA+"="+fecha+"&"+FORM_JS_OBSERVACIONES+"="+observaciones;
$("#params").val(params);

document.getElementById('actualizaInvitados').submit();
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
    //elementosFila[8].className = "ColumnFundador";
}

$("#btnAdd").click(function(){
	  $(".containerEdit").fadeOut();
	  $(".containerAdd").fadeIn();
	});


function insertaFila(){
	  var identificadorInput, nombreInput, fechaInput, observacionesInput;
	  var posicionInsercionElemento  = 0;
	  identificadorInput = $("#addIdentificador").val();
	  nombreInput = $("#addNombre").val();
	  fechaInput = $("#addFecha").val();
	  observacionesInput = $("#addObservaciones").val();
	  var identificadorValido = checkIdValido(identificadorInput);
	  var evalua = checkValues(nombreInput, fechaInput)
	  if(!evalua){
	    return evalua;
	  }
	    
	    
	  $("#tablaDinamica").bootstrapTable('insertRow', {
	    index: posicionInsercionElemento,
	    row: {
	        ColumnId : identificadorValido,
	        ColumnNombre: nombreInput,
	        ColumnFecha: fechaInput,
	        ColumnObservaciones: observacionesInput
	    }
	  });
	            
	                //añadimos etiquetas a nueva fila
	/*
	                  $("#tablaDinamica tbody tr").each(function(index){
	                    if($(this).attr("data-index")== posicionInsercionElemento){
	                      $(this).attr("id","A"+identificadorInput);
	                      return false;
	                    }
	                  });
	                  */
	                  //var fila = $("#tablaDinamica tbody tr")[posicionInsercionElemento];
	                  //fila.id = "A"+identificadorInput;
	                  annadeEtiquetas(identificadorValido,posicionInsercionElemento);
	       
	                  $(".containerAdd").fadeOut();

	}

function checkIdValido(identificador){
	var encontrado = checkExistId(identificador);
			while(encontrado){
				identificador = identificador + 1;
				encontrado = checkExistId(identificador);
			}
			return identificador;
	}

function checkExistId(identificador){
	  var enc = false;
	  var existe = $("#tablaDinamica").bootstrapTable('getRowByUniqueId',identificador);
	  if(existe instanceof Object){
	    enc = true;
	  }
	  return enc;
	}

function checkValues(nombre, fecha){
	  if(nombre == "" || fecha == ""){
	      alert("Por favor, inserte al menos un nombre y fecha.");
	      return false;
	        }
	  else{
		  return true;
	  }
	}