import random


def flla():
    input("结束了！")
    assd = input('是否重生？')
    if assd.lower() == "是":
        po()
    else:
        exit()


def sag():
    sss = random.randint(30, 50)
    g = 50 - sss
    print('还剩:', g, "点血")
    k = random.randint(30, 50)
    l = g - k
    print('还剩:', l, "点血")


def sa():
    input('回车开始战斗')
    sag()


def po():
    a = random.randint(1, 4)

    if a == 1:

        po = "突然尸潮,一大群僵尸狂奔过来。"
        print("", po)
        s = input("1:是 2:否进行战斗?")
        if s.lower() == "1":
            print("拿起旁边的散弹枪封死了一群僵尸。")
            print("他们身上掉下来一张")
            s = input("1:查看 2:离开")
            if s.lower() == "1":
                print("上面写着前往碧...")
                print("等你看完你便被僵尸病毒感染,毒发身亡。")
                exit()
            else:
                print("你没有管。")
                print("在外面你发现了一家超市。")
                s = input("1:是 2:否进入超市。")
                if s.lower() == "1":
                    print("你找到了两包弹药和一个急救箱。")
                    print("继续往前走。")
                    print("你发现了一个巨大的建筑。")
                    s = input("1:查看 2:离开")
                    if s.lower() == "1":
                        print("上面写着庇护所")
                        print("你走了进去")
                        print("你发现了一个医院")
                        s = input("1:是 2:否进入医院。")
                        if s.lower() == "1":
                            print("你进去发现了一个护士，护士赶忙叫你往急诊\n",
                                  "你被检查出了有丧尸病毒,还好及时被医生检查。")
                            print("你感谢了医生，但医生却叫你不要出去。")
                            s = input("1:留着 2:离开")
                            if s.lower() == "1":
                                print("突然停水停电。")
                                print("大群僵尸涌泪进来，还有当时的护士")
                                print("你含着泪把枪打爆了僵尸。")
                                print('找到了所有人!')
                                s = input("1:联盟 2:离开 3:死")
                                if s.lower() == "1":
                                    print("成功组建的联盟,开始四处收复丧尸")
                                    s = input("1:好人 2:坏人")
                                    if s.lower() == "1":
                                        print("还有一位英明的领导者，成功走向巅峰。")
                                    else:
                                        print("因为你是暴君，被丧尸将你的联盟铲掉。")
                                        flla()
                                elif s.lower() == "3":
                                    print("念之前的护士，你自杀。")
                                    flla()
                                else:
                                    print("回到家中,整天喝酒,使人杀死。")
                                    flla()
                            else:
                                print("你离开了这里,从此隐居。")
                                flla()
                        else:
                            print("你没有管。")
                            print("你感觉一阵剧痛。")
                            s = input("1:是 2:否用急救包。")
                            if s.lower() == "1":
                                print("你感觉一阵舒爽。\n", "在高兴时时两只僵尸涌过来把你击杀了。")
                                flla()
                            else:
                                print("在外面你毒发身亡。\n", "临死前,发现两只僵尸朝你出来...")
                                flla()

                    else:
                        print("你没有管。")
                        print("你感觉一阵剧痛。")
                        s = input("1:是 2:否用急救包。")
                        if s.lower() == "1":
                            print("你感觉一阵舒爽。\n", "在高兴时时两只僵尸涌过来把你击杀了。")
                            flla()
                        else:
                            print("在外面你毒发身亡。\n", "临死前,发现两只僵尸朝你出来...")
                            flla()
                else:
                    print("你再次回到家。")
        else:
            print("你被僵尸感染了。")

            print("你死了。")
            flla()


    elif a == 2:
        po = "你忽然感到肚中饥饿。"
        print("", po)
        s = input("1:是 2:否外出寻找?")
        if s.lower() == "1":
            print("你走出屋外看见远处有一间小房子。")
            print("你斩杀了一只僵尸\n", "找到了一大块面包和一瓶被污染的水。")
            s = input("1:面包 2:水")
            if s.lower() == "1":
                ss = random.randint(30, 90)
                print("你被恢复了", ss, "饥饿值。")
                if ss >= 60:
                    print("恢复了饥饿。")
                    print("你感觉好了一些，回到了房子。")



            else:
                print("你严重中毒了。\n", "几乎中毒身亡。")
                s = input("是否使用医疗包？1:是 2:否")
                if s.lower() == "1":
                    print("你感觉好了一些。")

                else:

                    print("当初把你领进屋子的人,忽然笑着走进来,一刀把你砍死了。")
                    flla()
        else:
            print("头昏眼花,似乎即将要死。")
            s = input("1:是 2:否外出寻找?")
            if s.lower() == "1":
                print("你走出屋外看见远处有一间小房子。")
                print("你斩杀了一只僵尸\n", "找到了一大块面包和一瓶被污染的水。")
                s = input("1:面包 2:水")
                if s.lower() == "1":
                    ss = random.randint(30, 90)
                    print("你被恢复了", ss, "饥饿值。")
                    if ss >= 60:
                        print("恢复了饥饿。")
                        print("你感觉好了一些，回到了房子。")
            else:
                print("你死了。")
                flla()
    elif a == 3:
        po = "一只僵尸突然跑进了你的屋子。"
        print("", po)
        s = input("1:是 2:否进行击杀?")
        if s.lower() == "1":
            sa()
            print("你用刀一下斩杀了僵尸。")
            ss = random.randint(1, 110)
            print("你被扣除了", ss, "饥饿值。")
            if ss >= 100:
                print("被饿死了。")
                flla()
        else:
            print("更多涌进来的僵尸把你五马分尸。")
            flla()
    elif a == 4:
        po = "房门突然被打开，当初那个人现在拿着刀子。"
        print("", po)
        s = input("1:是 2:否进行战斗?")
        if s.lower() == "1":
            print("拿起旁边的散弹枪打爆了他的脑袋。")
            print("他身上掉下来一张")
            s = input("1:查看 2:离开")
            if s.lower() == "1":
                print("上面写着快把他引进电厂，他是最后几个继承者，一定要救下他。")
                print("等你看完你热泪盈眶。")
            else:
                print("你没有管。")
                print("先在屋内休息。")
                s = input("1:是 2:否出去")
                if s.lower() == "1":
                    print("其他人发现那个人没有出来狂涌进来乱逛打死人。")
                    exit()
        else:
            print('他把事情都告诉了你，你明白了。')
            print('他是为了救你。')
            print('他让你跟他走。')

            s = input("1:是 2:否离开这里。")
            if s.lower() == "1":
                print("外面还有一群人。")
                print("他们拦着你来到一个巨大的建筑群。")
                s = input("1:查看 2:离开")
                if s.lower() == "1":
                    print("上面写着庇护")
                    print("等你看完你热泪盈眶。")
                    s = input("1:联盟 2:离开 ")
                    if s.lower() == "1":
                        print("成功组建的联盟,开始四处收复丧尸")
                        s = input("1:好人 2:坏人")
                        if s.lower() == "1":
                            print("还有一位英明的领导者，成功走向巅峰。")
                        else:
                            print("因为你是暴君，被丧尸将你的联盟铲掉。")
                            flla()
                    else:
                        print("回到家中,整天喝酒,使人杀死。")
                        flla()
            else:
                print("你跟着他们一起走。")
                s = input("1:联盟 2:离开 ")
                if s.lower() == "1":
                    print("成功组建的联盟,开始四处收复丧尸")
                    s = input("1:好人 2:坏人")
                    if s.lower() == "1":
                        print("还有一位英明的领导者，成功走向巅峰。")
                    else:
                        print("因为你是暴君，被丧尸将你的联盟铲掉。")
                        flla()

                else:
                    print('又回到了家里。')


print("世界丧尸横行，到处都充满了危机，在这危机的时刻,涌现出了一批人。")
input('回车继续')
print('他往往带着武器,寻找着幸存者,图在这末世界建立出一片生机。')
input('按回车继续')
a = input('你愿意吗？')

if a.lower() == "愿意":
    print("欢迎你的加入。")
    print("他把你引进了一间屋子，然后走了。")
    while True:
        po()

else:
    print('跟我一起毁灭吧。')
    exit()