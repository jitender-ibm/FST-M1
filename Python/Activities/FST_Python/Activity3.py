user1input = input("enter the input of 1st user: ")
user2input = input("enter the input of 2nd user: ")
if user1input == user2input:
    print("please try again, both inputs were same!")
elif user1input == "rock":
    if user2input == "scissors":
        print("first user won as rock beat scissor")
    else:
        print("user 2 won as paper beats rock")
elif user1input == "scissors":
    if user2input == "paper":
        print("first user won as scissor beat paper")
    else:
        print("user 2 won as rock beats scissor")
elif user1input == "paper" :
    if user2input == "rock":
        print("first user won as paper beats rock")
    else:
        print("user 2 won as scissors beats paper")
else:
    print("invalid input, please try again!!")