const net=require('net');
var client=net.Socket();

client.connect(8234, '127.0.0.1',()=>{
    console.log('连接成功');
    client.write('你好，服务端');
});

client.on('data',(data)=>{
    console.log('服务器返回数据'+data.toString());
});

client.on('end',()=>{
    console.log('连接关闭');
});