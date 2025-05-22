f = open("8.py", "w")
f.write("""def add_numbers(x,y):
    total = x+y 
    return(total) 
print("this won't be printed")
print(add_numbers(7,9))""")
f.close

File = open( "9.py", "w")
File.close
