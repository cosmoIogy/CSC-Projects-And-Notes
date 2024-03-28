#####################################################################
# author: Blair Bourque
# date: 3/13/24
# description: 
#####################################################################
# global Constants to restrict the maximum x and y values that a person object
# can have.
MAX_X = 800
MAX_Y = 600
# A class representing a person. A person can be initialized with a
# name, as well as x and y coordinates. However, there are default
# values for all those (i.e. player 1, 0 and 0 respectively). A person
# also has a size which is set to 1 by default. A person can go left,
# go right, go up and go down. A person also has a string function
# that prints out their name location, and size. A person also has a
# function that calculates the euclidean distance from another person
# object.

class Person:
    def __init__(self, name:str="player 1", x:int=0, y:int=0):
        self._name = name
        self._x = max(0,min(x,MAX_X))
        self._y = max(0,min(y,MAX_Y))
        self._size = 1.0
    
    #accesors  
    @property
    def name(self):
        return self._name

    @property
    def x(self):
        return self._x
    
    @property
    def y(self):
        return self._y
    
    @property
    def size(self):
        return self._size
    
    #mutators  
    @name.setter
    def name(self, value):
        if len(value) >= 2:
            self._name = value
    
    @x.setter
    def x(self, value):
        if 0 <= value <= MAX_X:
            self._x = value
    
    @y.setter
    def y(self, value):
        if 0 <= value <= MAX_Y:
            self._y = value
    
    @size.setter
    def size(self, value):
        if value >= 1:
            self._size = value
        
    def goLeft(self, value=1):
        self._x = max(0, self._x - value)
        return self._x
        
    def goRight(self, value=1):
        self._x = min(MAX_X, self._x + value)
        return self._x

    def goUp(self, value=1):
        self._y = max(0, self._y - value)
        return self._y
        
    def goDown(self, value=1):
        self._y = min(MAX_Y, self._y + value)
        return self._y
       
    def getDistance(self, other):
        distance = ((other.x - self._x)**2 + (other.y - self._y)**2)**0.5
        return distance
        
    def __str__(self):
        return f"Person({self._name}): size = {self._size}, x = {self._x}, y = {self._y}"