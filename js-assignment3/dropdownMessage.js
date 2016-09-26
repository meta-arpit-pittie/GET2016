/*Assignment 3
To alert the value of dropdown menu
based on the radio button selected*/

/*To show an alert message based on the radio button choice*/
function showAlert() {
    var choice = document.getElementsByName("choice");
    var message;
    var dropDown;
    
    /*Checking which option is selected*/
    if(choice[0].checked) {
        dropDown = document.getElementById("city");
        message = "City : "+dropDown.options[dropDown.selectedIndex].value;
    } else {
        dropDown = document.getElementById("state");
        message = "State : "+dropDown.options[dropDown.selectedIndex].value;
    }
    window.alert(message);
}