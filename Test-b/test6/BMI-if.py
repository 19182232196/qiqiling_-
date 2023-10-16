wei=float(input("体重kg"))
hig=float(input("身高cm"))
bmi=float(format((wei/hig**2,"1f")))
if bmi<18.5:
    print("偏瘦")
elif 24.9>=bmi>=18.5:
    print("正常")
elif  29.9>=bmi>=24.9:
    print("超重")
else:
    print("肥胖")
