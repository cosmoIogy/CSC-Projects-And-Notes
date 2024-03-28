class Person:
    
    def __init__(self,name):
        pass
    
class Dylan(Person):
    def __init__(self):
        super().__init__("Dylan")
        Person.__init__(self, "Dylan")
        
        