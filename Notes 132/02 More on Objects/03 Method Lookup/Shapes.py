class Shape:
    def __init__(self, length, width):
        self.length = length
        self.width = width
        
    def draw(self):
        for _ in range(self.width):
            print("*" * self.length)
            
class Rectangle(Shape):
    def __init__(self, length, width):
        super().__init__(length, width)
        
        
class Square(Shape):
    def __init__(self, side):
        super().__init__(side, side)
        
class Triangle(Shape):
    def __init__(self, side):
        super().__init__(side,side)
    
    def draw(self):
        for i in range(self.width):
            print ("*" * (self.width - i))
            
r = Rectangle(5,3)
r.draw()

t = Triangle(4)
t.draw()