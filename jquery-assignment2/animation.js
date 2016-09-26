/*Assignment 3
To perform the animation using ajax*/
$(document).ready(init);

/*initialisation function to bind the events with functions*/
function init() {
    $('#start').click(floatRight);
    $('#stop').click(floatStop);
    $('#back').click(floatLeft);
    $('#left').click(moveLeft);
    $('#right').click(moveRight);
    $('#top').click(moveTop);
    $('#bottom').click(moveBottom);
}

/*To move the div 500px towards right*/
function floatRight() {
    $('#myDiv').stop();
    $('#myDiv').animate({
        left: "+=500px"
    }, 2000);
}

/*To stop the current animation*/
function floatStop() {
    $('#myDiv').stop();
}

/*To move the div 500px towards left*/
function floatLeft() {
    $('#myDiv').stop();
    $('#myDiv').animate({
        left: "-=500px"
    }, 2000);
}

/*To move the div 50px towards left*/
function moveLeft() {
    $('#myDiv').animate({
        left: "-=50"
    }, 1000);
}

/*To move the div 50px towards right*/
function moveRight() {
    $('#myDiv').animate({
        left: "+=50"
    }, 1000);
}

/*To move the div 50px towards top*/
function moveTop() {
    $('#myDiv').animate({
        top: "-=50"
    }, 1000);
}

/*To move the div 50px towards bottom*/
function moveBottom() {
    $('#myDiv').animate({
        top: "+=50"
    }, 1000);
}