menu={"1":"采购管理","2":"销售管理","3":"库存管理","4":"报表管理","5":"系统管理","6":"退出"}
for i in menu:
    print(i,menu[i])
menu_input=input("请输入菜单序号：")
menu_sel=menu.get(menu_input,"nothing")
if menu_sel=="nothing":
    print("正在进入"+menu_sel)
else:
    print("输入非法")