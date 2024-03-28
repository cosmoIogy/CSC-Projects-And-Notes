from functools import reduce

names = ["Joshua","Michael","Coriell"]

def combine_names(name1,name2):
    return f"{name1} {name2}"

full_name = reduce(combine_names, names)
print(full_name)