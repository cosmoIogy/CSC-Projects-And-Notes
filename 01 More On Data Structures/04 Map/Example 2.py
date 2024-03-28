incoming_data = [
    ["Jeffrey","krabby patty"]
    ["Dylan","krsuty krab pizza"]
    ["Brandon","spaghetti"]
    ["Sage","burger"]
    ["Josh","tacos"]
]

def list_to_dict(item):
    return {"name": item[0], "favorite food": item[1]}

result = list(map(list_to_dict, incoming_data))

#.. lambda
result = list(
    map(
        lambda item: {"name": item[0], "favorite food": item[1]},
        incoming_data
    )
)

