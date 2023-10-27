const http=require('http');
const server=http.createServer((req,res)=>{
    console.log('Server is URL'+req.url);
    res.writeHead(200,{'Content-Type':'text/html;charset-utf-8'});
    res.write("<head> <meta charset='UTF-8'></head>");  //解决乱码
 
    res.write('解决乱码');
 
    res.end();  //结束响应

}).listen(8081,()=>{
    console.log('The server starts');
});