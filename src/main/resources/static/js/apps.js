///  Depeartment subdepartment select
//$(document).ready(function () {
//    //alert("Hello");
//    $('#department').change(function () {
//        var department = $('#department').val();
//       alert(department);
//
//        $.ajax({
//            type: "GET",
//            url: "/pims/subdepartment/bydepartment/" + department,
//            dataType: 'json',
//            success: function (data) {
//                var slctSubdepat=$('#subDepartment'), option="Select One";
//                slctSubdepat.empty();
//             for(var i=0; i<data.length; i++){
//                option = option + "<option value='"+data[i].id + "'>"+data[i].name + "</option>";
//            }
//            slctSubdepat.append(option);
//            }, //success
//
//            error: function (e) {
//                alert(e);
//            } // end error
//
//        });// end ajax
//
//    });// 
//});// jquery
//  End department select



$(document).ready(function () {
    //alert("Hello");
    $('#district').change(function () {
        var district = $('#district').val();
        //alert(district);

        $.ajax({
            type: "GET",
            url: "/pims/thana/bydistrict/" + district,
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