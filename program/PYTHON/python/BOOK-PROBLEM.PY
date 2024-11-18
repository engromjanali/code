#--------------CARCLE-ARIA বৃওের ক্ষেএফল---------------

##r = float(input("inter the radiud:"))
#pi = 3.1416
#carcle_aria = pi*r*r 
#print("your carcle aria is ")
#print(carcle_aria)
#the ind

#----------rectangle-aria আয়ত খেএ ------------

#length = float(input("inter the langth"))
#width = float(input("inter the width"))
#aria = length*width
#print("the rectangale aria is ")
#print(aria)


#---------------triangal-aria (সমকোনি  এীভুজের ক্ষেএফল)--------------

#bace = float(input("inter the bace"))
#hight = float(input("inter the hight"))
#aria = bace*hight*.5
#print(aria)

#--------faranhight skil to chalcies skil--------

#f = float(input("inter the f.skil: "))
#c = ((f-32)*5)/9
#print("the tramprator is :")
#print(c)

#----------BIGGEST BALU IN 3 NUMBER-----------

#a = float(input("inter the valu of a: "))
#b = float(input("inter the valu of b: "))
#c  = float(input("inter the valu of c:"))
#if a>b and a>c:
    #print("a is the largest number")
#elif a<b and c<b:
   # print("b is the largest number")
#elif a==b or a==c or b==c:
  #  print("the largest two number, that is equal.")
#else:
 #   print("c is the largest number")

#-----------দ্বিঘাত সমিকরনরে মূল (ax^2 +bx +c = 0)---------
#a = float(input("inter the valu of a "))
#b = float(input("inter the valu of b "))
#c = float(input("inter the valu of c "))

#d =  (b**2) - (4*a*c)
#if d>0 : 
#      x1 = (-b+(d**.5))/(2*a)
#      x2 = (-b-(d**.5))/(2*a)
#      print(x1 , x2 )
#elif d ==0:
#      x = -b/(2*a)
#      print(x )
#else :
#      print("the numober are imagenary")
      









#import math
#a = float(input("inter valu of a "))
#b = float(input("inter valu of b "))
#c = float(input("inter valu of c "))

#d = (b*b) - (4*a*c)
#x =  (-b)/(2*a)
#x1 =(-b + (d**.5))/(2*a)
#x2 =(-b - (d**.5))/(2*a)
#x1 = (-b + math.sqrt(d))/(2*a)
#x2 = (-b - math.sqrt(d))/(2*a)
#if d==0:
#    print("x:", x)
#elif d>0 :
#    print("x1:", x1)
#    print("x2:", x2)
#else:
#    print("root are imaginary")
    

#(-b + (d**.5))/(2*a)

#-------------------- factorail --------------

#n = int(input("enter the valu of n :"))
#if n<0 :
#  print("nagative number are not allowed.")
#elif n == 1 or n==0:
#      print("fact is :1")
#else :
#      i = 1

#      fact = 1

#      while i < n :
 #           i += 1
#            fact = fact * i
#      print("facts is :" , fact)

#print("program finesh.")

#example 2: facturial by fanction.
#def factrial(n):
#    if n==1 or n==0 :
#        return 1
#    else:
#        x = (n * factrial(n-1))
#        return x
#y = factrial(5)
#print(y)

#example 3: 
#def factrial(n):
#   y =1
#   i= 1
#   while i<n:
#      i+=1
#      y*=i
#   return y
#
#p = factrial(5)
#print(p)

#q = 5 
#r = type(q) is not int
#print(r)


#--------------------namta---------------------


#a = int(input("enter the number: "))
#i = 1 
 
#while i <= 10:
#      sum = (a*i)
#      print(a , "*" , i , '=' , sum)
#      i+=1

