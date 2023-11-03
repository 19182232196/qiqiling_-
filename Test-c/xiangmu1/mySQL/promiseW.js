const pro=require("mysql2/promise").createPool({
    user:'root',
    port:3306,
    password:'484110',
    database:'study'
})
pro.getConnection().then(conn=>{
    const res=conn.query("select * from `bookinfo`")
    conn.release()
    return res
}).then(result=>{
    console.log(result)
}).catch(err=>{
    console.log(err)
})