q1 = '''what is the name of your institute? 
a) bbpi
b) cpi
c)dmc
d)arif m.a
 '''
q2 = '''what is father of heuman? 
a)adom
b)hawa 
c)ibrahim
d)karim
'''
q3 = ''' which is not a ilegal variable name ? 
a) my_var
b) my -var
c)_myver
d)myvar_
'''
q4= '''what is the correct extionson  for python?
a) .exe
b) .jpeg
c) .png
d) .py
'''

score = 0 
questions = { q1:"a", q2:"a", q3:"d", q4:"d"}
name = input("enter your name : ")
print( "hello " ,  name , " welcome to the quiz ")
for i in questions :
    print ( i )
    ans= (input("inter the correct  ans:  "))
    #ans = 
    if ans == questions [ i ]:
        print(" crrect ans , you got 1 point.")
        score = score + 1
    else :
        print ('wrong ans , you loss 1 point.')
        score -=1

print ( ' final score is ', score )