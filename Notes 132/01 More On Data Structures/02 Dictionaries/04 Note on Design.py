#Sidenote on design

#Do I use dictionaries or objects/classses?
#Answer: Up to you. It is a design decision

# User as a dictionary:
user = {
    "username":"blair",
    "email":"cosmomail12@gmail.com",
    "password":123456,
}

# User as a class
class User:
    def __init__(self, username, password):
        self.username = username
        self.email = f"{username}@latech.edu"
        self.password = password
        
u = User("Blair", 123456)
print(u)

