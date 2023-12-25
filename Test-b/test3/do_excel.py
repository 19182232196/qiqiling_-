# !/usr/bin/env python
# -*-coding:utf-8 -*-

import datetime
import pands as pd

excel_path = "lib.xlsx"

# c -> 时间 2018-1-1 -> 字符串 -> 算日期
# python -> datetime
#

book_info = ["索引", "名称", "地址", "类别", "数量", "价格", "入库时间", "归还时间", "次数", "状态"]
book_info1 = [0, "明朝那些事", "三牌楼", "人文", 1, 22, datetime.datetime(2018, 1, 1), datetime.datetime(2018, 1, 1), 1, "可借"]
book_info2 = [1, "基督山伯爵", "三牌楼", "人文", 1, 22, datetime.datetime(2018, 1, 1), datetime.datetime(2018, 1, 1), 2, "可借"]
book_info3 = [2, "三体", "三牌楼", "人文", 1, 22, datetime.datetime(2018, 1, 1), datetime.datetime(2018, 1, 1), 3, "可借"]
all_book_info = [book_info, book_info1, book_info2, book_info3]


def write_excel(input_info):
    all_book_info_pd = pd.DataFrame(input_info)
    all_book_info_pd.to_excel(excel_path)
    print("all is write")


def read_excel():
    df = pd.read_excel(excel_path)
    # type - > dataframe
    # print(type(df))
    # print(df[5]) -》报错
    excel_read = []
    for _excel_index in range(len(df)):
        excel_read_one = []
        for _index, _data_index in enumerate(df.iloc[_excel_index, :]):
            if _index != 0:
                excel_read_one.append(_data_index)
        excel_read.append(excel_read_one)
    return excel_read


if __name__ == '__main__':
    all_book_info = read_excel()
    print(all_book_info)
