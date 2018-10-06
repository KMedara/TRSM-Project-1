window.onload = function() {
	getLoginInfo();
}
function getLoginInfo() {
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			let login = JSON.parse(xhttp.responseText);
			setValues(login);
		}
	}

	xhttp.open("GET",
			'http://localhost:8080/TRMSProject/html/riemburstment.do', true);
	xhttp.send();
}
function setValues(login) {
	document.getElementByName("username").innerHTML = "Your username is: " + // user.uname;
	document.getElementByName("password");
}
function getReimburstmant(form) {
	document.getElementbyId()
}
function getUserRegistration() {
	document.getElementByName("username");
	document.getElementByName("firstname");
	document.getElementByName("lastname");
	document.getElementByName("password");
	document.getElementByName("email");
	document.getElementByName("role");
}
function addEventListener() {
	var radios = document.forms["register"].elements["role"];
	for (var i = 0, max = radios.length; i < max; i++) {
		radios[i].onclick = function() {
			alert(this.value);
		}
	}
}