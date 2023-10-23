car_price={"微型车":10,"小型车":20,"中型车":30,"大型车":40,"紧凑型车":50,"跑车":60,"SUV":70,"MPV":80,"房车":90}
car_input=input("请输入车型").strip()
sch_price=car_price.get(car_input,"nothing")
if sch_price!="nothing":
    print(sch_price)
else:
    print("车型不存在")