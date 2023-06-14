userTuple = tuple(input("Enter the tuple elements: ").split(","))
for element in userTuple:
    if int(element)%5 == 0:
        print(element, "is divisible by 5")