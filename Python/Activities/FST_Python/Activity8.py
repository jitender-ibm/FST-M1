userList = list(input("Enter the numbers of the lists: ").split(","))
listSize = (len(userList))
lastElement = userList[listSize-1]
if userList[0] == lastElement:
    print(userList[0], "true")
else:
    print("false")