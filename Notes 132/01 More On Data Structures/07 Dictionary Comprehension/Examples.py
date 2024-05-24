a_dictionary = { x:x+1  for x in range(10) if x%2==0}
print(a_dictionary)

names = ["Stephanie","August","DAB","Fay","Blaine","Adam","Nick"]
ages = [18,78,45,18,32,112,2]

a_dictionary = { names[i]:ages[i] for i in range(len(names))}
print(a_dictionary)
