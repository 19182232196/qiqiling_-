import os
import sys
from PyQt6.QtWidgets import *
from PyQt6.QtCore import *
from PyQt6.QtGui import *
from PyQt6 import QtCore

import numpy as np
import time

import random

_ROW_ = 30
_COL_ = 30

_WIN_W = _COL_ * 20
_WIN_H = _ROW_ * 20

_LIVE_ = 1
_DIE_ = 0

_DIE_PIC = " "
_LIVE_PIC = ".\\DIE.png"

Cell_Old = [[0 for i in range(_COL_)] for j in range(_ROW_)]
Cell_New = [[0 for i in range(_COL_)] for j in range(_ROW_)]


def Init(list):
    for i in range(_ROW_):
        for j in range(_COL_):
            list[i][j] = _DIE_


Init(Cell_Old)
Init(Cell_New)


class My_Thread(QThread):
    trigger = pyqtSignal(list)

    def __init__(self):
        super(My_Thread, self).__init__()

    def run(self):
        while True:
            time.sleep(0.3)
            self.trigger.emit(Cell_Old)
            self.rule(Cell_Old, Cell_New)
            self.Swap(Cell_Old, Cell_New)
            Init(Cell_New)

    def Swap(self, list_old, list_new):
        for i in range(_ROW_):
            for j in range(_COL_):
                list_old[i][j] = list_new[i][j]

    def rule(self, list_old, list_new):
        for i in range(_ROW_):
            for j in range(_COL_):
                self.num(i, j, list_old, list_new)

    def num(self, x, y, list_old, list_new):
        sum = 0
        for i in range(x - 1, x + 2):
            for j in range(y - 1, y + 2):
                if i < 0 or i > _ROW_ - 1 or j < 0 or j > _COL_ - 1:
                    continue
                elif i == x and j == y:
                    continue
                else:
                    sum = sum + list_old[i][j]

        if list_old[x][y] == _LIVE_ and (sum < 2 or sum > 3):
            list_new[x][y] = _DIE_

        elif list_old[x][y] == _LIVE_ and (sum == 2 or sum == 3):
            list_new[x][y] = _LIVE_

        elif list_old[x][y] == _DIE_ and (sum == 3):
            list_new[x][y] = _LIVE_
        '''
        else:
            list_new[x][y] = list_old[x][y]
        '''


class Main_Window(QWidget):

    def __init__(self):
        super(Main_Window, self).__init__()
        self.setWindowTitle("Game Of Life")
        self.setFixedSize(_WIN_W, _WIN_H)
        self.GameUI()
        self.Thread = My_Thread()
        self.Thread.trigger.connect(self.Play)

    def GameUI(self):
        self.console = QLabel(self)
        self.console.resize(_WIN_W, 50)
        # self.console.setStyleSheet("background-color:#91D2EB")

        self.button_random = QPushButton(self.console)
        self.button_random.setText("Random")
        self.button_random.clicked.connect(lambda: self.Random(Cell_Old))

        self.button_restart = QPushButton(self.console)
        self.button_restart.setText("Restart")
        self.button_restart.clicked.connect(lambda: self.restart())

        self.button_start = QPushButton(self.console)
        self.button_start.setText("Start")
        self.button_start.clicked.connect(lambda: self.Thread.start())

        self.button_layout = QHBoxLayout(self.console)
        self.button_layout.addStretch(1)
        self.button_layout.addWidget(self.button_random)
        self.button_layout.addStretch(1)
        self.button_layout.addWidget(self.button_start)
        self.button_layout.addStretch(1)
        self.button_layout.addWidget(self.button_restart)
        self.button_layout.addStretch(1)

        self.feild = QLabel(self)
        self.feild.resize(_WIN_W, int(_WIN_H - 50))
        self.feild.move(0, 50)
        self.LifeFeild()

    def LifeFeild(self):
        self.grid = QGridLayout(self.feild)
        for i in range(_ROW_):
            for j in range(_COL_):
                self.button = QPushButton(self.feild)
                self.button.setFixedSize(19, 19)
                btn = self.button
                self.button.clicked.connect(lambda setlife, button=btn: self.SetLife(button))
                self.grid.addWidget(self.button, i, j)

    def GetPosition(self, button):
        btn_index = self.grid.indexOf(button)
        position = self.grid.getItemPosition(btn_index)
        return position

    def SetLife(self, button):
        x = self.GetPosition(button)[0]
        y = self.GetPosition(button)[1]
        life_button = self.grid.itemAtPosition(x, y).widget()
        if Cell_Old[x][y] == _LIVE_:
            Cell_Old[x][y] = _DIE_
            life_button.setIcon(QIcon(_DIE_PIC))
        else:
            Cell_Old[x][y] = _LIVE_
            life_button.setIcon(QIcon(_LIVE_PIC))

    def Random(self, list):
        for i in range(_ROW_):
            for j in range(_COL_):
                list[i][j] = random.randint(_DIE_, _LIVE_)

    def Draw(self, list):
        for i in range(_ROW_):
            for j in range(_COL_):
                if list[i][j] == _LIVE_:
                    self.grid.itemAtPosition(i, j).widget().setIcon(QIcon(_LIVE_PIC))
                else:
                    self.grid.itemAtPosition(i, j).widget().setIcon(QIcon(_DIE_PIC))

    def restart(self):
        os.execl(sys.executable, sys.executable, *sys.argv)

    def Play(self, list):
        self.Draw(list)


class Thread_Window(QThread):
    # trigger = pyqtSignal(QWidget)
    def __init__(self):
        super(Thread_Window, self).__init__()
        self.run()

    def run(self):
        self.main()

    def main(self):
        app = QApplication(sys.argv)
        Window = Main_Window()
        Window.show()
        sys.exit(app.exec())


Window = Thread_Window()
