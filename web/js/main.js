/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {

$('#goSearch').click(function () {
if ($('#search').val() === ''){
    console.log("please enter search string");
}
else{
    var type = $('#type').val();
        if (type === 'all') {
            var url = './webresources/search/' + $('#search').val();
            $.getJSON(url, function (data) {
            if (data && data !== null) {
            var outHtml = "";
                    for (var i = 0; i < data.length; i++)
                    //id = data[i].id;
                    outHtml += "<p>" + data[i].name + "<button id=\"details\">Details</button></p>"
                    + "<input type=\"hidden\" id=\"hid\" value=\"" + data[i].id + "\"/>";
            }
            else {
                var outHtml = "<p>No Results found</p>";
            }
                $('#output').html(outHtml);
            });
            }
        else {
            var url = './webresources/search/' + $('#search').val() + '/' + type;
                    $.getJSON(url, function (data) {
                    var outHtml = "";
                            for (var i = 0; i < data.length; i++)
                            //id = data[i].id;
                            outHtml += "<p>" + data[i].name + "<button id=\"details\">Details</button></p>"
                            + "<input type=\"hidden\" id=\"hid\" value=\"" + data[i].id + "\"/>";
                            $('#output').html(outHtml);
                    });
            }
            }
    });
});



