/*Assignment 2
To toggle the visiblity of span using jQuery*/
$(document).ready(init);

/*initialisation function to bind the events with functions*/
function init() {
    $("#toggle").click(toggleSpanVisibility);
}

/*To toggle the visibility of the span
 *To change the value of the button on click*/
function toggleSpanVisibility() {
    $("#message").toggle(300);
    if($(this).text() == "Hide") {
        $(this).text("Show");
    } else {
        $(this).text("Hide");
    }
}