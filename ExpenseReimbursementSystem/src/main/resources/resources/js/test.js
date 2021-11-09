let mySecondaryProcessReturnBoolean = true;
let myGlobalState = 25;


let myCustomPromise = new Promise(
    function (resolvingCallback, rejectingCallback){
        //the logic inside of this function will be your "secondary process"
        console.log("in the customPromise's function");

        if(mySecondaryProcessReturnBoolean){
            let res = {
                "var1" : 1,
                "var2" : "iter"
            }
            resolvingCallback(res);
        }else{
            rejectingCallback("process FAILED!!!!");
        }
    }
);

myCustomPromise
    .then(myResolver)
    .then(myResolver)
    .then(myResolver)
    .catch(myFailFunction)
    .finally( () => {
        console.log("finished successfully")
    })

function myFailFunction(arg){
    console.log(arg)
}


function myResolver(myVar){
    console.log(myVar.var1)
    console.log(myVar.var2)
    console.log("Inside Resolver. This is my promise's message:", myVar);
    let otro = {
        "var1" : myVar.var1 + 1,
        "var2" : myVar.var2 + (myVar.var1 + 1) + ""
    }
    return otro;
}
