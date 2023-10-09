# import random
#
# dict = {"一等奖": "奔驰GLA200", "二等奖": "B&W600音箱", "三等奖": "海尔双频冰箱", "四等奖": "海信43E2F电视",
#         "五等奖": "北鼎电炖锅"}
# luck = random.choice(list(dict.keys()))
# new = {}
# many = len(dict)
# for i in random(many):
#     luck_ord = random.choice(list(dict.keys()))
#     luck_get = dict.get(luck_ord)
#     print("您抽中了{}:{}".format(luck_ord, luck_get))
#     name = input("输入手机号")
#     new[luck_ord] = luck_get + "--" + name
#     dict.pop(luck_ord)
# print("获奖名单")
# for key, value in new.items():
#     print(str(key) + ":" + value)
#
# dict = {"1": "5", "2": "6", "3": "7", "4": "8", "5": "9", "6": "4", "7": "3", "8": "2", "9": "0", "0": "1"}
# instr = input("请输入密码:")
# new = ""
# for item in instr:
#     new += dict.get(item)
# print("转译密码为:", new)
#
# sys = {"sys": random.randint(1, 99), "my": random.randint(1, 99)}
# myint = int(input("请输入你的数字(1~99):"))
# sys.update({"my": myint})
# print(sys)
# print("这次猜:", random.choice(["大", "小"]))
#
# phone = []
# for value in new.values():
#     phone.append(value.pop("--")[1])
#     print('\n'.join(phone))
