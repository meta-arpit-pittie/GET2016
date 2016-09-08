/*Assignment 4
To display the input change value in the empty div
And animate the color change of the input box on the value change*/
$(document).ready(init);

/*initialisation function to bind the events with functions*/
function init() {
    $('#name').on("input paste",function() {
        getValue("#name");
    });
    
    $('#age').on("input paste",function() {
        getValue("#age");
    });
    
    $('#address').on("input paste",function() {
        getValue("#address");
    });
    
    $('#name').on("focusout",function() {
        revertBackground("#name");
    });
    
     $('#age').on("focusout",function() {
        revertBackground("#age");
    });
    
     $('#address').on("focusout",function() {
        revertBackground("#address");
    });
}

/*To animate the input box and get the result change*/
function getValue(inputBox) {
    $('#result').text($(inputBox).attr('placeholder')+' : '+$(inputBox).val());
    $(inputBox).animate({
        backgroundColor: "#bbb",
    }, 'slow');
}

/*To revert the background color to white*/
function revertBackground(inputBox) {
    $(inputBox).animate({
        backgroundColor: "white",
    }, 500);
}