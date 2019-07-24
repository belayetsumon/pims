///  Depeartment subdepartment select
$(document).ready(function () {
    //alert("Hello");
    $('#department').change(function () {
        var department = $('#department').val();
        //alert(district);

        $.ajax({
            type: "GET",
            url: "/subdepartment/bydepartment/" + department,
            dataType: 'json',
            success: function (data) {
                var slctSubcat=$('#subDepartment'), option="Select One";
                slctSubcat.empty();
             for(var i=0; i<data.length; i++){
                option = option + "<option value='"+data[i].id + "'>"+data[i].name + "</option>";
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
                var slctSubcat=$('#upazila'), option="Select One";
                slctSubcat.empty();
             for(var i=0; i<data.length; i++){
                option = option + "<option value='"+data[i].id + "'>"+data[i].name + "</option>";
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


//// Js PDF 

function pdfgenerator(){

var pdf = new jsPDF('p', 'mm', 'a4');

pdf.setFontSize(20);
pdf.setFont("times");
pdf.setFontType("bold");
pdf.setTextColor(255, 0, 0);
pdf.text(10,10, 'This is a 20pt Times Bold red string');
}