function* gF(i){
    yield+"积分"+i
    yield+"积分"+(i+10)
    return+"积分"+(i+20)
    yield+"积分"+(i+30)
    yield+"积分"+(i+30)
    yield+"积分"+(i+30)
}
var g = gF(10)
console.log(g.next())
console.log(g.next())
console.log(g.next())
