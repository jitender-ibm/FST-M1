userDict = {
    "apple": 100,
    "orange": 50,
    "mango": 80,
    "grapes": 120,
    "kiwi": 30
}
fruitToCheck = input("Enter the fruit name to check in dictionary: ").lower()
if fruitToCheck in userDict:
    print("The fruit name you entered is present into the dictionary")
else:
    print("The fruit name you entered is not present into the dictionary")
