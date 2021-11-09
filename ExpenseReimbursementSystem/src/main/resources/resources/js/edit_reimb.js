window.onload = () => {
	getReimbStatus()
}


async function getReimbStatus(){
	const payload = await fetch('http://localhost:9001/api/reimb/status')
	const reimbStatus = await payload.json()
	updateReimbStatusSelect(reimbStatus)	
}

function updateReimbStatusSelect(reimb){
	let select = document.getElementById('reimb_status')
	for(let r of reimb){
		let option = document.createElement('option')
		option.value = r.reimbStatusId
		option.innerText = r.reimbStatus
		select.appendChild(option)
	}	
}




console.log(sessionStorage.reimb)
document.getElementById('reimb_description').innerText = JSON.parse(sessionStorage.reimb).reimbDescription


function save(){
	
	let reimb = JSON.parse(sessionStorage.reimb)
	reimb.reimbResolverId = JSON.parse(sessionStorage.user).userId
	reimb.reimbStatusId = document.getElementById('reimb_status').value
	
	console.log(JSON.stringify(reimb))
	
	fetch('http://localhost:9001/api/reimbursement', {
		method: 'PUT',
		headers: {
			'authToken': JSON.parse(sessionStorage.user).userId			
		},
		body: JSON.stringify(reimb)
	}).then( (result) => {
		return result
	}).then( (res)=> {
		console.log(res)		
	})		
}