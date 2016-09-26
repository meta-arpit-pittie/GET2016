/*Assignment 1
Finding the largest among three numbers*/

function submitNumber() {
	var val1 = parseInt(document.getElementById('val1').value);
	var val2 = parseInt(document.getElementById('val2').value);
	var val3 = parseInt(document.getElementById('val3').value);
	document.getElementById('result').value = largestNumber(val1,val2,val3);
}

function largestNumber(val1, val2, val3) {
	var max;
	if (val1 > val2) {
		max = val1;
	} else {
		max = val2;
	}

	if (max > val3) {
		return max;
	} else {
		return val3;
	}
}