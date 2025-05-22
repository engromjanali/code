# Write a Python program to check the validity of a password (input from users).
# Validation :
# At least 1 letter between [a-z] and 1 letter between [A-Z].
# At least 1 number between [0-9].
# At least 1 character from [$#@].
# Minimum length 6 characters.
# Maximum length 16 characters.
# Input
# W3r@100a
# Output
# Valid password

i = input( "write a password : ")
print( " At least 1 letter between [a-z] and 1 letter between [A-Z]. \n At least 1 number between [0-9].At least 1 character from [$#@].Minimum length 6 characters.\n Maxmum  16 characters.")

import re 
p = input ( " input your password :" )
x = True 
while x : 
    if ( len(p)<6 or len(p)>16):
        break 
    elif not re.search("[a - z]", p ):
        break
    elif not re.search("[0-9]", p ):
        break
    elif not re.search( "[A-Z]", p):
        break 
    elif not re.search("[$#@]", p):
        break 
    else: 
        print("valid password ")
        x = False
        break
if x :  
    print( " not a valid password ")
    