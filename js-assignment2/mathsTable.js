/*Assignment 3
To print mathematical table of any number*/

function printTable() {
    var number;
    var div = document.getElementById("table");
    do {
		number = prompt("Enter number");
	} while(isNaN(number));
    
    var table=""
    for(var i=1; i <= 10; i++) {
        table += number+" * "+i+" = "+(number * i)+"<br/>";
    }
    div.innerHTML=table;
}