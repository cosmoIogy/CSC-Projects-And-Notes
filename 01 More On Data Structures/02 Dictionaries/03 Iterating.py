my_dictionary = {
    "first":"Blair",
    "last":"Bourque",
    "favorite number":10,
}

#default iteration is over the keys
for key in my_dictionary:
    print(key, my_dictionary[key])
    
# can be explicit and use keys
for key in my_dictionary.keys():
    print(key,my_dictionary[key])
    
#iterate over the values with .values()
for val in my_dictionary.values():
    print(val)
    
#iterate over both keys and values with .items()
for key, value in my_dictionary.items():
    print(key, value)
    
