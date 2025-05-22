# Write a Python program to remove the nth index character from a nonempty string

    # fast mathod
#def remove_char(str, n):
#    x = len(str)
#    q = ""
#    m=0
#    while m <x:
#        q+=str[m]
#        if m ==n:
#            continue
#        m+=1
#        
#    return q
#print(remove_char('Python', 3))

    # 2nd mathod 
n = int(input("enter number: "))
r = "romjan"
x =r[:n-1]
y = r[n:]
print(x+y)
