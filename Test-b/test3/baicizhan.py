import time

eng = ["counter", "stall", "shelf", "price tag", "discount", "change", "bank", "shop"]
chn = ["柜台", "售货摊", "货架", "标价签", "打折扣", "零钱", "银行", "商店"]
dic = dict(zip(eng, chn))
print("百词斩")
times = int(input("设置每个单词停留时间（1~10秒）"))
for key in dic:
    print(key + "___________")
    time.sleep(times)
for value in dic.values():
    print(value + "___________")
    time.sleep(times)
