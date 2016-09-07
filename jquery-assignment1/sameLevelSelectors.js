/*Assignment 5
To understand the selectors at the same level
And traverse them*/

$(document).ready(init);

/*To bind the button click with the functions*/
function init() {
    $('#siblings').click(btnSiblings);
    $('#siblingSpecific').click(btnSiblingSpecific);
    $('#next').click(btnNext);
    $('#nextAll').click(btnNextAll);
    $('#nextUntil').click(btnNextUntil);
    $('#prev').click(btnPrev);
    $('#prevAll').click(btnPrevAll);
    $('#prevUntil').click(btnPrevUntil);
}

/*To perform action on the button click*/
function btnSiblings() {
    $('h2').siblings().css("border", "solid black");
}

/*To perform action on the button click*/
function btnSiblingSpecific() {
    $('span').siblings('h5').css("color", "orange");
}

/*To perform action on the button click*/
function btnNext() {
    $('h3').next().css("color", "cyan");
}

/*To perform action on the button click*/
function btnNextAll() {
    $('h5').nextAll().css("font-size", "30px");
}

/*To perform action on the button click*/
function btnNextUntil() {
    $('h2').nextUntil('h6').css("font-family", "Verdana");
}

/*To perform action on the button click*/
function btnPrev() {
    $('h3').prev().css("color", "cyan");
}

/*To perform action on the button click*/
function btnPrevAll() {
    $('h1').prevAll().css("color", "brown");
}

/*To perform action on the button click*/
function btnPrevUntil() {
    $('h4').prevUntil().css("background-color", "lime");
}