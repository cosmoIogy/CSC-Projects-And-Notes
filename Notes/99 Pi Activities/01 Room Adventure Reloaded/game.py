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
        if self.current_room==None:
            img = PhotoImage(file=os.path.join("images","skull.gif"))
        else:
            img = PhotoImage(file=self.current_room.image)
        
        self.image_container.config(image=img)
        self.image_container.image = img
                    
    def set_status(self,status:str):
        self.text.config(state=NORMAL)
        self.text.delete(1.0, END)
        if self.current_room == None:
            self.text.insert(END, Game.Status.DEAD)
        else:
            content = f"{self.current_room}\n"
            content += f"You are carrying: {self.inventory}\n\n"
            content += status
            self.text.insert(END, content)
        
        self.text.config(state=DISABLED)
        
        
    def clear_entry(self):
        self.player_input.delete(0, END)

    def handle_go(self,direction):
        status = Game.Status.BAD_EXIT
        
        if direction in self.current_room.exits: #the keys for exits
            self.current_room = self.current_room.exits[direction]
            status = Game.Status.ROOM_CHANGED
            
        self.set_status(status)
        self.set_image()
        
    def handle_look(self,item):
        status = Game.Status.BAD_ITEM
        if item in self.current_room.items: #the keys for the items
            status= self.current_room.items[item]
            
        self.set_status(status)
        
    def handle_take(self,grabbable):
        status = Game.Status.BAD_GRAB
        if grabbable in self.current_room.grabbables:
            self.inventory.append(grabbable)
            self.current_room.delete_grabbable(grabbable)
            status = Game.Status.GRABBED

        self.set_status(status)
        
    def handle_default(self):
        self.set_status(Game.Status.DEFAULT)
        self.clear_entry()

    def play(self):
        self.setup_game()
        self.setup_gui()
        self.set_image()
        self.set_status("")

    def process_input(self, event):
        
        # get the input from the entry element
        action = self.player_input.get()
        action = action.lower()
        
        #stop the game if applicable
        if action in Game.EXIT_ACTION:
            exit()
            
        #clear the entry if None
        if self.current_room == None:
            self.clear_entry()
            return
        
        #sanitize the input
        words = action.split()
        
        if len(words) != 2:
            self.handle_default()
            return 
        
        verb = words[0]
        noun = words[1]
        
        #hande the appropriate verb
        match verb:
            case "go":
                self.handle_go(noun)
                
            case "look":
                self.handle_look(noun)
                
            case "take":
                self.handle_take(noun)

        self.clear_entry()