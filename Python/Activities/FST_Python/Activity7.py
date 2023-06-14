userList = list(input("enter the elements of the list: ").split(","))
total = 0
for element in userList:
    total = int(element) + total
print(total)