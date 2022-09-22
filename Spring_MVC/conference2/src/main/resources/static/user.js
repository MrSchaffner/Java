console.log("user.js");

$(document).ready(function(){
    $.ajax({
        url: "http://localhost:8080/conference2/user"
    }).then(function(data){
        $('.fName').append(data.fName);
        $('.lName').append(data.lName);
        $('.age').append(data.age);
    });
});