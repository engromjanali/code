# Write a Python program to remove duplicates from a list.
# Input a = [10,20,30,20,10,50,60,40,80,50,40]
# Output {40, 10, 80, 50, 20, 60, 30} 

# same to caracter can't servive in a set. so we  can remove duplicates elements from a list by convart to set.

a = [1,2,3,4,5,3,2,6]
x = set(a)
y = list(x)
print(y)