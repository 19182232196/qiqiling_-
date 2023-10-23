str=input("输入用户组设置的名称")
if str=='administrators':
    print('设置管理员')
elif str=='power users':
    print('高级账号')
elif str=='users':
    print('一般账号')
elif str=='guests':
    print('游客')
else:
    print('用户组不存在')