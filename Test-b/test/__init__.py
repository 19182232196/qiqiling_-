import os

filename = "students.txt"


# 定义菜单函数
def menu():  # 菜单
    print("===========================学生信息管理系统==========================")
    print('-------------------------------功能菜单----------------------------')
    print('\t\t\t\t\t\t1.录入学生信息')
    print('\t\t\t\t\t\t2.查找学生信息')
    print('\t\t\t\t\t\t3.删除学生信息')
    print('\t\t\t\t\t\t4.修改学生信息')
    print('\t\t\t\t\t\t5.对学生成绩排序')
    print('\t\t\t\t\t\t6.统计学生总人数')
    print('\t\t\t\t\t\t7.显示所有学生总数')
    print('\t\t\t\t\t\t0.退出系统')
    print('-----------------------------------------------------------------------')


# @allure.title('主菜单')
def main():  # 主函数
    while True:
        menu()
        choice = int(input('请选择：'))
        if choice in [0, 1, 2, 3, 4, 5, 6, 7]:
            if choice == 0:
                answer = input('您确定要退出系统吗？y/n')
                if answer == 'y':
                    print('谢谢您的使用')
                    break
                else:
                    continue
            elif choice == 1:
                insert()
            elif choice == 2:
                search()
            elif choice == 3:
                delete()
            elif choice == 4:
                modify()
            elif choice == 5:
                sort()
            elif choice == 6:
                total()
            elif choice == 7:
                show()
        else:
            print('您输入的有误，请重新输入')
            main()


#@save_decorator  # 添加装饰器，用于保存数据
def insert():  # 插入
    student_lst = []  # 声明一个列表，用于存储学生信息
    while True:
        id = input('请输入id（如1001）：')
        if not id:  # 如果输入为空，那么id的值为False,就进入不了循环，所以加一个not即可判断是否为空
            break
        name = input('请输入名字（如张三）：')
        if not name:
            break
        try:
            english = int(input('请输入英语成绩：'))
            python = int(input('请输入python成绩：'))
            java = int(input('请输入java成绩：'))
        except:
            print('您输入的有误，请重新输入')
            continue

        # 将录入的学生信息保存到字典中
        student = {'id': id, 'name': name, 'english': english, 'python': python, 'java': java}
        student_lst.append(student)
        answer = input('是否继续添加？y/n')
        if answer == 'y':
            continue
        else:
            break

    # 调用save()函数
    save(student_lst)
    print('学生信息完毕!!!')


# 保存函数，用于将列表lst中的元素保存到文件中
def save(lst):
    try:
        stu_text = open(filename, 'a', encoding='utf-8')  # 打开文件，以追加的形式
    except:
        stu_text = open(filename, 'w', encoding='utf-8')  # 以只写的形式打开文件
    for item in lst:
        stu_text.write(str(item) + '\n')
    stu_text.close()


# 定义删除函数
def delete():
    while True:
        student_id = input('请输入要删除的学生的ID:')
        if student_id != '':  # 输入的id不为空
            if os.path.exists(filename):  # 判断文件是否存在
                with open(filename, 'r', encoding='utf-8') as file:  # 打开文件
                    student_old = file.readlines()  # 读取所有数据，放到列表当中
            else:
                student_old = []
            flag = False  # 标记是否删除
            if student_old:  # 如果列表不空，用只写的方式打开，将原有类容进行覆盖
                with open(filename, 'w', encoding='utf-8') as wfile:
                    d = {}
                    for item in student_old:  # 遍历列表，读出的是一个字符串
                        d = dict(eval(item))  # 将字符串转成字典
                        if d['id'] != student_id:  # 如果不相等就把其写入
                            wfile.write(str(d) + '\n')
                        else:  # 相等就删除
                            flag = True
                    if flag:
                        print(f'id为{student_id}的学生信息以被删除')
                    else:
                        print(f'没有找到ID为{student_id}的学生信息')
            else:
                print('无学生信息')
                break
            show()  # 删除之后要重新显示所有学生信息
            answer = input('是否继续删除?y/n')
            if answer == 'y':
                continue
            else:
                break


# 定义show函数
def show():
    # 创建一个空列表
    student_lst = []
    # 判断文件是否存在
    if os.path.exists(filename):
        # 打开文件
        with open(filename, 'r', encoding='utf-8') as rfile:
            # 读取文件中的内容
            students = rfile.readlines()
            # 遍历文件中的每一行
            for item in students:
                # 将每一行转换成字典
                student_lst.append(eval(item))
            # 判断列表是否为空
            if student_lst:
                # 调用show_student函数
                show_student(student_lst)


# 定义函数show_student，用于显示学生信息
def show_student(lst):
    # 判断传入的列表是否为空
    if len(lst) == 0:
        # 如果为空，则打印提示信息
        print('没有查询到学生信息，无数据显示！！！')
        # 返回函数
        return
    # 定义标题的显示格式
    format_title = '{:^6}\t{:^12}\t{:^8}\t{:^10}\t{:^10}\t{:^8}'
    # 打印标题
    print(format_title.format('ID', '姓名', '英语成绩', 'python成绩', 'java成绩', '总成绩'))
    # 定义内容的显示格式
    format_data = '{:^6}\t{:^12}\t{:^8}\t{:^10}\t{:^10}\t{:^8}'
    # 遍历列表，打印学生信息
    for item in lst:
        # 打印英语成绩
        # print(item.get('english'))
        print(format_data.format(item.get('id'),
                                 item.get('name'),
                                 item.get('english'),
                                 item.get('python'),
                                 item.get('java'),
                                 item.get('english') + item.get('python') + item.get('java')
                                 ))


# 定义修改函数
def modify():
    # 显示文件内容
    show()
    # 判断文件是否存在
    if os.path.exists(filename):  # 判断这个文件是否存在
        # 以只读的形式打开文件
        with open(filename, 'r', encoding='utf-8') as rfile:
            # 将文件内容赋给列表
            student_old = rfile.readlines()  # 以只读的形式赋给列表
    else:
        return
    # 输入要修改的学生id
    student_id = input('请输入要修改的学生id:')
    # 以写入的形式打开文件
    with open(filename, 'w', encoding='utf_8') as wfile:
        # 遍历列表
        for item in student_old:
            # 将列表中的每一项转换成字典
            d = dict(eval(item))
            # 判断字典中的id是否与要修改的id相同
            if d['id'] == student_id:
                print('找到学生信息，可以修改他的相关信息了！')
                # 循环修改
                while True:
                    try:
                        d['name'] = input('请输入姓名:')
                        d['englist'] = input('请输入英语成绩:')
                        d['python'] = input('请输入python成绩：')
                        d['java'] = input('请输入java成绩：')
                    except:
                        print('您的输入有误，请重新输入！！！')
                    else:
                        break
                # 将修改后的字典写入文件
                wfile.write(str(d) + '\n')
                print('修改成功')
            else:
                # 将字典写入文件
                wfile.write(str(d) + '\n')
        # 判断是否修改其他学生信息
        answer = input('是否修改其他学生信息？y/n\n')
        if answer == 'y':
            modify()


# 定义一个函数search，用于查询学生信息
def search():
    student_query = []  # 声明一个列表
    while True:
        id = ''
        name = ''
        if os.path.exists(filename):  # 判断文件是否存在
            mode = input('按id查找请输入1，按姓名查找请输入2')
            if mode == '1':
                id = input('请输入学生ID:')
            elif mode == '2':
                name = input('请输入学生姓名:')
            else:
                print('您的输入有误，请重新输入')
                search()
            with open(filename, 'r', encoding='utf-8') as rfile:  # 以只读的方式打开
                student = rfile.readlines()  # 获取全部的内容存入列表中
                for item in student:  # 遍历列表存入字典中
                    d = dict(eval(item))
                    if id != '':  # 因为有两种查询方式，再加上最开始默认值为0，所以进行判断用哪种方式
                        if d['id'] == id:
                            student_query.append(d)  # 如果查询的id在字典中，则将内容添加到新的列表中
                    elif name != '':
                        if d['name'] == name:
                            student_query.append(d)  # 如果查询到name在字典中，则将内容添加到新的列表中
            # 显示查询结果
            show_student(student_query)  # 展现新的列表，需要格式化输出
            # 清空列表
            student_query.clear()
            answer = input('是否要继续查询？y/n\n')
            if answer == 'y':
                continue
            else:
                break

        else:
            print('暂未保存学生信息')
            return


# 定义total函数
def total():
    if os.path.exists(filename):  # 判断文件是否存在
        with open(filename, 'r', encoding='utf-8') as rfile:  # 只读的模式打开文件
            students = rfile.readlines()  # 获取文件中全部内容，存入列表中
            if students:
                print(f'一共有{len(students)}名学生')
            else:
                print('还没有录入学生信息')
    else:
        print('暂未保存数据.....')


# 定义排序函数
def sort():
    show()  # 显示所有学生信息
    if os.path.exists(filename):  # 判断文件是否存在
        with open(filename, 'r', encoding='utf-8') as rfile:
            student_list = rfile.readlines()  # 读取所有信息
        student_new = []
        for item in student_list:  # 编列列表，存入新的列表中
            d = dict(eval(item))
            student_new.append(d)
    else:
        return
    asc_or_desc = input('请选择(0,升序  1,降序)')
    if asc_or_desc == '0':  # 之所以升序是False是因为python内置函数的原因
        asc_or_desc_bool = False
    elif asc_or_desc == '1':
        asc_or_desc_bool = True
    else:
        print('您的输入有误，请重新输入')
        sort()
    mode = input('请选择排序方式（1.按英语成绩排序 2.按Python成绩排序 3.按java成绩排序 0.按总成绩排序：')
    if mode == '1':
        student_new.sort(key=lambda x: int(x['englist']), reverse=asc_or_desc_bool)
    elif mode == '2':
        student_new.sort(key=lambda x: int(x['python']), reverse=asc_or_desc_bool)
    elif mode == '3':
        student_new.sort(key=lambda x: int(x['java']), reverse=asc_or_desc_bool)
    elif mode == '0':
        student_new.sort(key=lambda x: int(x['englist']) + int(x['python']) + int(x['java']), reverse=asc_or_desc_bool)
    else:
        print('您输入有误，请重新 输入！！！')
        sort()
    show_student(student_new)


if __name__ == '__main__':
    main()
