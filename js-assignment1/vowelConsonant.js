/*Assignment 2
To find a character is consonant or vowel*/
function checkVowel() {
	var pattern = new RegExp("[aeiou]","i");
	var str = document.getElementById('toCheck').value;

	if(str.length === 1) {
		if (pattern.test(str)) {
			document.getElementById('result').innerHTML = "It is a vowel";
		} else {
			document.getElementById('result').innerHTML = "It is a consonant";
		}
	} else {
		if(str.length < 1) {
			document.getElementById('result').innerHTML = "Enter a character";
		} else {
			document.getElementById('result').innerHTML = "Enter single character only";
		}
	}
}