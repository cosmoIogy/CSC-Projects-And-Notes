favorite_foods = ["cabbages","spaghetti","crawfish","krabby patty",
                  "diet dr. kelp","saLADs","krusty krab pizza",
                  "caf nuggets","communion wafers"]

def make_sentence(food):
    return f"My least favorite food is {food}"

formatted = list(map(make_sentence, favorite_foods))

print(formatted)

#..lambda function
formatted = list(map(lambda food: f"My favorite food is {food}", favorite_foods))

print(formatted)
