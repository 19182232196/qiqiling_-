var pro=Promise.resolve(70)
var pro2=82
var pro3=new Promise(function(resolve){
    setTimeout(resolve,1000,95)
})
Promise.all([pro,pro2,pro3]).then(function(value){
    console.log(value)
})