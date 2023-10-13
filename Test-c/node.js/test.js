var show_day=new Array("一","二","三","四","五","六","日");
var nowTiame=new Date();
var day=nowTiame.getDay();
exports.sayHello=function(name){
    console.log("hello world"+name);
    console.log("today is"+show_day[day-1]);
}