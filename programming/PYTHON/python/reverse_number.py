

#number = "romjan"
#number_reversed = number[::-1]
#print(number_reversed)

#number = "romjan ali mr.r"
#number_reversed = number[::-1]
#print(number_reversed)



#number ="romjan"

#number_reversed = number[::-1]
#print(number_reversed)

#number = [20,30,40]
#print(number[::-1])

def reverse(str1):
    rstr =""
    index = len(str1)
    while index != 0:
        rstr+=str1[index-1]
        index = index-1
    return rstr
print(reverse("12345"))
import time
x = time.localtime()
print(x)
