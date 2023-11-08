const mysql = require("mysql2");
const connection=mysql.createConnection({
    host:"localhost",
    user:"root",
    port:3306,
    password:"484110",
    database:"study"
})
connection.connect()
//定义修改参数
var upSql="UPDATE bookinfo SET author=?, price=? WHERE id=?"
var upSqlPar=['6',81.5,9]
//查询命令执行修改
connection.query(upSql,upSqlPar,function(err,results){
    if(err){
        console.log("修改失败",err.message)
        return
    }else{
        console.log("修改成功")
        console.log("地址:",results.affectedRows)
    }
})
connection.end()