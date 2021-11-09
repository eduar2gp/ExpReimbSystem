window.onload = () => {
	console.log('window loaded')
	managerServiceGetUser()
}

let selectedReimbursement = {}
let pendingReimbArray
let resolvedReimbArray


function filter(){
	let filteredPending = filterArray(pendingReimbArray, document.getElementById('searchInput').value)
	let filteredResolved = filterArray(resolvedReimbArray, document.getElementById('searchInput').value)	
	updateReimbList(filteredPending)
	updateResolvedReimbList(filteredResolved)
}