import time

ra = 0.05
print('个人存款计算'.center(15))
print('-' * 20)
print('储蓄方式:活期'.ljust(20))
print('存款日' + time.strftime('%Y-%m-%d'))
print('利率', format(ra * 100), '.2f')
d = input('存款日(格式:2000-1-1)')

try:
    time.strptime(d, '%Y-%m-%d')
    s_d = d.split('-')
    m_t = (int(s_d[0]), int(s_d[1]), int(s_d[2]), 0, 0, 0, 0, 0, 0)
    u_t = time.mktime(m_t)
    re = int((u_t - time.time()) / 3600 / 24)
    if re > 1:
        m = input('请输入存款金额:')
        if not m.isdigit():
            print('非法字符')
        else:
            m = int(m)
            s = m
            if re < 360:
                le = re * m * ra / 360
                s += le
            else:
                ye, da = divmod(re, 360)
                for i in range(ye):
                    le = s * ra
                    s += le
                else:
                    le = da * m * ra / 360
                    s += le
        print('-' * 20)
        print('所得利息', format(s - m, '.2f'))
        print('本息合计', format(s, '.2f'))
    else:
        print('时间错误')
except:
    print('日期错误')
