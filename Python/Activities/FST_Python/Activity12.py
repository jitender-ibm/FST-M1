def calculateSum(num):
    if num:
        return num + calculateSum(num-1)
    else:
        return 0

number = int(input("Enter an number: "))
result = calculateSum(number)

# Print result
print(result)