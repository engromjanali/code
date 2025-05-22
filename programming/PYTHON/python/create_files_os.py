#___stel now creatr a new file and open an file & write and reed

#new = open("C:\Users\DELL\Desktop\demo.txt","x")  # if we do not use path in the code, the file will maked in the larn python folder 
# file opration
#new.close()


# start writeing  ---------------
#import os
#os.remove("romjanc.txt")


#f = open("romjan.txt", "w") #"x" = x,w,a,r.(create,write,add,read)
#f.write("\n i am a cyber \n  spcailist\ ")#write
#f.write("now i am a student ") # write in next line
#f.write("now i am a student ")# write in next line
#f.write("i am a cyber spcailist\ ")#add jast x = a
#f.close()

# read file
#f = open("romjan.txt", "r")
#x = f.read()
#x = f.readline()# jast read 1 line
#y = f.readline()# for read 2nd line 
#y = f.readline()# for read 3rd line
#print(x)
#
# stard reading-----------------
#x = f.read()
#print(x)
#

#----------------delete ---------------------------------------
# for delete you will need to import a fanksion that is "os" # watch on  top
#f = open("romjanc.txt", "r")
#f.close()
    
#  ---------------sccess File from dasktop-------------------

#f = open(r"C:\Users\DELL\Desktop\txxx.txt", "x")
#x = f.readline()# jast read 1 line
#y = f.readline()# for read 2nd line 
#z = f.readline()# for read 3rd line
##print(x,y,z)
#
##f = open("romjan_ali.py", "w")
##x = f.write("i also a  remamber")
##print(x)
#
#f = open("romjan.txt", "r+")
#x = f.readline()
#print(x)
#f.close()
#
#f = open("romjan.txt", "r")
#x = f.readline(6)
#print(x)
#f.close()

i = 1
listS = []
while ( i<=5):
    element =f"{i: 06d}"
    #print(element)
    listS.append(element)
    #print(listS)
    i+=1

l = len(listS)
listS= str(listS)
print(l)
#print(listS)
#print(type(listS))
newlist ="romjan"
j=0
while j <= l:
    newlist+="\n"+listS[5]
    

print(newlist)











f = open("password.txt", "w")
x= f.write(listS)
f.close()


