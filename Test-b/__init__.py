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
