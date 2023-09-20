# num=input("输入一串数字")
# print(num[::-1])
# name=input("输入名字")
# print(name[::-1])
# ----------------------------------------------------------------------------------------------------------------------
# num=input("输入身份证")
# birth=num[6:10]+"-"+num[10:12]+"-"+num[12:14]
# print(birth))
# ----------------------------------------------------------------------------------------------------------------------
# var=input("请输入电话码")
# num1=int(var[-2:])
# num2=int(var[0:2])
# num2+=num1
# num1+=num2
# num2//=3
# num1%=num2
# print(num1)
# ----------------------------------------------------------------------------------------------------------------------
# str1=input("输入一串字符")
# substr1=str1[0:4]
# substr2=str1[4:8]
# substr3=str1[8:12]
# substr4=str1[12:16]
# substr5=str1[16:20]
# print(substr1,substr2,substr3,substr4,substr5)
#  ---------------------------------------------------------------------------------------------------------------------
# num="澳C-mk416,澳C-mk416,澳C-mk416,澳C-mk416,澳C-mk416,澳C-mk416,澳C-mk416,澳C-mk416"
# new=num.replace("澳C","**")
# print(new)
#  ---------------------------------------------------------------------------------------------------------------------
# word=input("姓名").strip(" ")+"."
# word+=input("身高").strip(" ")+"."
# word+=input("体重").strip(" ")+"."
# print(word)
#  ---------------------------------------------------------------------------------------------------------------------
# num=input("身份证")
# year=int(num[8:10])
# month=int(num[10:12])
# day=int(num[12:14])
# year%=month
# day%=month
# year+=day
# num=year%month
# print(num)
#   --------------------------------------------------------------------------------------------------------------------
# print("输入四句藏头诗")
# word1 = input("输入第一句")
# word2 = input("输入第二句")
# word3 = input("输入第三句")
# word4 = input("输入第四句")
# print(word1[0] + word2[0] + word3[0] + word4[0])
# ----------------------------
# import random
# surname = '赵,钱,孙,李,周,吴,郑,王,冯,陈,褚,卫,蒋,沈,韩,杨,朱,秦,尤,许'
# second = '一,二,三,四,五,六,七,八,九,十'
# third = '一,二,三,四,五,六,七,八,九,十'
# surname_list = surname.split(',')
# second_list = second.split(',')
# third_list = third.split(',')
# num = list(range(100))
# name = random.choice(surname_list) + random.choice(second_list) + random.choice(third_list)
# print(name)
# post = str(random.choice(num)) + str(random.choice(num)) + str(random.choice(num)) + "@qq.com"
# print(post)
# ----------------------------
# num=input("输入一串数字")
# print(num[::-1])
# name=input("输入名字")
# print(name[::-1])
# num2=input("输入身份证")
# birth=num2[6:14]+'-'+num2[14:16]+'-'+num2[16:18]
# print(birth)
# ----------------------------------------------------------------------------------------------------------------------
# str1='62122111111111202'
# substr1=str1[6:14]
# substr2=str1[14:16]
# substr3=str1[16:18]
# print(substr1+' '+substr2+' '+substr3)
# number="澳C-KM516,澳C-KM516,澳C-KM516,澳C-KM516,澳C-KM516,澳C-KM516,澳C-KM516"
# new=number.replace("澳C","**")
# print(new)
# word=input("输入姓名").strip(" ")+"."
# word+=input("输入身高").strip(" ")+"."
# word+=input("输入体重").strip(" ")+"."
# print(word)
# ----------------------------------------------------------------------------------------------------------------------
# num="294961321641649461.16131631303130348"
# order=""
# for i in range(10):
#     count=num.count(str(i))
#     order+=str(i)+":"+str(count)+"\n"
# print(order)
# ----------------------------------------------------------------------------------------------------------------------
# year='''2301
# 1310
# 5656
# 4152'''
# List_year=year.split("\n")
# print(List_year)
# ----------------------------------------------------------------------------------------------------------------------
# import random
# num='qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890'
# word=random.choice(num)
# option=random.choice(num)+random.choice(num)+random.choice(num)+random.choice(num)
# print("验证码", option)
# var=input("请输入验证码：").strip(" ")
# if option.lower()==var.lower():
#     print("验证码正确")
# else:
#     print("验证码错误")
#    -------------------------------------------------------------------------------------------------------------------
# high=input("请输入身高")
# num=5
# for i in high:
#     num+=int(i)
# num+=len(high)
# print(num)
#    -------------------------------------------------------------------------------------------------------------------
# money="1:!@#-Q,2:QWE-W,3:ASD-E,4:ZXCV-R,5:QAZ-T,6:000-Y,7:AZ-U,8:Q-I,9:qW-O,10:azx-P"
# net=money.split(",")
# 
# 
# for i in net:
#     new=i.split(":")
#     print("NO"+new[0]+"+++++"+new[1])
# 
# 
# for i in net:
#     new =i.split(":")
#     character_to_remove = "-"
#     parts=new[1].split(character_to_remove)
#     result=parts[1] if len(parts)>1 else new[1]
#     print("NO"+new[0]+"+++++"+result)
#    -------------------------------------------------------------------------------------------------------------------
# num=input("输入3个字母")
# rev=num[-1::-1]
# upp=num.upper()
# low=rev.lower()
# mid=num.capitalize()
# num=low[1]+mid[1]+rev[1]
# var=num[::-1]
# print(var)
#    -------------------------------------------------------------------------------------------------------------------
# import random
# 
# word = input("输入英文").strip(" ")
# num = 'qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM'
# psw = ""
# save = []
# if not word:
#     print("请输入英文")
# else:
#     for i in word:
#         new = chr(ord(i) + 3)
#         low = random.choice(num)
#         upp = random.choice(num).upper()
#         psw += new + low + upp
#         save.append(psw)
# print("new password", psw)
# save.append(psw)
# print(save)
# 
# 
# word = save[0]
# psw = ""
# for i in range(1, len(word), 3):
#     new = chr(ord(word[i]) + 3)
#     psw += new
# print("oldpassword", psw)
#    -------------------------------------------------------------------------------------------------------------------
