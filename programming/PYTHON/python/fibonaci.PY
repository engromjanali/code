# Write a Python program to get the Fibonacci series between 0 to 50
n = int (input("enter the value which number you want to print fibo: "))
x  = 0
y = 1
p=0
print(x,y)
while p<(n-1):
    z = x+y
    print(z,end=" ")
    x=y
    y=z
    p+=1


    