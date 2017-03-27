$(document).ready(function(){
	

$("#btnEdit").click(function(){
  var elementSelect = checkStatusCheckbox(); 
  if(elementSelect.length > 0){
  $(".containerAdd").fadeOut();
  $("#editEmail").val(elementSelect[0].ColumnEmail);
  $("#editFundador").val(elementSelect[0].ColumnFundador);
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

            var email = $.map($("#tablaDinamica").bootstrapTable('getSelections'), function (row) {
                return row.ColumnEmail;
            });
           /* var activo = $.map($("#tablaDinamica").bootstrapTable('getSelections'), function (row) {
                return row.ColumnActivo;
            });*/
            $("#tablaDinamica").bootstrapTable('remove', {
                field: 'ColumnEmail',
                values: email
            });
 
            //var params = "?oper=delete&email="+email+"&activo="+activo;
            var params = "?oper=delete&email="+email;

            $("#params").val(params);

            document.getElementById('actualizaSocios').submit(); 	  
}
    else{
    alert("Por favor, selecciona la fila a eliminar");
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
  var identificadorInput, FundadorInput, indiceFila;
  identificadorInput = $("#editEmail").val().replace("@","arroba");
  identificadorInput = identificadorInput.replace(".","punto");
  FundadorInput = $("#editFundador").val();

  indiceFila = $("#"+identificadorInput).attr("data-index");

$("#tablaDinamica").bootstrapTable('updateRow', {
                index: indiceFila,
                row: {
                    ColumnState : false,
                    ColumnId : identificadorInput,
                    ColumnFundador: FundadorInput
                }
            });  
annadeEtiquetas(identificadorInput,indiceFila);
var email= document.getElementById("editEmail").value;
var fundador = document.getElementById("editFundador").value; 
var params = "?oper=update&email="+email+"&fundador="+fundador;
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