const fs=require('fs');
const zlib=require('zlib');
fs.createReadStream('./demo.txt.gz')
    .pipe(zlib.createGzip())
    .pipe(fs.createWriteStream('./demo.txt'));
console.log('ok');