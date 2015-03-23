/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    $('#goSearch').click(function () {
        if ($('#search').val() === '') {
            alert("please enter search string");
            console.log("please enter search string");
        }
        else {
            var type = $('#type').val();
            if (type === 'all') {
                var url = './webresources/search/' + $('#search').val();
                $.getJSON(url, function (data) {
                    if (data && data !== null) {
                        var outHtml = "";
                        for (var i = 0; i < data.length; i++)
                            outHtml += "<p>" + data[i].name + "&nbsp<button id=\"save\" onclick=\"save(" + data[i].id + ")\">Save</button></p>"
                                    + "<input type=\"hidden\" id=\"hid\" value=\"" + data[i].id + "\"/>"
                                    + "<p>" + data[i].address + "</p>"
                                    + "<p>" + data[i].phone + "</p>";
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
                         outHtml += "<p>" + data[i].name + "&nbsp<button id=\"save\" onclick=\"save(" + data[i].id + ")\">Save</button></p>"
                                    + "<input type=\"hidden\" id=\"hid\" value=\"" + data[i].id + "\"/>"
                                    + "<p>" + data[i].address + "</p>"
                                    + "<p>" + data[i].phone + "</p>";
                    $('#output').html(outHtml);
                });
            }
        }
    });


    $('#goSaved').click(function () {
        if ($('#savedSearch').val() === '') {
            alert("please enter search string");
            console.log("please enter search string");
        }
        else {
            var type = $('#typeSaved').val();
            if (type === 'all') {
                var url = './webresources/saved/' + $('#savedSearch').val();
                $.getJSON(url, function (data) {
                    if (data && data !== null) {
                        var outHtml = "";
                        for (var i = 0; i < data.length; i++)
                            outHtml += "<p>" + data[i].name + "</p>"
                                    + "<input type=\"hidden\" id=\"hid\" value=\"" + data[i].id + "\"/>"
                                    + "<p>" + data[i].address + "</p>"
                                    + "<p>" + data[i].phone + "</p>";
                    }
                    else {
                        var outHtml = "<p>No Results found</p>";
                    }
                    $('#output').html(outHtml);
                });
            }
            else {
                var url = './webresources/saved/' + $('#savedSearch').val() + '/' + type;
                $.getJSON(url, function (data) {
                    var outHtml = "";
                    for (var i = 0; i < data.length; i++)
                        //id = data[i].id;
                        outHtml += "<p>" + data[i].name + "</p>"
                                    + "<input type=\"hidden\" id=\"hid\" value=\"" + data[i].id + "\"/>"
                                    + "<p>" + data[i].address + "</p>"
                                    + "<p>" + data[i].phone + "</p>";
                    $('#output').html(outHtml);
                });
            }
        }
    });
});


function save(id) {
    console.log("id:" + id);
//    var url = './webresources/saved/';
//                    $.post(url, id, function (data) {
//                    var outHtml = "";
//                                                    
//                            outHtml += "<p>" + data + "</p>";
//                            $('#output').html(outHtml);
//                    });
    $.ajax({
        url: 'webresources/saved',
        method: 'POST',
        data: {'id': id},
        success: function (data) {
            $('#output').text(data);
        }
    });
}



