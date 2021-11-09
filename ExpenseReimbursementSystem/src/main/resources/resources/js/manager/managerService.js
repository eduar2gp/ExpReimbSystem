async function managerServiceGetUser() {
	const responsePayload = await fetch('http://localhost:9001/api/user')
	const user = await responsePayload.json()
	console.log('user ' + JSON.stringify(user))
	sessionStorage.user = JSON.stringify(user)
	updateUserProfile(user)	
	managerServiceGetPendingReimb()
}


async function managerServiceGetPendingReimb() {
	await fetch('http://localhost:9001/api/reimbursement', {
		method: 'GET',
		headers: {
			'authToken': JSON.parse(sessionStorage.user).userId
		}
	}).then((result) => {
		//console.log(result)
		return result.json()
	}).then((reimb) => {		
		pendingReimbArray = reimb
		updateReimbList(reimb)
		getResolvedReimbByUser()
	}).catch((error) => {
		console.log(error)		
	})
}


async function getResolvedReimbByUser() {
	let userID = {
		'userId': JSON.parse(sessionStorage.user).userId
	}
	await fetch('http://localhost:9001/api/reimbursement', {
		method: 'POST',
		headers: {
			'authToken': JSON.parse(sessionStorage.user).userId
		},
		body: JSON.stringify(userID)
	}).then((result) => {
		return result.json()
	}).then((reimb) => {
		console.log(reimb)
		resolvedReimbArray = reimb
		updateResolvedReimbList(reimb)
	}).catch((error) => {
		console.log(error)
		//window.location = "/"		
	})
}

function denyReimb() {
	selectedReimbursement.reimbStatusId = 3
	updateReimb(selectedReimbursement)
}

function approveReimb() {
	selectedReimbursement.reimbStatusId = 2
	updateReimb(selectedReimbursement)
}

function updateReimb(selectedReimbursement){
	fetch('http://localhost:9001/api/reimbursement', {
		method: 'PUT',
		headers: {
			'authToken': JSON.parse(sessionStorage.user).userId
		},
		body: JSON.stringify(selectedReimbursement)
	}).then((result) => {
		return result
	}).then((res) => {
		console.log(res)
		managerServiceGetPendingReimb()
	})	
}


async function logout() {
	await fetch('http://localhost:9001/api/user/logout', {
		method: 'POST',
		headers: {
			'Accept': 'application/json',
			'Content-Type': 'application/json',
			'authToken': JSON.parse(sessionStorage.user).userId
		},
		//body: JSON.stringify(request)
	}).then((result) => {
		console.log(result)
		return result
	}).then((res) => {
		console.log(res)
		sessionStorage.user = null
		window.location = "/"
	})
}