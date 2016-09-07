/*Assignment 3
To write selectors for different combinations*/
$(document).ready(init);

/*To bind the button click with the functions*/
function init() {
    $("#btn1").click(questionOneAction);
    $("#btn2").click(questionTwoAction);
    $("#btn3").click(questionThreeAction);
    $("#btn4").click(questionFourAction);
    $("#btn5").click(questionFiveAction);
    $("#btn6").click(questionSixAction);
    $("#btn7").click(questionSevenAction);
    $("#btn8").click(questionEightAction);
    $("#btn9").click(questionNineAction);
    $("#btn10").click(questionTenAction);
}

/*To perform action on the button click*/
function questionOneAction() {
    $('span.message').css("color","yellow");
}

/*To perform action on the button click*/
function questionTwoAction() {
    $('div.box:first').css("background-color", "green");
}

/*To perform action on the button click*/
function questionThreeAction() {
    $('button').css("background-color", "brown");
}

/*To perform action on the button click*/
function questionFourAction() {
    $('img[alt="hello"]').css("color", "red");
}

/*To perform action on the button click*/
function questionFiveAction() {
    $('#myDiv').find('input[type="text"]').css("border", "solid red");
}

/*To perform action on the button click*/
function questionSixAction() {
    $('input[name^="txt"]').css("border", "solid green");
}

/*To perform action on the button click*/
function questionSevenAction() {
    $('p:not(.box)').css("color", "orange");
}

/*To perform action on the button click*/
function questionEightAction() {
    $('div.box, div.correct').css("background-color", "gray");
}

/*To perform action on the button click*/
function questionNineAction() {
    $('div.correct.box').css("background-color", "lime");
}

/*To perform action on the button click*/
function questionTenAction() {
    $('div#myDiv span.info').css("color", "violet");
}