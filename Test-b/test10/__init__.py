def f():
    global choice, yourobject, choice2, Hp, Hunger, obj1, obj2, obj3, obj4, obj5, obj6, obj7, nun, koo, Def, Atk, uplimit
    while True:
        try:
            choice = int(input('\n>>(查看人物状态，返回1；查看物品栏，返回2):'))
            break
        except:
            print('error')
    if choice == 1:
        print('查看人物状态')
        print('生命：' + str(Hp) + '\n' + '饥饿：' + str(Hunger) + '\n' + '攻击：' + str(Atk) + '\n' + '防御：' + str(Def))
    if choice == 2:
        print('查看物品栏')
        print(sorted(yourobject.values()))
        if sorted(yourobject.values()) == []:
            print('物品栏为空！')
            koo = 1
        else:
            while True:
                try:
                    choice2 = int(input('是否使用物品？（是：1；否；2）:'))
                    koo = 0
                    break
                except:
                    print('error')
        if choice2 == 1 and koo == 0:
            while True:
                try:
                    nun = int(input('请输入将使用物品的序号:'))
                    break
                except:
                    print('error')
            print('你使用了' + yourobject1[nun])
            if obj1 >= 2 and nun == 1:
                obj1 -= 1
                Hunger += 80
                if Hunger >= uphunger:
                    Hunger = uphunger
                    print('###############饥饿已达上线！')
                else:
                    print('Hunger+80')
                yourobject[1] = str(1) + '牛肉干' + '×' + str(obj1)

            elif obj1 == 1 and nun == 1:
                yourobject.pop(nun)
                Hunger += 80
                if Hunger >= uphunger:
                    Hunger = uphunger
                    print('###############饥饿已达上线！')
                else:
                    print('Hunger+80')
            elif obj2 >= 2 and nun == 2:
                obj2 -= 1
                Hp += 50
                if Hp >= uplimit:
                    Hp = uplimit
                    print('###############血量已达上线！')
                else:
                    print('Hp:+50')
                yourobject[2] = str(2) + '旺仔牛奶' + '×' + str(obj2)
            elif obj2 == 1 and nun == 2:
                yourobject.pop(nun)
                Hunger += 1
                Hp += 50
                if Hp >= uplimit:
                    Hp = uplimit
                    print('###############血量已达上线！')
                else:
                    print('Hp:+50')
            elif obj3 >= 2 and nun == 3:
                obj3 -= 1
                Atk += 15
                Hp += 90
                if Hp >= uplimit:
                    Hp = uplimit
                    print('###############血量已达上线！')
                    print('攻击+15')
                else:
                    print('Hp:+90\n攻击+15')
                yourobject[3] = str(3) + '红牛' + '×' + str(obj3)
            elif obj3 == 1 and nun == 3:
                yourobject.pop(nun)
                Atk += 15
                Hp += 90
                if Hp > uplimit:
                    Hp = uplimit
                    print('###############血量已达上线！')
                    print('攻击+15')
                else:
                    print('Hp:+90\n攻击+15')
            elif obj4 >= 2 and nun == 4:
                obj4 -= 1
                Hunger += 100
                if Hunger >= uphunger:
                    Hunger = uphunger
                    print('###############饥饿已达上线！')
                else:
                    print('Hunger+100')
                yourobject[4] = str(4) + '鱼肉罐头' + '×' + str(obj4)
            elif obj4 == 1 and nun == 4:
                yourobject.pop(nun)
                Hunger += 100
                if Hunger >= uphunger:
                    Hunger = uphunger
                    print('###############饥饿已达上线！')
                else:
                    print('Hunger+100')
            elif obj5 >= 2 and nun == 5:
                obj5 -= 1
                Def += 10
                print('防御+10')
                yourobject[5] = str(5) + '健力多' + '×' + str(obj5)
            elif obj5 == 1 and nun == 5:
                yourobject.pop(nun)
                Def += 10
                print('防御+10')
            elif obj6 >= 2 and nun == 6:
                obj6 -= 1
                uplimit += 300
                print('生命上限+300')
                yourobject[6] = str(6) + '肾宝片' + '×' + str(obj6)
            elif obj6 == 1 and nun == 6:
                yourobject.pop(nun)
                uplimit += 300
                print('生命上限+300')
            elif obj7 >= 2 and nun == 7:
                obj7 -= 1
                Atk += 1
                Def += 1
                print('攻击+1\n防御+1')
                yourobject[7] = str(7) + '彩虹糖' + '×' + str(obj7)
            elif obj7 == 1 and nun == 7:
                yourobject.pop(nun)
                Atk += 1
                Def += 1
                print('攻击+1\n防御+1')
    if choice == 2019:
        print('获得一枚肾宝片！！！')
        name = '肾宝片'
        q()
        obj6 += 1
        yourobject[6] = str(6) + name + '×' + str(obj6)
        yourobject1[6] = name
    elif choice == 520:
        Atk += 200
    elif choice == 1314:
        Def += 50


def g():
    global time, choice1
    while True:
        try:
            print('\n现在是{}，你该如何行动？\n>>1.搜索物资；2.打开菜单栏；3.在庇护所修整'.format(timedic[time]))
            choice1 = int(input('>>你的选择是（输入1或2或3）？:'))
            break
        except:
            print('error')


def t():
    enter = input('(enter继续游戏)')
    if enter == '':
        pass


def t1():
    enter = input('(enter继续战斗！)\n')
    if enter == '':
        print('\n' + '*' * 50)


def w():
    global Hp, die, tap
    ff = randint(0, 50)
    if ff == 12 or ff == 5 or ff == 28 or ff == 44:
        print('\n糟糕！\n出现了僵尸头目！！！')
        Hp -= 50
        print('经过战斗，你损失了50点HP\n-50Hp')
    elif tap == 1:
        print('你遭遇了尸潮！！！')
        Hp -= 300
        print('受到重创！！！\nHp-300')
        die = 1
    elif ff > 30 and ff < 40:
        print('\n糟糕！\n出现了普通僵尸！！！')
        Hp -= 10
        print('经过战斗，你损失了10点HP\n-10Hp')
    else:
        print('\n你没有惊动丧尸。\n')


def w1():
    global monster, Hp, Hp1
    print('{}发现了你！！！\n你将面临苦战！'.format(monster))
    t()
    while Hp > 0 and Hp1 > 0:
        first = randint(0, 1)
        if first == 0:
            print('>>{}的回合！\n'.format(monster))
            w2()
            t1()
        elif first == 1:
            print('>>你的回合！\n')
            w3()
            t1()


def w2():
    global Atk1, Def, Hp, Hp1
    mon1 = randint(1, 10)
    if mon1 == 1:
        if Atk1 <= Def:
            print('miss')
        else:
            Hp -= (Atk1 - Def)
            print(
                '>{}抬起了血腥的利爪，一记重击！               {}的HP：{}\n                                                   你的HP：{}\n***对你造成了{}点伤害！'.format(
                    monster, monster, Hp1, Hp, Atk1 - Def))
    else:
        if Atk1 <= 3 * Def:
            print('miss')
        else:
            Hp -= (Atk1 - 3 * Def)
            print(
                '>{}抬手进行了普通攻击！               {}的HP：{}\n                                              你的HP：{}\n***对你造成了{}点伤害！'.format(
                    monster, monster, Hp1, Hp, Atk1 - 3 * Def))


def w3():
    global monster, Atk, Def1, Hp1, Hp
    you = randint(1, 10)
    if you == 1:
        if 2 * Atk <= Def1:
            print('miss')
        else:
            Hp1 -= (2 * Atk - Def1)
            print(
                '>你打出了致命一击！！！               {}的HP：{}\n                                          你的HP：{}\n***对{}造成了{}点伤害！！！'.format(
                    monster, Hp1, Hp, monster, 2 * Atk - Def1))
    else:
        if Atk <= Def1:
            print('miss')
        else:
            Hp1 -= (Atk - Def1)
            print(
                '>你打出了普通攻击！               {}的HP：{}\n                                   你的HP：{}\n***对{}造成了{}点伤害！！！'.format(
                    monster, Hp1, Hp, monster, Atk - Def1))


def h():
    global obj1, obj2, name, obj3, obj4, obj5, obj6, obj7
    print('开始搜索！')
    obj = randint(1, 40)
    if obj == 1 or obj == 4 or obj == 7:
        name = '牛肉干'
        q()
        obj1 += 1
        yourobject[1] = str(1) + name + '×' + str(obj1)
        yourobject1[1] = name
    elif obj == 14 or obj == 17 or obj == 20 or obj == 21:
        name = '旺仔牛奶'
        q()
        obj2 += 1
        yourobject[2] = str(2) + name + '×' + str(obj2)
        yourobject1[2] = name
    elif obj == 2 or obj == 8 or obj == 13:
        name = '红牛'
        q()
        obj3 += 1
        yourobject[3] = str(3) + name + '×' + str(obj3)
        yourobject1[3] = name
    elif obj == 24 or obj == 11 or obj == 10:
        name = '鱼肉罐头'
        q()
        obj4 += 1
        yourobject[4] = str(4) + name + '×' + str(obj4)
        yourobject1[4] = name
    elif obj == 5 or obj == 15:
        name = '健力多'
        q()
        obj5 += 1
        yourobject[5] = str(5) + name + '×' + str(obj5)
        yourobject1[5] = name
    elif obj == 9:
        name = '肾宝片'
        q()
        obj6 += 1
        yourobject[6] = str(6) + name + '×' + str(obj6)
        yourobject1[6] = name
    elif obj == 40 or obj == 33 or obj == 35 or obj == 37:
        name = '彩虹糖'
        q()
        obj7 += 1
        yourobject[7] = str(7) + name + '×' + str(obj7)
        yourobject1[7] = name

    else:
        print('你什么都没找到！')
        t()


def q():
    global name
    print('恭喜你，获得了' + name)
    t()


yourobject = {}
yourobject1 = {}
obj1 = 0
obj2 = 0
obj3 = 0
obj4 = 0
obj5 = 0
obj6 = 0
obj7 = 0
Hp = 250
uplimit = 250
Hp1 = 550
Hunger = 300
uphunger = 300
Day = 0
time = 1
choice1 = 0
name = ''
name2 = ''
a = ''
monster = ''
choice2 = 100
koo = 0
tap = 0
Atk = 22
Atk1 = 70
Def = 10
Def1 = 20
die = 0
timedic = {1: '清晨6点', 2: '中午12点', 3: '下午2点', 4: '傍晚6点', 5: '午夜12点'}
from random import *

while Hp > 0:
    Day += 1
    time = 1
    tap = 0
    print('\n>>你被庇护所外丧尸的吼叫吵醒了，你活到了第{}天！######'.format(Day))
    if Day == 1:
        print(
            '末世的第一天，整座城市都被丧尸袭击了，交通瘫痪，电力受损。\n清晨6点，面对着突如其来的一切，你感到了迷茫与无助。')
    elif Day == 7:
        print('\n事态似乎愈来愈严重了！\n')
        t()
        monster = '【䘮爆者】'
        w1()
        if Hp <= 0:
            print('你死了！')
            break
        elif Hp1 <= 0:
            print('{}已经死亡！'.format(monster))
            print('\n>>>>获得一枚肾宝片！！！')
            name = '肾宝片'
            q()
            obj6 += 1
            yourobject[6] = str(6) + name + '×' + str(obj6)
            yourobject1[6] = name
    elif Day == 22:
        print('\n你不确定是否还有活人！\n')
        t()
        monster = '【尸王】'
        Hp1 += 3000
        Atk1 += 200
        Def1 += 50
        w1()
        if Hp <= 0:
            print('你死了！')
            break
        elif Hp1 <= 0:
            print('{}已经死亡！'.format(monster))
            print('\n>>>>获得一枚肾宝片！！！')
            name = '肾宝片'
            q()
            obj6 += 1
            yourobject[6] = str(6) + name + '×' + str(obj6)
            yourobject1[6] = name
    t()
    while time <= 5:
        g()
        if choice1 == 1:
            time += 1
            Hunger -= 10
            print('\n饥饿让你行动迟缓！  Hunger-10\n')
            h()
            if time == 6:
                tap = 1
            w()
            if die == 1 and Hp <= 0:
                print('你在尸潮中死亡！')
                break
        elif choice1 == 2:
            time = time
            f()
        elif choice1 == 3:
            time += 1
            Hp += 30
            if Hp >= uplimit:
                Hp = uplimit
                print('###############血量已达上线！无需休息！')
            else:
                print('Hp:+30')

    if Hunger <= 0:
        Hp += Hunger
        print('饥饿让你抓狂！\n你损失了{}点Hp\n-{}Hp'.format(abs(Hunger), abs(Hunger)))
print('gameover')
input('123:')
