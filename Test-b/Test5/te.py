import time
import pygame
import random
import sys


class Poi:
    r = 0
    c = 0

    def __init__(self, r, c):
        self.r = r
        self.c = c

    def cop(self):
        return Poi(r=self.r, c=self.c)


pygame.init()
W = 800
H = 600

R = 50
C = 80

MAX_FOODS = 20

size = (W, H)
window = pygame.display.set_mode(size)
pygame.display.set_caption("My Game")

bg_col = (255, 255, 255)
sn_col = (200, 200, 200)

he = Poi(r=int(R / 2), c=int(C / 2))
he_col = (0, 128, 128)
sna = [
    Poi(r=he.r, c=he.c + 1),
    Poi(r=he.r, c=he.c + 2),
    Poi(r=he.r, c=he.c + 3)
]

foods = []


def gr_fo():
    while 1:
        pos = Poi(r=random.randint(0, R - 1), c=random.randint(0, C - 1))
        is_co = False
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


for _ in range(MAX_FOODS):
    foods.append(gr_fo())

dir = 'left'


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
countdown_timer = 30  # 30秒倒计时
start_time = time.time()

# 游戏失败标志
game_over = False

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
        q = False

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

    # 添加倒计时显示
    font = pygame.font.SysFont(None, 55)
    timer_text = font.render(
        f"Time: {countdown_timer - elapsed_time}", True, (0, 0, 0))
    window.blit(timer_text, (10, 10))

    pygame.display.flip()
    c.tick(20)

# 游戏失败处理
if game_over:
    font = pygame.font.SysFont(None, 75)
    game_over_text = font.render("Game Over", True, (255, 0, 0))
    window.blit(game_over_text, (W // 2 - 150, H // 2 - 50))
    pygame.display.flip()

    pygame.time.delay(3000)  # 等待3秒
    pygame.quit()
    sys.exit()
