d  = { 1:10,2:20,3:30,4 :40,5:50,6:60,7:70,9:101}
def is_key_in_present(x):
    if x in d :
        print(x,"is present in D!")
    else:
        print(x, "is not present in D!")

is_key_in_present(5)
is_key_in_present(9)