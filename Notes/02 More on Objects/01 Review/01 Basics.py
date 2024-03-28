class House:
    #class names are written in UpperCamelCase
    
    MIN_PRICE = 0 #class variable, it's a constant because of the SCREAMING_SNAKE_CASE
    
    def __init__(self, price:float, sqft:int): #self is a reference to the object
        #constructor
        self.price = price   #this is an instance variable
        self.sqft = sqft 
     
    @property    
    def price(self):
        return self._price
    
    @price.setter
    def price(self, value):
        if value > House.MIN_PRICE:
            self._price = value

    def __str__(self):
        return f"Price: {self.price}"

h = House(10.0,1)
h.price = -100.00