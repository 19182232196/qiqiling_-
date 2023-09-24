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
# str1 = "www.baidu.com"
# print(str1[0])#w
# print(str1[5])#a
# print(str1[-1])#m
# print(str1[-5])#u
# print(str1[0:5])#www.b
# print(str1[5:8])#aid
# print(str1[6:5])#
# print(str1[6:-1])#aidu.
# print(str1[0:5:-1])#w.baid
# -------------------------------------------
# str1 = "pink red andy tom and bob"
# print(str1.replace("and", "&"))#pink red &y tom & bob
# print(str1.replace("red", "**", 1))#pink ** andy tom and bob
# print(str1.replace("red", "&", 2))#pink & andy tom and bob
# str2 = "*hello*"
# print(str2.lstrip("*"))#hello*
# print(str2.rstrip("*"))#*hello
# print(str2.strip("*"))#hello
# -------------------------------------------
# str1 = "andy and tom and jack and bob and lily and job"
# print(str1.count('a'))#7
# print(str1.count('a', 5))#6
# print(str1.count('o', 11))#2
# print(str1.find('a'))#0
# print(str1.find('an'))#0
# print(str1.find('hello'))#-1
# print(str1.find('an', 5))#5
# print(str1.index('a'))#0
# print(str1.index('and'))#0
# print(str1.index('and', 3))#5
# print(len('test'))#2
# print(len(str1))#46
# -------------------------------------------
# s1 = "hello"
# s2 = "red yellow blue"
# s3 = "apple,orange,banana"
# print(s1.split())  # ['hello']
# print(s2.split())  # ['red', 'yellow', 'blue']
# print(s3.split(','))  # ['apple', 'orange', 'banana']
# print(s3.split(',', 1))  # ['apple', 'orange,banana']
# print(s2.split('y', 1))  # ['red ', 'ellow blue']
# print(s2.split(' ', 2))  # ['red', 'yellow', 'blue']
# -------------------------------------------
# s1 = "hello world"
# s2 = "You are a good BOY"
# print(s1.upper())#HELLO WORLD
# print(s2.upper())#YOU ARE A GOOD BOY
# print(s1.lower())#hello world
# print(s2.lower())#you are a good boy
# print(s1.title())#Hello World
# print(s1.capitalize())#Hello world
# -------------------------------------------
# print(range(6))
# for i in range(2, 6, 2):
#     print(i)  # 2 4
# -------------------------------------------
# arr=['red','green','black']
# for i in arr:
#     print(i)
# ----------------------------------------------------------------------------------------------------------------------
# arr = [1, 2, 3, 4]
# print(arr)
# arr.append(9)
# print(arr)
#
# arr.extend([99])
# print(arr)
#
# arr.insert(2, 999)
# print(arr)
# ----------------------------------------------------------------------------------------------------------------------
# arr = ['red', 'green', 'primary', 'white', 'black']
# del arr[2]
# print(arr)
# arr.remove('red')
# print(arr)
#
# arr[1] = 'cold'
# print(arr)
# ----------------------------------------------------------------------------------------------------------------------
# arr = [75, 85, 12, 17, 18, 19, 13]
# print(arr)
# arr.sort()
# print(arr)
# arr.sort(reverse=True)
# print(arr)
# ----------------------------------------------------------------------------------------------------------------------
# arr = [95, 62, 54, 12, 78, 99, 87, 65, 43, 21]
# print(sum(arr))
# ----------------------------------------------------------------------------------------------------------------------
# import random
# print("彩球号码\n")
# lan = []
# lan.append(str(random.randint(1, 33)))
# lan.append(str(random.randint(1, 33)))
# lan.append(str(random.randint(1, 33)))
# lan.append(str(random.randint(1, 33)))
# lan.append(str(random.randint(1, 33)))
# lan.append(str(random.randint(1, 33)))
# blue = str(random.randint(1, 16))
# print(" ".join(lan) + " " + blue)
# ----------------------------------------------------------------------------------------------------------------------
# test = '''lmy 546,zhb 656,zjl 609,zzh 541,sml 578,yjh 476,gnp 598,whm 687'''
# new = []
# stad = test.split(", ")
# for i in stad:
#     lin = i.split(" ")
#     new.append([lin[1], lin[0]])
# new.sort(reverse=True)
# for i in new:
#     print([i[1], i[0]])
# test_max = max(new)
# test_min = min(new)
# print("最高分：", test_max[0], "，最高分的人：", test_max[1])
# print("最低分：", test_min[0], "，最低分的人：", test_min[1])
# ----------------------------------------------------------------------------------------------------------------------
# print("===报名系统===")
# term=[]
# for i in range(1,5):
#     order=format(i,"0>3")
#     name=input("名字")
#     money=int(input("金额"))
#     term.append([order,name,money])
# print("===报名统计===")
# term.reverse()
# for i in term:
#     print(i[0],i[1],i[2])
# tup=tuple(a[2] for a in term)
# total=sum(tup)
# print("总金额：",total)
# ----------------------------------------------------------------------------------------------------------------------
# print("===打分系统===")
# print('=' * 40)
# score = []
# data = input("七次打分，按空格分隔")
# score = data.split(" ")
# print(score)
# print('去掉最大', str(min(score)))
# print('去掉最小', str(max(score)))
# score.remove(min(score))
# score.remove(max(score))
# digit = [float(i) for i in score]
# avg = format(sum(digit) / len(digit), '.2f')
# print('平均分', avg)
# ----------------------------------------------------------------------------------------------------------------------
