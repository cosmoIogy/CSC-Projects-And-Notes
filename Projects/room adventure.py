###################################################################################
###################################
# Name: Blair Bourque
# Date: 1/3/24
# Description: A room adventure
###################################################################################
###################################

class Room:
    def __init__(self, name):
        self.name = name
        self.items = []
        self.exits = []
        self.grabbables = []
        self.exitNames = []
        self.itemDescriptions = []

    @property
    def name(self):
        return self._name

    @name.setter
    def name(self,value):
        self._name = value

    @property
    def items(self):
        return self._items

    @items.setter
    def items(self,value):
        self._items = value
    
    @property
    def exits(self):
        return self._exits

    @exits.setter
    def exits(self,value):
        self._exits = value

    @property
    def grabbables(self):
        return self._grabbables

    @grabbables.setter
    def grabbables(self,value):
        self._grabbables = value

    @property
    def exitNames(self):
        return self._exitNames

    @exitNames.setter
    def exitNames(self,value):
        self._exitNames = value

    @property
    def itemDescriptions(self):
        return self._itemDescriptions

    @itemDescriptions.setter
    def itemDescriptions(self,value):
        self._itemDescriptions = value

    def addExit(self,exitName,destinationRoom):
        self.exitNames.append(exitName)
        self.exits.append(destinationRoom)

    def addItem(self,itemName,itemDescription):
        self.items.append(itemName)
        self.itemDescriptions.append(itemDescription)

    def addGrabbable(self,grabbable):
        self.grabbables.append(grabbable)

    def delGrabbable(self, item):
        # remove the item from the list
        self._grabbables.remove(item)

    # returns a string description of the room
    def __str__(self):
    # first, the room name
        s = "You are in {}.\n".format(self.name)
        
    # next, the items in the room
        s += "You see: "
        for item in self.items:
            s += item + " "
        s += "\n"
        
    # and now the exits
        s+="Exits to the:\n"

        for exitName in self.exitNames:
            s+=exitName+"\n"

        s+="\n"

        return s

def createRooms():
    # add the rooms
    r1 = Room("Room 1")
    r2 = Room("Room 2")
    r3 = Room("Room 3")
    r4 = Room("Room 4")

    # add exits to room 1
    r1.addExit("east", r2)  # -> to the east of room 1 is room 2
    r1.addExit("south", r3)

    # add grabbables to room 1
    r1.addGrabbable("key")
    r1.addGrabbable("hat") ##added code

    # add items to room 1
    r1.addItem("chair", "It is made of wicker and no one is sitting on it.")
    r1.addItem("table", "It is made of oak. A golden key rests on it.")
    r1.addItem("prather", "It is a man named prather. He has a hat on his head.") ##added code
    r1.addItem("twins", "Freakishly alike twins.") ##added code
    
    # add exits to room 2
    r2.addExit("west", r1)
    r2.addExit("south", r4)

    # add grabbables to room 2
    r2.addGrabbable("toy") ##added code

    # add items to room 2
    r2.addItem("rug", "It is nice and Indian. It also needs to be vacuumed.")
    r2.addItem("fireplace", "It is full of ashes.")
    r2.addItem("dog", "It is a golden retriever, he has big black cute eyes. He has a toy in his mouth") ##added code
    r2.addItem("caluclus book", "It seems to be opened to a page that has work written on it.") ##added code
    
    # add exits to room 3
    r3.addExit("north", r1)
    r3.addExit("east", r4)

    # add grabbables to room 3
    r3.addGrabbable("book")
    r3.addGrabbable("cat") ##added code
    
    # add items to room 3
    r3.addItem("bookshelves", "They are empty. Go figure.")
    r3.addItem("statue", "There is nothing special about it.")
    r3.addItem("desk", "The statue is resting on it. So is a book.")
    r3.addItem("red_velvety_blanket", "It is so red and velvety, there is a cat laying on it") ##added code

    # add exits to room 4
    r4.addExit("north", r2)
    r4.addExit("west", r3)
    r4.addExit("south", None)  # DEATH!

    # add grabbables to room 4
    r4.addGrabbable("6-pack")
    r4.addGrabbable("coin") ##added code

    # add items to room 4
    r4.addItem("brew_rig", "Gourd is brewing some sort of oatmeal stout on the brew rig. A 6-pack is resting beside it.")
    r4.addItem("golden_fountain", "Extremely shiny fountain, there is a coin at the bottom of the fountain.") ##added code

    # set room 1 as the current room at the beginning of the game
    currentRoom = r1

    return currentRoom


currentRoom = createRooms()

print(currentRoom)

######Start game yay

inventory = []
createRooms()

# play forever (well, at least until the player dies or asks to quit)
while (True):
    # set the status so the player has situational awareness
    # the status has room and inventory information
    status = "{}\nYou are carrying: {}\n".format(currentRoom, inventory)

    # if the current room is None, then the player is dead
    # this only happens if the player goes south when in room 4
    # exit the game
    if (currentRoom == None):
        death()
        break
    
    # display the status
    print("========================================================")
    print(status)


    # prompt for player input
    # the game supports a simple language of <verb> <noun>
    # valid verbs are go, look, and take
    # valid nouns depend on the verb
    action = input("What to do? ")

    # set the user's input to lowercase to make it easier to compare
    # the verb and noun to known values
    action = action.lower()

    # set a default response
    response = "I don't understand. Try verb or noun. Valid verbs are go, look, and take"

    # split the user input into words (words are separated by spaces)
    # and store the words in a list
    words = action.split()

    # the game only understands two word inputs
    if (len(words) == 2):
    # isolate the verb and noun
        verb = words[0]
        noun = words[1]

        # the verb is: go
        if verb == "go":
            # set a default response
            response = "Invalid exit."

            # check for valid exits in the current room
            for exitName in currentRoom.exitNames:
                # a valid exit is found
                if noun == exitName:
                    # change the current room to the one associated with the specified exit
                    currentRoom = currentRoom.exits[currentRoom.exitNames.index(exitName)]
                    # set the response (success)
                    response = "Room changed."
                    # no need to check any more exits
                    break


        # the verb is: look
        elif (verb == "look"):
            # set a default response
            response = "I don't see that item."

            # check for valid items in the current room
            for i in range(len(currentRoom.items)):
                # a valid item is found
                if noun == currentRoom.items[i]:
                # set the response to the item's description
                    response = currentRoom.itemDescriptions[i]
                    # no need to check any more items
                    break

        # the verb is: take
        elif (verb == "take"):
        # set a default response
            response = "I don't see that item."

            # check for valid grabbable items in the current room
            for grabbable in currentRoom.grabbables:
                if noun == grabbable:
                    inventory.append(grabbable)
                    currentRoom.grabbables.remove(grabbable)
                    response = "Item grabbed."
                    break

    # display the response
    print("\n{}".format(response))
