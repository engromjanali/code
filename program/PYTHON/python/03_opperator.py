#---------------operator ----------------
#there are 6 quality opertor
#1 Arithmetic operator 2 assignment operatoe 3 comprarison operator
#4 logical operator 5 identity operator 6 membership operator 7 bitwaise operator
 
#-------------arithmetic operator--------------

#print(10-20)#subtaction
#print(10+20)#addation
#print(10*20)#multipilication
#print(10/20)#dibision(desimal)
#print(10**20)#exponentitation
#print(10%3)#remainder
#print(101//20)#floor dibision(intger)

#---------assignment operator ------------

#z = 20
#x = 52
#y = 88
#x += y #x = x+y
#
# print(x)

#-----------comprasion ---------------
#x = 39
#y = 40 
#compare =x==y
#compare =x>=y#geter then or equalto
#compar = x<y
#compar = x<=y
#PRINT_1 = A!=B # UNEQUALTY
#print(PRINT)
#print(PRINT_1)

#X = 5
#Y = 6
#Z = X==Y 
#Z = X!=Y
#print(Z)
#print(compare)# true/false
#print(compar)

#----------LOGICAL TRUE FALSE AND OR NOT ---------------

#LOGICAL AND OPRATOR
#--TROUTH TABILE---
#TT = True
#TF = False
#FT = False
#FF = False 
#LOGICAL_AND
#x = 55
#y = 50
#logical_and = x>y and x>y 
#print(logical_and)

#-----------logical or oprator ------------
#TT = True
#TF = true
#FT = true
#FF = False 
#x = 55
#y = 50
#logical_or = x>y or x<y 
#print(logical_or)
#------logical not oprator---------------
#(true hoibe false and false hoiba true)
#T= False
#F = True
#x = 5 
#y = 5 
#logical_not = not x<y 
#logical_not1 = not x==y
#print(logical_not)
#3print(logical_not1)



#def romjan(n):
#    sum = 0 
#    for I in range (n):
#        if I %2 == 1:
#            sum+=I
#    return sum
#x = romjan(5)
#print(x)

#def facturial(x):
#    if x ==1:
#        return 1 
#    else :
#        return (x * facturial(x-1))
#x = int(input("enter you value: "))
#print(facturial(x))

class animal:
    def __init__(self,name):
        self.name = name 
        print(self.name + "was adopted.")
    def run(self):
        print("running")
        