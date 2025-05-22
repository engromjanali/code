
n = int(input("enter the number of file: "))
f = "problem_"
l = ".java"
lis = [ "problem_05.java"]

for b in range (n):
    if b >=5:
        ba = str(b)
        x= str(f+ba+l)
        #print(x)
        lis.append(x)

print(lis)
m= len(lis)
print(m)

for i in range(m):
    open(lis[i], "w")
