const fs=require('fs');
const path=require('path');
var filePath=path.resolve('../');
fileTraverse(filePath);

function fileTraverse(filePath){
    fs.readdir(filePath,function(err,files){
        if(err){
            console.warn(err);
        }else{
            files.forEach(function(file){
                var fullPath=path.join(filePath,file);
                fs.stat(fullPath,function(eror,stats){
                    if(eror){
                        console.warn("文件不存在");
                    }else{
                        if(stats.isFile()){
                            console.log(fullPath);
                        }
                        if(stats.isDirectory()){
                            fileTraverse(fullPath);
                        }
                    }
                });
            });
        }
    });
}