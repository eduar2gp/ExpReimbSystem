function updateUserProfile(json) {
	document.getElementById("username").innerText = json.userName
	document.getElementById("useremail").innerText = json.userEmail
	document.getElementById("userFirstName").innerText = json.userFirstName
	document.getElementById("userLastName").innerText = json.userLastName
}


function updateReimbList(reimbursement) {
	let ul = document.getElementById("listReimbPending")
	removeAllChildNodes(ul)
	for (let reimb of reimbursement) {
		let li = document.createElement('li')
		li.setAttribute('class', 'list-group-item')
		li.setAttribute('data-bs-target', '#exampleModalToggle')
		li.setAttribute('data-bs-toggle', 'modal')

		let divMain = document.createElement('div')
		divMain.setAttribute('class', 'reimbursement')
		let div1 = document.createElement('div')
		//const reimbDate = new String(new Date(reimb.reimbSubmittedDate));

		if (reimb.reimbReceipt != null) {
			const blob = b64toBlob(reimb.reimbReceipt, 'image/png');
			const blobUrl = URL.createObjectURL(blob);
			const img = document.createElement('img');
			img.width = 100;
			img.height = 75;

			img.src = blobUrl;
			div1.appendChild(img);
		}

		let h4reimbType = document.createElement('h5')
		h4reimbType.innerText = reimb.reimbType

		let h3reimbAmount = document.createElement('h5')
		h3reimbAmount.innerText = formatter.format(reimb.reimbAmount)
		div1.appendChild(h4reimbType)
		div1.appendChild(h3reimbAmount)

		let div2 = document.createElement('div')

		let h5reimbStatus = document.createElement('h4')
		h5reimbStatus.innerText = reimb.reimbStatus
		if (reimb.reimbStatus == 'Approved') {
			h5reimbStatus.style.color = 'green';
		} else if (reimb.reimbStatus == 'Denied') {
			h5reimbStatus.style.color = 'red';
		}

		let pDesc = document.createElement('p')
		pDesc.innerText = reimb.reimbDescription

		div2.appendChild(h5reimbStatus)
		div2.appendChild(pDesc)

		let div3 = document.createElement('div')
		div3.setAttribute('class', 'dates');

		let h5reimbDate = document.createElement('h5')
		h5reimbDate.innerText = parseFullDate(reimb.reimbSubmittedDate)


		let label = document.createElement('label')
		label.innerText = 'Created'

		let divAux = document.createElement('div')

		divAux.appendChild(label)
		divAux.appendChild(h5reimbDate)
		div3.appendChild(divAux)

		
		divMain.appendChild(div1)
		divMain.appendChild(div2)
		divMain.appendChild(div3)


		let onclick = goto.bind(reimb)
		li.addEventListener('click', onclick)
		li.appendChild(divMain)

		ul.appendChild(li)
	}
}


function updateResolvedReimbList(reimbursement) {
	let ul = document.getElementById("listReimbResolved")
	removeAllChildNodes(ul)
	for (let reimb of reimbursement) {
		let li = document.createElement('li')
		li.setAttribute('class', 'list-group-item')
		let divMain = document.createElement('div')
		divMain.setAttribute('class', 'reimbursement')
		let div1 = document.createElement('div')
		//const reimbDate = new String(new Date(reimb.reimbSubmittedDate));
		if (reimb.reimbReceipt != null) {
			const blob = b64toBlob(reimb.reimbReceipt, 'image/png');
			const blobUrl = URL.createObjectURL(blob);
			const img = document.createElement('img');
			img.width = 100;
			img.height = 75;
			img.src = blobUrl;
			div1.appendChild(img);
		}

		let h4reimbType = document.createElement('h5')
		h4reimbType.innerText = reimb.reimbType
		let h3reimbAmount = document.createElement('h5')
		h3reimbAmount.innerText = formatter.format(reimb.reimbAmount)
		div1.appendChild(h4reimbType)
		div1.appendChild(h3reimbAmount)
		let div2 = document.createElement('div')
		let h5reimbStatus = document.createElement('h4')
		h5reimbStatus.innerText = reimb.reimbStatus
		if (reimb.reimbStatus == 'Approved') {
			h5reimbStatus.style.color = 'green';
		} else if (reimb.reimbStatus == 'Denied') {
			h5reimbStatus.style.color = 'red';
		}

		let pDesc = document.createElement('p')
		pDesc.innerText = reimb.reimbDescription

		div2.appendChild(h5reimbStatus)
		div2.appendChild(pDesc)

		let div3 = document.createElement('div')
		div3.setAttribute('class', 'dates');

		let h5reimbDate = document.createElement('h5')
		h5reimbDate.innerText = parseFullDate(reimb.reimbSubmittedDate)


		let label = document.createElement('label')
		label.innerText = 'Created'

		let divAux = document.createElement('div')

		divAux.appendChild(label)
		divAux.appendChild(h5reimbDate)
		div3.appendChild(divAux)

		if (reimb.reimbResolvedDate != null) {			
			let h5reimbDateResolvedString = parseFullDate(reimb.reimbResolvedDate)
			let h5reimbDateResolved = document.createElement('h5')
			h5reimbDateResolved.innerText = h5reimbDateResolvedString

			let label = document.createElement('label')
			label.innerText = 'Resolved'


			let divAux = document.createElement('div')

			divAux.appendChild(label)
			divAux.appendChild(h5reimbDateResolved)
			div3.appendChild(divAux)
		}

		divMain.appendChild(div1)
		divMain.appendChild(div2)
		divMain.appendChild(div3)


		let onclick = goto.bind(reimb)
		li.addEventListener('click', onclick)
		li.appendChild(divMain)

		ul.appendChild(li)
	}
}

function goto() {
	document.getElementById('reimb_amount').innerText = formatter.format(this.reimbAmount)
	document.getElementById('reimb_type').innerText = this.reimbType
	document.getElementById('reimb_description').innerText = this.reimbDescription
	document.getElementById('reimb_author_username').innerText = this.reimbAuthorUsername
	document.getElementById('reimb_author_email').innerText = this.reimbAuthorEmail
	document.getElementById('reimb_author_firstname').innerText = this.reimbAuthorFirstname
	document.getElementById('reimb_author_lastname').innerText = this.reimbAuthorLastname

	selectedReimbursement.reimbursementId = this.reimbursementId

	if (this.reimbReceipt != null) {
		const contentType = 'image/png';
		const blob = b64toBlob(this.reimbReceipt, contentType);
		const blobUrl = URL.createObjectURL(blob);
		const img = document.getElementById('reimb_image')
		img.width = 350;
		img.height = 250;
		img.src = blobUrl;
		img.style.display = 'inline'
	}
	else{
		const img = document.getElementById('reimb_image')
		img.style.display = 'none'		
	}

}
