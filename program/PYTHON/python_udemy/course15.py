# Write a Python program to find common items from two lists.
# input
# color1 = "Red", "Green", "Orange", "White"
# color2 = "Black", "Green", "White", "Pink"
# output
# {'Green', 'White'}

#input
color1 = {"Red", "Green", "Orange", "White", "Black"}
color2 = {"Green", "White", "Pink"}

    
print(color1 & color2)