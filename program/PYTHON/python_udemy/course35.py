# Write a Python script to print a dictionary where the keys are numbers between 1 and 15 (both included) and the values are square of keys.
r = dict()

for i in range(1,15):
    r[i] = i**2
    
print(r)