import random

# 增加一个随机数。
while True:
    # 循环玩耍。
    print('石头 剪刀 布？')
    player = input('请选择:')
    if player.lower() == "石头" or player.lower() == "剪刀" or player.lower() == "布":
        com = ["石头", "剪刀", "布"]
        # 字典参数
        computer = random.choice(com)
        print('你出拳:', player)
        print('电脑出拳:', computer)
        # 你和电脑的结果
        if player == computer:
            print("儿童对手,情战天明。>_<")
        elif player == "石头" and computer == "剪刀":
            print("赢了!")
        elif player == "剪刀" and computer == "布":
            print("赢了!")
        elif player == "布" and computer == "石头":
            print("赢了!")
            # 判断一个条件。
        else:
            print('输了!')
            # 判断输的条件。
        o = input('还要继续玩吗？按(输入)Q可以退出。')
        # 请问是否退出？
        if o.lower() == 'q':
            exit()
            break

            # 退出
    else:
        print('正确输入')
        # 用户是否正确输入。
