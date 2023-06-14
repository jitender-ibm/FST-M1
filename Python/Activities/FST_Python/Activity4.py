user1Name = input("Enter name of user 1: ")
user2Name = input("Enter name of user 2: ")

userChoices = True
userChoice = "yes"
while userChoices == True:
    if userChoice == "yes":
        user1input = input("enter the input of 1st user: ")
        user2input = input("enter the input of 2nd user: ")
        if user1input == user2input:
            print("please try again, both inputs were same!")
        elif user1input == "rock":
            if user2input == "scissors":
                print(user1Name +" won as rock beat scissor")
            else:
                print(user2Name +" won as paper beats rock")
        elif user1input == "scissors":
            if user2input == "paper":
                print(user1Name +" won as scissor beat paper")
            else:
                print(user2Name +" won as rock beats scissor")
        elif user1input == "paper" :
            if user2input == "rock":
                print(user1Name +" won as paper beats rock")
            else:
                print(user2Name +" won as scissors beats paper")
        else:
            print("invalid input, please try again!!")
    userChoice = input("Do you wanna play again? ").lower();
    if userChoice == "yes":
        continue
    elif userChoice == "no":
        userChoices = False
    else:
        raise SystemExit