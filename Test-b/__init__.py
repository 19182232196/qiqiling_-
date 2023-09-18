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
