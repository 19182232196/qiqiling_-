const http=require('http');
const queryString=require('querystring');
const postData=queryString.stringify({'msg':'This is the client'});
const options={
    hostname:'127.0.0.1',
    port:8081,
    path:'/upload',
    method:'POST',
    headers:{
        'Content-Type':'application/x-www-form-urlencoded;charset-utf-8',
        'Content-Length':Buffer.byteLength(postData)
    }
};
const req=http.request(options,(res)=>{
    console.log(`STATUS:,${res.statusCode}`);
    console.log(`HEADERS:${JSON.stringify(res.headers)}`);
    res.setEncoding('utf8');
    res.on('data',(chunk)=>{
        console.log(`DATA:${chunk}`);
    });
    res.on('end',()=>{
        console.log('No more data in response.');
    });
});
req.on('error',(e)=>{
    console.error(`problem with request: ${e.message}`);
});
req.write(postData);
req.end();