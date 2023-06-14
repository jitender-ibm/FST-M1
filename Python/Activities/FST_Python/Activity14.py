def fibonacci(number):
    if number <= 1:
        return number
    else:
        return(fibonacci(number-1) + fibonacci(number-2))

userInput = int(input("Enter a number: "))

if userInput <= 0:
    print("Enter positive integer")
else:
    print("Fibonacci Sequence is: ")
    for i in range(userInput):
        print(fibonacci(i))