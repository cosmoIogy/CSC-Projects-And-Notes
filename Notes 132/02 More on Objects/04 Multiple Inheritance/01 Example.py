class Bread:
    def __init__(self, flour_type:str, is_moldy:bool):
        self.flour_type = flour_type
        self.is_moldy = is_moldy
        
    def __str__(self):
        return f"Flour : {self.flour_type}; Moldy: {self.is_moldy}"
    
class SaleItem:
    def __init__(self, price):
        self.price = price
    
    def __str__(self):
        return f"Price: {self.price}"
    
class Bun(Bread, SaleItem):
    def __init__(self):
        Bread.__init__(self, "Wheat", False)
        SaleItem.__init__(self, 10)
        
    def __str__(self):
        return f"Bun: {self.flour_type}; Price {self.price}"
    
b = Bun()
print(b)