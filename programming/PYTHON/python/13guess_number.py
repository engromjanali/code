#------------guess the number game in paython----------------

#    1------
# mynum = 5
#print("i have a number in my maind, can you guess it?")
#usernum = int(input("inter your guess: "))
# 
#if mynum == usernum:
#    print("yes you are right")
#elif mynum < usernum:
#    print("your guess is greater than then my number, thank you!")
#else:
#    print("your guess is less than then my number, thank you!")

#----2-----------

mynum = 5
while True:
    usernum = int(input("inter your guess: "))
     
    if mynum == usernum:
        print("yes you are right, \n congratulation.")
        break
    elif mynum < usernum:
        print("your guess is greater than then my number, thank you!")
    else:
        print("your guess is less than then my number, thank you!")
#--3-----------

#import random
#mynum = random.randint(0,9)
#print("i have a number in my maind, can you guess it?")
#while True:
    #usernum = int(input("inter your guess: "))
     
    #if mynum == usernum:
    #    print("yes you are right, \n congratulation.")
     #   break
    #elif mynum < usernum:
     #   print("your guess is greater than then my number, \ntry agin!")
    #else:
     #   print("your guess is less than then my number,\n try agin!")
