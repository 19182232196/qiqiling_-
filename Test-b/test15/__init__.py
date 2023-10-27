import random


def pj():
    zj = int(random.randint(200, 500))
    while True:
        print("你有", zj, "w(交了手续费)")
        ss = int(input('请选择 1.初级房 2.中级房 3.高级房 4.大师赛'))
        if ss == 1:
            if zj <= 0:
                print('钱不够,至少需要0w。')
            else:
                print("恭喜加入初级")
                dz = int(input("请你下赌注:"))
                s = random.randint(1, 6)
                # 设置玩家
                com = random.randint(1, 6)
                # 电脑
                z = input("摇骰子,enter可以继续。")
                print('对手出的是:', com)
                print('你出的是:', s)
                a = int(s)
                b = int(com)
                # 看结果
                if a == b:
                    print('没有任何一方赢得赌注。')
                elif a <= b:
                    print('输了!')
                    zj = int(zj - dz)
                    print("还剩", zj, "w")
                else:
                    print('赢了!')
                    zj = int(zj + dz)
                    print("还剩", zj, "w")
        elif ss == 2:
            if zj <= 50:
                print('钱不够,至少需要50w。')
            else:
                print("恭喜加入中级")
                dz = int(input("请你下赌注:"))
                s = random.randint(1, 6)
                # 设置玩家
                com = random.randint(1, 6)
                # 电脑
                z = input("摇骰子,enter可以继续。")
                print('对手出的是:', com)
                print('你出的是:', s)
                a = int(s)
                b = int(com)
                # 看结果
                if a == b:
                    print('没有任何一方赢得赌注。')
                elif a <= b:
                    print('输了!')
                    zj = int(zj - dz)
                    print("还剩", zj, "w")
                else:
                    print('赢了!')
                    zj = int(zj + dz)
                    print("还剩", zj, "w")
        elif ss == 3:
            if zj <= 100:
                print('钱不够,至少需要100w。')
            else:
                print("恭喜加入高级")
                dz = int(input("请你下赌注:"))
                s = random.randint(1, 6)
                # 设置玩家
                com = random.randint(1, 6)
                # 电脑
                z = input("摇骰子,enter可以继续。")
                print('对手出的是:', com)
                print('你出的是:', s)
                a = int(s)
                b = int(com)
                # 看结果
                if a == b:
                    print('没有任何一方赢得赌注。')
                elif a <= b:
                    print('输了!')
                    zj = int(zj - dz)
                    print("还剩", zj, "w")
                else:
                    print('赢了!')
                    zj = int(zj + dz)
                    print("还剩", zj, "w")
        elif ss == 4:
            if zj <= 1000:
                print('钱不够,至少需要1000w。')
            else:
                print("恭喜加入大师")

                dz = int(input("请你下赌注:"))
                s = random.randint(1, 6)
                # 设置玩家
                com = random.randint(1, 6)
                # 电脑
                z = input("摇骰子,enter可以继续。")
                print('对手出的是:', com)
                print('你出的是:', s)
                a = int(s)
                b = int(com)
                # 看结果
                if a == b:
                    print('没有任何一方赢得赌注。')
                elif a <= b:
                    print('输了!')
                    zj = int(zj - dz)
                    print("还剩", zj, "w")
                else:
                    print('赢了!')
                    zj = int(zj + dz)
                    print("还剩", zj, "w")


pj()


