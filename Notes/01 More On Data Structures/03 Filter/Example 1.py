names = ["Colin", "Dylan", "Jeffrey", 
         "Jackson", "Blaine","Josh","Craig",
         "Johnathan","John","James","Jolene"]

def starts_with_j(name:str) -> bool:
    if name[0]=="J":
        return True
    else:
        return False
    
j_names = filter(starts_with_j,names)
print(list(j_names))

# ... with lambda functions
j_names = list(filter(lambda name:name[0]=="J", names))
print(j_names)