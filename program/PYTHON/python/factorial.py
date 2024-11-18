#-------------------------- make a module to write factorial program by (using build in fanction)
#import math
#n = 5
#A = math.factorial(n)
#print(A)
#
#-------------------------- make a module to write factorial program by (user defind fanction )

def factorial(n):
    if n==0 or n==1:
        print(1)
    else:
        i=1
        f = 1
        while i<=n:
            f= f*i
            i+=1
        print(f)
factorial(5)
