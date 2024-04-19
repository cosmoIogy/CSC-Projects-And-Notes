from tkinter import (
    # Widgets 
    Frame, Label, Text, PhotoImage, Entry,

    # Constants
    X, Y, BOTH,
    BOTTOM, RIGHT, LEFT,
    DISABLED, NORMAL, END,

    # Type Hint Stuff
    Tk 
)
from room import Room
import os 

class Game(Frame):

    # some constants
    EXIT_ACTION = ["quit", "exit", "bye", "adios"]
    WIDTH = 800
    HEIGHT = 600

    # statuses
    class Status:
        DEFAULT = "I don't understand. Try verb noun. Valid verbs are go, look, take."
        DEAD = "You are dead."
        BAD_EXIT = "Invalid Exit."
        ROOM_CHANGED = "Room changed."
        GRABBED = "Item Grabbed."
        BAD_GRAB = "I can't grab that."
        BAD_ITEM = "I don't see that."
    
    def __init__(self, parent: Tk):
        self.inventory = []
        Frame.__init__(self,parent)
        self.pack(fill = BOTH, expand = 1) # geometry management for Game instances

    def setup_game (self) -> None:
        
        # create the rooms
        r1 = Room("Room 1", os.path.join("images","room1.gif"))
        r2 = Room("Room 2", os.path.join("images","room2.gif"))
        r3 = Room("Room 3", os.path.join("images","room3.gif"))
        r4 = Room("Room 4", os.path.join("images","room4.gif"))
        # create the exits
        r1.add_exit("east", r2)
        r1.add_exit("south", r3)

        r2.add_exit("west", r1)
        r2.add_exit("south", r4)

        r3.add_exit("east", r4)
        r3.add_exit("north", r1)

        r4.add_exit("west", r3)
        r4.add_exit("north", r2)
        r4.add_exit("south", None)
        # add items
        r1.add_item("chair", "It's made of wicker")
        r1.add_item("big_table", "It's made of wicker.")

        r2.add_item("dog","It's made of wicker.")
        r2.add_item("wicker","It's made of wicker.")

        r3.add_item("tooth","It's made of wicker.")
        r3.add_item("floor","It's made of teeth")

        r4.add_item("dwayne_the_rock_johnson","He made of pure muscle and steroids.")
        r4.add_item("d_va", "She's made of code.")
        # add grabbables
        r1.add_grabbable("key")
        r2.add_grabbable("baby_gronk")
        r3.add_grabbable("the_ultimate_super_saiyan_excalibur")
        r4.add_grabbable("rick")

        # set the current room
        self.current_room = r1

    def setup_gui(self) -> None:
        # the input element
        self.player_input = Entry(self, bg = "white", fg = "black")
        self.player_input.bind("<Return>", self.process_input)
        self.player_input.pack(side=BOTTOM,fill=X)
        self.player_input.focus()

        # the image element
        img = None
        img_width = Game.WIDTH // 2
        self.image_container = Label (
            self,
            width = img_width,
            image = img
        )
        self.image_container.image = img
        self.image_container.pack(side=LEFT, fill=Y)
        self.image_container.pack_propagate(False)
        # the info area
        text_container_width = Game.WIDTH // 2
        text_container = Frame(self, width = text_container_width)
        self.text = Text(
            text_container,
            bg = "lightgrey",
            fg = "black",
            state = DISABLED
        )
        self.text.pack(fill = Y, expand = 1)
        text_container.pack(side=RIGHT, fill = Y)
        text_container.pack_propagate(False)

    def set_image(self):
        pass

    def set_status(self,status:str):
        pass

    def clear_entry(self):
        pass

    def handle_go(self,direction):
        pass

    def handle_look(self,item):
        pass

    def handle_take(self,grabbable):
        pass

    def handle_default(self):
        pass

    def play(self):
        pass

    def process_input(self):
        pass
