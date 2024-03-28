# Typical way of adding things to list

numbers = []

for i in range(10):
    numbers.append(i)
    
names = ["Dylan","Nick","Tyler","Obama","Serenity","Adam","Brandon"]
first_characters = []

for name in names:
    first_characters.append(name[0])
    
#with list comprehension

numbers = [i for i in range(10)]
print(numbers)

first_characters = [name[0] for name in names]
print(first_characters)

evens = [i for i in range(10) if i%2==0]
print(evens)

firsts = [name[0] for name in names if len(name)%2==0]
print(firsts)

#nesting
pairs = [(x,y) for x in range(4) for y in range(5)]
print(pairs)

pairs = [(x,y) for x in range(4) if x%2==0 for y in range(5) if y%2==1]
print(pairs)

[print(i) for i in range(10)]