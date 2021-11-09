window.onload = () => {
	employeeServiceGetUser()
	employeeServiceGetReimbTypes()
}

let reimbursementsArray

function filter() {
	let filteredArray = filterArray(reimbursementsArray, document.getElementById("searchInput").value)
	updateReimbursemetsList(filteredArray)
}

function displayReimb() {	
	removeAllChildNodes(document.getElementById('imageDiv'))
	if (this.reimbReceipt != null) {		
		const img = document.createElement('img');
		img.width = 100;
		img.height = 75;
		img.src = `data:${'image/png'};base64,${this.reimbReceipt}`;
		document.getElementById('imageDiv').appendChild(img);
	}	
	document.getElementById('reimb_author_username').innerText = this.reimbAuthorUsername
	document.getElementById('reimb_author_email').innerText = this.reimbAuthorEmail
	document.getElementById('reimb_author_firstname').innerText = this.reimbAuthorFirstname
	document.getElementById('reimb_author_lastname').innerText = this.reimbAuthorLastname
	document.getElementById('reimb_description').innerHTML = this.reimbDescription
	document.getElementById('reimb_amount').innerText = formatter.format(this.reimbAmount)
	document.getElementById('reimb_type').innerText = this.reimbType

}