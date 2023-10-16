num=int(input("输入七天商品销量"))
if num>=1000:
    print("销量为A类")
elif num>=500:
    print("销量为B类")
elif num>=300:
    print("销量为C类")
else:
    print("销量为D类")
