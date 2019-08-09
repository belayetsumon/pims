//// Js PDF 

$(document).ready(function () {

    //pdf 다운로드 	
    $("#pdfDownloader").click(function () {
      
        alert("hello");
var doc = new jsPDF();   

doc.html(document.body, {
   callback: function (doc) {
     doc.save("sumon.pdf");
   }
});

    });


})