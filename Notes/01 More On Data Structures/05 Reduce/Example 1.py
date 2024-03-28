from functools import reduce

a_list = [1,2,3,4,5,6]

def multiply(a,b): # function has 2 arguments
    return a * b

result = reduce(multiply, a_list)
print(result)