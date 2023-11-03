var resolveAfter=function(){
    console.log("开始慢Promise")
    return new Promise(resolve=>{
        setTimeout(function(){
            resolve("慢")
            console.log("慢Promise完成")
        },1000)
    })
}
var resolveNow=function(){
    console.log("开始快Promise")
    return new Promise(resolve=>{
        setTimeout(function(){
            resolve("快")
            console.log("快Promise完成")
        },500)
    })
}
var seuenStart=async function(){
    console.log("==串行处理==")
    const slow=await resolveAfter()
    console.log(slow)
    const fast=await resolveNow()
    console.log(fast)
}
var concurStart=async function(){
    console.log("==并发处理从await==")
    const slow=resolveAfter()
    const fast=resolveNow()
    console.log(await slow)
    console.log(await fast)
}
var concurPromise=function(){
    console.log("=并行处理从awaitPromise.all=")
    return Promise.all([resolveAfter(),resolveNow()]).then((mess)=>{
        console.log(mess[0])
        console.log(mess[1])
    })
}
var para=async function(){
    console.log("=并行处理从Promise.all=")
    await Promise.all([
        (async()=>console.log(await resolveAfter()))(),
        (async()=>console.log(await resolveNow()))()
    ])
}
var paraP=function(){
    console.log("=并行处理从Promise.then=")
    resolveAfter().then((mess)=>console.log(mess))
    resolveNow().then((mess)=>console.log(mess))
}
seuenStart()
setTimeout(concurStart,2000)
setTimeout(concurPromise,3000)
setTimeout(para,4000)
setTimeout(paraP,5000)