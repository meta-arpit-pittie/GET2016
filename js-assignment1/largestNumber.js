/*Assignment 1
Finding the largest among three numbers*/

function largestNumber() {
	var val1 = parseInt(document.getElementById('val1').value);
	var val2 = parseInt(document.getElementById('val2').value);
	var val3 = parseInt(document.getElementById('val3').value);

	if (val1 > val2) {
		max = val1;
	} else {
		max = val2;
	}

	if (max > val3) {
		document.getElementById('result').value = max;
	} else {
		document.getElementById('result').value = val3;
	}
}