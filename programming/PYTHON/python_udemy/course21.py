# Write a Python program to find the second smallest number in a list.
# input
def find_second_smallest(lst):
    if lst[1] > lst[0]:
        smllest = lst[0]
        second_smllest = lst[1]
    else:
        second_smllest = lst[0]
        smllest = lst[1]
    for i in range (2,len(lst)):
        if lst[i] < smllest:
            second_smllest = smllest
            smllest = lst[i]
            return second_smllest
        #elif lst[i] < second_smllest and smllest != lst[i]:
            second_smllest = lst[i]
        return second_smllest 
x=find_second_smallest([-1,60,2,3,])
print(x)