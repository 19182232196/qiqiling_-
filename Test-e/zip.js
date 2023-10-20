const fs=require('fs');
const zlib=require('zlib');
fs.createReadStream("./demo.txt")
    .pipe(zlib.createGzip())
    .pipe(fs.createWriteStream("./demo.txt.gz"));
console.log("压缩完成");