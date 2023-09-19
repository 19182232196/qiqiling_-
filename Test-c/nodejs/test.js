const fs = require('fs');
fs.readFile('./demo.txt', 'utf-8', function (err, dataStr) {
    if (err) {
        console.log('No'+err);
    }
    console.log('ok'+dataStr);
})