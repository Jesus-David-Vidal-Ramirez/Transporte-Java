/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



function validar(e) {
    swal({
        title: "Buen trabajo!", 
        text: "Clickeaste en el boton!", 
        type: "success"
    }).then(function () {
        console.log("Despues de dar click en el boton, aqui llamarias al submit");
    });
    return false;
}
 function validar() {  
     event.preventDefault();
     swal({         
         title: "mal trabajo!",
         text: "Clickeaste en el boton!",
         type: "success",
         confirmButtonText: "Ok"
     }).then((resukt) => {
         if (resukt.value) {
    document.formulario_registro.submit();
    }
        return false;
        });
}

function validar(){
    event.preventDefault();
    Swal.fire({
    title: '¿Seguro de Validar el formulario?',
    type: 'warning',
    showCancelButton: true,
    confirmButtonText: 'Si',
    cancelButtonText: "No",
    confirmButtonColor: '#3085d6',
    cancelButtonColor: '#d33'
  }).then((result) => {
    if (result.value) {
    document.formulario_registro.submit();
    }
    return false;
  });
}

function enviar(){
event.preventDefault();
    Swal.fire({
    title: '¿Seguro de enviar el formulario?',
    type: 'warning',
    showCancelButton: true,
    confirmButtonText: 'Si',
    cancelButtonText: "No",
    confirmButtonColor: '#3085d6',
    cancelButtonColor: '#d33'
  }).then((result) => {
    if (result.value) {
    document.formulario_registro.submit();
    }
    return false;
  });
}