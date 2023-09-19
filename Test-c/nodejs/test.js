// const fs = require('fs');
// fs.readFile('./demo.txt', 'utf-8', function (err, dataStr) {
    // if (err) {
        // console.log('No'+err);
    // }
    // console.log('ok'+dataStr);
// })
//** */
//** */
// fs.writeFile('./demo.txt', 'hello world', function (err) {
    // if (err) {
        // console.log(err);
    // }
    // console.log('写入');
// })
//** */
//** */
//------------------------------------------------------------------
const events = require('events');
const myevents = new events.EventEmitter();
myevents.on('say', function (name) { 
    console.log('hello'+name);
});
myevents.emit('say', 'world');