#####################################################################
# author: Blair Bourque
# date: 3/31/24    
# description: A program that will make use of pygame, it will change the square everytime spacebar is hit and move when direction keys 
# are used
#####################################################################
import pygame
from random import randint, choice
from Item import *
from Constants import *

class Person(pygame.sprite.Sprite, Item):
    def __init__(self):
        # call the constructor of both parent classes
        pygame.sprite.Sprite.__init__(self)
        Item.__init__(self)
        
        # initialize instance variables
        self.color = [0xe3, 0x1b, 0x23]
        self.surf = pygame.Surface((self.size, self.size))
        self.surf.fill(self.color)
    
    #returns the color
    @property
    def color(self):
        return self._color
        
    #sets the color
    @color.setter
    def color(self, value):
        self._color = value
            
    #returns the surf
    @property
    def surf(self):
        return self._surf
    #sets the surf
    @surf.setter
    def surf(self, value):
        self._surf = value

    #sets a random position when launch
    def setRandomPosition(self):
        self.x = randint(0, WIDTH - self.size)
        self.y = randint(0, HEIGHT - self.size)
        
    #gets the position of the surf
    def getPosition(self):
        return (self.x - self.size/2, self.y - self.size/2)
        
    #sets the size of the surf and changes the color
    def setSize(self):
        self.size = randint(10, 100)
        self.surf = pygame.Surface((self.size, self.size))
        self.surf.fill(self.color)
    
        #sets the color of the surf
    def setColor(self):
        colorNum = randint(0,4)
        colorSurf = COLORS[colorNum]
        self.color = colorSurf
        self.surf.fill(colorSurf)
        
    #update based on key press
    def update(self, keys):
        if keys[pygame.K_UP]:
            self.goUp()
        if keys[pygame.K_DOWN]:
            self.goDown()
        if keys[pygame.K_LEFT]:
            self.goLeft()
        if keys[pygame.K_RIGHT]:
            self.goRight()
        if keys[pygame.K_SPACE]:
            self.setSize()
            self.setColor()
    
    #returns a string value
    def __str__(self):
        return f"Person color: {self.color}"
    
########################### main game################################
# DO NOT CHANGE ANYTHING BELOW THIS LINE
#####################################################################

# Initialize pygame library and display
pygame.init()
screen = pygame.display.set_mode((WIDTH, HEIGHT))

# Create a person object
p = Person()
RUNNING = True  # A variable to determine whether to get out of the
                # infinite game loop

while (RUNNING):
    # Look through all the events that happened in the last frame to see
    # if the user tried to exit.
    for event in pygame.event.get():
        if (event.type == KEYDOWN and event.key == K_ESCAPE):
            RUNNING = False
        elif (event.type == QUIT):
            RUNNING = False
        elif (event.type == KEYDOWN and event.key == K_SPACE):
            print(p)

    # Otherwise, collect the list/dictionary of all the keys that were
    # pressed
    pressedKeys = pygame.key.get_pressed()
    
    # and then send that dictionary to the Person object for them to
    # update themselves accordingly.
    p.update(pressedKeys)

    # fill the screen with a color
    screen.fill(WHITE)
    # then transfer the person to the screen
    screen.blit(p.surf, p.getPosition())
    pygame.display.flip()

