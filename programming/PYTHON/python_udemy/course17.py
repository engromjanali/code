# Write a Python program to get the smallest number from a list.
x= [1, 2, -8, 0]
# return 2
y = min(x)
print(y)

# Write a Python program to get the smallest number from a list by useing fanction.
# min_num_in_list([1, 2, -8, 0])
# return 2
def min_num_in_list( list ):
    min = list[ 0 ]
    for a in list:
        if a < min:
            min = a
    return min
print(min_num_in_list([1, 2, 10,-8]))
