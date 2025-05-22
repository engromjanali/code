#-------------------------

#class persion:
#    fastname= "romjan "
#    last_name = "ali "
#    age = "ali "
#persion_objets = persion()
#fast = persion_objets.fastname 
#last = persion_objets.last_name
#age = persion_objets.age
#print("fast name : " , fast )
#print("last_name  ", last)
#print( " age : ", age  )

## -----------------------------
#
#class student:
#    def __init__(self , id_number , name , age ) :
#        self.id_number = id_number
#        self.name = name 
#        self.age = age 
#student1 = student(677844, "romjan ", 19 )
#student2 = student(677829, "kapil", 19 )
#student3 = student(677828, "jahid", 18)
#student4 = student(677813, "indrojid" , 18)
#
#x = student1.id_number
#y = student1.name 
#z = student1.age 
#
#print("student1 age  is ; " ,  x)
#print(" student1 name  is:  ; " , y )
#print("studen 1 age is:  " , z)
#
#print("student 2 id number is : " , student2.id_number)
#print( "student 2 name is : " , student2.name)
#print("student 2 age is : ",  student2.age )
#
#print("student 3 id number is :", student3.id_number )
#print("student 3 name is : " , student3.name)
#print("student 3 age is : ", student3.age)
#
#print("student 4 id is : ", student4.id_number)
#print("student 4 name is : ", student4.name)
##print("student4 age is : ", student4.age )
##
### -------------------------



#class student:
#    def __init__(self , id_number , name , age ) :
#        self.id_number = id_number
#        self.name = name 
#        self.age = age
#    
#    def  greet_student(self):
#        print("hello " + self.name + ", how are you?")
#
#
#student1 = student(677844, "romjan ", 19 )
#student2 = student(677829, "kapil", 19 )
#student3 = student(677828, "jahid", 18)
#student4 = student(677813, "indrojid" , 18)
#student1.greet_student()
#
#x = student1.id_number
#y = student1.name 
#z = student1.age 
#
#print("student1 age  is ; " ,  x)
#print(" student1 name  is:  ; " , y )
#print("studen 1 age is:  " , z)
#
#print("student 2 id number is : " , student2.id_number)
#print( "student 2 name is : " , student2.name)
#print("student 2 age is : ",  student2.age )
#
#print("student 3 id number is :", student3.id_number )
#print("student 3 name is : " , student3.name)
#print("student 3 age is : ", student3.age)
#
#print("student 4 id is : ", student4.id_number)
#print("student 4 name is : ", student4.name)
#print("student4 age is : ", student4.age )




##--------------------------------------
class student:
    def __init__(self,name,age,roll,city):
        self.name = name
        self.age =  age
        self.roll = roll
        self.city = city
    def great_student(self):
        print("hello "+ self.name + "\n congratulation! \n you are the great student on the batch of AWS 43 - ALPHA") 

    def student_info(self):
        print("name =",self.name, "\nage = ", self.age,"\nroll = ",self.roll, "\ncity = " , self.city,"\n")

kapil = student("kapil uddin" , 19 , 677829, "cox's baxer")
jahid = student("jahid mia ", 18, 677828,"brahmanbaria")
romjan = student( "md romjan ali ", 19, 677844, "cumilla")
sakib = student("sakib", 19, 677845, "cumilla")
arfat = student("md arfat mia", 20, 677819, "brahmanbaria - sador")

kapil.great_student()

romjan.student_info()
kapil.student_info()
sakib.student_info()
jahid.student_info()
arfat.student_info()

