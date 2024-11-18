import math
def triangle ():
    a = int(input("enter the value of a:"))
    b = int( input("enter the value of b : "))
    c = int(input("enter the value of c: "))
    if (a+b)<c or (b+c)<a or (c+a)<b:
        print("the triangle is not possible: ")
    else :
        s = (a+b+c)/2
        area = math.sqrt(s*(s-a)*(s-b)*(s-c))
        print("area of the triangle is : ", area)
    return()
triangle()


open("30.py", "x")


