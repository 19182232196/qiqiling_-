sr = input('输入运算符(+/-*)')
if sr == '+' or sr == '-' or sr == '*' or sr == '/':
    n1 = input('输入第一个数字')

    if n1.isdigit():
        n1 = float(n1)
        n2 = input('输入第二个')
        if n2.isdigit():
            n2 = float(n2)
            if sr == '+':
                print(f'{n1}+{n2}={n1 + n2}')
            elif sr == '-':
                print(f'{n1}-{n2}={n1 - n2}')
            elif sr == '*':
                print(f'{n1}*{n2}={n1 * n2}')
            else:
                if n2 == 0:
                    print('除数不能为0')
                else:
                    print(f'{n1}/{n2}={n1 / n2}')
        else:
            print('第二个不是数字')
    else:
        print('第一个不是数字')
else:
    print('运算符错误')
