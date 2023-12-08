import time
import pygame
import random
import sys

# 定义一个Poi类
class Poi:
    r = 0
    c = 0

    def __init__(self, r, c):
        self.r = r
        self.c = c

    def cop(self):
        return Poi(r=self.r, c=self.c)

# 初始化pygame
pygame.init()

# 设置窗口大小
W = 800
H = 600

# 设置半径
R = 50
# 设置列数
C = 80

# 设置最大食物数
MAX_FOODS = 20

# 设置窗口大小
size = (W, H)
# 设置窗口标题
window = pygame.display.set_mode(size)
pygame.display.set_caption("My Game")

# 设置背景颜色
bg_col = (255, 255, 255)
# 设置蛇颜色
sn_col = (200, 200, 200)

# 设置蛇头
he = Poi(r=int(R / 2), c=int(C / 2))
# 设置蛇头颜色
he_col = (0, 128, 128)
# 设置蛇身
sna = [
    Poi(r=he.r, c=he.c + 1),
    Poi(r=he.r, c=he.c + 2),
    Poi(r=he.r, c=he.c + 3)
]

# 定义一个函数，用于添加食物
foods = []

# 定义函数gr_fo，用于随机生成一个坐标
def gr_fo():
    while 1:
        pos = Poi(r=random.randint(0, R - 1), c=random.randint(0, C - 1))
        is_co = False
        # 检查食物位置是否和蛇头、蛇身、已存在的食物位置冲突
        if he.r == pos.r or he.c == pos.c:
            is_co = True

        for sn in sna:
            if sn.r == pos.r and sn.c == pos.c:
                is_co = True
                break

        for food in foods:
            if food.r == pos.r and food.c == pos.c:
                is_co = True
                break

        if not is_co:
            break
    return pos

# 初始化食物列表
for _ in range(MAX_FOODS):
    foods.append(gr_fo())

# 初始化方向
dir = 'left'

# 定义函数re，参数为poi和col
def re(poi, col):
    cel_w = W / C
    cel_h = H / R
    le = poi.c * cel_w
    to = poi.r * cel_h
    pygame.draw.rect(window, col, (le, to, cel_w, cel_h))

q = True
timer = pygame.time.get_ticks()
c = pygame.time.Clock()

# 添加计时器和倒计时时间
countdown_timer = 5  # 5秒倒计时
start_time = time.time()

# 游戏失败标志
game_over = False

# 游戏主循环
while q:
    current_time = pygame.time.get_ticks()
    elapsed_time = int(time.time() - start_time)

    if current_time - timer > 500:
        if len(foods) < MAX_FOODS:
            foods.append(gr_fo())
        timer = current_time

    for es in pygame.event.get():
        if es.type == pygame.QUIT:
            q = False
        elif es.type == pygame.KEYDOWN:
            if es.key == 273 or es.key == 119:
                if dir == 'left' or dir == 'right':
                    dir = 'up'
            elif es.key == 274 or es.key == 115:
                if dir == 'left' or dir == 'right':
                    dir = 'down'
            elif es.key == 276 or es.key == 97:
                if dir == 'up' or dir == 'down':
                    dir = 'left'
            elif es.key == 275 or es.key == 100:
                if dir == 'up' or dir == 'down':
                    dir = 'right'
            elif es.key == pygame.K_SPACE and game_over:
                # 重新开始游戏
                he = Poi(r=int(R / 2), c=int(C / 2))
                sna = [Poi(r=he.r, c=he.c + i) for i in range(1, 4)]
                foods = [gr_fo() for _ in range(MAX_FOODS)]
                start_time = time.time()
                countdown_timer = 30
                game_over = False

    ea = False
    for food in foods:
        if he.r == food.r and he.c == food.c:
            ea = True
            foods.remove(food)
            break

    if ea:
        foods.append(gr_fo())
        countdown_timer += 5  # 每吃一个食物增加5秒倒计时

    sna.insert(0, he.cop())

    if not ea:
        sna.pop()

    if dir == 'left':
        he.c -= 1
    elif dir == 'right':
        he.c += 1
    elif dir == 'up':
        he.r -= 1
    elif dir == 'down':
        he.r += 1

    dea = False
    for sn in sna:
        if sn.r == he.r and sn.c == he.c:
            dea = True
            break
    if dea:
        print("dead")
        game_over = True

    if he.r < 0:
        he.r = R
    if he.c < 0:
        he.c = C
    if he.c > C:
        he.c = 0
    if he.r > R:
        he.r = 0

    pygame.draw.rect(window, bg_col, (0, 0, W, H))

    for food in foods:
        re(food, (255, 255, 0))

    for sn in sna:
        re(sn, sn_col)

    re(he, he_col)

    font = pygame.font.SysFont(None, 55)
    timer_text = font.render(
        f"Time: {max(0, countdown_timer - elapsed_time)}", True, (0, 0, 0))
    window.blit(timer_text, (10, 10))

    pygame.display.flip()
    c.tick(20)

    if countdown_timer - elapsed_time <= 0:
        game_over = True

    # 在游戏失败处理部分
    if game_over:
        font = pygame.font.SysFont(None, 75)
        game_over_text = font.render("Game Over", True, (255, 0, 0))
        window.blit(game_over_text, (W // 2 - 150, H // 2 - 50))

        # 添加提示文字
        font = pygame.font.SysFont(None, 30)
        restart_text = font.render("Press SPACE to restart", True, (0, 0, 0))
        window.blit(restart_text, (W // 2 - 150, H // 2 + 20))

        pygame.display.flip()

        waiting_for_restart = True
        while waiting_for_restart:
            for event in pygame.event.get():
                if event.type == pygame.QUIT:
                    waiting_for_restart = False
                    q = False
                elif event.type == pygame.KEYDOWN:
                    if event.key == pygame.K_SPACE:
                        # 重新开始游戏
                        he = Poi(r=int(R / 2), c=int(C / 2))
                        sna = [Poi(r=he.r, c=he.c + i) for i in range(1, 4)]
                        foods = [gr_fo() for _ in range(MAX_FOODS)]
                        start_time = time.time()
                        countdown_timer = 5
                        game_over = False
                        waiting_for_restart = False
