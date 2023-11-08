async function getData() {//声明asy函数
    const mysql = require('mysql2/promise');
    const pool = mysql.createPool({user: 'root',port:'3306' ,password: '484110', database: 'study'})
    //并行执行
    var results=await Promise.all([
        pool.query('SELECT * FROM `bookinfo` WHERE `press`="人民邮电出版社"'),
        pool.query('SELECT * FROM `bookinfo` WHERE `press`="机械工业出版社"')
    ])
    await pool.end()//关闭连接池
    return results//返回结果
}

getData().then(data=>{//获取信息
    console.log(data[0])
    console.log(data[1])
}).catch(error=>{
    console.log(error)
})