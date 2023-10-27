import random as rd
import time
import threading
import os


# 生命体
class Life:
    def __init__(self, name='LIFE', life=100, attack=100, defend=100, money=300):
        self.name = name
        self.life = life
        self.attack = attack
        self.defend = defend
        self.money = money
        self.vis_lt = []

    def fight(self):
        pass


# 武器装备,技能
class Weapon:
    def __init__(self):
        pass


# 英雄
class Hero(Life):
    def __init__(self, name='镜', life=3000, attack=200, defend=100, money=300, ocu_name='打野'):
        super().__init__(name, life, attack, defend, money)
        self.ocu_name = ocu_name
        self.move()
        self.kill_monster = 0
        self.kill_hero = 0

        self.hurt_level = self.attack  # 伤害水平

    def __str__(self):
        return '%s:%s life:%s attack:%s defend:%s money:%s position:%s' % (
            self.ocu_name, self.name, self.life, self.attack, self.defend, self.money, self.position)

    # 1英雄随机运动寻找目标
    def move(self):
        enemy = monster
        if isinstance(enemy, Monsters) and len(enemy.mst_lt) != 0:
            count = 0
            while len(self.vis_lt) < 1:  # 视野空 可在此设置最小同时打野数
                count += 1
                self.p_x = rd.randrange(0, 400, 10)
                self.p_y = rd.randrange(0, 400, 10)
                self.position = (self.p_x, self.p_y)
                for mon in enemy.mst_lt:
                    if abs(mon.p_x - self.p_x) <= 20 and abs(mon.p_y - self.p_y) <= 20:  # 视野范围20x20
                        self.vis_lt.append(mon)  # 发现野怪
                        mon.vis_lt.append(self)  # 同时被发现,可能被多个野怪发现
            if len(self.vis_lt) != 0 and self.life > 0:
                print('搜寻%s次 终于找到%s只野怪:' % (count, len(self.vis_lt)), *self.vis_lt, sep='\n')
            else:
                print('生命值%s,you have been killed by %s!!!\n累计打野数：%s  累计击败英雄数%s' % (
                    self.life, self.vis_lt[0].name, self.kill_monster, self.kill_hero))
        else:
            print('所有野怪均被消灭！！！')
            os._exit(0)

    # 2攻击目标,次线程
    def fight(self):
        enemy = self.vis_lt[0]
        if isinstance(enemy, Hero):
            enemy.life -= self.attack
        elif isinstance(enemy, Monster):
            Times = 0
            while enemy.life > 0 and self.life > 0:
                Times += 1
                enemy.life -= self.hurt_level
                print('\n[打野第%s下]---> %s 生命值：%s' % (Times, enemy.name, enemy.life))
                time.sleep(0.3)  # 打野速度体现
            while enemy.life <= 0 and self.life > 0:
                self.kill_monster += 1
                self.money += enemy.money  # 增加金币，回血
                self.life += enemy.money
                print('[%s Killed %s野怪, 回血%s 生命值：%s]\n\n继续寻找下一只野怪。。。' % (
                    self.name, enemy.name, enemy.money, self.life))
                self.vis_lt.remove(enemy)
                monster.mst_lt.remove(enemy)
                break

    # 重复搜索，打野过程
    def mainloop(self):
        while len(self.vis_lt) != 0:
            if self.life > 0:
                self.fight()
                self.move()
            else:
                break


# 野怪
class Monster(Life):
    def __init__(self, name='LIFE', life=500, attack=180, defend=100, money=800, mon_name='野怪'):
        super().__init__(name, life, attack, defend, money)
        self.mon_name = mon_name
        self.p_x = rd.randrange(0, 400, 10)
        self.p_y = rd.randrange(0, 400, 10)
        self.position = (self.p_x, self.p_y)

    def __str__(self):
        return '%s:%s life:%s attack:%s defend:%s money:%s positon:%s' % (
            self.mon_name, self.name, self.life, self.attack, self.defend, self.money, self.position)

    # 报复目标，次线程
    def fight(self):
        while len(self.vis_lt) != 0:
            enemy = self.vis_lt[0]
            Times = 0
            while enemy.life > 0 and self.life > 0:
                Times += 1
                enemy.life -= self.attack
                print('\n(你被%s报复第%s下)---> %s 生命值：%s' % (self.name, Times, enemy.name, enemy.life))
                time.sleep(0.3)  # 野怪攻击速度体现
            else:
                break


# 批量生成野怪
class Monsters:
    def __init__(self):
        self.mst_lt = []
        for i in range(1, 20):
            setattr(self, 'monster_%s' % i, Monster('腥红石像%s号' % i, 1000, attack=180, money=800, mon_name='BUFF'))
            self.mst_lt.append(eval('self.monster_%s' % i))


# 批量生成英雄
class Heroes:
    def __init__(self):
        self.mst_lt = []
        for i in range(1, 10):
            setattr(self, 'hero_%s' % i, Hero('亚瑟%s号' % i, 1000, 100, 200, ocu_name='对抗路'))
            self.mst_lt.append(eval('self.hero_%s' % i))


# 法师
class Rabbi(Hero):
    def __init__(self, name):
        super().__init__(name)
        pass


# 射手
class Shooter(Hero):
    def __init__(self, name):
        super().__init__(name)
        pass


# 战士
class Soldier(Hero):
    def __init__(self, name, ):
        super().__init__(name)
        pass


# 刺客
class Assassin(Hero):
    def __init__(self, name, ):
        super().__init__(name)
        pass


# 野怪反击
def back_atk():
    jug = 0  # 跳出循环的判定
    t = None
    while jug == 0:
        if len(monster.mst_lt) != 0:
            for mon in monster.mst_lt:
                if len(mon.vis_lt) != 0:
                    if mon.vis_lt[0].life > 0:  # 只攻击最近的敌人
                        t = threading.Thread(target=mon.fight)
                        t.start()
                    else:
                        jug = 1
            t.join()


if __name__ == '__main__':
    print('#' * 25 + ' welcome to 王者RY ' + '#' * 25 + '\n登录/回车进入：')

    monster = Monsters()
    hero1 = Rabbi('妲己')

    t1 = threading.Thread(target=hero1.mainloop)
    t2 = threading.Thread(target=back_atk)

    t1.start()
    t2.start()