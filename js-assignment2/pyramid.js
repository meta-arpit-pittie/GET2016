/* Assignment 2
Print a pyramid */

function forPyramid() {
	var rows = getRows();
    var div = document.getElementById("for");
    div.innerHTML="";

	for(var i=1; i <= rows; i++) {
        var line="";
		for (var j = i; j <= rows; j++) {
			line += "&nbsp;&nbsp;&nbsp;";
		}
		for(var j=0; j < (i*2)-1; j++) {
			line += "* ";
		}
		div.innerHTML+=line+"<br/>";
	}
}

function whilePyramid() {
	var rows = getRows();
    var div = document.getElementById("while");
    div.innerHTML="";

    var i = 1;
	while(i <= rows) {
        var line="";
        var j = i;
		while(j <= rows) {
			line += "&nbsp;&nbsp;&nbsp;";
            j++;
		}
        j = 0;
		while(j < (i*2)-1) {
			line += "* ";
            j++;
		}
		div.innerHTML+=line+"<br/>";
        i++;
	}
}

function doWhilePyramid() {
	var rows = getRows();
    var div = document.getElementById("doWhile");
    div.innerHTML="";

	var i = 0;
	do {
        var line="";
        var j = i;
		do {
			line += "&nbsp;&nbsp;&nbsp;";
            j++;
		}while(j <= rows-1);
        j = 0;
		do {
			line += "* ";
            j++;
		}while(j < (i*2)+1);
		div.innerHTML+=line+"<br/>";
        i++;
	}while(i < rows);
}

function getRows() {
    do {
		var rows = prompt("Enter number of rows");
	} while(isNaN(rows));
    return rows;
}