window.onload = () => {
	if (sessionStorage.user != null && sessionStorage.user != 'null') {
		if (JSON.parse(sessionStorage.user).userRoleId == 1) {
			window.location = "/html/employee.html"
		}
		else {
			window.location = "/html/manager.html"
		}
	}
	/*else{
		window.location = "/html/badlogin.html"
	}	*/
}

window.addEventListener("hashchange", function(){
    console.log("Hash changed to", window.location.hash);
    // .... Do your thing here...
});

function checkEmail() {
	if (!validateEmail(document.getElementById('exampleInputEmail1').value)) {
		document.getElementById('emailHelp').style.visibility = "visible";
	}
	else {
		document.getElementById('emailHelp').style.visibility = "hidden";
	}
}
