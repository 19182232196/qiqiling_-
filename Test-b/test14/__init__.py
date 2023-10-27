import random
while True:
    #循环
    s=random.randint(1,6)
    #设置玩家
    com=random.randint(1,6)
    #电脑
    z=input("摇骰子,enter可以继续。")
    print('电脑出的是:',com)
    print('你出的是:',s)
    a=int(s)
    b=int(com)
    #看结果
    if a==b:
        print('心有灵犀!')
    elif a<=b:
        print('输了!')
    else:
        print('你赢了!')
    #玩家设置,是否再来一次？
    j=input('1：是 2：否继续？')
    if j.lower()=="1":
        print("来一局!")
    else:
        exit()#退出界面