function watchFilm() {
	document.getElementsByTagName('iframe')[0].style.display='block';
	document.getElementById('clickme').style.display='none';
	document.getElementsByClassName('picture')[0].style.display='none';
}

var meowing = '../../sound/Cat-meowing-and-purring-sound.mp3';
var barking = '../../sound/Dog-barking-on-the-city-street-sound-effect.mp3';

function giveSound(img) {
	if(img.src.substring(img.src.lastIndexOf('/'),img.src.indexOf('.png')) === '/cartoon-cat-free')
		var audio = new Audio(meowing);
	else
		var audio = new Audio(barking);
	
	audio.play();
}

function mouseOverMe() {
	document.getElementsByTagName('p')[0].innerHTML = 'Once again!';
}
