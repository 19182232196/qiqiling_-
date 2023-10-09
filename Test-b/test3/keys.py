# citys = {"sc": "cd", "sh": "bj", "gz": "gz"}
# print(citys)
# print(citys.keys())
# for i in citys.keys():
#     print(i)
#     print(citys[i])

# citys = {"sc": "cd", "sh": "bj", "gz": "gz"}
# print(citys.values())
# for ii in citys.values():
#     print(ii)

citys = {"sc": "cd", "sh": "bj", "gz": "gz"}
print(citys.items())
for item in citys.items():
    print(item)
    print(item[0], item[1])
