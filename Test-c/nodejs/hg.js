const fs=require('fs')
var readStream=fs.createReadStream('./demo.txt','utf8')
var str='';
readStream.on('data',function(chunk){
    str+=chunk;
})
readStream.on('end',function(chunk){
    console.log(str);
    console.log('读取完')
})
readStream.on('error',function(err){
    console.log(err);
    console.log('读取失败')
})
