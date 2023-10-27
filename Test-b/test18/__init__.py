#!/usr/bin/env python
# -*- coding: utf-8 -*-
# 编写程序，模拟聪明版及非聪明版的尼姆游戏
# 并进行两种的比较及分析，给出聪明版比非聪明版的胜算结论
from random import randint
from math import floor


def nim_silly(n):  # 愚钝版本随机取数
    if n <= 3:
        return 1
    return randint(1, floor(n / 2))


def nim_smart(n):  # 聪明版本自动选择最佳数
    if n <= 3:
        return 1
    x = 0
    while (True):
        if pow(2, x) <= n < pow(2, x + 1):
            break
        x += 1

    num = n - pow(2, x) + 1
    if 1 <= num <= n / 2:
        return num
    else:  # 若最佳数不在范围内，则选取随机数
        return randint(1, floor(n / 2))


def nim_game(n, choose):
    if choose == 'silly':
        print("你选择了傻瓜难度")
        f = nim_silly  # 函数指针选择silly函数
    else:
        print("你选择了地狱难度")
        f = nim_smart  # 函数指针选择smart函数

    while (True):
        print("现在共有" + str(n) + "个棋子")
        nim = f(n)
        print("Nim拿走了" + str(nim) + "个")
        n -= nim
        print("现在共有" + str(n) + "个棋子")
        if n == 0:
            print("你赢了！")
            return

        you = int(input("该你了，你要拿走:"))
        while (True):
            if 1 <= you <= n / 2 or n == 1:
                print("你拿走了" + str(you) + "个")
                break
            if you < 1:
                print("至少要拿走一个棋子！")
            else:
                print("最多只能拿走一半的棋子！")
            you = int(input("请重新输入，你要拿走:"))

        n -= you
        if n == 0:
            print("现在共有" + str(n) + "个棋子")
            print("你输了！")
            return


if __name__ == '__main__':
    num = int(input("请输入棋子的总数: "))
    choose = input("请输入你要选择的难度（'silly' or 'smart'）: ")
    nim_game(num, choose)