const mysql = require("mysql2");
const connection=mysql.createConnection({
    host:"localhost",
    user:"root",
    port:3306,
    password:"484110",
    database:"study"
})
connection.connect()
//定义删除语句
var deSql="DELETE FROM bookinfo WHERE id=10"
//查询命令执行修改
connection.query(deSql,function(err,results){
    if(err){
        console.log("修改失败",err.message)
        return
    }else{
        console.log("修改成功")
        console.log("地址:",results.affectedRows)
    }
})
connection.end()