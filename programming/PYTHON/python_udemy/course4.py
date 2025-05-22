#Write a Python program to check a triangle is valid or not

def tryngel_chack(x,y,z):
    if (x+y<z) or (x+z<y) or (z+y<x):
        print("the tryangle is not valid")
    elif (x==y+z) or (y==z+x) or (z==x+y):
        print("the tryangle is  valid")
    else :
        print("the tryangle is valid")
A = int(input("enter the valu of X:"))
B =int(input("inter the valu of Y:"))
C = int (input("enter the value of Z:"))
tryngel_chack(A,B,C)
