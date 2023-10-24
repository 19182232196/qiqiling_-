const fs=require('fs');
console.log("查看上一级目录的内容");
fs.readdir("../",function(err,files){
    if (err) throw err;
    files.forEach(function(file){
        console.log(file);
    });
});