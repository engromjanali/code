
# Create a program that asks the user to enter their name and their age.
# Print out a message addressed to them that tells them the year that they will turn 100 years old.

x = (input("enter your name:"))
y = int(input("enter your age:"))

z = str((2023-y) + 100)
print(x + "you will 100 year old in "+  z)