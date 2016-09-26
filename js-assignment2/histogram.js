/*Assignment 4
To print the Histogram*/
function getNumber() {
    do {
		var rows = prompt("Enter number of rows");
	} while(isNaN(rows));
    return rows;
}

function getLargestNumber(numbers) {
    var max=numbers[0];
    for(var i=1; i < numbers.length; i++) {
        if(numbers[i] > max) {
            max = numbers[i];
        }
    }
    return max;
}

function printHistogram() {
    var numbers = new Array;
    var div = document.getElementById("histogram");
    div.innerHTML = "";
    for(var i=0; i < 4; i++) {
        numbers[i] = parseInt(getNumber());
    }
    
    for(var i = getLargestNumber(numbers); i > 0; i--) {
        var line="";
        for(var j = 0; j < numbers.length; j++) {
            if(numbers[j] >= i) {
                line += "&nbsp;*&nbsp;"
            } else {
                line += "&nbsp;&nbsp;&nbsp;&nbsp;"
            }
        }
        div.innerHTML+=line+"<br/>"
    }
}