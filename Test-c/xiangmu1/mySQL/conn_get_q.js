const mysql = require('mysql2');

const connection = mysql.createConnection({
   host: 'localhost',
   user: 'root',
   port: 3306,
   password: '484110',
   database: 'testmydb',
   dateStrings: true
});
connection.connect();

connection.query('SELECT * FROM`bookinfo`WHERE`press`="人民邮电出版社"', 
function (err, results, fields) {
      if (err){
         console.log('[查询错误 ]', err.message);
         return;
      }
      console.log('--------------------------');
      console.log("结果",results);
      console.log('--------------------------');
      console.log("结果字段",fields);
});
connection.end();