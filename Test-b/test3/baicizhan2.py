import time

for i in range(100):
    print("当前时间：", time.ctime())
    time.sleep(0.1)

print("--------------------------------------")

dic = {"counter": "柜台", "stall": "售货摊", "shelf": "货架", "discount": "标价签"}
for item in dic.items():
    print(item[0])
    print(item[1])
for item in dic.items():
    print(item[0][0])
    print(item[1][0])
