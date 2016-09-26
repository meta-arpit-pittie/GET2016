/*Assignment 1
To set 'Hello World!'on all the labels
having css class 'hello'*/
$(document).ready(init);

/*initialisation function to bind the events with functions*/
function init() {
    $('.hello').text("Hello World!");
}