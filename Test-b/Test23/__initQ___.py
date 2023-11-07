x = input('输入x轴数据')
t = x[0]
if x.isdigit() or (t == '-' and x[1:].isdecimal()):
    x = float(x)
    y = input('输入y轴数据')
    t1 = y[0]
    if y.isdigit() or (t1 == '-' and y[1:].isdecimal()):
        y = float(y)
        if x > 0:
            if y > 0:
                print(f'{x},{y}在第一象限')
            else:
                print(f'{x},{y}在第二象限')
        else:
            if y > 0:
                print(f'{x},{y}在第三象限')
            else:
                print(f'{x},{y}在第四象限')
    else:
        print('y有误')
else:
    print('x有误')
