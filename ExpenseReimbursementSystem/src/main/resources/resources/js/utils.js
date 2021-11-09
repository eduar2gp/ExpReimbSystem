function filterArray(reimbursementsArray, filterText) {    
    console.log("in utils filter function " + filterText)
    let filteredArray = reimbursementsArray.filter(
        (myValue, myIndex, myArray) => {
            //return a boolean value, anything true will appear in the new array, anything false will not    			
            if (myValue.reimbDescription.toLowerCase().indexOf(filterText.toLowerCase()) != -1) {
                return true;
            }
            if (myValue.reimbType.toLowerCase().indexOf(filterText.toLowerCase()) != -1) {
                return true;
            }
            if (myValue.reimbStatus.toLowerCase().indexOf(filterText.toLowerCase()) != -1) {
                return true;
            }
            return false
        }
    );
    return filteredArray;
}

function removeAllChildNodes(parent) {
    while (parent.firstChild) {
        parent.removeChild(parent.firstChild);
    }
}

var formatter = new Intl.NumberFormat('en-US', {
  style: 'currency',
  currency: 'USD',

  // These options are needed to round to whole numbers if that's what you want.
  //minimumFractionDigits: 0, // (this suffices for whole numbers, but will print 2500.10 as $2,500.1)
  //maximumFractionDigits: 0, // (causes 2500.99 to be printed as $2,501)
});

const b64toBlob = (b64Data, contentType = '', sliceSize = 512) => {
    const byteCharacters = atob(b64Data);
    const byteArrays = [];
    for (let offset = 0; offset < byteCharacters.length; offset += sliceSize) {
        const slice = byteCharacters.slice(offset, offset + sliceSize);

        const byteNumbers = new Array(slice.length);
        for (let i = 0; i < slice.length; i++) {
            byteNumbers[i] = slice.charCodeAt(i);
        }

        const byteArray = new Uint8Array(byteNumbers);
        byteArrays.push(byteArray);
    }
    const blob = new Blob(byteArrays, { type: contentType });
    return blob;
}

function showModal() {
    var myModal = new bootstrap.Modal(document.getElementById('myModal'), {
        keyboard: false
    })    
    myModal.show()
}


function validateEmail(email) {
    const re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
  }
  
  
  const _monthNames = ['','January','February','March','April','May','June','July','August','September','October','November','December'];

function parseDate(d) {
    d = Number(d);     
    var tp =  new Date(d);
    return `${_monthNames[tp.getMonth()+1]} ${tp.getDate()}, ${tp.getFullYear()}`;
}

function parseFullDate(d) {
    d = Number(d);     
    var tp =  new Date(d);
    return `${tp.getDate()} ${_monthNames[tp.getMonth()+1]} ${tp.getFullYear()} \n ${tp.getHours()}:${tp.getMinutes()}`;
}


