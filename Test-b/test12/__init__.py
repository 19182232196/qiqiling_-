import random

while True:
    def c():
        while True:
            sk = input('继续哦?1=是 2=否')
            if sk.lower() == "1":
                ss()
            elif sk.lower() == "2":
                exit()
            else:
                print("重新输入。")


    def ss():
        a = int(input('请你输入最小的数字:'))
        b = int(input('请你输入最大的数字:'))
        nums = random.randint(a, b)
        while True:
            s = int(input('输入你猜的数字:'))

            if s == nums:
                print("有灵犀,一点通。")

                c()
            elif s <= nums:
                print("太小了。")
            else:
                print("大了。")


    ss()

