/*Assignment 1
To toggle the visiblity of span using javascript*/

/*To toggle the visibility of the span
 *To change the value of the button on click*/
function toggleSpanVisibility() {
    var span = document.getElementById("message");
    var button = document.getElementById("toggle");
    
    /*Checking if the span is hidden or visible*/
    if(span.style.display == "none") {
        span.style.display = "inline";
        button.innerHTML = "Hide";
    } else {
        span.style.display = "none";
        button.innerHTML = "Show";
    }
}