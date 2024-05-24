users = [
    {"username":"Aang", "age": 112},
    {"username":"Goku", "age": 37},
    {"username":"Mercy", "age": 39},
    {"username":"Master Chief", "age":49},
    {"username":"The Lorax", "age":70},
]

def is_old(user:dict) -> bool:
    if user["age"]>=49:
        return True
    return False

olds = list(filter(is_old,users))
print(olds)

# ... as a lambda function
olds = list(filter(lambda user: user["age"] >= 49, users))
print(olds)