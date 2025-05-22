# Write a Python program that accepts a string and calculate the number of digits and letters
# Sample Data : "Python 3.2"
# Expected Output :
# Letters 6 
# Digits 2

s = input("input a istring: ")

d = l = 0

for c in s :
    if c.isalpha():
        d = d+1
    elif c.isalpha():
        l=l+1
    else :
        pass
print("letters", l)
print("degits", d)
