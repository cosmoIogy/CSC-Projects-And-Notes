#####################################################################
# author: Blair Bourque 
# date: 4/4/24
# description: An employee class  
#####################################################################

# import the abc library to make abstract classes
from abc import ABC, abstractmethod

######################################################################
# An employee class. Its constructor takes the first name, last name and
# pay. It also has email and position as instance variables. It contains
# a single abstract method i.e. applyRaise, and a createEmail function
# that creates an appropriate email address from the employee's first
# and last names.
######################################################################

class Employee(ABC):
    def __init__(self, firstname:str, lastname:str, pay:int):
        self.firstname = firstname
        self.lastname = lastname
        self.pay = pay
        self.email = self.createEmail()
        self.position = None
        
    @property    
    def firstname(self):
        return self._firstname
    
    @firstname.setter
    def firstname(self, value):
        self._firstname = value.strip().lower().capitalize()
        
    @property    
    def lastname(self):
        return self._lastname

    @lastname.setter
    def lastname(self, value:int):
        self._lastname = value.strip().lower().capitalize()
    
    @property
    def pay(self):
        return self._pay
    
    @pay.setter
    def pay(self, value):
        self._pay = max(value, 20000)
    
    @property
    def email(self):
        return self._email
    
    @email.setter
    def email(self, val):
        if (val.find("@latech.edu") >= 0):
            self._email = val
    
    ##
    
    def createEmail(self):
        return f"{self.firstname.lower()}.{self.lastname.lower()}@latech.edu"
   
    
    def __str__(self):
        return f"{self.lastname}, {self.firstname} ({self.email})"

    @abstractmethod
    def applyRaise(self, rate:int):
        raise NotImplementedError("applyRaise not implemented in subclass!")
    
######################################################################
# A faculty class is a subclass of the Employee class above. Its
# constructor receives both names as well as the position. The Faculty
# class also overrides the applyRaise function by multiplying the pay by
# the rate provided as an argument. It also slightly tweaks the __str__
# function in the super class.
######################################################################

class Faculty(Employee):
    def __init__ (self, firstname, lastname, position):
        super().__init__(firstname, lastname, pay = 50000)
        self.position = position
        
    def applyRaise(self, rate: int):
        if rate > 0:
            self.pay = self.pay * rate
        else:
            pass
            
    def __str__(self):
        return f"{self.lastname}, {self.firstname} ({self.email}) -- {self.position}"
    
######################################################################
# A Staff class is a subclass of the Employee class above. Its
# constructor only receives both names. It also overrides the applyraise
# function but adding the increase (provided as the argument) to the
# pay. It doesn't change anything else from the Employee class.
######################################################################

class Staff(Employee):
    def __init__(self, firstname, lastname):
        super().__init__(firstname, lastname, pay = 40000)

    
    def applyRaise(self, rate:int):
        if rate > 0:
            self.pay = self.pay + rate
        else:
            pass
    