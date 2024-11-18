# Count the number of even and odd numbers from a series of numbers
# Input 
# numbers = (1, 2, 3, 4, 5, 6, 7, 8, 9) # Declaring the tuple
# Output
# Number of even numbers : 4                                                                                    
# Number of odd numbers : 5
numbers = (1, 2, 3, 4, 5, 6, 7, 8, 9,15) # Declaring the tuple
x_even = 0
y_odd = 0
for x in numbers:
    if not x % 2:
        x_even += 1
    else:
        y_odd+=1
                
print("Number of even numbers :",x_even)
print("Number of odd numbers :",y_odd)