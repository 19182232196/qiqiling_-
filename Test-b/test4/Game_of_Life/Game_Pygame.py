import pygame
import numpy as np
import sys

WIDTH = 800
HEIGHT = 600

BLACK_COLOR = "#33333D"
WHITE_COLOR = "#FFFFFF"
GREY_COLOR = "#808080"
BLUE_COLOR = "#88B1C2"

RUNNING = False

DIE = 0
ALIVE = 1

CELL_SIZE = 10

FPS = 60

# surface Object, named Main_Screen
Main_Screen = pygame.display.set_mode((WIDTH, HEIGHT))
Main_Screen.fill(GREY_COLOR)

# Initialize pygame
pygame.init()

fps = pygame.time.Clock()

# Set title
pygame.display.set_caption("Game of Life")


def DrawCell(surface, cell):
    for i, j in np.ndindex(cell.shape):
        if cell[i][j] == DIE:
            pygame.draw.rect(surface, BLACK_COLOR, (i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE - 1, CELL_SIZE - 1))
        elif cell[i][j] == ALIVE:
            pygame.draw.rect(surface, WHITE_COLOR, (i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE - 1, CELL_SIZE - 1))


def update(cell, update_cell):
    alive = 0
    for i, j in np.ndindex(cell.shape):
        alive = np.sum(cell[i - 1:i + 2, j - 1:j + 2]) - cell[i][j]
        if cell[i][j] == ALIVE:
            if alive < 2 or alive > 3:
                update_cell[i][j] = DIE
            if 2 <= alive <= 3:
                update_cell[i][j] = ALIVE
        else:
            if alive == 3:
                update_cell[i][j] = ALIVE

    cell[0:] = update_cell[0:]
    DrawCell(Main_Screen, cell)
    pygame.display.update()
    update_cell[0:] = DIE


Cell = np.zeros((int(WIDTH / CELL_SIZE), int(HEIGHT / CELL_SIZE)))
Update_Cell = np.zeros((int(WIDTH / CELL_SIZE), int(HEIGHT / CELL_SIZE)))

# 固定代码段，实现点击"X"号退出界面的功能，几乎所有的pygame都会使用该段代码
while True:
    fps.tick(FPS)
    # 循环获取事件，监听事件状态
    for event in pygame.event.get():
        # 判断用户是否点了"X"关闭按钮,并执行if代码段
        if event.type == pygame.QUIT:
            # 卸载所有模块
            pygame.quit()
            # 终止程序，确保退出程序
            sys.exit()
        if pygame.mouse.get_pressed()[0]:
            pos = pygame.mouse.get_pos()
            if Cell[pos[0] // CELL_SIZE][pos[1] // CELL_SIZE] == DIE:
                Cell[pos[0] // CELL_SIZE][pos[1] // CELL_SIZE] = ALIVE
            elif Cell[pos[0] // CELL_SIZE][pos[1] // CELL_SIZE] == ALIVE:
                Cell[pos[0] // CELL_SIZE][pos[1] // CELL_SIZE] = DIE
            pygame.display.update()
        if event.type == pygame.KEYDOWN:
            if event.key == pygame.K_SPACE:
                RUNNING = not RUNNING
    if RUNNING:
        update(Cell, Update_Cell)
    if not RUNNING:
        DrawCell(Main_Screen, Cell)
        pygame.display.flip()  # 更新屏幕内容
