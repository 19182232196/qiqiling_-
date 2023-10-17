const fs = require('fs');
console.log("打开文件");
fs.open('./demo.txt','r+',function(err,fd){
    if(err){
        return console.log(err);
    }
    console.log("文件打开成功");
});