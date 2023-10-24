const dgram=require('dgram');
const message=Buffer.from('这是UDP客户端');
const client=dgram.createSocket('udp4');

client.on('close',()=>{
    console.log('客户端关闭');
});

client.on('error',(err)=>{
    console.log('客户端错误',err);
});

client.on('message',(msg,rinfo)=>{
    if(msg=='exit') client.close();
    var strmsg=msg.toString();
    console.log(`客户端收到:${rinfo.address}:${rinfo.port}的${strmsg}`);
});

client.send(message,41234,'localhost',(err)=>{
    if(err) client.close();
});