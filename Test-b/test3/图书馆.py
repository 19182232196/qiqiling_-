# !/usr/bin/env python
# -*-coding:utf-8 -*-
"""
# File       : 图书馆.py
# Time       ：2023/12/18 14:09
# Author     ：blue-eyes
# Computer   ：MACBOOK PRO
# Description：
"""

import datetime

# c -> 时间 2018-1-1 -> 字符串 -> 算日期
# python -> datetime
#

book_info = ["索引", "名称", "地址", "类别", "数量", "价格", "入库时间", "归还时间", "次数", "状态"]
book_info1 = [0, "明朝那些事", "三牌楼", "人文", 1, 22, datetime.datetime(2018, 1, 1), datetime.datetime(2018, 1, 1), 1, "可借"]
book_info2 = [1, "基督山伯爵", "三牌楼", "人文", 1, 22, datetime.datetime(2018, 1, 1), datetime.datetime(2018, 1, 1), 2, "可借"]
book_info3 = [2, "三体", "三牌楼", "人文", 1, 22, datetime.datetime(2018, 1, 1), datetime.datetime(2018, 1, 1), 3, "可借"]
all_book_info = [book_info1, book_info2, book_info3]


# 关于删除
# 把txt所有信息先提取出来，直接对信息更改
# 然后再把TXT覆盖掉


# 如何数写输入txt的函数 -> 单个
def add_book(_book_info, mode="a+"):
    f = open(r'lib.txt', mode)
    print(_book_info, file=f)
    f.close()


# 如歌更新整个文件
def renew_books(_all_books):
    for index, _book in enumerate(_all_books):
        if index == 0:
            add_book(_book, mode="w+")
        else:
            add_book(_book)


# 读取整个文件的信息
def read_books():
    f = open(r'lib.txt', "r")
    _books_info = f.read()
    # f.readline() -》 感兴趣可以看一下
    # range(0,3) -》0，1，2
    _books_info_str = _books_info.split("\n")[:-1]
    _return_info = []
    for _book in _books_info_str:
        _return_info.append(eval(_book))
    # print(_books_info_str)
    # print(len(_books_info_str))
    f.close()

    return _return_info


# print(read_books())
# renew_books(all_book_info)
# add_book(book_info)

print("1.添加书")
print("2.删除书")
print("3.借书")
print("4.还书")
print("5.查询图书信息")
print("6.查询马上要归还的图书信息")
print("7.按照借阅次数排序")
print("**********")
do_now = int(input("你想做什么呢？(输入为数字)"))

# elif -》 else if
# if -》if
# book_info = ["索引", "名称", "地址", "类别", "数量", "价格", "入库时间", "归还时间", "次数", "状态"]
# datetime.datetime(2018, 1, 1)
if do_now == 1:
    print("1.添加书")
    # the_add_book -》新添加一本的书的全部信息
    the_add_book = []
    for info in book_info:
        # int
        if info in ["索引", "数量", "价格", "次数"]:
            # 等价于 if info == "索引" or info == "数量" ......
            put_number = int(input(info + ":"))
            the_add_book.append(put_number)
        # datetime
        elif info in ["入库时间", "归还时间"]:
            # 2018,1,1 -》 datetime.datetime(2018, 1, 1)
            put_date = input(info + ":(用逗号分开年月日)").split(",")
            the_add_book.append(datetime.datetime(int(put_date[0]), int(put_date[1]), int(put_date[2])))
        # str
        else:
            put_txt = input(info + ":")
            the_add_book.append(put_txt)
    add_book(the_add_book)

elif do_now == 2:
    # 读取所有书
    all_book_info = read_books()
    # 把所有书名打出
    for _book in all_book_info:
        print(_book[1])
    del_book_name = input("你想删除哪一本书？")
    # stay_book -》 最后留下来的书
    stay_book = []
    for _book in all_book_info:
        if del_book_name != _book[1]:
            stay_book.append(_book)
    renew_books(stay_book)

elif do_now == 3:
    # 读取所有书
    all_book_info = read_books()
    # 把所有书名打出
    for _book in all_book_info:
        if "不" not in _book[-1]:
            print(_book[1])
    borrow_book_name = input("你想借哪一本书？")
    for _book in all_book_info:
        if borrow_book_name == _book[1]:
            _book[4] = _book[4] - 1
            _book[-2] = _book[-2] + 1
            if _book[4] == 0:
                _book[-1] = "不可借"
    renew_books(all_book_info)

elif do_now == 4:
    # 读取所有书
    all_book_info = read_books()
    # 把所有书名打出
    for _book in all_book_info:
        print(_book[1])
    return_book_name = input("你想还哪一本书？")
    for _book in all_book_info:
        if return_book_name == _book[1]:
            _book[4] = _book[4] + 1
            if _book[4] == 1:
                _book[-1] = "可借"
    renew_books(all_book_info)

elif do_now == 5:
    # 读取所有书
    all_book_info = read_books()
    # 把所有书名打出
    for _book in all_book_info:
        print(_book[1])
    search_book_name = input("你想查询哪一本书？")
    for _book in all_book_info:
        if search_book_name == _book[1]:
            print(_book)
    renew_books(all_book_info)

elif do_now == 6:
    all_book_info = read_books()
    # 把所有书名打出
    for _book in all_book_info:
        # datetime.datetime.now() -》获取当前日期
        if datetime.datetime.now() - _book[-3] > datetime.timedelta(days=3):
            print(_book[1], datetime.datetime.now() - _book[-3])

elif do_now == 7:
    all_book_info = read_books()
    all_book_info.sort(key=lambda x: x[-2] * -1)
    for _book in all_book_info:
        print(_book[1])

