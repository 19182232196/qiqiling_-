const fs=require('fs');
fs.open("./demo.txt","r",function(err,fd){
    if(err) throw err;
    console.log("打开成功");
    var bur = Buffer.alloc(1024);

    fs.read(fd,bur,0,bur.length,0,function(err,bytes){
        if(err){
            fs.closeSync(fd);
            return console.log(err);
        }
        console.log("读取字节长度:"+bytes);
        
        if(bytes>0){
            console.log("读取内容:"+bur.slice(0,bytes).toString());
        }
        fs.closeSync(fd);
    });
});