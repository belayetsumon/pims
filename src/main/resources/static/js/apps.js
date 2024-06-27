///  Depeartment subdepartment select
$(document).ready(function () {

    $('#department').change(function () {
        var department = $('#department').val();
        //alert(district);

        $.ajax({
            type: "GET",
            url: "/subdepartment/bydepartment/" + department,
            dataType: 'json',
            success: function (data) {
                var slctSubcat = $('#subDepartment'), option = "Select One";
                slctSubcat.empty();
                for (var i = 0; i < data.length; i++) {
                    option = option + "<option value='" + data[i].id + "'>" + data[i].name + "</option>";
                }
                slctSubcat.append(option);
            }, //success

            error: function (e) {
                alert("Error!");
            } // end error

        });// end ajax

    });// end change function

});// jquery
//  End department select

$(document).ready(function () {
    //alert("Hello");
    $('#district').change(function () {
        var district = $('#district').val();
        //alert(district);

        $.ajax({
            type: "GET",
            url: "/thana/bydistrict/" + district,
            dataType: 'json',
            success: function (data) {
                var slctSubcat = $('#upazila'), option = "Select One";
                slctSubcat.empty();
                for (var i = 0; i < data.length; i++) {
                    option = option + "<option value='" + data[i].id + "'>" + data[i].name + "</option>";
                }
                slctSubcat.append(option);
            }, //success

            error: function (e) {
                alert("Error!");
            } // end error

        });// end ajax

    });// end change function

});// jquery



// J query Form Validator

// file validation for pic
$(document).ready(function () {
    $.validate({
        modules: 'file'
    });
});


/// qr code generator 

var emp_name = document.getElementById("emp_name").innerText;
var emp_mobile = document.getElementById("emp_mobile").value;

var final_value = 'Name :'+emp_name+'Mobile :'+emp_mobile;

$('#exa').qrcode({
    render: "table",
    text: final_value,
    background: "#ffffff",
    foreground: "#000000",
    width: 90,
    height: 90,
    correctLevel: QRErrorCorrectLevel.H
});

//jQuery('#qrcodeCanvas').qrcode({
//		text	: "https://www.jqueryscript.net"
//	});
