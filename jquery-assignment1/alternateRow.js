/*Assignment 4
Table having different background color for alternative rows*/
$(document).ready(init)

/*To give different background color to alternate row*/
function init() {
    $('tr:even').css("background-color", "gray");
}