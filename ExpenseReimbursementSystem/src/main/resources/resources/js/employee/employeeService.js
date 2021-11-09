
async function employeeServiceGetUser() {
    const responsePayload = await fetch('http://localhost:9001/api/user')
    const user = await responsePayload.json()
    sessionStorage.user = JSON.stringify(user)    
    updateUserProfile(user)
    employeeServiceGetAllReimbByUserId()
}


async function employeeServiceGetReimbTypes() {
    const payload = await fetch('http://localhost:9001/api/reimb/types')
    const jsonReimbTypes = await payload.json()
    updateReimbTypesSelect(jsonReimbTypes)
}


async function employeeServiceGetAllReimbByUserId() {
    let request = {
        'userId': JSON.parse(sessionStorage.user).userId
    }    
    const responsePayload = await fetch('http://localhost:9001/api/reimbursement', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'authToken': request.name
        },
        body: JSON.stringify(request)
    })
    const reimbursement = await responsePayload.json()
    reimbursementsArray = reimbursement
    updateReimbursemetsList(reimbursement)
}


function onSubmitForm() {
    let amount = document.getElementById("reimb_amount").value
    let description = document.getElementById("reimb_description").value
    let type = document.getElementById("reimb_type").value

    console.log(amount + " " + description + " " + type)

    if (!amount || !description || !type) {
        alert('Fill form')
        return
    }

    let request = {
        'amount': amount,
        'description': description,
        'type': type,
        'user_id': JSON.parse(sessionStorage.user).userId
    }

    const formData = new FormData();
    formData.append('jsonData', JSON.stringify(request));
    const input = document.getElementById('reimbReceipt');

    if (!(input.files.length === 0)) {
        const file = input.files[0];
        formData.append('image', file);
    }

    fetch('http://localhost:9001/api/reimbursement/add', {
        method: 'POST',
        body: formData,
        headers: {
            'authToken': ''
        }
    }).then(result => {
        return result
    }).then(res => {
		resetForm()
        employeeServiceGetAllReimbByUserId()
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
        //window.location = "/"
    }).catch((error) => {
		console.log(error)	
	})
}