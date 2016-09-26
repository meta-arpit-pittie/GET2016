/*Assignment 2
To display employee detail: Name, email, dob, address
on selecting the employee in dropdown*/
$(document).ready(init);

/*initialisation function to bind the events with functions*/
function init() {
    $('#employeeName').change(getDetails);
}

/*To get the details from the file*/
function getDetails() {
    $.getJSON('json/employeeDetail.json',display);
}

/*To populate the table with the selected employee detail*/
function display(data) {
    $('table').css("display", "block");
    $('.error').css("display", "none");
    switch($('#employeeName').val()) {
        case "abcd" :
            $('#name').text(data.abcd.name);
            $('#email').text(data.abcd.email);
            $('#dob').text(data.abcd.dob);
            $('#address').text(data.abcd.address);
            break;
        case "lmno" :
            $('#name').text(data.lmno.name);
            $('#email').text(data.lmno.email);
            $('#dob').text(data.lmno.dob);
            $('#address').text(data.lmno.address);
            break;
        case "xyz" :
            $('#name').text(data.xyz.name);
            $('#email').text(data.xyz.email);
            $('#dob').text(data.xyz.dob);
            $('#address').text(data.xyz.address);
            break;
        default :
            console.log("default");
            $('table').css("display", "none");
            $('.error').text("Please select employee name").css('display','block');
    }
}