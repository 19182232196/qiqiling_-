setTimeout(()=>{
    console.log('一次定时器')
},2000);

setInterval(()=>{
    console.log('周期定时器')
},3000);

setImmediate(()=>{
    console.log('即时定时器')
});
