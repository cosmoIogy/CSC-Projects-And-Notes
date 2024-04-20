from tkinter import Tk
from game import Game

window = Tk()
window.title("Room Adventure Pt.2")
game = Game(window)
game.play()
window.mainloop()