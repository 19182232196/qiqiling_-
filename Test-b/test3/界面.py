# !/usr/bin/env python
# -*-coding:utf-8 -*-
"""
# File       : 界面.py
# Time       ：2023/12/19 19:20
# Author     ：blue-eyes
# Computer   ：MACBOOK PRO
# Description：
"""

import tkinter as tk
from do_excel import read_excel, write_excel
import datetime


# def hello():
#     print("hello")
#
#
# main_windows = tk.Tk()
#
# tk.Button(main_windows, text="按键", command=hello).grid(row=0,column=0)
# tk.Button(main_windows, text="按键1", command=hello).grid(row=0,column=1)
# tk.Button(main_windows, text="按键2", command=hello).grid(row=2,column=0)
#
# main_windows.mainloop()


# 页面跳转的逻辑 -》删除当前页面
#             -> 新建一个新的页面


class MainPage:
    def bf_go_add(self):
        self.root.destroy()
        AddBook()

    def bf_go_del(self):
        self.root.destroy()
        DelBook()

    def bf_go_borrow(self):
        self.root.destroy()
        BorrowBook()

    def bf_go_return(self):
        self.root.destroy()
        ReturnBook()

    def bf_go_find(self):
        self.root.destroy()
        FindBook()

    def bf_go_delay(self):
        self.root.destroy()
        DelayBook()

    def bf_go_popular(self):
        self.root.destroy()
        PopularBook()

    def __init__(self):
        self.root = tk.Tk()
        tk.Button(self.root, text="添加书", command=self.bf_go_add).grid(row=0, column=0)
        tk.Button(self.root, text="删除书", command=self.bf_go_del).grid(row=1, column=0)
        tk.Button(self.root, text="借书", command=self.bf_go_borrow).grid(row=2, column=0)
        tk.Button(self.root, text="还书", command=self.bf_go_return).grid(row=3, column=0)
        tk.Button(self.root, text="查询图书信息", command=self.bf_go_find).grid(row=4, column=0)
        tk.Button(self.root, text="查询要归还的书", command=self.bf_go_delay).grid(row=5, column=0)
        tk.Button(self.root, text="按照借阅次数查询", command=self.bf_go_popular).grid(row=6, column=0)

        self.root.mainloop()


class SmallPage(object):
    def __init__(self):
        self.root = tk.Tk()
        tk.Button(self.root, text="返回", command=self.bf_go_main).grid(row=10, column=1)

    def bf_go_main(self):
        self.root.destroy()
        MainPage()


class AddBook(SmallPage):
    def bf_add_book(self):
        all_book_info = read_excel()

        book_index = int(self.a_index.get())
        book_name = self.a_name.get()
        book_address = self.a_address.get()
        book_class = self.a_class.get()
        book_number = int(self.a_number.get())
        book_pay = int(self.a_pay.get())
        book_time_in_1 = self.a_time_in.get().split(",")
        book_time_in = datetime.datetime(int(book_time_in_1[0]), int(book_time_in_1[1]), int(book_time_in_1[2]))
        book_time_out_1 = self.a_time_out.get().split(",")
        book_time_out = datetime.datetime(int(book_time_out_1[0]), int(book_time_out_1[1]), int(book_time_out_1[2]))
        book_time = int(self.a_time.get())
        book_state = self.a_state.get()
        all_book_info.append(
            [book_index, book_name, book_address, book_class, book_number, book_pay, book_time_in, book_time_out,
             book_time, book_state])

        write_excel(all_book_info)

    def __init__(self):
        super().__init__()
        # book_info = ["索引", "名称", "地址", "类别", "数量", "价格", "入库时间", "归还时间", "次数", "状态"]
        tk.Label(self.root, text="索引：").grid(row=0, column=0)
        self.a_index = tk.Entry(self.root)
        self.a_index.grid(row=0, column=1)
        tk.Label(self.root, text="名称：").grid(row=1, column=0)
        self.a_name = tk.Entry(self.root)
        self.a_name.grid(row=1, column=1)
        tk.Label(self.root, text="地址：").grid(row=2, column=0)
        self.a_address = tk.Entry(self.root)
        self.a_address.grid(row=2, column=1)
        tk.Label(self.root, text="类别：").grid(row=3, column=0)
        self.a_class = tk.Entry(self.root)
        self.a_class.grid(row=3, column=1)
        tk.Label(self.root, text="数量：").grid(row=4, column=0)
        self.a_number = tk.Entry(self.root)
        self.a_number.grid(row=4, column=1)
        tk.Label(self.root, text="价格：").grid(row=5, column=0)
        self.a_pay = tk.Entry(self.root)
        self.a_pay.grid(row=5, column=1)
        tk.Label(self.root, text="入库时间：").grid(row=6, column=0)
        self.a_time_in = tk.Entry(self.root)
        self.a_time_in.grid(row=6, column=1)
        tk.Label(self.root, text="归还时间：").grid(row=7, column=0)
        self.a_time_out = tk.Entry(self.root)
        self.a_time_out.grid(row=7, column=1)
        tk.Label(self.root, text="次数：").grid(row=8, column=0)
        self.a_time = tk.Entry(self.root)
        self.a_time.grid(row=8, column=1)
        tk.Label(self.root, text="状态：").grid(row=9, column=0)
        self.a_state = tk.Entry(self.root)
        self.a_state.grid(row=9, column=1)

        tk.Button(self.root, text="添加", command=self.bf_add_book).grid(row=10, column=0)

        self.root.mainloop()


class DelBook(SmallPage):
    def bf_del_book(self):
        stay_book = []
        for _book in self.all_book_info:
            if self.a_del.get() != _book[1]:
                stay_book.append(_book)
        write_excel(stay_book)

    def __init__(self):
        super().__init__()
        self.all_book_info = read_excel()
        self.all_book_info_1 = self.all_book_info[1:]
        for _index, _book in enumerate(self.all_book_info_1):
            tk.Label(self.root, text=_book[1]).grid(row=_index, column=0)

        tk.Label(self.root, text="请输入你想删除的书").grid(row=len(self.all_book_info_1), column=0)
        self.a_del = tk.Entry(self.root)
        self.a_del.grid(row=len(self.all_book_info_1) + 1, column=0)
        tk.Button(self.root, text="删除", command=self.bf_del_book).grid(row=10, column=0)


class BorrowBook(SmallPage):
    def bf_borrow_book(self):
        for _book in self.all_book_info:
            if self.a_borrow.get() == _book[1]:
                _book[4] = _book[4] - 1
                _book[-2] = _book[-2] + 1
                if _book[4] == 0:
                    _book[-1] = "不可借"
        write_excel(self.all_book_info)

    def __init__(self):
        super().__init__()
        self.all_book_info = read_excel()
        self.all_book_info_1 = self.all_book_info[1:]
        for _index, _book in enumerate(self.all_book_info_1):
            if "不" not in _book[-1]:
                tk.Label(self.root, text=_book[1]).grid(row=_index, column=0)
        tk.Label(self.root, text="请输入你想借阅的书").grid(row=len(self.all_book_info_1), column=0)
        self.a_borrow = tk.Entry(self.root)
        self.a_borrow.grid(row=len(self.all_book_info_1) + 1, column=0)
        tk.Button(self.root, text="借阅", command=self.bf_borrow_book).grid(row=10, column=0)


class ReturnBook(SmallPage):
    def bf_return_book(self):
        for _book in self.all_book_info:
            if self.a_return.get() == _book[1]:
                _book[4] = _book[4] + 1
                if _book[4] == 1:
                    _book[-1] = "可借"
        write_excel(self.all_book_info)

    def __init__(self):
        super().__init__()
        self.all_book_info = read_excel()
        self.all_book_info_1 = self.all_book_info[1:]
        for _index, _book in enumerate(self.all_book_info_1):
            tk.Label(self.root, text=_book[1]).grid(row=_index, column=0)
        tk.Label(self.root, text="请输入你想还的书").grid(row=len(self.all_book_info_1), column=0)
        self.a_return = tk.Entry(self.root)
        self.a_return.grid(row=len(self.all_book_info_1) + 1, column=0)

        tk.Button(self.root, text="还书", command=self.bf_return_book).grid(row=10, column=0)


class FindBook(SmallPage):
    def bf_find_book(self):
        for _book in self.all_book_info:
            if self.a_find.get() == _book[1]:
                tk.Label(self.root, text=_book).grid(row=len(self.all_book_info_1) + 2, column=0)

    def __init__(self):
        super().__init__()
        self.all_book_info = read_excel()
        self.all_book_info_1 = self.all_book_info[1:]
        for _index, _book in enumerate(self.all_book_info_1):
            tk.Label(self.root, text=_book[1]).grid(row=_index, column=0)

        tk.Label(self.root, text="请输入你想查询的书").grid(row=len(self.all_book_info_1), column=0)
        self.a_find = tk.Entry(self.root)
        self.a_find.grid(row=len(self.all_book_info_1) + 1, column=0)
        tk.Button(self.root, text="查询", command=self.bf_find_book).grid(row=10, column=0)


class DelayBook(SmallPage):

    def __init__(self):
        super().__init__()
        self.all_book_info = read_excel()
        self.all_book_info_1 = self.all_book_info[1:]
        for _index, _book in enumerate(self.all_book_info_1):
            if datetime.datetime.now() - _book[-3] > datetime.timedelta(days=2000):
                tk.Label(self.root, text=_book[1]).grid(row=_index, column=0)


class PopularBook(SmallPage):

    def __init__(self):
        super().__init__()
        self.all_book_info = read_excel()
        self.all_book_info_1 = self.all_book_info[1:]
        self.all_book_info_1.sort(key=lambda x: x[-2] * -1)
        for _index, _book in enumerate(self.all_book_info_1):
            tk.Label(self.root, text=_book[1]).grid(row=_index, column=0)


MainPage()

