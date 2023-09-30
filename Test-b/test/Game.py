import pygame
import sys
from Board import *

pygame.init()

Main_Window = pygame.display.set_mode(((COL+SCORE_FEILD)*SIZE,ROW*SIZE))

while True:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            sys.exit()