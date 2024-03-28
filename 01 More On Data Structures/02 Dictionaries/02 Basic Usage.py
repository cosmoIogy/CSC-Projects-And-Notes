my_dictionary = {
"first":"josh",
"last":"coriell",
"favorite food":"tacos",
10:3000,
} 

#accessing values
food = my_dictionary["favorite food"]
food = my_dictionary.get("favorite food") # safe way to access
#assigning new values
my_dictionary["favorite color"] = "green"
my_dictionary["favorite food"] = "mole" 


print(my_dictionary)