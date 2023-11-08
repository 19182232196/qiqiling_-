const mysql = require("mysql2");
const connection=mysql.createConnection({
    host:"localhost",
    user:"root",
    port:3306,
    password:"484110",
    database:"study"
})
connection.connect()
//定义增加参数
var addSql="INSERT INTO bookinfo(`id`,`isbn`,`name`,`author`,`press`,`price`,`pubdate`) VALUES (?,?,?,?,?,?,?)"
var addSqlPar=[11,123456789,'QWER',"ASDF","ZXCV",99.99,"2000-01-01"]
//查询命令执行修改
connection.query(addSql,addSqlPar,function(err,results){
    if(err){
        console.log("修改失败",err.message)
        return
    }else{
        console.log("修改成功")
        console.log("地址:",results.affectedRows)
    }
})
connection.end()