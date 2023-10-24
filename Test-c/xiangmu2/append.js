const fs=require('fs');
console.log('追加文件');
fs.appendFile('./1.txt','hello world',(err)=>{
    if(err) throw err;
    console.log('追加成功');
});