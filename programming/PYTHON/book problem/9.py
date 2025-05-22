def changeme (mylist): 
    print("this changes a passed list into this function")
    mylist.append([1,2,3,4])
    print("valued inside the function:", mylist)
    return
mylist = [10,20,30]
changeme(mylist)
print('values outside the function: ', mylist)