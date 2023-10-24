const dgram=require('dgram');
const server=dgram.createSocket('udp4');

server.on('error',(err)=>{ 
    console.log(`server error:\n${err.stack}`);
    server.close();
});

server.on('message',(msg,rinfo)=>{
    var strmsg=msg.toString();
    server.send(strmsg,0,strmsg,rinfo.port,rinfo.address);
    console.log(`服务器接收来自: ${rinfo.address} : ${rinfo.port} 的 ${strmsg}`);
});

server.on('listening',()=>{
    const address=server.address();
    console.log(`服务器开始监听 ${address.address}:${address.port}`);
});

server.bind(41234);