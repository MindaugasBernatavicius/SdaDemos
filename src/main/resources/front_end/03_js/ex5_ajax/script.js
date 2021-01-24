console.log("External JS file is being executed");

// https://www.mocky.io/ ... we can create custom responses
// [{"name": "Mindaugas", "surname": "Smolinskas"}, {"name": "Jonas", "surname": "Jonaitis"}]
$("#simple-json-button").click(function () {
    $.ajax({
        url: "http://www.mocky.io/v2/5d026c4b3100002900ab2f7e",
        success: function (result) {
            console.log(result);
            console.log(JSON.stringify(result));
            $("#div1").html(JSON.stringify(result));
        }
    });
});

// creating a table from the response
// $("#table-from-json-button").click(function(){
//     $.ajax({
//         url: "http://www.mocky.io/v2/5d026c4b3100002900ab2f7e",
//         success: function(result){
//             var table =
//                 '<table border="1" style="margin: 10px 0px 10px 0px;">' +
//                     '<thead><tr><th>Name</th><th>Surname</th></tr></thead>' +
//                     '<tbody>';
//                     $.each(result, function(i, item) {
//                         // console.log("Debugging i:" + i);
//                         table += '<tr><td>' + item.name + '</td><td>' + item.surname + '</td></tr>';
//                     });
//                     table += '</tbody></table>';
//             $("#div2").html(table);
//         }
//     });
// });

// Exercise: use the 'i' index to create a table || No. || Name || Surname ||;
// $("#table-from-json-button").click(function(){
//     $.ajax({
//         url: "http://www.mocky.io/v2/5d026c4b3100002900ab2f7e",
//         success: function(result){
//             var table =
//                 '<table border="1" style="margin: 10px 0px 10px 0px;">' +
//                     '<thead><tr><th>No.</th><th>Name</th><th>Surname</th></tr></thead>' +
//                     '<tbody>';
//                     $.each(result, function(i, item) {
//                         table += '<tr><td>' + ++i + '</td><td>' + item.name + '</td><td>' + item.surname + '</td></tr>';
//                     });
//                     table += '</tbody></table>';
//             $("#div2").html(table);
//         }
//     });
// });

// TODO :: let's break the second ajax call, so it would fail. And handle that failure gracefully (print error to the user).
// ... what you will need for this is (1) know how to break the ajax and (2) how to handle ajax errors

$("#table-from-json-button").click(function () {
    $.ajax({
        url: "http://www.mocky.io/v2/5d026c4b3100002900ab2f7e",
        success: function (result) {
            var table =
                '<table border="1" style="margin: 10px 0px 10px 0px;">' +
                '<thead><tr><th>No.</th><th>Name</th><th>Surname</th></tr></thead>' +
                '<tbody>';
            $.each(result, function (i, item) {
                table += '<tr><td>' + ++i + '</td><td>' + item.name + '</td><td>' + item.surname + '</td></tr>';
            });
            table += '</tbody></table>';
            $("#div2").html(table);
        },
        // 0. Simple error handling
        // error: function (resp, exception) {
        //     $('#div2').html("<p style='color: red'>Error, could not retrieve info!</p>")
        // },

        // 1. More complex error handling
        error: function (resp, exception) {
            var msg = '';
            if (resp.status === 0) {
                msg = 'Not able to connect.\n Verify Network.';
            } else if (resp.status == 404) {
                msg = 'Requested page not found. [404]';
            } else if (resp.status == 500) {
                msg = '<h1>Internal Server Error [500].</h1>';
            } else if (exception === 'parsererror') {
                msg = 'Requested JSON parse failed.';
            } else if (exception === 'timeout') {
                msg = 'Time out error.';
            } else if (exception === 'abort') {
                msg = 'Ajax request aborted.';
            } else {
                // very rare
                msg = 'Uncaught Error.\n' + resp.responseText;
            }

            $('#div2').html(msg);
        },
    });
});

// TODO :: sort data as it comes in.
// TODO :: add additional rows to the table using mocky (or you can use Spark framework if you are confident with it);
// TODO :: attach an event handler (onClick()) on each table row, that would display it in XML format, or something else (regular string);
// TODO :: add invalid JSON to mocky for example [{},{}] ommit the "," between array elements - validate the JSON and handle the errors appropriatelly;
// ... for starters you can take a look at this: https://css-tricks.com/snippets/jquery/jquery-json-error-catching/
// TODO :: table appendage feature - new data is added to the ajax endpoint when we press update, it is just appended, not the whole table recreated;
// TODO :: create a completely generalized table, not matter how many collumns and rows the data has, it should adjust accordingly ...
// ... this means you will need to also handle any possible table header name
// TODO :: initially present the data unsorted, but provide the ability to sort by collumn (when user click on the collumn it should sort by it).