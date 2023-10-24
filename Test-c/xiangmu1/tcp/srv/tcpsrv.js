const net=require("net");
var clientNO=0;

const server=net.createServer((client)=>{

    clientNO++;
    console.log(clientNO+"客户端已连接");
    client.on('end',()=>{
        console.log(clientNO+"客户端断开连接");
    });

    client.write(clientNO+'号客户端,你好\r\n');
    client.pipe(client);
    client.on('data',(data)=>{
        console.log(clientNO+"客户端发送数据:"+data.toString());
    });
});

server.on('error',(err)=>{
    throw err;
});

server.listen(8234,()=>{
    console.log("服务器启动成功");
});