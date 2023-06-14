userList1 = list(input("Enter the elements of list: "))
userList2 = list(input("Enter the elements of list: "))
finalList= []
for temp in userList1:
    if (int(temp) % 2 != 0) :
        finalList.append(temp)

for temp in userList2:
    if (int(temp) % 2 == 0) :
        finalList.append(temp)

print("final list is", finalList)