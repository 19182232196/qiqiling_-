import pygame
import numpy as np

COL = 10
ROW = 25
SIZE = 45
SCORE_FEILD = 6

class Board():
    def __init__(self):
        super().__init__()
        self.board = np.zeros((ROW, COL))

    def Load_Game(self):
        for j in range(COL):
            for i in range(ROW):
                if self.board[i][j] == 0:
                    pygame.draw.rect(surface,color,r)