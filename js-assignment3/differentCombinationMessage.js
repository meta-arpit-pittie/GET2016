/*Assignment 2
To show custom message based on
two radio fields having two options each*/

/*To display the custom message*/
function showMessage() {
    var message = "";
    var side = document.getElementsByName("side");
    var lang = document.getElementsByName("lang");
    
    /*Checking which option is selected*/
    if(side[0].checked) {
        message += "Type of work : "+side[0].value;
    } else {
        message += "Type of work : "+side[1].value;
    }
    
    if(lang[0].checked) {
        message += "\nLanguage used : "+lang[0].value;
    } else {
        message += "\nLanguage used : "+lang[1].value;
    }
    window.alert(message);
}