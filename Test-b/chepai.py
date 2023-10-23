switcher={"MA":"Fuzhou","SH":"Shanghai","SZ":"Shenzhen","CQ":"Chongqing","HD":"Hangzhou","HB":"Hubei","HN":"Hunan"}
car_input=input("请输入车牌号：")
result=switcher.get(car_input, "nuthing")
if  result=="nuthing":
    print("输入错误")
else:
    print(result)