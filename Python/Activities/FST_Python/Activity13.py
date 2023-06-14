def calculate_sum(numbers):
    sum = 0
    for number in numbers:
        sum += number
    return sum

userInupt = list(map(int, input("Enter the numbers: ").split()))

result = calculate_sum(userInupt)
print("The sum is: " + str(result))