

function get_Patients(last_name) {
    //console.log(last_name);
    
    var radio_button_id = document.getElementById("search_type_id");
    if (radio_button_id.checked) {
        $.ajax({
            url: "/get_patients_by_id",
            data: {
                last_name: last_name
            },
            success: function( result ) {
                $( "#patients" ).html( "<strong>" + result + "</strong> " );
            }
        });  
    }
    else{
        $.ajax({
            url: "/get_patients_by_last_name",
            data: {
                last_name: last_name
            },
            success: function( result ) {
                $( "#patients" ).html( "<strong>" + result + "</strong> " );
            }
        });  
    }    
  }

  function get_Patients_Modal(last_name) {
    //console.log(last_name);
    $.ajax({
        url: "/get_patients_by_last_name_modal",
        data: {
            last_name: last_name
        },
        success: function( result ) {
            $( "#list" ).replaceWith( result );
            console.log(last_name);
        }
    });   
  }

function get_patient(patient_id) {
    console.log(patient_id);

    var x = document.getElementById("patient_info");
    // var y = document.getElementById("footer_id")
    var z = document.getElementById("welcome_page")
    if (x.style.display === "none") {
            x.style.display = "flex";
    }
    // if(y.style.display === "none"){
    //     y.style.display = "flex";
    // }
    if(z.style.display==="flex"){
        z.style.display = "none";
    }


    $.ajax({
        url: "/get_patient",
        data: {
        patient_id: patient_id
        },
        success: function( result ) {
        $( "#patient_info" ).html(  result );
        }
    });
}

function edit_patient(patient_id) {
    console.log(patient_id+"edit");
    
    $.ajax({
        url: "/edit_patient",
        data: {
        patient_id: patient_id
        },
        success: function( result ) {
        $( "#patient_info" ).html(  result );
        }
    });
}

function get_app_by_id(app_id) {
    console.log(app_id);

    $.ajax({
        url: "/get_app_by_id",
        data: {
        app_id: app_id
        },
        success: function( result ) {
        $( "#modal" ).html(  result );
        $('#modalBox').modal('show');
        }
    });
}

function modalAdd(){
    $.ajax({
        url: "/calendar/add_event",
        success: function( result ) {
            $( "#modal_add" ).html(  result );
            $('#modal_edit').modal('show');
        }
    });
}

function add_fields() {
    var d = document.getElementById("table_body");
   
    d.innerHTML += "<tr>"+
                        "<td>Insurer:</td>"+
                        "<td>"+
                            "<input placeholder='Type' name='company_name' type='text' />"+
                        "</td>"+
                    "</tr>"+
                    "<tr>"+
                        "<td>Name:</td>"+
                        "<td>"+
                            "<input placeholder='Name' name='insurance_number' type='text'/>"+
                        "</td>"+
                    "</tr>"+
                    "<tr>"+
                        "<td>Name:</td>"+
                        "<td>"+
                            "<input placeholder='Description' name='insurance_number' type='text'/>"+
                        "</td>"+
                    "</tr>";
                    
 }

function getDate() {
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth()+1; //January is 0!
    var yyyy = today.getFullYear();

    if(dd<10) {
        dd = '0'+dd
    } 

    if(mm<10) {
        mm = '0'+mm
    } 

    today = yyyy + '/' + mm + '/' + dd;
    console.log(today);
    document.getElementById("date").value = today;
}

(function($) {
    "use strict";

    
    /*==================================================================
    [ Validate ]*/
    var input = $('.validate-input .input100');

    $('.validate-form').on('submit',function(){
        var check = true;

        for(var i=0; i<input.length; i++) {
            if(validate(input[i]) == false){
                showValidate(input[i]);
                check=false;
            }
        }

        return check;
    });


    $('.validate-form .input100').each(function(){
        $(this).focus(function(){
           hideValidate(this);
        });
    });

    function validate (input) {
        if($(input).attr('type') == 'email' || $(input).attr('name') == 'email') {
            if($(input).val().trim().match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/) == null) {
                return false;
            }
        }
        else {
            if($(input).val().trim() == ''){
                return false;
            }
        }
    }

    function showValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).addClass('alert-validate');
    }

    function hideValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).removeClass('alert-validate');
    }
    
    

})(jQuery);
