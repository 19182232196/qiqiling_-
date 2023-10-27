import random


def ui():
    y = 0
    t = int(y)
    zj = int(random.randint(200, 500))
    while True:

        zi = ["香蕉", "苹果", "西瓜", "哈密瓜", "桃子"]
        zid = ["香蕉", "苹果", "西瓜", "哈密瓜", "桃子"]
        zids = ["香蕉", "苹果", "西瓜", "哈密瓜", "桃子"]
        zidsd = ["香蕉", "苹果", "西瓜", "哈密瓜", "桃子"]
        f = random.choice(zi)
        o = random.choice(zid)
        l = random.choice(zids)
        k = random.choice(zidsd)
        t = int(t + 1)
        print("第", t, "次:", f, o, l, k)
        if t == 5:
            print("没有!")
            zj = int(zj - 100)
            print("还剩", zj, "筹码")
            po()
        else:
            "香蕉" == int(1)
            "苹果" == int(2)
            "西瓜" == int(3)
            "哈密瓜" == int(4)
            "桃子" == int(5)
            if f == o == l == k:
                input("呃，奖励10000筹码")
                print('赢了!')
                zj = int(zj + 10000)
                print("还剩", zj, "筹码")
                po()
            elif f == o == l or f == l == k or o == l == k:
                input("呃，奖励100筹码")
                print('赢了!')
                zj = int(zj + 100)
                print("还剩", zj, "筹码")
                po()


def po():
    d = input("一会儿再玩?enter==再玩一次 1=退出")
    if d.lower() == "1":
        exit()
    else:
        ui()


ui()