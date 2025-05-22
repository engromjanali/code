x = int(input("enter the year: "))
y = x % 400
z = x % 4
p = x % 100
if y ==0 :
    print("the year is leap year ")
elif  z ==0 or p != 0:
    print("the year is leap year")
else :
    print("the year is not leap year")

str