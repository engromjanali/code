def changeme (mylist):
    print("this changes a passed list into this fanction")
    mylist = [ 1,2,3,4]

# this world assing new referance in my list 
    print( "values inside the function: ", mylist )
    return()
#now you can call changes function
mylist = [ 10,20,30]
changeme(mylist)

print( "values outside the function: ", mylist)
